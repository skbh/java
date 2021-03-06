<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib  prefix="form" uri="http://www.springframework.org/tags/form" %>  
<%@taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

</head>
<body>
<blockquote>
<p class="text-left text-capitalize">${headermessage}</p>
<footer>Author <cite title="Source Title">Sushil Kumar Bhaskar</cite></footer>
</blockquote>

	<c:if test="${successMessage ne null}">
		<div class="alert alert-success">${successMessage}</div>
	</c:if>
	
	<c:if test="${logoutMessage ne null}">
		<div class="alert alert-success">${logoutMessage}</div>
	</c:if>
	

	<form:form class="form-signin" action="${pageContext.request.contextPath}/admin/loginProcessor" method="post" modelAttribute="loginDetails">
        <h2 class="form-signin-heading">Please Sign In</h2>
        <label for="inputEmail" class="sr-only">Email address</label>
        <input type="email" id="inputEmail" name="userName" class="form-control" placeholder="Email address" required autofocus>
        <label for="inputPassword" class="sr-only">Password</label>
        <input type="password" id="inputPassword" name="password" class="form-control" placeholder="Password" required>
        <div class="checkbox">
          <label>
            <input type="checkbox" value="remember-me"> Remember me
          </label>
        </div>
        <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
      </form:form>
      

</body>
</html>