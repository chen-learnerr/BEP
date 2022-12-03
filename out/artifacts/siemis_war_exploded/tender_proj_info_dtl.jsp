<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="beans.IeProg" %>
<%	
	IeProg ie_prog = (IeProg)request.getAttribute("proinfo_list");
	int proj_num = ie_prog.getProj_no();
	String proj_name = ie_prog.getProj_name();
	String proj_sch = ie_prog.getProj_sch();
	String proj_country = ie_prog.getProj_country();
	int proj_credict = ie_prog.getProj_credict();
	Date proj_start_time = ie_prog.getProj_start_time();
	Date proj_apply_ddl = ie_prog.getProj_apply_ddl();
	String proj_lang = ie_prog.getProj_lang();
	String proj_time = ie_prog.getProj_time();
	String proj_info = ie_prog.getProj_info();
	String proj_file = ie_prog.getProj_file();
%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/infoCommon.css">
    <script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
    <script type="text/javascript">
		function fileDown(e){
			var url="DownFile";
			var filename = e.id;
			var params="filename="+filename;
    		sendRequest(url,params,'POST', result);
		}
		function result() {
			if(httpRequest.readyState == 4) {
    			if(httpRequest.status == 200) {
    				var info=httpRequest.responseText;
    				alert("1");
    			}
    		}
		}
	</script>
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>项目列表>项目详细信息</span>
            <span class="fac-information"><a href="#" onClick="javascript :history.back(1);" class="save">返回</a></span>
        </div>
        <!--项目信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">项目信息</p>
            </div>
            <div class="unit-list clearfix">
                <div class="fl">
                    <div class="list"><label>项目名称</label> : <input type="text" value="<%=proj_name %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>招标公司</label> : <input type="text" value="<%=proj_sch %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>所在地区</label> : <input type="text" value="<%=proj_country %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>项目预算</label> : <input type="number" value="<%=proj_credict %>" name="number" disabled='disabled'/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>开始时间</label> : <input type="date" value="<%=proj_start_time %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>招标截止时间</label> : <input type="date" value="<%=proj_apply_ddl %>"name="branch" disabled='disabled'/></div>
                    <div class="list"><label>项目类型</label> : <input type="text" value="<%=proj_lang %>"name="address" disabled='disabled'/></div>
                    <div class="list"><label>预计结束时间</label> : <input type="text" value="<%=proj_time %>" name="address" disabled='disabled'/></div>
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
                        <textarea disabled='disabled'><%=proj_info %></textarea>
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
                <div style="width:100%; margin-top: 50px; margin-left: 50%; margin-right: 50%;"><a href="DownFile?filename=<%=proj_file %>">下载附件</a></div>
            </div>
        </div>
        <!--附件信息结束-->
    </div>
</body>
</html>