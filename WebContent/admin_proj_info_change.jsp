<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="beans.IeProg" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/infoCommon.css">
     <script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
	    function infoSubmit(e){
	    	var proj_name = document.getElementById("proj_name").value;
            var proj_sch = document.getElementById("proj_sch").value;
            var proj_country = document.getElementById("proj_country").value;
            var proj_credict = document.getElementById("proj_credict").value;
            var proj_start_time = document.getElementById("proj_start_time").value;
            var proj_apply_ddl = document.getElementById("proj_apply_ddl").value;
            var proj_lang = document.getElementById("proj_lang").value;
            var proj_time = document.getElementById("proj_time").value;
            if(proj_name=="" || proj_sch=="" || proj_country=="" || proj_credict=="" || proj_start_time=="" || proj_apply_ddl=="" || proj_lang=="" || proj_time==""){
                alert("请填写完整信息！");
            }
            else if(proj_start_time <= proj_apply_ddl) {
            	alert("项目开始时间小于项目截止时间！");
            }
		    else {
		    	var form = new FormData(document.getElementById("ProjInfoDtl"));
		        $.ajax({
		            url:"ProjInfoChange?proj_no="+e,
		            type:"post",
		            data:form,
		            processData:false,
		            contentType:false,
		            success:function(data) {
		                if(data == "success") {
		                	alert("项目更新成功");
		                }
		                else if(data == "fail_1") {
		                	alert("提交的不是.zip压缩文件");
		                }
		            },
		            error:function(e) {
		                alert("错误！！");
		                window.clearInterval(timer);
		            }
		        });        
		    }
	    }
    </script>
</head>

<body>
   <%	
		IeProg ie_prog = (IeProg)request.getAttribute("proinfo_list");
		int proj_no = ie_prog.getProj_no();
		String proj_name = ie_prog.getProj_name();
		String proj_sch = ie_prog.getProj_sch();
		String proj_country = ie_prog.getProj_country();
		int proj_credict = ie_prog.getProj_credict();
		Date proj_start_time = ie_prog.getProj_start_time();
		Date proj_apply_ddl = ie_prog.getProj_apply_ddl();
		String proj_lang = ie_prog.getProj_lang();
		String proj_time = ie_prog.getProj_time();
		String proj_info = ie_prog.getProj_info();
	%>
    <div class="content">
        <div class="information-title">
            <span>当前位置>项目列表>更改项目</span>
            <span class="fac-information"><a href="#" onClick="javascript :history.back(1);" class="save">返回</a></span>
        </div>
        <!--项目信息开始-->
        <form  id="ProjInfoDtl" action = "ProjInfoDtl" enctype="multipart/form-data" method="post">
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">项目信息</p>
            </div>
            <div class="unit-list clearfix">
                <div class="fl">
                    <div class="list"><label>项目名称</label> : <input type="text" value="<%=proj_name %>" name="proj_name" id="proj_name"/></div>
                    <div class="list"><label>招标公司</label> : <input type="text" value="<%=proj_sch %>" name="proj_sch" id="proj_sch"/></div>
                    <div class="list"><label>所在地区</label> : <input type="text" value="<%=proj_country %>" name="proj_country"id="proj_country" /></div>
                    <div class="list"><label>项目预算</label> : <input type="number" value="<%=proj_credict %>" name="proj_credict" id="proj_credict"/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>开始时间</label> : <input type="date" value="<%=proj_start_time %>" name="proj_start_time"id="proj_start_time" /></div>
                    <div class="list"><label>招标截止时间</label> : <input type="date" value="<%=proj_apply_ddl %>"name="proj_apply_ddl"id="proj_apply_ddl" /></div>
                    <div class="list"><label>项目类型</label> : <input type="text" value="<%=proj_lang %>"name="proj_lang" id="proj_lang"/></div>
                    <div class="list"><label>预计结束时间</label> : <input type="text" value="<%=proj_time %>" name="proj_time" id="proj_time"/></div>
                </div>
            </div>
        </div>
        <!--项目信息结束-->
        <!--报到证档案信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">详细信息</p>
            </div>
            <div class="unit-list clearfix">
                <div class="reason">
                    <p>描述：</p>
                    <div>
                        <textarea name="proj_info" id="proj_info"><%=proj_info %></textarea>
                    </div>
                </div>
            </div>
        </div>
        <!--报到证档案信息结束-->
        <!--附件信息开始-->
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">附件</p>
            </div>
            <div class="unit-list clearfix">
                <div style="width:100%"><input value="" type="file" name="myFile" id="myFile" accept=".zip"></div>
                <div style="width:100%; margin-top: 50px; margin-left: 50%; margin-right: 50%;"><input type="button" value="确认更改保存" onclick="infoSubmit(<%=proj_no %>)"/></div>
            </div>
        </div>
        </form>
        <!--附件信息结束-->
    </div>
</body>
</html>