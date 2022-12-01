<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.IeProg"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/tabelCommon.css">
    <script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
		function delProjInfo(e) {
			var msg="确认撤销项目吗？";
	        if(confirm(msg)==true){
	        	var url="DelProjInfo";
				var proj_no = e;
				var params="proj_no="+proj_no;
	    		sendRequest(url, params, 'POST', delInfoResult);
	        }
		}
		function delInfoResult() {
			if(httpRequest.readyState == 4) {
	 			if(httpRequest.status == 200) {
	 				var info=httpRequest.responseText;
	 				alert(info);
	 				location.reload();
	 			}
	 		}
		}
	</script>
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>项目列表>当前项目列表</span>
        </div>
        <!--项目信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">查询</p>
            </div>
            <div class="unit-list clearfix">
	            <form action = "CurProjQuery" method = "post">
	                <div class="querycol"><label>项目名称</label> : <input type="text" value="" name="proj_name" id="proj_name"/></div>
	                <div class="querycol"><label>招标公司</label> : <input type="text" value="" name="proj_school" id="proj_school" /></div>
	                <div class="querycol"><label>所在地区</label> : <input type="text" value="" name="proj_country" id="proj_country" /></div>
	                <input type="hidden" value="isAdmin" id="isAdmin" name="isAdmin"/>
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
                        <th>执照编号</th>
                        <th>项目名称</th>
                        <th>招标公司</th>
                        <th>所在地区</th>
                        <th>详细情况</th>
                        <th>更改项目</th>
                        <th>撤销项目</th>
                        <th>投标名单</th>
                    </tr>
                    <%
	                    List<IeProg> list = (List<IeProg>)request.getAttribute("proinfo_list");
	                    if(list != null){
	                    	for(int i=0;i<list.size();i++){
	                    		IeProg indexproj_info = (IeProg)list.get(i);
                    %>
                    <tr>
                        <td><%=indexproj_info.getProj_no() %></td>
                        <td><%=indexproj_info.getProj_name() %></td>
                        <td><%=indexproj_info.getProj_sch() %></td>
                        <td><%=indexproj_info.getProj_country() %></td>
                        <td><a href="ProjInfoDtl?proj_no=<%=indexproj_info.getProj_no() %>">详细信息</a></td>
                        <td><a href="ProjInfoUpdate?proj_no=<%=indexproj_info.getProj_no() %>">更改项目</a></td>
                       	<td><a href="javascript:void(0);" onclick="delProjInfo(<%=indexproj_info.getProj_no()%>)">撤销项目</a></td>
                       	<td><a href="AdminStuPro?proj_no=<%=indexproj_info.getProj_no() %>">投标名单</a></td>
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