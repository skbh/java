<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Form input</title>

<style type="text/css">
.overlay {
	opacity: 1.8;
	position: fixed;
	width: 97%;
	height: 100%;
	top: 10px;
	left: 10px;
	right: 10px;
	z-index: 1000;
}
</style>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<script type="text/javascript">
  
$(document).ready(function(){
	$('#buttonId').click(function(){
		if(!(validateEmailField("email"))){
			return false;
		}
		 if(!(validatePasswordField("pwd"))){
			return false;
		} 
		$("#formId").submit();
	});
});


	
function validateEmailField(id) {
		if ($('#' + id).val() == null || $('#' + id).val().length == 0) {
			var div = $('#' + id).closest("div");
			div.addClass("has-error");
			/* $('#error1').html("<font color='red'>" + "Please Enter Email ID" + "</font>"); */
			$('#' + id).attr("placeholder", "Type your email here").focus();
			return false;
			}
		else{
			var div = $('#' + id).closest("div");
			div.removeClass("has-error has-feedback");
			/* $('#error1').html(""); */
			return true;
		}
}

function validatePasswordField(id) {
	if (($('#' + id).val() == null || $('#' + id).val().length == 0)) {
		var div = $('#' + id).closest("div");
		div.addClass("has-error");
		/* $('#error2').html("<font color='red'>" + "Please Enter Password ID" + "</font>"); */
		$('#' + id).attr("placeholder", "Type your password here").focus();
		return false;
		}
	else{
		var div = $('#' + id).closest("div");
		div.removeClass("has-error");
		/* $('#error2').html(""); */
		return true;
	}
}
</script>


</head>
<body>
<div class="overlay">
	
		<div class="col-xs-12">
		<hr>
		</div>
		<div class="container">
			<h2>Registration Page Validation</h2>
			<div id="result1"></div>
			<div id="result2"></div>
			<div id="result3"></div>
			<form method="post" id="formId"  action="" role="form">
				<div class="col-sm-8">
					<label for="email">Email:</label> 
					<input type="text"	class="form-control" id="email" placeholder="Enter email">
					<div id="error1"></div>
				</div>
				<div class="col-sm-8">
					<label for="pwd">Password:</label>
					 <input type="password"	class="form-control" id="pwd" placeholder="Enter password">
					 <div id="error2"></div>
				</div>

				<div class="col-sm-8">
					<label for="rpwd">Confirm Password:</label>
					 <input type="password"	class="form-control" id="rpwd" placeholder="Confirm password">
					 <div id="error3"></div>
				</div>


				<div class="col-sm-8">
				<label for="textArea">Comments</label> 
					<textarea id="textAreaId" class="form-control " rows="3" style="resize: none">
	   			</textarea>
	   			<div id="error4"></div>
				</div>
				<div class="col-sm-8"><br><br>
					<button type="submit" id="buttonId" class="btn btn-primary">Submit</button>
					<button type="button" class="btn btn-danger">Cancel</button>
				</div>
			</form>
		</div>
		<div class="col-xs-12">
			<hr>
		</div>
	</div>
</body>
</html>


















<!-- 	<ul class="nav navbar-nav navbar-right">
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#">Login <span
					class="glyphicon glyphicon-log-in"></span></a>
				<div class="dropdown-menu">
					<form id="formlogin" class="form container-fluid">
						<div class="form-group ">
							<label for="inputWarning">Name:</label> <input type="text"
								class="form-control" id="usr">
						</div>
						<div class="form-group">
							<label for="pwd">Password:</label> <input type="password"
								class="form-control" id="pwd">
						</div>
						<div class="checkbox">
							<label><input type="checkbox"> Remember me</label>
						</div>
						<button type="button" id="btnLogin" class="btn btn-block">Login</button>
					</form>
					<div class="container-fluid">
						<a class="small" href="#">Forgot password?</a>
					</div>
				</div></li>
		</ul> -->
		