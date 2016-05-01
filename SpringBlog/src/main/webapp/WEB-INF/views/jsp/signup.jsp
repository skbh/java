<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">


<script type="text/javascript">
  
$(document).ready(function(){
	$('#buttonId').click(function(){
		if(!(validateUserNameField("userName"))){
			return false;
		}
		
		if(!(validatePasswordField("inputPassword"))){
			return false;
		}
		
		if(!(validateEmailField("inputEmail"))){
			return false;
		}
		if(!(validateGenderField("male","female","trangender"))){
			return false;			
		}
		
		if(!(validateCountryField("country"))){
			return false;
		}
		
		$("#formId").submit();
	});
});


	
function validateUserNameField(id) {
		if ($('#' + id).val() == null || $('#' + id).val().length == 0 || $('#' + id).val()=="-") {
			var div = $('#' + id).closest("div");
			div.addClass("has-error has-feedback");
			$("#glypcn"+id).remove();
			div.append('<span id="glypcn'+id+'"  class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
			/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
			$('#' + id).attr("placeholder", "Type your UserName And Press Enter").focus();
			return false;
			}
		else{
			var div = $('#' + id).closest("div");
			div.removeClass("has-error");
			div.addClass("has-success has-feedback");
			$("#glypcn"+id).remove();
			div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
			/* $('#error1').html(""); */
			return true;
		}
}


function validatePasswordField(id) {
	if ($('#' + id).val() == null || $('#' + id).val().length == 0 || $('#' + id).val()=="-") {
		var div = $('#' + id).closest("div");
		div.addClass("has-error has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'"  class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
		$('#' + id).attr("placeholder", "Type your Password And Press Enter").focus();
		return false;
		}
	else{
		var div = $('#' + id).closest("div");
		div.removeClass("has-error");
		div.addClass("has-success has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html(""); */
		return true;
	}
}



function validateEmailField(id) {
	var regex = /^([a-zA-Z0-9_.+-])+\@(([a-zA-Z0-9-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	if ($('#' + id).val() == null || $('#' + id).val().length == 0 || !regex.test($('#' + id).val())) {
		var div = $('#' + id).closest("div");
		div.addClass("has-error has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'"  class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
		$('#' + id).attr("placeholder", "Type your email And Press Enter").focus();
		return false;
		}
	else{
		var div = $('#' + id).closest("div");
		div.removeClass("has-error");
		div.addClass("has-success has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html(""); */
		return true;
	}
}



function validateGenderField(id,id2,id3) {
		var male=($('[name="id"]:checked').length ==0  || $('#' + id).val() == null)?true:false;
		var female=($('[name="id2"]:checked').length ==0  || $('#' + id2).val() == null)?true:false;
		var transgender=($('[name="id3"]:checked').length ==0  || $('#' + id3).val() == null)?true:false;
		console.log($('#' + id).val() + male + " " + $('#' + id2).val()+ female +" "+ $('#' + id3).val() + transgender);
		if ((male || female || transgender)) {
		var div = $('#' + id).closest("div");
		div.addClass("has-error has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'"  class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
		$('#' + id).attr("placeholder", "Select Gender And Press Enter").focus();
		console.log(male + " " + female +" " + transgender);
		return false;
		}
	else{
		var div = $('#' + id).closest("div");
		div.removeClass("has-error");
		div.addClass("has-success has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html(""); */
		return true;
	}
}




function validateCountryField(id) {
	if ($('#' + id).val() == null || $('#' + id).val().length == 0 || $('#' + id).val()=="-") {
		var div = $('#' + id).closest("div");
		div.addClass("has-error has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'"  class="glyphicon glyphicon-remove form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
		$('#' + id).attr("placeholder", "Type select country And Press Enter").focus();
		return false;
		}
	else{
		var div = $('#' + id).closest("div");
		div.removeClass("has-error");
		div.addClass("has-success has-feedback");
		$("#glypcn"+id).remove();
		div.append('<span id="glypcn'+id+'" class="glyphicon glyphicon-ok form-control-feedback" aria-hidden="true"></span>');
		/* $('#error1').html(""); */
		return true;
	}
}


</script>

</head>
<body>
	<blockquote>
		<p class="text-left text-capitalize">${headermessage}</p>
		<footer>Author <cite title="Source Title">Sushil Kumar
			Bhaskar</cite></footer>
		<%-- p class="text-left"><h4>private page : <a href="<c:url value='/logout'/>">Logout</h4></a></p> --%>

		<%-- 
<c:url var="logoutUrl" value="/logout"/>
<!-- logout section -->
<form action="${logoutUrl}" method="post">
    <input type="submit" value="Logout"/>
    <a href="javascript:{}" onclick="submit()">Logout</a>
    <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>
<!-- end logout section --> --%>
		<c:set var="userName"
			value="${pageContext.request.userPrincipal.name}"></c:set>
		<c:if test="${userName ne null}">
			<div class="alert alert-success">Welcome : ${userName} | You
				are superuser</div>
		</c:if>


	</blockquote>
	<form:form class="form-horizontal has-feedback"	id="formId" action="${pageContext.request.contextPath}/admin/registerProcessor"		method="post" modelAttribute="loginDetails">
		
		
		 <div class="form-group">
		
		 <div class="col-sm-6">
			<label>Create Your Blog Account</label>
		</div>
		</div>
		
		 <div class="form-group has-feedback">
		<label for="userName" class="col-sm-2 control-label" >User Name</label>
		 <div class="col-sm-6">
		<form:input path="userName" id="userName" class="form-control"	placeholder="User Name"  />
		</div>
		</div>
		
		 <div class="form-group has-feedback">
		<label for="inputPassword" class="col-sm-2 control-label" >Password</label>
		 <div class="col-sm-6">
		<form:password path="password" id="inputPassword" class="form-control"	placeholder="Password" />
		</div>
		 </div>
		  <div class="form-group has-feedback">
		<label for="inputEmail" class="col-sm-2 control-label">Email address</label>
		 <div class="col-sm-6">
		<form:input path="email"  id="inputEmail" class="form-control"	placeholder="Email address"  />
		</div>
		 </div>
		 
		 <div class="form-group has-feedback">
		<label for="male" class="col-sm-2 control-label">Gender</label>
		 <div class="col-sm-6">
		<div class="radio">
			<label> <form:radiobutton path="sex" id="male" value="Male"/>Male</label>
		</div>
		<div class="radio">
			<label> <form:radiobutton path="sex" id="female" value="Female"/>Female</label>
		</div>
		
		<div class="radio">
			<label> <form:radiobutton path="sex" id="trangender" value="Transgender"/>Trangender</label>
		</div>
		
		</div>
		 </div>

		<div class="form-group has-feedback">
			<label for="country" class="col-sm-2 control-label">Country</label>
			<div class="col-sm-6">
			<form:select path="country" id="country" class="form-control">
              <form:option value="-" label="--Select Country--"/>
              <form:options items="${country}"/>
          </form:select>
			</div>
		</div>


		<div class="form-group">
			<div class="col-sm-6">
				<button class="btn btn-primary" type="submit" id="buttonId">Sign up</button>
				<button class="btn btn-warning" type="reset">Reset</button>
				<button class="btn btn-danger" type="button">Cancel</button>
			</div>
		</div>

	</form:form>


</body>
</html>