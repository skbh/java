<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="/struts-tags" prefix="s" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Profile update System</title>
</head>
<body>
session value : <s:property value="#session.LOGIN_OK"/><br>
First Name	:<s:property value="#session.firstName"/><br>
Last Name	:<s:property value="#session.lastName"/><br>
UserID		: <s:property value="#session.userId"/><br>
Contact No	:<s:property value="#session.contactNumber"/><br>
Email Id	:<s:property value="#session.emailId"/><br>
Country		:<s:property value="#session.countryName"/><br>
Address		:<s:property value="#session.address"/><br>


<s:form action="update" method="post">
<s:textfield  key="firstname" label="firstname"/>
<s:textfield  key="lastname" label="lastname"/> 
<s:textfield  key="contact" label="contact"/>
<s:textfield  key="email" label="email"/>
<s:textfield  key="country" label="country"/>
<s:textfield  key="address" label="address"/>
<s:token/> <s:a href="logout">Logout</s:a>
<s:submit/>





</s:form>
</body>
</html>