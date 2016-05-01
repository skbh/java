<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!-- logout section -->
<c:url var="logoutUrl" value="/logout" />
<form action="${logoutUrl}" method="post" id="logoutForm">
	<input type="hidden" name="${_csrf.parameterName}"
		value="${_csrf.token}" />
</form>



<script>
	function logoutFunction() {
		document.getElementById("logoutForm").submit();
	}
</script>

<!-- Static navbar -->
<nav class="navbar navbar-default">
	<div class="container-fluid">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="/">Spring MVC</a>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav">
				<li class="active"><a href='<spring:url value="/"/>'>Home</a></li>
				<li><a href='<spring:url value="/admin/signin"/>'>Login</a></li>
				<li><a href='<spring:url value="/admin/register"/>'>Register</a></li>
				<li class="dropdown"><a href="#" class="dropdown-toggle"
					data-toggle="dropdown" role="button" aria-haspopup="true"
					aria-expanded="false">Dropdown <span class="caret"></span></a>
					<ul class="dropdown-menu">
						<li><a href="#" onclick="logoutFunction();">Logout</a></li>
						<li><a href="#">Another action</a></li>
						<li><a href="#">Something else here</a></li>
						<li role="separator" class="divider"></li>
						<li class="dropdown-header">Nav header</li>
						<li><a href="#">Separated link</a></li>
						<li><a href="#">One more separated link</a></li>
					</ul></li>
			</ul>
			<ul class="nav navbar-nav navbar-right">
				<c:set var="userName"
					value="${pageContext.request.userPrincipal.name}"></c:set>
				<c:choose>
					<c:when test="${userName ne null}">
						<li class="active"><a href="#" onclick="logoutFunction();">Logout
								<span class="sr-only">(current)</span>
						</a></li>
					</c:when>
					<c:otherwise>
					<li><a href="#"></a></li>					
					</c:otherwise>
				</c:choose>
				<li><a href="../navbar-static-top/">Static top</a></li>
				<li><a href="../navbar-fixed-top/">Fixed top</a></li>
			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	<!--/.container-fluid -->
</nav>