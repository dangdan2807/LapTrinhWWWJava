<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>student form</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/style.css" />
    <style type="text/css">
    	.error {
    		color: red;
    	}
    </style>
</head>

<body>
    <form:form action="processForm" modelAttribute="student" method="POST">
        First Name:
        <form:input path="firstName" />
        <form:errors path="firstName" cssClass="error"/>
        <br /><br />

        Last Name:
        <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error"/>
        <br /><br />
        
        Country:
        <!-- c1 -->
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>
        <br /><br />
        
        Phone:
        <form:input path="phone" type="number" />
        <form:errors path="phone" cssClass="error"/>
        <br /><br />
        
        Year of birth:
        <form:input path="yearOfBirth" />
        <form:errors path="yearOfBirth" cssClass="error"/>
        <br /><br />
        
        Postal Code:
        <form:input path="postalCode" />
        <form:errors path="postalCode" cssClass="error"/>
        <br /><br />
        
<!--         Course Code: -->
<%--         <form:input path="courseCode" /> --%>
<%--         <form:errors path="courseCode" cssClass="error"/> --%>
<!--         <br /><br /> -->
        
        <input class="btn" type="submit" value="submit" />
    </form:form>
</body>

</html>