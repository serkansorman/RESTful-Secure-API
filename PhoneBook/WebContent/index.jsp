<!doctype html>
<html>
 
<head>
<meta charset="utf-8">
<title>Form Page</title>
<style>
 
@import url(https://fonts.googleapis.com/css?family=Montserrat:400,700);
 
html{ background:url(http://thekitemap.com/images/feedback-img.jpg) no-repeat;
background-size: cover;
height:100%;
}
 
#feedback-page{
text-align:center;
}
 
#form-main{
width:100%;
float:left;
padding-top:0px;
}
 
#form-div {
background-color:rgba(72,72,72,0.4);
padding-left:35px;
padding-right:35px;
padding-top:35px;
padding-bottom:50px;
width: 450px;
float: left;
left: 50%;
position: absolute;
margin-top:30px;
margin-left: -260px;
-moz-border-radius: 7px;
-webkit-border-radius: 7px;
}
 
.feedback-input {
color:#3c3c3c;
font-family: Helvetica, Arial, sans-serif;
font-weight:500;
font-size: 18px;
border-radius: 0;
line-height: 22px;
background-color: #fbfbfb;
padding: 13px 13px 13px 54px;
margin-bottom: 10px;
width:100%;
-webkit-box-sizing: border-box;
-moz-box-sizing: border-box;
-ms-box-sizing: border-box;
box-sizing: border-box;
border: 3px solid rgba(0,0,0,0);
}
 
.feedback-input:focus{
background: #fff;
box-shadow: 0;
border: 3px solid #3498db;
color: #3498db;
outline: none;
padding: 13px 13px 13px 54px;
}
 
.focused{
color:#30aed6;
border:#30aed6 solid 3px;
}
 
/* Icons ---------------------------------- */
#firstname{
background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
background-size: 30px 30px;
background-position: 11px 8px;
background-repeat: no-repeat;
}
 
#firstname:focus{
background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
background-size: 30px 30px;
background-position: 8px 5px;
background-position: 11px 8px;
background-repeat: no-repeat;
}
 
#lastname{
background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
background-size: 30px 30px;
background-position: 11px 8px;
background-repeat: no-repeat;
}
 
#lastname:focus{
background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
background-size: 30px 30px;
background-position: 8px 5px;
background-position: 11px 8px;
background-repeat: no-repeat;
}


#tcno{
background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
background-size: 30px 30px;
background-position: 11px 8px;
background-repeat: no-repeat;
}
 
#tcno:focus{
background-image: url(http://rexkirby.com/kirbyandson/images/name.svg);
background-size: 30px 30px;
background-position: 8px 5px;
background-position: 11px 8px;
background-repeat: no-repeat;
}



#phone{
background-image: url(http://rexkirby.com/kirbyandson/images/comment.svg);
background-size: 30px 30px;
background-position: 11px 8px;
background-repeat: no-repeat;
}
 
#phone:focus{
background-image: url(http://rexkirby.com/kirbyandson/images/comment.svg);
background-size: 30px 30px;
background-position: 8px 5px;
background-position: 11px 8px;
background-repeat: no-repeat;
}
 
textarea {
width: 100%;
height: 150px;
line-height: 150%;
resize:vertical;
}
 
input:hover, textarea:hover,
input:focus, textarea:focus {
background-color:white;
}
 
#button-blue{
font-family: 'Montserrat', Arial, Helvetica, sans-serif;
float:left;
width: 100%;
border: #fbfbfb solid 4px;
cursor:pointer;
background-color: #3498db;
color:white;
font-size:24px;
padding-top:22px;
padding-bottom:22px;
-webkit-transition: all 0.3s;
-moz-transition: all 0.3s;
transition: all 0.3s;
margin-top:-4px;
font-weight:700;
}
 
#button-blue:hover{
background-color: rgba(0,0,0,0);
color: #0493bd;
}
 
.submit:hover {
color: #3498db;
}
 
.ease {
width: 0px;
height: 74px;
background-color: #fbfbfb;
-webkit-transition: .3s ease;
-moz-transition: .3s ease;
-o-transition: .3s ease;
-ms-transition: .3s ease;
transition: .3s ease;
}
 
.submit:hover .ease{
width:100%;
background-color:green;
}
 
@media only screen and (max-width: 580px) {
#form-div{
left: 3%;
margin-right: 3%;
width: 88%;
margin-left: 0;
padding-left: 3%;
padding-right: 3%;
}
}
</style>
</head>
 
<body>
 

<div id="form-div">
<form id = loginForm class="form" id="form1" name="loginForm" method="post" action="formServlet">
 
<p class="firstname">
<input  name="firstname" type="text" class="validate[required,custom[onlyLetter],length[1,20]] feedback-input" placeholder="Firstname" id="firstname" pattern="[A-Za-z]{1,20}"  maxLength ="20" required />
</p>
 
<p class="lastname">
<input  name="lastname" type="text" class="validate[required,custom[onlyLetter],length[1,20]] feedback-input" placeholder="Lastname" id="lastname" pattern="[A-Za-z]{1,20}"  maxLength ="20" required/>
</p>

<p class="tcno">
<input  name="tcno" type="text" class="validate[required,custom[onlyNumber],length[11,11]] feedback-input" placeholder="T.C No" id="tcno" pattern="[0-9]{1,11}" minlength="11" maxLength ="11" required/>
</p>

<p class="phone">
<input name="phone" type="text" class="validate[required,custom[onlyNumber],length[11,11]] feedback-input" placeholder="Phone number" id="phone" pattern="[0-9]{1,11}" minlength="11" maxLength ="11" required/>
</p>

<input type="radio" name="choice" value="update"><label style="color:white;">Update</label><br>
  <input type="radio" name="choice" value="register" checked><label style="color:white;">Register</label><br><br>
  
  


<div class="submit">
<input type="submit" value="APPLY" id="button-blue"/>
<div class="ease"></div>
</div>
</form>
</div>
<button onclick="addPerson()">Add New Record</button>
<button onclick="addPerson()">Update Record</button>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>




<script>


function addPerson() {
	

    var person = {
   	
        firstname: document.getElementById("firstname").value,
        lastname: document.getElementById("lastname").value,
        phone: document.getElementById("phone").value,
        tcno: document.getElementById("tcno").value
    }

    $('#target').html('sending..');

    $.ajax({
        url: 'rest/addPerson',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
        	alert("Record saved successfully !");
        },
        data: JSON.stringify(person)
    });
}


function updatePerson() {
	

    var person = {
   	
        firstname: document.getElementById("firstname").value,
        lastname: document.getElementById("lastname").value,
        phone: document.getElementById("phone").value,
        tcno: document.getElementById("tcno").value
    }

    $('#target').html('sending..');

    $.ajax({
        url: 'rest/updatePerson',
        type: 'post',
        dataType: 'json',
        contentType: 'application/json',
        success: function (data) {
        	alert("Record updated successfully !");
        },
        data: JSON.stringify(person)
    });
}

</script>
</body>
</html>