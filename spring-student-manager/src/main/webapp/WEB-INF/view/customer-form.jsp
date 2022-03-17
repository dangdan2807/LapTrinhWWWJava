<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>

<head>
    <meta charset="UTF-8">
    <title>customer form</title>
</head>

<body>
    <form:form action="processForm" modelAttribute="customer" method="POST">
        First Name:
        <form:input path="firstName" />
        <br /><br />

        Last Name:
        <form:input path="lastName" />
        <br /><br />
        
        Sex:
        <br />
        Nam <form:radiobutton path="sex" item="0" />
        Nữ <form:radiobutton path="sex" item="1" />
        <br /><br />

        Email:
        <form:input path="email" />
        <br /><br />

        Address:
        <form:input path="address" />
        <br /><br />
        <input type="submit" value="submit" />
    </form:form>
</body>

</html>