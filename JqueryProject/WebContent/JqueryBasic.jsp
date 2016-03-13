<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Jquery Basics</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
</head>
<body>
	<p id="showAndHide">Mouse Over Hide and show</p>
	<table id="tableId" border="2">

		<tr>
			<td><font color="#66768">Welcome To Jquery Basics</font></td>

			<td><font color="#66768">value of Query</font></td>

		</tr>
	</table>

	<!-- Javascript code below -->

	<script type="text/javascript">
		$(window).load(function() {
			alert("window loaded");
		});

		$(document).ready(function(){
			alert("document is  ready to use");
			
		});
		$(function() {
			$("#h1Id").click(function() {
				$(this).hide();
			});

			$("#showAndHide").mouseover(function() {
				$("#tableId").toggle(200);
			});

		});
	</script>

</body>
</html>