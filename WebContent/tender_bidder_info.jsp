<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<%@page import="beans.BidderInfo" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <link rel="stylesheet" href="css/tabelCommon.css">
    <link rel="stylesheet" href="css/CurrentProjectList.css">
    <script src="js/tender_bidder_info.js"></script>
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>公司信息</span>
        </div>
        <!--项目信息开始-->
        <div class="unit-information">
            <div class="unit">
                <p class="unit-content">查询</p>
            </div>
            <div class="unit-list clearfix">
            <form action = "TenderBidderInfoQuery" method = "post">
                <div class="querycol"><label>公司名称</label> : <input type="text" value="" name="bidder_name" id="bidder_name"/></div>
                <div class="querycol"><label>执照编号</label> : <input type="text" value="" name="bidder_num" id="bidder_num"/></div>
                <div class="querycol"><label>电话号码</label> : <input type="text" value="" name="bidder_grd" id="bidder_grd"/></div>
                <div class="querycol"><input type="submit" value="查询" onclick="Checkform()"/></div>
            </form>
            </div>
        </div>
        <!--项目信息结束-->
        <!--报到证档案信息开始-->
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">查询结果</p>
            </div>
            <div class="unit-list clearfix">
                <table>
                    <tr>
                        <th>执照编号</th>
                        <th>公司名称</th>
                        <th>是否上市</th>
                        <th>电话号码</th>
                        <th>主营业务</th>
                        <th>电话号码</th>
                        <th>详细情况</th>
                    </tr>
                    <%
                        List<BidderInfo> list = (List<BidderInfo>)request.getAttribute("bidder_list");
                        if(list != null){
                        	for(int i=0;i<list.size();i++){
                        		BidderInfo bidder_info = (BidderInfo)list.get(i);
                    %>
                    <tr>
                        <td><%=bidder_info.getBidder_num() %></td>
                        <td><%=bidder_info.getBidder_name() %></td>
                        <td><%=bidder_info.getBidder_sex() %></td>
                        <td><%=bidder_info.getBidder_mob_no() %></td>
                        <td><%=bidder_info.getBidder_major() %></td>
                        <td><%=bidder_info.getBidder_grade() %></td>
                        <td><a href="TenderBidderInfoDtl?bidder_num=<%=bidder_info.getBidder_num() %>">详细信息</a></td>
                    </tr>
                    <%
                        	}
                        }
                    %>
                </table>

            </div>
        </div>
        <!--报到证档案信息结束-->
    </div>


</body>

</html>