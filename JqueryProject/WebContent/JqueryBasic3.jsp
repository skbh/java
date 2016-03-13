<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jquery Basics-Playing with div title</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
	<p id="showAndHide" title="P_title">Playing with div title</p>
	<div title="div_one">
	Div one title
	</div>
	
	<div title="div_two">
	Div two title
	</div>
	
	
	<span title="div_four">
	Div four title
	</span>
	
	<div title="div_three">
	Div three title
	</div>
	
	<div title="div_four">
	Div four title
	</div>

	<!-- Javascript code below -->

	<script type="text/javascript">
	
	$(document).ready(function(){
		$('[title="div_four"').css('border','2px solid aqua');		
	});

	</script>

</body>
</html>