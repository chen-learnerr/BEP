<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>Title</title>
    <link rel="stylesheet" href="css/infoCommon.css">
    <script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
	    function pwdCheck() {
	 		var url="PwdChange";
	 		var orig_pwd=document.getElementById("orig_pwd").value;
	 		var new_pwd=document.getElementById("new_pwd").value;
            var rpt_new_pwd=document.getElementById("rpt_new_pwd").value;
            if(new_pwd.length>=6 && new_pwd.length<=12 && rpt_new_pwd.length>=6 && rpt_new_pwd.length<=12){
                var type="tender";
	 		    var params="orig_pwd="+orig_pwd+"&new_pwd="+new_pwd+"&rpt_new_pwd="+rpt_new_pwd+"&type="+type;
	 		    sendRequest(url,params,'POST', pwdChangeResult);
            }
            else{
                alert("密码长度不合要求！（6~12位）");
                location.reload();
            }
	 	}
	 	function pwdChangeResult() {
	 		if(httpRequest.readyState == 4) {
	 			if(httpRequest.status == 200) {
	 				var info=httpRequest.responseText;
	 				alert(info);
	 			}
	 		}
	 	}
    </script>
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>修改密码</span>
        </div>
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">修改密码</p>
            </div>
            <div class="unit-list clearfix">
                <div class="oneline"><label>原密码</label> : <input type="password" value="" name="orig_pwd" id="orig_pwd"/></div>
                <div class="oneline"><label>新密码</label> : <input type="password" value="" name="new_pwd" id="new_pwd"/></div>
                <div class="oneline"><label>确认密码</label> : <input type="password" value="" name="rpt_new_pwd" id="rpt_new_pwd"/></div>
            </div> 
            <div style="width:100%; margin-top: 50px; margin-left: 50%; margin-right: 50%;" onclick="pwdCheck()"><button>提交</button></div>
        </div>
    </div>
</body>

</html>