<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/infoCommon.css">
    <script src="js/jquery-1.9.1.min.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
	    function infoSubmit(){
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
		    	var form = new FormData(document.getElementById("ProjRls"));
		        $.ajax({
		            url:"ProjRls",
		            type:"post",
		            data:form,
		            processData:false,
		            contentType:false,
		            success:function(data) {
		                if(data == "success") {
		                	alert("项目创建成功");
		                	location.reload();
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
		                window.clearInterval(timer);
		            }
		        });        
		    }
	    }
    </script>
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>项目列表>发布新的项目</span>
        </div>
        <!--项目信息开始-->
        <form id="ProjRls" action="ProjRls" enctype="multipart/form-data" method="post">
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">项目信息</p>
            </div>
            <div class="unit-list clearfix">
                <div class="fl">
                    <div class="list"><label>项目名称</label> : <input type="text" value="" name="proj_name" id="proj_name"/></div>
                    <div class="list"><label>招标公司</label> : <input type="text" value="" name="proj_sch" id="proj_sch"/></div>
                    <div class="list"><label>所在地区</label> : <input type="text" value="" name="proj_country" id="proj_country"/></div>
                    <div class="list"><label>项目规模</label> : <input type="number" value="" name="proj_credict" id="proj_credict"/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>项目开始时间</label> : <input type="date" value="" name="proj_start_time" id="proj_start_time"/></div>
                    <div class="list"><label>投标截止时间</label> : <input type="date" value="" name="proj_apply_ddl" id="proj_apply_ddl"/></div>
                    <div class="list"><label>项目类型</label> : <input type="text" value="" name="proj_lang" id="proj_lang"/></div>
                    <div class="list"><label>预计结束时间</label> : <input type="text" value="" name="proj_time" id="proj_time"/></div>
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
                        <textarea name="proj_info" id="proj_info"></textarea>
                    </div>
                </div>
            </div>
        </div>
        <!--报到证档案信息结束-->
        <!--附件信息开始-->
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">附件（将文件以.zip压缩包形式上传）</p>
            </div>
            <div class="unit-list clearfix">
                <div style="width:100%"><input type="file" name="attachment" id="attachment" accept=".zip"></div>
                <div id="rls_result" style="width: 100%; text-align: center; color: red; margin-bottom: 20px;"></div>
                <div style="width:100%; margin-top: 50px; margin-left: 50%; margin-right: 50%;"><input type="button" value="提交" onclick="infoSubmit()"/></div>
            </div>
        </div>
        </form>
        <!--附件信息结束-->
    </div>
</body>
</html>