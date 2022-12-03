function infoChange(){
    if(document.getElementById("bidder_num").value=="") document.getElementById("bidder_num").removeAttribute('disabled');
    document.getElementById("bidder_name").removeAttribute('disabled');
    document.getElementById("bidder_major").removeAttribute('disabled');
    document.getElementById("bidder_id").removeAttribute('disabled');
    document.getElementById("bidder_nation").removeAttribute('disabled');
    document.getElementById("bidder_pol").removeAttribute('disabled');
    document.getElementById("bidder_email").removeAttribute('disabled');
    document.getElementById("bidder_sex").removeAttribute('disabled');
    document.getElementById("bidder_grade").removeAttribute('disabled');
    document.getElementById("bidder_call").removeAttribute('disabled');
    document.getElementById("bidder_year").removeAttribute('disabled');
    document.getElementById("bidder_birth").removeAttribute('disabled');
}