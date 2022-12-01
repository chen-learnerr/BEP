<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function applySubmit(e) {
			var form = new FormData(document.getElementById("ApplySub"));
	        $.ajax({
	            url:"ApplySub?proj_num="+e,
	            type:"post",
	            data:form,
	            dataType:"text",
	            processData:false,
	            contentType:false,
	            success:function(data) {
	                if(data == "noNum") {
	                	var info = "无法进行申请，可能是因为系统出现错误或用户未更新个人信息";
	                	var cur_proj_list = window.opener;
	                	cur_proj_list.getInfo(info);
	                	window.close();
	                }
	                else if(data == "success") {
	                	var info = "申请提交成功";
	                	var cur_proj_list = window.opener;
	                	window.opener.location.reload(); 
	                	cur_proj_list.getInfo(info);
	                	window.close();
	                }
	                else if(data == "fail_1") {
	                	alert("提交的不是.zip压缩文件");
	                }
	                else if(data == "fail_2") {
	                	alert("没有提交文件");
	                }
	            },
	            error:function(e) {
	                alert("错误！！");
	            }
	        });  
		}
	</script>
</head>
<body>

</body>
	<%
		String s = (String)request.getParameter("proj_num");
	%>
	<form id="ApplySub" action="ApplySub" enctype="multipart/form-data" method="post">
		<input type="file" name="attachment" id="attachment" accept=".zip">
		<input type="button" value="提交" onclick="applySubmit(<%=s %>)"/>
	</form>
</html>