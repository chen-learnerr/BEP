<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
		function reviewSubmit(a, b) {
			var proj_status = document.getElementById("proj_status").value;
			if(proj_status == "") {
				alert("还未选择审核结果！");
			}
			else {
				var msg="确认更改审核结果吗？";
		        if(confirm(msg)==true){
		            var url="TenderReviewSub";
					var params="proj_no="+a+"&stu_num="+b+"&proj_status="+proj_status;
		   			sendRequest(url, params, 'POST', reviewSubResult);
		        }
			}
	    }
		function reviewSubResult() {
			if(httpRequest.readyState == 4) {
	 			if(httpRequest.status == 200) {
	 				var info = "审核结果变更成功";
                	var tender_app_list = window.opener;
                	window.opener.location.reload();
					tender_app_list.getInfo(info);
                	window.close();
	 			}
	 		}
		}
	</script>
</head>
<body>

</body>
	<%
		int proj_no = Integer.parseInt(request.getParameter("proj_no"));
		String stu_num = (String)request.getParameter("stu_num");
	%>
	<form action="">
		<input id="proj_status" type="text" list="statuslist" placeholder="请选择">
		<datalist id="statuslist">
		　　<option>等待审批</option>
		　　<option>中标</option>
			<option>未中标</option>
		</datalist>
		<input type="button" value="提交" onclick="reviewSubmit(<%=proj_no %>, <%=stu_num %>)"/>
	</form>
</html>