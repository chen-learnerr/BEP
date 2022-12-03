function Checkform(){
    var bidder_name=document.getElementById("bidder_name").value;
    var bidder_num=document.getElementById("bidder_num").value;
    var bidder_grd=document.getElementById("bidder_grd").value;
    if(bidder_name=="" && bidder_num=="" && bidder_grd==""){
        alert("请输入查询信息！");
    }
}