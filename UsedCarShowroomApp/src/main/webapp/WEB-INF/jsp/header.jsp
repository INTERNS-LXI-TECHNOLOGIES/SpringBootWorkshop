<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="contextPath" value="${pageContext.request.contextPath}"/>
<!DOCTYPE html>
<div class="header">
	<h2>
		<b>Used Car Showroom Application</b>
	</h2>
	<h4 class="links mt-4">
		<b> <a href="${contextPath}/home" class="${navAction == 'home' or navAction == 'search' or navAction == 'filter' ? 'selected' : ''}">Home</a>
			&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${contextPath}/create" class="${navAction == 'car' ? 'selected' : ''}">Car Details</a>
			&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${contextPath}/create-owner" class="${navAction == 'owner' ? 'selected' : ''}">Owner Details</a>
			&nbsp;&nbsp;|&nbsp;&nbsp; <a href="${contextPath}/logout">Logout</a>
		</b>
	</h4>
</div>
