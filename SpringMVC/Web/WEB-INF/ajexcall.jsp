<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Spring Jquery Ajax Demo</title>
<style>
Table.GridOne {
 padding: 3px;
 margin: 0;
 background: lightyellow;
 border-collapse: collapse; 
 width:35%;
}
Table.GridOne Td { 
 padding:2px;
 border: 1px solid #ff9900;
 border-collapse: collapse;
}
</style>
<script type="text/javascript">
function madeAjaxCall(){
	var formdata=$("#employeeForm").serialize();
 $.ajax({
  type: "post",
  url: "/SpringMVC/url",
  async: true,  
  data:formdata,/* 'firstName=' + $("#firstName").val() + "&lastName=" + $("#lastName").val() + "&email=" + $("#email").val(), */
  success: function(response){
   $('#result').html("");
   var obj = JSON.parse(response);
   $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
  },
  error: function(){      
	 $('#result').html("Error While processing");
  }
 });
}
</script>
</head>
<body>
 <form name="employeeForm"  id="employeeForm" method="post"> 
  <table cellpadding="0" cellspacing="0" border="1" class="GridOne">
   <tr>
    <td>First Name</td>
    <td><input type="text" name="firstName" id="firstName" value=""></td>
   </tr>
   <tr>
    <td>Last Name</td>
    <td><input type="text" name="lastName" id="lastName" value=""></td>
   </tr>
   <tr>
    <td>Email</td>
    <td><input type="text" name="email" id="email" value=""></td>
   </tr>
   <tr>
    <td colspan="2" align="center"><input type="button" value="Ajax Submit" onclick="madeAjaxCall();"></td>
   </tr>
  </table>
 </form>
  <h1>Spring Framework Jquery Ajax Demo</h1>
 <div id="result"></div>
</body>
</html>



<!-- function madeAjaxCall(){
 $.ajax({
  type: "post",
  url: "SpringMVC/url",
  cache: false,    
  data:'firstName=' + $("#firstName").val() + "&lastName;=" + $("#lastName").val() + "&email;=" + $("#email").val(),
  success: function(response){
   $('#result').html("");
   var obj = JSON.parse(response);
   $('#result').html("First Name:- " + obj.firstName +"</br>Last Name:- " + obj.lastName  + "</br>Email:- " + obj.email);
  },
  error: function(){      
   alert('Error while request..');
  }
 });
} -->