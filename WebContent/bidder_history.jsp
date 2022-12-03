<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.IeProg" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/tabelCommon.css">
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>项目列表>历史项目列表</span>
        </div>
        <!--项目信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">查询</p>
            </div>
            <div class="unit-list clearfix">
	           <form action = "HistProjQuery" method = "post">
	               <div class="querycol"><label>项目名称</label> : <input type="text" value="" name="proj_name"  id="proj_name"/></div>
	               <div class="querycol"><label>招标公司</label> : <input type="text" value="" name="proj_school"  id="proj_school"/></div>
	               <div class="querycol"><label>所在地区</label> : <input type="text" value="" name="proj_country" id="proj_country"/></div>
	               <input type="hidden" value="isBidder" id="isBidder" name="isBidder"/>
	               <div class="querycol"><input type="submit" value="查询"></div>
	           </form>
            </div>
        </div>
        <!--项目信息结束-->
        <!--报到证档案信息开始-->
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">查询结果</p>
            </div>
            <div class="unit-list clearfix">
                <table>
                    <tr>
                    	<th>项目编号</th>
                        <th>项目名称</th>
                        <th>招标公司</th>
                        <th>所在地区</th>
                        <th>开始时间</th>
                        <th>结束时间</th>
                        <th>详细信息</th>
                    </tr>
                    <tr>
                    <%
                   		List<IeProg> list = (List<IeProg>)request.getAttribute("historypro_list");
                        if(list != null){
                        	for(int i=0;i<list.size();i++){
                        		IeProg historyproj_info = (IeProg)list.get(i);
                    %>
                    <tr>
                        <td><%=historyproj_info.getProj_no() %></td>
                        <td><%=historyproj_info.getProj_name() %></td>
                        <td><%=historyproj_info.getProj_sch() %></td>
                        <td><%=historyproj_info.getProj_country() %></td>
                        <td><%=historyproj_info.getProj_start_time() %></td>
                        <td><%=historyproj_info.getProj_apply_ddl() %></td> 
                      	<td><a href="ProjInfoDtl?proj_no=<%=historyproj_info.getProj_no() %>">详细信息</a></td>
                    </tr>
                    <%
                        	}
                        }
                    %>
                </table>
            </div>
        </div>
        <!--报到证档案信息结束-->
    </div>
</body>

</html>