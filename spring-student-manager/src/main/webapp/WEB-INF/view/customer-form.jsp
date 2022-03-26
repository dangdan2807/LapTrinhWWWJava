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
        <b>First Name:</b>
        <form:input path="firstName" />
        <form:errors path="firstName" cssClass="error"/>
        <br /><br />

        <b>Last Name:</b>
        <form:input path="lastName" />
        <form:errors path="lastName" cssClass="error"/>
        <br /><br />
        
        <b>Sex:</b>
        <br />
        Nam <form:radiobutton path="sex" item="0" checked="checked"/>
        Nữ <form:radiobutton path="sex" item="1" />
        <br /><br />

        <b>Email:</b>
        <form:input path="email" />
        <form:errors path="email" cssClass="error"/>
        <br /><br />

        <b>Address:</b>
        <form:input path="address" />
        <br /><br />
        <input type="submit" value="submit" />
    </form:form>
</body>

</html>