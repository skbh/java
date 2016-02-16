<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>User Registration Form</title>
</head>
<body>
<h1>User Registration Form</h1>
<s:form action="register" method="post" validate="true">
<s:textfield key="username" label="UserName"></s:textfield>
<s:password key="password" label="Password"></s:password>
<s:password key="confirmpassword" label="Confirm-Password"></s:password>
<s:textfield key="firstname" label="First Name"></s:textfield>
<s:textfield key="lastname" label="Last Name"></s:textfield>
<s:textfield key="contact" label="Contact No"></s:textfield>
<s:textfield key="email" label="Email"></s:textfield>
<s:textfield key="country" label="Country"> </s:textfield>
<s:textarea key="address" label="Address"></s:textarea>
<s:submit/>
</s:form>

</body>
</html>