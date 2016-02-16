<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Welcome to Hibernate struts2 app</title>
<script src="/script/angular.min.js"></script>

</head>
<body>
<h1>Employee Detail</h1>
<s:form action="User" namespace="/action">
<s:textfield label="Enter Id" name="eid" />
<s:textfield label="Enter Name" name="name" />
<s:textfield label="Enter City" name="city"  />
<s:textfield label="Enter Salary" name="salary"/>
  <s:submit action="saveUser" value="Save"/>
  <s:submit action="deleteUser" value="Delete"/>
  <s:submit action="updateUser" value="Update"/>
  <s:submit action="queryUser" value="Query"/>
  <s:submit action="showallUser" value="ShowAll"/>
  
</s:form>
<hr>
<s:property value="message"/>
Welcome <s:property value="username"/>!
<h3>Your username is:<s:property value="username"/></h3>
<h3>Your password is:<s:property value="password"/></h3>
<hr>
<table border="1">
<%! int i=1; %>
<tr>
  <td>S.No</td>
  <td>Employee ID</td> 
  <td>Employee Name</td>
  <td>Employee city </td>
  <td>Employee Salary</td>
  </tr>
  <s:iterator value="emps">
  <tr>
  <td><%= i++ %></td>
  <td><s:property value="eid"/> </td> 
  <td><s:property value="name"/></td>
  <td><s:property value="city"/></td>
  <td><s:property value="salary"/></td>
  </tr>
</s:iterator>
</table>

</body>
</html>