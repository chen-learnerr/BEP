<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<title></title>
	<link rel="stylesheet" href="css/left.css">
</head>

<body>
	<div class="nav">
		<div class="nav-list">
			<div class="nav-tit">
				<a href="tender_stu_info.jsp" target="main">
					<img src="images/PubMed-msg.png" alt="">
					<span>查询公司信息</span>
				</a>
			</div>
			<div class="nav-tit" id="project">
				<a href="#">
					<img src="images/archives-msg.png" alt="">
					<span>项目信息</span>
				</a>
			</div>
			<div class="personal-list" id="project_child">
				<ul>
					<li><a href="tender_proj_rls.jsp" target="main">发布新的项目</a></li>
					<li><a href="AllProjDisp?type=tender" target="main">当前项目列表</a></li>
					<li><a href="tender_history.jsp" target="main">历史项目列表</a></li>
				</ul>
			</div>
			<div class="nav-tit">
				<a href="tender_pwd_change.jsp" target="main">
					<img src="images/modify-password.png" alt="">
					<span>修改密码</span>
				</a>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script>
		$(document).ready(function () {
			$('#project').on('click', function () {
				$('#project_child').fadeToggle(300);
			});
			let aLi = $('#project_child li');
			aLi.on('click', function () {
				$(this).addClass('active').siblings('li').removeClass('active');
			})
		});
	</script>
</body>

</html>