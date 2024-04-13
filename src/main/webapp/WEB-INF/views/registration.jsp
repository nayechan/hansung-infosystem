<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Course Registration</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/registration.css">
</head>
<body>
<!-- Navigation Bar -->
<jsp:include page="navbar.jsp" />
<div class="container">
    <h1>수강 신청하기</h1>
    <form:form action="/enroll/" method="post" modelAttribute="courseRegistration">
        <form:errors path="*" cssClass="error" element="div" />
        <label for="year">연도</label>
        <form:input type="number" id="year" path="year" value="2024" readonly="true"/><br>

        <label for="semester">학기</label>
        <form:input type="number" id="semester" path="semester" value="2" readonly="true"/><br>

        <label for="name">교과목명</label>
        <form:input type="text" id="name" path="name" required="true"/><br>


        <label for="category">교과구분</label>
        <form:select id="category" path="category" required="true">
            <form:option value="">-- 선택하세요 --</form:option>
            <%
                String[] categories = {
                        "기초", "토대", "한성인재", "자율", "소양", "핵심", "선필교", "전기", "전지(전필)", "전선",
                        "부전지(필)", "부전선", "부전기", "복전지", "복전선", "복전기", "연전지", "연전선", "연전기", "일선", "교직", "교직선"
                };
                for (String category : categories) {
            %>
            <option value="<%= category %>" ${category eq courseRegistration.category ? 'selected' : ''}><%= category %></option>
            <% } %>
        </form:select><br>

        <label for="professor">담당교수</label>
        <form:input type="text" id="professor" path="professor" required="true"/><br>

        <label for="credit">학점</label>
        <form:input type="number" id="credit" path="credit" value="3" required="true"/><br>

        <button type="submit">등록</button>
        <!-- Include CSRF token -->
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}" />
    </form:form>
</div>
</body>
</html>
