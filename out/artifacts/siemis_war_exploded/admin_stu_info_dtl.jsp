<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="beans.StuInfo" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/infoCommon.css">
</head>

<body>
    <%	
		StuInfo stu_info = (StuInfo)request.getAttribute("stu_list");
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
            <span>当前位置>公司详细信息</span>
            <span class="fac-information"><a href="#" onClick="javascript :history.back(1);" class="save">返回</a></span>
        </div>
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">公司信息</p>
            </div>
            <div class="unit-list clearfix lastpart">
            <form action = "AdminStuInfoDtl" method = "post">
                <div class="fl">
                    <div class="list"><label>执照编号</label> : <input type="number" value="<%=stu_num %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>公司名称</label> : <input type="text" value="<%=stu_name %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>主营业务</label> : <input type="text" value="<%=stu_major %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>注册编号</label> : <input type="number" value="<%=stu_id_num %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>公司地址</label> : <input type="text" value="<%=stu_nation %>" name="branch" disabled='disabled'/></div>
                    <div class="list"><label>公司类型</label> : <input type="text" value="<%=stu_political_status %>" name="address" disabled='disabled'/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>电子邮箱</label> : <input type="text" value="<%=stu_mail %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>是否上市</label> : <input type="text" value="<%=stu_sex %>" name="branch" disabled='disabled'/></div>
                    <div class="list"><label>电话号码</label> : <input type="text" value="<%=stu_grade %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>邮编</label> : <input type="number" value="<%=stu_mob_no %>" name="address" disabled='disabled'/></div>
                    <div class="list"><label>注册年份</label> : <input type="number" value="<%=stu_dates %>" name="number" disabled='disabled'/></div>
                    <div class="list"><label>成立日期</label> : <input type="date" value="<%=stu_birthday %>" name="number" disabled='disabled'/></div>
                </div>
            </form>
            </div>
        </div>
	</div>
</body>

</html>