<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/2.1.3/jquery.min.js"></script> 
<title>default.jsp</title>
<script type="text/javascript">
function startAjex(){
	var formData=$("#ajaxFormRequest").serialize();
	console.log("formData " + formData);
	$.ajax({
	type:"POST",
	url:"/SpringMVC/ajexurl",
	date:formData,
	async: true,
	success: function(response){
		$("#jsonMessage").text(response);
		console.log("response " + response);
	},
	error: function(e){
		console.log("Error " + e);
	}
});
	
}

function randomNumber(){
	$.ajax({
		type:"POST",
		url:"/SpringMVC/random",
		success: function(response){
			$("#randomMessage").text(response);
		},
		error:function(error){
			$("#randomMessage").text(error);
		},
		complete:function(done){
			$("#randomMessage").text(done);
		}
		
		
	});
}
</script>
</head>
<body>
Dynamic web application default.jsp

<form id="ajaxFormRequest"  name="ajaxFormRequest" action="/SpringMVC/ajexurl" method="get">
<input type="text" id="t1" name="t1">
<input type="text" id="t2" name="t2">
<input type="button" value="ajexCaLL" onclick="startAjex()">
</form> 

<form id="Random"  name="Random" action="/SpringMVC/ajexurl" method="post">
<input type="button" value="getRandomCaLL" onclick="randomNumber()">
</form> 

<span id="jsonMessage"></span>
<span id="randomMessage"></span>
</body>
</html>