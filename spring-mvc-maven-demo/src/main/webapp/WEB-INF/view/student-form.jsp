<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="org.springframework.web.servlet.tags.Param"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>student form</title>
</head>
<body>
    <form:form action="processForm" modelAttribute="student" method="POST">
        First Name:
        <form:input path="firstName" />
        <br /><br />
        Last Name:
        <form:input path="lastName" />
        <br /><br />
        Country:
        <!-- c1 -->
        <form:select path="country">
            <form:options items="${student.countryOptions}" />
        </form:select>
        <!-- c2 -->
        <!-- <form:select path="country">
            <form:option value="Brazil" label="Brazil" />
            <form:option value="France" label="France" />
            <form:option value="India" label="India" />
            <form:option value="Germany" label="Germany" />
        </form:select> -->
        <br /><br />
        Favorite Language:
        <!-- c1 -->
        <form:radiobuttons path="favoriteLanguage" items="${student.languageOptions}" />
        <!-- c2 -->
        <!-- 
            <form:radiobutton path="favoriteLanguage" items="Java" />
            <form:radiobutton path="favoriteLanguage" items="C#" />
            <form:radiobutton path="favoriteLanguage" items="PHP" />
            <form:radiobutton path="favoriteLanguage" items="Ruby" />
        -->
        <br /><br />
        Operating Systems:
        <!-- c1 -->
        <form:checkboxes path="operatingSystems" items="${student.operatingSystemOptions}" />
        <!-- c2 -->
        <!-- 
            Linux <form:checkbox path="operatingSystems" value="Linux" />
            Windows <form:checkbox path="operatingSystems" value="Windows" />
            Mac OS <form:checkbox path="operatingSystems" value="Mac OS" />
        -->
        <br /><br />
        <input type="submit" value="submit" />
    </form:form>
</body>
</html>