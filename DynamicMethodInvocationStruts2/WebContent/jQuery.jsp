<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<html>
<head>
<title>Dispatch Action</title>
<script src="http://code.jquery.com/jquery-2.1.4.min.js"  type="text/javascript"></script>
<script type="text/javascript">
$(document).ready(function() {
    $('#userName').blur(function() {
        $.ajax({
            url : 'displayNumber',
            data : {
                userName : $('#userName').val()
            },
            success : function(responseText) {
                $('#ajaxGetUserServletResponse').text(responseText);
            }
        });
    });
});


</script>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#div1").click(function(){
		$("#div2").slideToggle(500);
		$("#div3").slideToggle(1000);
		
	});
});


$(document).ready(function(){
	$("#div4").click(function(){
		$("#div4").animate({left:'200px',top:'500px'} , 2000);
	
	});
	
	
});
</script>
</head>
<body>

<div id="div1"style="width: 400px;height: 50px; background-color: orange; border-bottom: medium; text-align: center;">
This is jQuery slider example slider ONE
</div>

 <div id="div2" style="width: 400px;height: 50px; background-color: white; border-bottom: medium;  text-align: center;">
This is jQuery slider example slider two
</div>

<div id="div3" style="width: 400px;height: 50px; background-color: green; border-bottom: medium; text-align: center; ">
This is jQuery slider example slider Three
</div>

<div id="div4" style="width: 400px;height: 50px; background-color: maroon;; border-bottom: medium; text-align: center; position: absolute; ">
This is jQuery animation example animate[left to right]
</div>



</body>

</html>