<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>
<head>
    <title>Navigation Bar</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/navbar.css">
</head>
<body>
<div class="navbar">
    <a href="<c:url value='/' />"><h1>한성대학교</h1></a>

    <sec:authorize access="isAuthenticated()">
        <button onclick="location.href='<c:url value='/logout' />'">Logout</button>
    </sec:authorize>

    <sec:authorize access="!isAuthenticated()">
        <button onclick="location.href='<c:url value='/login' />'">Login</button>
    </sec:authorize>
</div>
</body>
</html>
