<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="beans.IeProg"%>
<%@page import="beans.StuApply" %>
<%@page import="dao.StuApplyDao"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.StuApply" %>
<%@page import="java.sql.Date" %>
<!DOCTYPE html>
<html>

<%
	Date cur_date = new java.sql.Date(System.currentTimeMillis());
	String stu_num = (String)request.getAttribute("stu_num");
%>
<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/tabelCommon.css">
    <script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
		function fileDown(e){
			var url="DownFile";
			var filename = e.id;
			var params="filename="+filename;
    		sendRequest(url,params,'POST', xxx);
		}
		function applyFileUp(e) {
	        window.open("apply_child_window.jsp?proj_num="+e, "_blank",
	            'height=200,width=400,status=yes,top=200,left=400,toolbar=no,menubar=no,location=no')
	    }
		function getInfo(info) {
			alert(info);
	    }
		function delApplyInfo(e) {
			var msg="确认撤销投标吗？";
	        if(confirm(msg)==true){
	            var url="DelApplyInfo";
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
            <span>当前位置>项目信息>当前项目列表</span>
        </div>
        <!--项目信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">查询</p>
            </div>
            <div class="unit-list clearfix">
	           <form action = "CurProjQuery" method = "post">
	               <div class="querycol"><label>项目名称</label> : <input type="text" value="" name="proj_name" id="proj_name"/></div>
	               <div class="querycol"><label>招标公司</label> : <input type="text" value="" name="proj_school" id="proj_school"/></div>
	               <div class="querycol"><label>项目规模</label> : <input type="text" value="" name="proj_country" id="proj_country"/></div>
	                <input type="hidden" id="stu_num" name="stu_num" value="<%=stu_num%>"> 
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
                        <th>项目名称</th>
                        <th>招标公司</th>
                        <th>所在地区</th>
                        <th>详细情况</th>
                        <th>申请截止时间</th>
                        <th>项目开始时间</th>
                        <th>申请状态</th>
                        <th>审核人员</th>
                    </tr>
					<%
						StuApplyDao stu_apply_dao = new StuApplyDao();
	                    List<IeProg> list = (List<IeProg>)request.getAttribute("proinfo_list");
	                    if(list != null){
	                    	for(int i=0; i<list.size(); i++){
	                    		IeProg indexproj_info = (IeProg)list.get(i);
	                    		if(indexproj_info.getProj_apply_ddl().after(cur_date)) {
	                    		int proj_no = indexproj_info.getProj_no();
	                    		StuApply stu_apply = null;
	                    		stu_apply = stu_apply_dao.findStuApply(stu_num, proj_no);
                    %>
                    <tr>
                        <td><%=indexproj_info.getProj_name() %></td>
                        <td><%=indexproj_info.getProj_sch() %></td>
                        <td><%=indexproj_info.getProj_country() %></td>
                        <td><a href="ProjInfoDtl?proj_no=<%=indexproj_info.getProj_no() %>">详细情况</a></td>
                        <td><%=indexproj_info.getProj_apply_ddl() %></td>
                       	<td><%=indexproj_info.getProj_start_time() %></td>
                       	<%
                       	    if(stu_apply == null) {
                       	%>
                       	<td><a href="javascript:void(0);" onclick="applyFileUp(<%=indexproj_info.getProj_no()%>)">提交申请</a></td>
                       	<td></td>
                       	<%
                       	    }
                       	    else {
                       	    	if(stu_apply.getApply_status().equals("等待审批")) {
                       	%>
                       	<td>等待审批<a href="javascript:void(0);" onclick="delApplyInfo(<%=indexproj_info.getProj_no()%>)">撤销</a></td>
                       	<td><%=stu_apply.getAprv_tender() %> </td>
                       	<%
                       	    	} else if(stu_apply.getApply_status().equals("通过")) {
                       	%>
                       	<td>审核通过</td>
                       	<td><%=stu_apply.getAprv_tender() %></td>
                       	<%  	
                       	    	} else {
						%>    	
                       	<td>未通过<a href="javascript:void(0);" onclick="applyFileUp(<%=indexproj_info.getProj_no()%>)">重新提交</a></td>
                       	<td><%=stu_apply.getAprv_tender() %></td>
                       	<% 
                       	    	}
                       	    }
                       	%>
                    </tr>
                    <%		}
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