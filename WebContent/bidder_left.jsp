<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" href="css/left.css">
</head>

<body>
	<div class="nav">
		<div class="nav-list">
			<div class="nav-tit" id="info">
				<a href="#">
					<img src="images/PubMed-msg.png" alt="">
					<span>公司信息</span>
				</a>
			</div>
			<div class="personal-list" id="info_child">
				<ul>
					<li><a href="BidderInfoFind" target="main" style="margin-left: 15px;">公司信息</a></li>
					<li><a href="AllPrefFind" target="main" style="margin-left: 15px;">投标偏好</a></li>
				</ul>
			</div>
			<div class="nav-tit" id="project">
				<a href="#">
					<img src="images/archives-msg.png" alt="">
					<span>项目信息</span>
				</a>
			</div>
			<div class="personal-list" id="project_child">
				<ul>
					<li><a href="AllProjDisp?type=bidder" target="main">当前项目列表</a></li>
					<li><a href="bidder_history.jsp" target="main">历史项目列表</a></li>
				</ul>
			</div>
			<div class="nav-tit">
				<a href="bidder_pwd_change.jsp" target="main">
					<img src="images/modify-password.png" alt="">
					<span>修改密码</span>
				</a>
			</div>
			<div class="nav-tit">
				<a href="bidder_right.jsp" target="main">
					<img src="images/job-change.png" alt="">
					<span>通知信息</span>
				</a>
			</div>
		</div>
	</div>

	<script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
	<script>
		$(document).ready(function () {
			$('#info').on('click', function () {
				$('#info_child').fadeToggle(300);
			});
			let aLi = $('#info_child li');
			aLi.on('click', function () {
				$(this).addClass('active').siblings('li').removeClass('active');
			})
		});
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