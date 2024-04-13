<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>수업 목록</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/courses.css">
</head>
<body>
<!-- Navigation Bar -->
<jsp:include page="navbar.jsp" />
<div class="container">
    <h2>학기별 이수 총 학점</h2>
    <table>
        <tr>
            <th>년도</th>
            <th>학기</th>
            <th>취득 학점</th>
            <th>상세보기</th>
        </tr>
        <c:forEach var="entry" items="${creditsByYearAndSemester}">
            <tr>
                <td>${entry.key.split("-")[0]}</td>
                <td>${entry.key.split("-")[1]}</td>
                <td>${entry.value}</td>
                <td><a href="<c:url value=
                    '/courseDetails?year=${entry.key.split("-")[0]}&semester=${entry.key.split("-")[1]}'/>">
                    링크
                </a></td>
            </tr>
        </c:forEach>
    </table>
</div>

</body>
</html>