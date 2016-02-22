<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div style="background-color:gray; font-family: sans-serif; color:white; " align="center">
Know your Lin Response : ${HeaderMesageSSDS}
</div>
<div style="background-color: silver; font-family: sans-serif; color:navy; ">
<table>
<tr>
<td>Error Code :</td><td>${errorMessage.errorCode}</td>
</tr>
<tr>
<td>Error Message  : </td><td>${errorMessage.errorMesssage}</td>
</tr>
<tr>
<td>Error Message Information  :</td><td>${errorMessage.errorInfo}</td>
</tr>
</table>

</div>
     <div style="background-color:gray; font-family: sans-serif; color:white; font-size: x-small; " align="center" >
Information : Welcome to Unified Portal for Registration of Units for LIN, Reporting of Inspection, Submission of returns and Grievance Redressal...<br>
***The employers who are registered with EPFO and have been using the online return portal ECR Portal of EPFO find the code number as Establishment ID on the right hand top corner of the portal after login.
</div>
</body>
</html>