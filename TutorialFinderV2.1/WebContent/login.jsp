<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login Page</title>
</head>
<body>

<table bgcolor="FFFFCC" align="center" border="2"><tr><td align="center"><font color="red">Login Area</font></td></tr>
<tr><td>
<s:form action="login">
	<s:fielderror name="invalid"/>
	<s:actionmessage/>
	<s:textfield label="Login ID" key="userid"></s:textfield>
	<s:password label="Password" key="password"></s:password>
	<s:token/>
<s:submit label="Login"></s:submit>
</s:form>
</td></tr>
<tr><td>
<s:a href="ForgotPassword.jsp">Forgot password</s:a></td></tr>
</table>

</body>
</html>