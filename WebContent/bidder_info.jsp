<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="beans.BidderInfo" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <link rel="stylesheet" href="css/infoCommon.css">
	<script src="js/bidder_info.js" type="text/javascript" charset="utf-8"></script>
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
		    var v=document.getElementById("bidder_email").value;
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
                var url="bidderInfoChange";
		        var msg="确定要保存吗？首次保存后执照编号无法修改！";
		        if(confirm(msg)==true){
		            var bidder_num = document.getElementById("bidder_num").value;
		            var bidder_name = document.getElementById("bidder_name").value;
		            var bidder_major = document.getElementById("bidder_major").value;
		            var bidder_id = document.getElementById("bidder_id").value;
		            var bidder_nation = document.getElementById("bidder_nation").value;
		            var bidder_pol = document.getElementById("bidder_pol").value;
		            var bidder_email = document.getElementById("bidder_email").value;
		            var bidder_sex = document.getElementById("bidder_sex").value;
		            var bidder_grade = document.getElementById("bidder_grade").value;
		            var bidder_call = document.getElementById("bidder_call").value;
		            var bidder_year = document.getElementById("bidder_year").value;
		            var bidder_birth = document.getElementById("bidder_birth").value;
		            var params="bidder_num="+bidder_num+"&bidder_name="+bidder_name+"&bidder_major="+bidder_major+"&bidder_id="+bidder_id+"&bidder_nation="+bidder_nation+"&bidder_pol="+bidder_pol
		            +"&bidder_email="+bidder_email+"&bidder_sex="+bidder_sex+"&bidder_grade="+bidder_grade+"&bidder_call="+bidder_call+"&bidder_year="+bidder_year+"&bidder_birth="+bidder_birth;
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
				        document.getElementById("bidder_num").setAttribute('disabled','disabled');
				        document.getElementById("bidder_name").setAttribute('disabled','disabled');
				        document.getElementById("bidder_major").setAttribute('disabled','disabled');
				        document.getElementById("bidder_id").setAttribute('disabled','disabled');
				        document.getElementById("bidder_nation").setAttribute('disabled','disabled');
				        document.getElementById("bidder_pol").setAttribute('disabled','disabled');
				        document.getElementById("bidder_email").setAttribute('disabled','disabled');
				        document.getElementById("bidder_sex").setAttribute('disabled','disabled');
				        document.getElementById("bidder_grade").setAttribute('disabled','disabled');
				        document.getElementById("bidder_call").setAttribute('disabled','disabled');
				        document.getElementById("bidder_year").setAttribute('disabled','disabled');
				        document.getElementById("bidder_birth").setAttribute('disabled','disabled');
    				}
    				
    			}
    		}
		}
	</script>
</head>

<body>
	<%	
		BidderInfo bidder_info = (BidderInfo)request.getAttribute("bidder_info");
		if (bidder_info == null) {
			bidder_info = new BidderInfo();
		}
		String bidder_num = bidder_info.getBidder_num();
		String bidder_name = bidder_info.getBidder_name();
		String bidder_id_num = bidder_info.getBidder_id_num();
		String bidder_sex = bidder_info.getBidder_sex();
		String bidder_political_status = bidder_info.getBidder_political_status();
		String bidder_major = bidder_info.getBidder_major();
		String bidder_mob_no = bidder_info.getBidder_mob_no();
		String bidder_mail = bidder_info.getBidder_mail();
		String bidder_nation = bidder_info.getBidder_nation();
		String bidder_grade = bidder_info.getBidder_grade();
		Date bidder_birthday = bidder_info.getBidder_birthday();
		int bidder_dates = bidder_info.getBidder_dates();
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
                    <div class="list"><label>执照编号</label> : <input type="number" value="<%=bidder_num %>" name="bidder_num" id="bidder_num" disabled='disabled'/></div>
                    <div class="list"><label>公司名称</label> : <input type="text" value="<%=bidder_name %>" name="bidder_name" id="bidder_name" disabled='disabled'/></div>
                    <div class="list"><label>主营业务</label> : <input type="text" value="<%=bidder_major %>" name="bidder_major" id="bidder_major" disabled='disabled'/></div>
                    <div class="list"><label>注册编号</label> : <input type="number" value="<%=bidder_id_num %>" name="bidder_id" id="bidder_id" disabled='disabled'/></div>
                    <div class="list"><label>公司地址</label> : <input type="text" value="<%=bidder_nation %>" name="bidder_nation" id="bidder_nation" disabled='disabled'/></div>
                    <div class="list"><label>公司类型</label> : <input type="text" value="<%=bidder_political_status %>" name="bidder_pol" id="bidder_pol" disabled='disabled'/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>电子邮箱</label> : <input type="text" value="<%=bidder_mail %>" name="bidder_email" id="bidder_email" disabled='disabled'/></div>
                    <div class="list"><label>是否上市</label> : <input type="text" value="<%=bidder_sex %>" name="bidder_sex" id="bidder_sex" list="sexlist" disabled='disabled'/></div>
                    <datalist id="sexlist">
					　　<option>是</option>
					　　<option>否</option>
					</datalist>
                    <div class="list"><label>电话号码</label> : <input type="number" value="<%=bidder_grade %>" name="bidder_grade" id="bidder_grade" disabled='disabled'/></div>
                    <div class="list"><label>公司邮编</label> : <input type="number" value="<%=bidder_mob_no %>" name="bidder_call" id="bidder_call" disabled='disabled'/></div>
                    <div class="list"><label>注册年份</label> : <input type="number" value="<%=bidder_dates %>" name="bidder_year" id="bidder_year" disabled='disabled'/></div>
                    <div class="list"><label>成立日期</label> : <input type="date" value="<%=bidder_birthday %>" name="bidder_birth" id="bidder_birth" disabled='disabled'/></div>
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
