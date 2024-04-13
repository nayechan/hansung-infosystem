<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course List</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courses.css">
</head>
<body>
<!-- Navigation Bar -->
<jsp:include page="navbar.jsp" />
<div class="container">
    <h2>학기별 수강 내역</h2>
    <table>
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>교과목명</th>
            <th>교과구분</th>
            <th>담당교수</th>
            <th>학점</th>
        </tr>
        <c:forEach var="course" items="${courses}">
            <tr>
                <td>${course.year}</td>
                <td>${course.semester}</td>
                <td>${course.name}</td>
                <td>${course.category}</td>
                <td>${course.professor}</td>
                <td>${course.credit}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>
