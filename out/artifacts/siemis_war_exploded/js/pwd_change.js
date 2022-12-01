function getpwd(){
    var pwd1=document.getElementById("orig_pwd").value;
    var pwd2=document.getElementById("new_pwd").value;
    var pwd3=document.getElementById("rpt_new_pwd").value;
    var len1=document.getElementById("orig_pwd").value.length;
    var len2=document.getElementById("new_pwd").value.length;
    var len3=document.getElementById("rpt_new_pwd").value.length;

    if(pwd2!=pwd3){
        alert("两次密码输入不一致，请重新输入！");
        location.reload();
        return false;
    }

    if(len2<6 || len3<6){
        alert("密码长度过短，请重新输入！");
        location.reload();
        return false;
    }
    else if(len2>16 || len3>16){
        alert("密码长度过长，请重新输入！");
        location.reload();
        return false;
    }
    else{
        var msg="确认修改密码？";
        if(confirm(msg)==true){
            alert("密码修改成功！");
            location.reload();
            return true;
        }
        else{
            location.reload();
            return false;
        }
    }
}