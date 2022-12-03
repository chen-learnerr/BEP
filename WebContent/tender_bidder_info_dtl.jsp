<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.sql.Date" %>
<%@ page import="beans.BidderInfo" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/infoCommon.css">
</head>

<body>
    <%	
		BidderInfo bidder_info = (BidderInfo)request.getAttribute("bidder_list");
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
            <span>当前位置>公司详细信息</span>
            <span class="fac-information"><a href="#" onClick="javascript :history.back(1);" class="save">返回</a></span>
        </div>
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">公司信息</p>
            </div>
            <div class="unit-list clearfix lastpart">
            <form action = "TenderBidderInfoDtl" method = "post">
                <div class="fl">
                    <div class="list"><label>执照编号</label> : <input type="number" value="<%=bidder_num %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>公司名称</label> : <input type="text" value="<%=bidder_name %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>主营业务</label> : <input type="text" value="<%=bidder_major %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>注册编号</label> : <input type="number" value="<%=bidder_id_num %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>公司地址</label> : <input type="text" value="<%=bidder_nation %>" name="branch" disabled='disabled'/></div>
                    <div class="list"><label>公司类型</label> : <input type="text" value="<%=bidder_political_status %>" name="address" disabled='disabled'/></div>
                </div>
                <div class="fr">
                    <div class="list"><label>电子邮箱</label> : <input type="text" value="<%=bidder_mail %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>是否上市</label> : <input type="text" value="<%=bidder_sex %>" name="branch" disabled='disabled'/></div>
                    <div class="list"><label>电话号码</label> : <input type="text" value="<%=bidder_grade %>" name="username" disabled='disabled'/></div>
                    <div class="list"><label>邮编</label> : <input type="number" value="<%=bidder_mob_no %>" name="address" disabled='disabled'/></div>
                    <div class="list"><label>注册年份</label> : <input type="number" value="<%=bidder_dates %>" name="number" disabled='disabled'/></div>
                    <div class="list"><label>成立日期</label> : <input type="date" value="<%=bidder_birthday %>" name="number" disabled='disabled'/></div>
                </div>
            </form>
            </div>
        </div>
	</div>
</body>

</html>