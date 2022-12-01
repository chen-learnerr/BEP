<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.util.List" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title></title>
    <meta name="Generator" content="EditPlus">
    <meta name="Author" content="">
    <meta name="Keywords" content="">
    <meta name="Description" content="">
    <link rel="stylesheet" href="css/infoCommon.css">
    <link rel="stylesheet" href="css/stu_right.css">
	<script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
</head>

<%
	List<String> info_list = (List<String>)session.getAttribute("new_proj_notify");
	if(info_list == null) {
		info_list = new ArrayList<String>();
	}
	List<String> del_notify_list = (List<String>)session.getAttribute("del_notify_list");
	if(del_notify_list == null) {
		del_notify_list = new ArrayList<String>();
	}
	List<String> rev_notify_list = (List<String>)session.getAttribute("rev_notify_list");
	if(rev_notify_list == null) {
		rev_notify_list = new ArrayList<String>();
	}
%>
<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>消息通知</span>
        </div>
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">消息通知</p>
            </div>
            <div class="my_msg_list_title" style="padding-left: 20px;">
                <span>消息总数：</span><span><%=info_list.size()+del_notify_list.size()+rev_notify_list.size()%></span>
            </div>
            <div class="msg_list">
                <ul class="msg_list_ul">
                <%
			     	if(info_list != null && !info_list.isEmpty()){
			     		for(int i=0; i<info_list.size(); i++){
			     			String info = (String)info_list.get(i);
 				%>
                    <li class="msg_list_ul_li" style="width: 750px;">
                        <span class="msg_type">新项目</span>
                        <div class="msg_content "><%=info%></div>
                    </li>
				<%
     					}
     				}
    			%> 
    			<%
			     	if(del_notify_list != null && !del_notify_list.isEmpty()){
			     		for(int i=0; i<del_notify_list.size(); i++){
			     			String info = (String)del_notify_list.get(i);
 				%>
                    <li class="msg_list_ul_li" style="width: 750px;">
                        <span class="msg_type">项目变更</span>
                        <div class="msg_content "><%=info%></div>
                    </li>
				<%
     					}
     				}
    			%> 
    			<%
			     	if(rev_notify_list != null && !rev_notify_list.isEmpty()){
			     		for(int i=0; i<rev_notify_list.size(); i++){
			     			String info = (String)rev_notify_list.get(i);
 				%>
                    <li class="msg_list_ul_li" style="width: 750px;">
                        <span class="msg_type">申请结果变更</span>
                        <div class="msg_content "><%=info%></div>
                    </li>
				<%
     					}
     				}
    			%> 
                </ul>
            </div>       
            <div class="page-box">
            </div> 
        </div>
	</div>
</body>

</html>
