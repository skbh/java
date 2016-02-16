<%@ page language="java" contentType="text/html; charset=US-ASCII"
    pageEncoding="US-ASCII"%>
<%@ taglib uri="/struts-tags" prefix="s" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=US-ASCII">
<title>Security Thread!,Duplicate Request Detected.</title>
</head>
<body>
<h3>Security Thread! Duplicate Request Detected.</h3>
<h4>To protect the safety of your account, you have been logged out,Error has occured for one of the following Reasons are:</h4>
<ul>
    <li>You have used Back/Forward/Refresh button of your Browser.</li>
    <li>You have clicked twice on any options/buttons.</li>
    <li>You have kept the browser window idle for a long time.</li>
    <li>You have logged in from another browser window</li>
	<li>You are accessing the application URL from a saved or static page.</li>
	<li>You have not used "Microsoft Internet Explorer" Browser.</li>
</ul>
<br>
<s:if test="hasActionErrors()">
    <s:actionerror/>
</s:if>
</body>
</html>