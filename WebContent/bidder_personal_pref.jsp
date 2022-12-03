<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="beans.BidderPref"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
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
	<script src="js/ajax.js" type="text/javascript" charset="utf-8"></script>
</head>

<body>
    <div class="content">
        <div class="information-title">
            <span>当前位置>投标偏好</span>
        </div>
        <div class="unit-information lastpart">
            <div class="unit">
                <p class="unit-content">投标偏好</p>
            </div>
            <input type="button" value="增加偏好" style="margin-left: 100px;" onclick="setValue()">
	        <form>
		        <table id="addTable">
		            <tbody id="templeteTBody" style="display: none;">
		                <tr>
		                    <td><label style="margin-left: 100px;">偏好类型：</label></td>
		                    <td><input type="text" id="pref_type" list="typelist"/>
		                    <datalist id="typelist">
		                    	<option>建设项目前期咨询招标</option>
		                    	<option>工程勘察设计招标</option>
								<option>材料设备采购招标</option>
								<option>施工招标</option>
		                    </datalist></td>
		                    <td>项目规模：</td>
		                    <td><input type="text" id="pref_name"/></td>
		                    <td><input type="button" value="删除" onclick="deleteRow(this)" /></td>
		                </tr>
		            </tbody>
				    <%
					    List<BidderPref> list = (List<BidderPref>)request.getAttribute("bidderPreflist");
					    if(list != null) {
						    for(int i = 0; i < list.size(); i++) {
							    BidderPref bidder_pref = list.get(i);
				    %>
		            <tbody>
		                <tr>
		                    <td><label style="margin-left: 100px;">偏好类型：</label></td>
		                    <td><input type="text" id="pref_type" value="<%=bidder_pref.getPref_type() %>"/></td>
		                    <td>项目规模：</td>
		                    <td><input type="text" id="pref_name" value="<%=bidder_pref.getPref_name() %>"/></td>
		                    <td><input type="button" value="删除" onclick="deleteRow(this)" /></td>
		                </tr>
		            </tbody>
	           	    <%		
	           			    }
	            	    }	
	           	    %>
		            <tbody id="footTbody">
		            </tbody>
		        </table>
		        <input type="button" value="更新" style="margin-left: 100px;"  onclick="prefSummit()">
	        </form>
        </div>
	</div>
</body>

<script type="text/javascript">
    function addRow() {
    	var num = document.getElementsByTagName("tbody").length - 2;
        var table = document.getElementById("addTable");
        var tbody = document.getElementById("templeteTBody");
        var newTBody = tbody.cloneNode(true);
        newTBody.style.display = "";
        newTBody.id = 'pref' + num;
        var footTBody = document.getElementById("footTbody");
        return table.insertBefore(newTBody, footTBody);
    }
    function deleteRow(obj) {
        var tbody = obj.parentNode.parentNode.parentNode;
        var table = document.getElementById("addTable");
        table.removeChild(tbody);
    }
    function setValue() {
        var tbody = addRow();
    }
    function prefSummit() {
    	var url="BidderPrefChange";
    	var num = document.getElementsByTagName("tbody").length - 2;
    	var bodyList = document.getElementsByTagName("tbody");
    	var param = "";
    	for(var i = 0; i < num; i++) {
    		var pref_type = bodyList[i+1].getElementsByTagName("input").pref_type.value;
    		var pref_name = bodyList[i+1].getElementsByTagName("input").pref_name.value;
    		if(pref_type != "" && pref_name != "") {
    			param = param+"pref"+i+"type="+ pref_type +"&pref"+i+"name="+ pref_name +"&";
    		}
    	}
    	param = param+"pref_num="+num;
    	sendRequest(url,param,'POST', changeResult);
    }
    function changeResult() {
    	if(httpRequest.readyState == 4) {
			if(httpRequest.status == 200) {
				var info=httpRequest.responseText;
				alert(info);
			}
		}
    }
</script>

</html>