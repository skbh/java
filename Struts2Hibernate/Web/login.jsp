<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login App</title>
</head>
<body>
<s:form action="login" namespace="/action">
<s:textfield  label="Username" name="username"/>
<s:textfield label="Password" name="password"/>
<s:submit action="signlogin" value="Login"/>
<s:submit action="createlogin" value="Create User"/>
</s:form>
<s:property value="message"/>
</body>
</html>