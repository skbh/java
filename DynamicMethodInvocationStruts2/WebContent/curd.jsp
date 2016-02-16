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
            },
                error: function(xhr, status, error) {
                    alert('Failed to get details: ' + error);
                }
           
        });
    });
});


</script>

<script type="text/javascript">
$(document).ready(function(){
	
	$("#div1").click(function(){
		$("#div2").slideToggle(2000);
		$("#div3").slideToggle(2000);
			/* $("#div2").click(function(){
				 $("#div3").slideToggle(1000);
	}); */

	 
	});
	
 	$("h1").click(function(){
			$(this).hide();
	});
	
	$("h2").dblclick(function(){
			$(this).hide();
	}); 
/* 	
	$("button").click(function(){
		$("p").hide();		
	});
	
	$("#button1").click(function(){
		$("p").show();		
	});  */
	
/* 	$("button").click(function(){
		$("h3").toggle("slow");		
	}); 
	*/
  	$("h3").hover(function(){
		$(this).hide(2000);		
	}); 
	
	$("button").click(function(){
		$("h4").fadeToggle(1000);		
	});
	

	
});
</script>
</head>
<body>
<h1>this is sushil, click to hide me</h1>
<h2>this is sushil, Double click to hide me</h2>
<h3>hide this content [ Click to Hide ] [ Click to show] <br>$("button").click(function(){
		$("h3").toggle(2000);		
	}); </h3>
	
<button>Click to Hide and show [Toggle]</button>
<h4>hide this content [ Click to Hide ] [ Click to show] <br>	$("#button3").hover(function(){
		$("h1").fadeIn("slow");		
	}); </h4>
<h4>hide this content [ Click to Hide ] [ Click to show] <br>	$("#button3").hover(function(){
		$("h1").fadeIn("slow");		
	}); </h4>
	<h4>hide this content [ Click to Hide ] [ Click to show] <br>	$("#button3").hover(function(){
		$("h1").fadeIn("slow");		
	}); </h4>
<!-- <button id="button1">Click to show</button>
<button id="button2">Click to hide and show</button> -->


<div id="div1"style="width: 400px;height: 50px; background-color: orange; border-bottom: medium; text-align: center;">
This is jQuery slider example slider ONE
</div>

 <div id="div2" style="width: 400px;height: 50px; background-color: white; border-bottom: medium;  text-align: center;">
This is jQuery slider example slider two
</div>

<div id="div3" style="width: 400px;height: 50px; background-color: green; border-bottom: medium; text-align: center; ">
This is jQuery slider example slider Three
</div>


<!-- <div id="div1"style="width: 400px;height: 50px; background-color: orange; border-bottom: medium; text-align: center;">
This is jQuery slider example slider ONE
</div>

 <div id="div2" style="width: 400px;height: 50px; background-color: white; border-bottom: medium;  text-align: center; display: none;">
This is jQuery slider example slider two
</div>

<div id="div3" style="width: 400px;height: 50px; background-color: green; border-bottom: medium; text-align: center; display: none;">
This is jQuery slider example slider Three
</div> -->
<s:form action="Number">
<table>
	<tr><td><s:textfield name="number1" label="Number 1 " id="number1"/></td></tr>
	<tr><td><s:textfield name="number2" label="Number 2 " id="number2"/></td></tr>
	<tr><td><s:textfield name="result" label="Result " readonly="true" /></td></tr>
	<tr><td><s:textfield name="methodName" label="Method involked " readonly="true" /></td></tr>
	<tr>
		<td><s:submit action="addNumber" value="Add" align="left"/></td>
		<td><s:submit action="subtractNumber" value="Subtract" align="left"/></td>
		<td><s:submit action="divideNumber" value="Divide" align="left"/></td>
		<td><s:submit action="multiplyNumber" value="Multiply" align="left"/></td>
		<td><s:submit action="displayNumber" value="display" align="left"/></td>
		<td><s:submit align="left"/></td>
		<td></td>
		
	</tr>
</table>
</s:form>

    <form>
        Enter Your Name: <input type="text" id="userName" />
    </form>
    <br>
    <br>
 
    <strong>Ajax Response</strong>:
    <div id="ajaxGetUserServletResponse" contenteditable="false" dir="ltr"></div>



</body>

</html>