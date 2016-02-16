<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@ taglib prefix="s" uri="/struts-tags" %>
    <%@ page language="java"  import="java.util.*"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search Page</title>
<%
response.setHeader("Cache-Control","no-cache,no-store,must-revalidate");
response.setHeader("Pragma","no-cache");
response.setDateHeader("Expires", 0);
%>
<s:head/>

<body>
from session  user Id : <% session.getAttribute("userid"); %>
<b>Session Time: </b><%= new Date(session.getLastAccessedTime())%>
  <br /><br />
  
Welcome <s:property value="name"/> 
<br>User ID :<s:property value="userid"/> 
<br> session Username : <s:property value="#session.userid"/>

 
<s:form action="tutorial/getTutorial" method="post" validate="true">
<s:textfield label="Enter the Language" key="language"></s:textfield>
<s:submit/>
</s:form>
<% session.setAttribute("userId",session.getAttribute("userid")); %>
from session  user Id : <% session.getAttribute("userid"); %>
<br>
session value :<s:property value="#session.LOGIN_OK"/><br>
First Name	:<s:property value="#session.firstName"/><br>
Last Name	:<s:property value="#session.lastName"/><br>
UserID		:<s:property value="#session.userId"/><br>
Contact No	:<s:property value="#session.contactNumber"/><br>
Email Id	:<s:property value="#session.emailId"/><br>
Country		:<s:property value="#session.countryName"/><br>
Address		:<s:property value="#session.address"/><br>

<s:a href="showprofile">Show Profile</s:a>
<s:a href="update.jsp">Update</s:a> 
<s:a href="logout">Logout</s:a>
</body>
</html>