<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="beans.StuInfo" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/infoCommon.css">
	<script src="js/stu_info.js" type="text/javascript" charset="utf-8"></script>
	<script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
	<script type="text/javascript">
		function isEmail(vEMail){
		    if (vEMail!=""){
		        var regInvalid=/(@.*@)|(\.\.)|(@\.)|(\.@)|(^\.)/;
		        var regValid=/^.+\@(\[?)[a-zA-Z0-9\-\.]+\.([a-zA-Z]{2,3}|[0-9]{1,3})(\]?)$/;
		        return (!regInvalid.test(vEMail)&&regValid.test(vEMail));
		    }
		}
		
		function checkEmail(){
		    var v=document.getElementById("stu_email").value;
		    if(isEmail(v)==0){
		        return false;
		    }
		    else{
		        return true;
		    }
		}
		function infoSave(){
            if(checkEmail()==false){
                alert("电子邮箱不合法！");
            }
            else{
                var url="StuInfoChange";
		        var msg="确定要保存吗？首次保存后执照编号无法修改！";
		        if(confirm(msg)==true){
		            var stu_num = document.getElementById("stu_num").value;
		            var stu_name = document.getElementById("stu_name").value;
		            var stu_major = document.getElementById("stu_major").value;
		            var stu_id = document.getElementById("stu_id").value;
		            var stu_nation = document.getElementById("stu_nation").value;
		            var stu_pol = document.getElementById("stu_pol").value;
		            var stu_email = document.getElementById("stu_email").value;
		            var stu_sex = document.getElementById("stu_sex").value;
		            var stu_grade = document.getElementById("stu_grade").value;
		            var stu_call = document.getElementById("stu_call").value;
		            var stu_year = document.getElementById("stu_year").value;
		            var stu_birth = document.getElementById("stu_birth").value;
		            var params="stu_num="+stu_num+"&stu_name="+stu_name+"&stu_major="+stu_major+"&stu_id="+stu_id+"&stu_nation="+stu_nation+"&stu_pol="+stu_pol
		            +"&stu_email="+stu_email+"&stu_sex="+stu_sex+"&stu_grade="+stu_grade+"&stu_call="+stu_call+"&stu_year="+stu_year+"&stu_birth="+stu_birth;
		            sendRequest(url, params, 'POST', changeResult);
		        }
            }
		}
		function changeResult() {
			if(httpRequest.readyState == 4) {
    			if(httpRequest.status == 200) {
    				var info=httpRequest.responseText;
    				if(info == "ok"){
    					alert("保存成功！");
				        document.getElementById("stu_num").setAttribute('disabled','disabled');
				        document.getElementById("stu_name").setAttribute('disabled','disabled');
				        document.getElementById("stu_major").setAttribute('disabled','disabled');
				        document.getElementById("stu_id").setAttribute('disabled','disabled');
				        document.getElementById("stu_nation").setAttribute('disabled','disabled');
				        document.getElementById("stu_pol").setAttribute('disabled','disabled');
				        document.getElementById("stu_email").setAttribute('disabled','disabled');
				        document.getElementById("stu_sex").setAttribute('disabled','disabled');
				        document.getElementById("stu_grade").setAttribute('disabled','disabled');
				        document.getElementById("stu_call").setAttribute('disabled','disabled');
				        document.getElementById("stu_year").setAttribute('disabled','disabled');
				        document.getElementById("stu_birth").setAttribute('disabled','disabled');
    				}
    				
    			}
    		}
		}
	</script>
</head>

<body>
	<%	
		StuInfo stu_info = (StuInfo)request.getAttribute("stu_info");
		if (stu_info == null) {
			stu_info = new StuInfo();
		}
		String stu_num = stu_info.getStu_num();
		String stu_name = stu_info.getStu_name();
		String stu_id_num = stu_info.getStu_id_num();
		String stu_sex = stu_info.getStu_sex();
		String stu_political_status = stu_info.getStu_political_status();
		String stu_major = stu_info.getStu_major();
		String stu_mob_no = stu_info.getStu_mob_no();
		String stu_mail = stu_info.getStu_mail();
		String stu_nation = stu_info.getStu_nation();
		String stu_grade = stu_info.getStu_grade();
		Date stu_birthday = stu_info.getStu_birthday();
		int stu_dates = stu_info.getStu_dates();
	%>
    <div class="content">
        <div class="information-title">
            <span>当前位置>公司信息</span>
        </div>
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">公司信息</p>
            </div>
            <div class="unit-list clearfix lastpart">
                <div class="fl">
                    <div class="list"><label>执照编号</label> : <input type="number" value="<%=stu_num %>" name="stu_num" id="stu_num" disabled='disabled'/></div>
                    <div class="list"><label>公司名称</label> : <input type="text" value="<%=stu_name %>" name="stu_name" id="stu_name" disabled='disabled'/></div>
                    <div class="list"><label>主营业务</label> : <input type="text" value="<%=stu_major %>" name="stu_major" id="stu_major" disabled='disabled'/></div>
                    <div class="list"><label>注册编号</label> : <input type="number" value="<%=stu_id_num %>" name="stu_id" id="stu_id" disabled='disabled'/></div>
                    <div class="list"><label>公司地址</label> : <input type="text" value="<%=stu_nation %>" name="stu_nation" id="stu_nation" disabled='disabled'/></div>
                    <div class="list"><label>公司类型</label> : <input type="text" value="<%=stu_political_status %>" name="stu_pol" id="stu_pol" disabled='disabled'/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>电子邮箱</label> : <input type="text" value="<%=stu_mail %>" name="stu_email" id="stu_email" disabled='disabled'/></div>
                    <div class="list"><label>是否上市</label> : <input type="text" value="<%=stu_sex %>" name="stu_sex" id="stu_sex" list="sexlist" disabled='disabled'/></div>
                    <datalist id="sexlist">
					　　<option>是</option>
					　　<option>否</option>
					</datalist>
                    <div class="list"><label>电话号码</label> : <input type="number" value="<%=stu_grade %>" name="stu_grade" id="stu_grade" disabled='disabled'/></div>
                    <div class="list"><label>公司邮编</label> : <input type="number" value="<%=stu_mob_no %>" name="stu_call" id="stu_call" disabled='disabled'/></div>
                    <div class="list"><label>注册年份</label> : <input type="number" value="<%=stu_dates %>" name="stu_year" id="stu_year" disabled='disabled'/></div>
                    <div class="list"><label>成立日期</label> : <input type="date" value="<%=stu_birthday %>" name="stu_birth" id="stu_birth" disabled='disabled'/></div>
                </div>
            </div>
            <div>
                <button style="margin-left: 320px; height: 35px; width: 70px; " onclick="infoChange()">修改</button>
                <button style="margin-left: 50px; height: 35px; width: 70px; " onclick="infoSave()">保存</button>
            </div>
        </div>
	</div>
</body>

</html>
