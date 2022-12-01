function infoChange(){
    if(document.getElementById("stu_num").value=="") document.getElementById("stu_num").removeAttribute('disabled');
    document.getElementById("stu_name").removeAttribute('disabled');
    document.getElementById("stu_major").removeAttribute('disabled');
    document.getElementById("stu_id").removeAttribute('disabled');
    document.getElementById("stu_nation").removeAttribute('disabled');
    document.getElementById("stu_pol").removeAttribute('disabled');
    document.getElementById("stu_email").removeAttribute('disabled');
    document.getElementById("stu_sex").removeAttribute('disabled');
    document.getElementById("stu_grade").removeAttribute('disabled');
    document.getElementById("stu_call").removeAttribute('disabled');
    document.getElementById("stu_year").removeAttribute('disabled');
    document.getElementById("stu_birth").removeAttribute('disabled');
}