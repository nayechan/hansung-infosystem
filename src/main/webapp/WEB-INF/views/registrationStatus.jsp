<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>수강 신청 조회</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registrationStatus.css">
</head>
<body>
<!-- Navigation Bar -->
<jsp:include page="navbar.jsp" />
<div class="container">
    <h1>수강 신청 조회</h1>
    <table>
        <tr>
            <th>연도</th>
            <th>학기</th>
            <th>교과목명</th>
            <th>교과구분</th>
            <th>담당교수</th>
            <th>학점</th>
        </tr>
        <c:forEach items="${registrations}" var="registration">
            <tr>
                <td>${registration.year}</td>
                <td>${registration.semester}</td>
                <td>${registration.name}</td>
                <td>${registration.category}</td>
                <td>${registration.professor}</td>
                <td>${registration.credit}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
