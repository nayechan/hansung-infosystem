<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
  <title>한성대학교</title>
  <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/home.css/">
</head>
<body>
<!-- Navigation Bar -->
<jsp:include page="navbar.jsp" />

<!-- Landing Page Sections -->
<div class="section">
  <h2>학년별 이수 학점 조회</h2>
  <p>학년별 이수 학점을 조회할 수 있습니다.</p>
  <button onclick="location.href='<c:url value='/courses' />'">이동하기</button>
</div>

<div class="section">
  <h2>수강 신청하기</h2>
  <p>강의를 수강 신청할 수 있습니다.</p>
  <button onclick="location.href='<c:url value='/registration' />'">이동하기</button>
</div>

<div class="section">
  <h2>수강 신청 조회</h2>
  <p>수강 신청한 강의를 조회할 수 있습니다.</p>
  <button onclick="location.href='<c:url value='/registrationStatus' />'">이동하기</button>
</div>
</body>
</html>
