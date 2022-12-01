<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	<style type="text/css">
		a{text-decoration: none;}

		* {
			margin: 0;
			padding: 0;
		}

		.bx {
			height: 60px;
			width: 100%;
			background: #177ec1;
		}

		.bx .left {
			width: 70%;
			margin-left: 10px;
			color: #FFFFFF;
			font-size: 24px;
			line-height: 60px;
			float: left;
			text-align: left;
		}

		.bx .right {
			line-height: 60px;
			float: right;
			font-size: 16px;
			color: #fff;
		}

		.bx .right .l {
			width: 60px;
			float: left;
		}

		.bx .right .r {
			width: 100px;
			float: right;
		}
	</style>
	<script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
		function logout(){
			var url="LoginOut";
			var params="";
    		sendRequest(url,params,'POST', result);
		}
		function result() {
			if(httpRequest.readyState == 4) {
	 			if(httpRequest.status == 200) {
	 				top.location='login.html';
	 			}
	 		}
		}
	</script>
</head>

<body>
	<div class="bx">
		<h2 class="left">BEP工程项目招标平台</h2>
		<div class="right">
			<label style="margin-right: 30px;">欢迎您，<%=session.getAttribute("acct")%></label>
			<span class="r"><a style="color: white;" href="javascript:void(0);" onclick="logout()">退出登录</a></span>
		</div>
	</div>
</body>

</html>