<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>AdmissionForm.jsp</title>
</head>
<body>
<h1>Welcome to ${headermessage}</h1>
<table>
<tr>
<td>Student Name</td>
<td>${student_Model.studentName}</td>
</tr>

<tr>
<td>Student Course</td>
<td>${student_Model.course}</td>
</tr>



<tr>
<td>Student Contact No</td>
<td>${student_Model.contact}</td>
</tr>

<tr>
<td>Student date of birth</td>
<td>${student_Model.dob}</td>
</tr>

<tr>
<td>Student skills</td>
<td>${student_Model.skills}</td>
</tr>

<tr>
<td>Student Address : </td>
<td>
${student_Model.address.city}
${student_Model.address.street}
${student_Model.address.country}
${student_Model.address.pincode}
</td>
</tr>

</table>
</body>
</html>