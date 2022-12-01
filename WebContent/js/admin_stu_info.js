function Checkform(){
    var stu_name=document.getElementById("stu_name").value;
    var stu_num=document.getElementById("stu_num").value;
    var stu_grd=document.getElementById("stu_grd").value;
    if(stu_name=="" && stu_num=="" && stu_grd==""){
        alert("请输入查询信息！");
    }
}