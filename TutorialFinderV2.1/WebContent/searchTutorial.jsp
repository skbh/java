<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Tutorial</title>
</head>
<body>
Search Tutorial page called!
<s:form action="tutorial/getTutorial" validate="true">
<s:textfield label="Enter the Language" key="language"></s:textfield>
<s:submit/>
</s:form>

</body>
</html>