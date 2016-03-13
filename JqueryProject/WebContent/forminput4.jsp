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

	$('#buttonId').click(function() {
		var textValue = $('input[type="text"]');
		if(textValue.length>0){
			$('#result3').html(textValue + " Entered");
		}
		else{
			$('#error3').html("<font color='red'>" + "Please Enter Email ID" + "</font>");
		}
		
			var checked = $('input[type="checkbox"]:checked');
			if (checked.length > 0) {
				var resultLength=checked.length + " check box selected <br/>";
				$(checked).each(function(){
					resultLength += $(this).val() + "<br/>";
				});
				$('#error1').html("");
				$('#result1').html(resultLength);
			} else {
				
				$('#error1').html("<font color='red'>" + "Please Select Qualification" + "</font>");
			}

			var result2 = $('input[type="radio"]:checked');
			console.log(result2);
			if (result2.length > 0) {
				$('#error2').html("");
				$('#result2').html(result2.val() + " is selected");
			} else {
				$('#error2').html("<font color='red'>" + "Please Select Gender" +  "</font>");
			}
		});
	});
</script>


</head>
<body>
<div class="overlay">
	
		<div class="col-xs-12">
			<hr>
		</div>
		<div class="container">
			<h2>Simple Registration Page</h2>
			<div id="result1"></div>
			<div id="result2"></div>
			<div id="result3"></div>
			<form id="formId" class="form-group">
				<div class="form-group">
					<label for="email">Email:</label> <input type="text"
						class="form-control" id="email" placeholder="Enter email"><div id="error3"></div>
				</div>
				<div class="form-group">
					<label for="pwd">Password:</label> <input type="password"
						class="form-control" id="pwd" placeholder="Enter password">
				</div>

				<!-- Row start -->
				<div class="row">
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading clearfix">
								<i class="icon-calendar"></i>
								<h3 class="panel-title">Qualification</h3><div id="error1"></div>
							</div>

							<div class="panel-body">
								<label class="checkbox-inline"> <input type="checkbox"
									id="inlineCheckbox1" value="Graduate"> Graduate
								</label> <label class="checkbox-inline"> <input type="checkbox"
									id="inlineCheckbox2" value="Post-Graduate"> Post-Graduate
								</label> <label class="checkbox-inline"> <input type="checkbox"
									id="inlineCheckbox3" value="Doctorate"> Doctorate
								</label>
							</div>
						</div>
					</div>
					<div class="col-md-6 col-sm-6 col-xs-12">
						<div class="panel panel-default">
							<div class="panel-heading clearfix">
								<i class="icon-calendar"></i>
								<h3 class="panel-title">Select Gender</h3><div id="error2"></div>
							</div>

							<div class="panel-body">
								<label class="radio-inline"> <input type="radio"
									name="optionsRadios" id="optionsRadios1" value="Male">Male
								</label> <label class="radio-inline"> <input type="radio"
									name="optionsRadios" id="optionsRadios2" value="Female">Female
								</label> <label class="radio-inline"> <input type="radio"
									name="optionsRadios" id="optionsRadios3" value="Transgender">Transgender
								</label>
							</div>
						</div>
					</div>

				</div>
				<!-- Row end -->

				<input type="button" id="buttonId" class="btn btn-primary" value="Submit" /> <input
					type="submit" class="btn btn-danger" value="Cancel">
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