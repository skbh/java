<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<tiles:insertAttribute  name="header"/>
</head>
<body>
<tiles:insertAttribute name="menu"/>
<div class="container">

<tiles:insertAttribute name="body"/>
...
<center>
<tiles:insertAttribute  name="footer"/>
</center>
</div>
</body>
</html> 