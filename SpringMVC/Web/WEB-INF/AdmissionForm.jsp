<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>     
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdmissionForm.jsp</title>
<style type="text/css">
.error {
    color: #ff0000;
    font-style: italic;
    font-weight: bold;
}
</style>
</head>
</head>
<body>
<h1>${headermessage}</h1>

<form:form action="/SpringMVC/submitform.Spring" method="post" modelAttribute="student_Model">
<table>
<tr>
<td>Student Name : </td>
<td><form:input path="studentName"/></td>
<td><form:errors path="studentName" /></td>
</tr>

<tr>
<td>Student course :</td>
<td><form:input  path="course" /></td>
<td><form:errors path="course" /></td>
</tr>

<tr>
<td>Address	 : </td>
<td>Type your Full Address</td>

</tr>

<tr>
<td>Country	 : </td>
<td><form:input  path="address.country" /></td>
<td><form:errors path="address.country" /></td>
</tr>

<tr>
<td>City	 : </td>
<td><form:input  path="address.city" /></td>
<td><form:errors path="address.city" /></td>
</tr>

<tr>
<td>Street	 : </td>
<td><form:input  path="address.street" /></td>
<td><form:errors path="address.street" /></td>
</tr>

<tr>
<td>Pin 	 : </td>
<td><form:input  path="address.pincode" /></td>
<td><form:errors path="address.pincode" /></td>
</tr>

<tr>
<td>Contact No: </td>
<td><form:input  path="contact" /></td>
<td><form:errors path="contact" /></td>
</tr>

<tr>
<td>Date of birth :</td>
<td><form:input  path="dob" /></td>
<td><form:errors path="dob" /></td>
</tr>

<tr>
<td>skills		:	</td><td>
<td><form:select path="skills" multiple="true" >
				<form:option value="" label="Select"/>
				<form:option value="Core java" label="Core java"/>
				<form:option value="Spring" label="Spring"/>
				<form:option value="Struts2" label="Struts2"/>
				<form:option value="Hibernate" label="Hibernate"/>
				<form:option value="html" label="html"/>
				<form:option value="CSS" label="CSS"/>
				<form:option value="Java Script"  label="Java Script"/>
				<form:option value="Ibatis"  label="Ibatis"/>
			</form:select>
</td>
<td><form:errors path="skills" /></td>		
</tr>
		
<tr>
<td><form:button id="submit"></form:button></td>
</tr>

</table>
</form:form>

</body>
</html>
