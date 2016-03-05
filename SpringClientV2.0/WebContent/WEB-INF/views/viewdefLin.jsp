<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<div style="background-color: silver; font-family: sans-serif; color: blue; ">
<table border="1" align="center" style="width:50%">
        <thead>
            <tr>
                <th>Key </th>
                <th>Value</th>
             
            </tr>
        </thead>
        <tbody>
            <tr>
                    <td>${testPojo.key}</td>
                    <td>${testPojo.value}</td>
                                   
                </tr>
           
        </tbody>
    </table> 
    </div>
</body>
</html>