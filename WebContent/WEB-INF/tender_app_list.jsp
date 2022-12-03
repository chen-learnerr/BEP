<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.Applicant" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/tabelCommon.css">
    <link rel="stylesheet" href="css/CurrentProjectList.css">
    <script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
		function statusChange(a, b) {
	        window.open("review_child_window.jsp?proj_no="+a+"&bidder_num="+b, "_blank",
	            'height=200,width=400,status=yes,top=200,left=400,toolbar=no,menubar=no,location=no')
	    }
		function getInfo(info) {
			alert(info);
	    }
	</script>
</head>

<%
	int proj_no = Integer.parseInt(request.getParameter("proj_no"));
%>
<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>项目列表>申请名单</span>
            <span class="fac-information"><a href="#" onClick="javascript:history.back(1);" class="save">返回</a></span>
        </div>
        <!--项目信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">查询</p>
            </div>
            <div class="unit-list clearfix">
            <form action = "TenderBidderProQuery?proj_no=<%=proj_no %>"  method = "post">
                <div class="querycol"><label>学生姓名</label> : <input type="text" value="" name="bidder_name" id="bidder_name" /></div>
                <div class="querycol"><label>学号</label> : <input type="text" value="" name="bidder_num" id="bidder_num" /></div>
                <div class="querycol"><label>年级</label> : <input type="text" value="" name="bidder_grd" id="bidder_grd" /></div>
                <div class="querycol"><input type="submit" value="查询" onclick="Checkform()"/></div>
            </form>
            </div>
        </div>
        <!--项目信息结束-->
        <!--报到证档案信息开始-->
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">未审核</p>
            </div>
            <div class="unit-list clearfix">
                <table>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>所学专业</th>
                        <th>年级</th>
                        <th>提交材料</th>
                        <th>审批状态</th>
                    </tr>
                    <%
                        List<Applicant> list = (List<Applicant>)request.getAttribute("app_list");
                        if(list != null){
                        	for(int i=0;i<list.size();i++) {
                        		Applicant applicant  = list.get(i);
                        		if(applicant.getApply_status().equals("等待审批")) {
                    %>
                    <tr>
                        <td><%=applicant.getBidder_num() %></td>
                        <td><%=applicant.getBidder_name() %></td>
                        <td><%=applicant.getBidder_sex() %></td>
                        <td><%=applicant.getBidder_major() %></td>
                        <td><%=applicant.getBidder_grd() %></td>
                        <td><a href="DownFile?filename=<%=applicant.getApply_att_name() %>">材料下载</a></td>
                        <td>未审核<a href="javascript:void(0);" onclick="statusChange(<%=proj_no %>, <%=applicant.getBidder_num() %>)">更改</a></td>
                    </tr>
                    <%
                        		}
                        	}
                        }
                    %>
                </table>
            </div>
            <div class="unit">
                <p class="unit-content">已审核</p>
            </div>
            <div class="unit-list clearfix">
                <table>
                    <tr>
                        <th>学号</th>
                        <th>姓名</th>
                        <th>性别</th>
                        <th>所学专业</th>
                        <th>年级</th>
                        <th>提交材料</th>
                        <th>审批状态</th>
                    </tr>
                    <%
	                    if(list != null){
	                    	for(int i=0;i<list.size();i++) {
	                    		Applicant applicant  = list.get(i);
	                        	if(applicant.getApply_status().equals("通过") || applicant.getApply_status().equals("未通过")){
                    %>
                    <tr>
                        <td><%=applicant.getBidder_num() %></td>
                        <td><%=applicant.getBidder_name() %></td>
                        <td><%=applicant.getBidder_sex() %></td>
                        <td><%=applicant.getBidder_major() %></td>
                        <td><%=applicant.getBidder_grd() %></td>
                        <td><a href="DownFile?filename=<%=applicant.getApply_att_name() %>">材料下载</a></td>
                        <td><%=applicant.getApply_status() %><a href="javascript:void(0);" onclick="statusChange(<%=proj_no %>, <%=applicant.getBidder_num() %>)">更改</a></td>
                    </tr>
                    <%
                        		}
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