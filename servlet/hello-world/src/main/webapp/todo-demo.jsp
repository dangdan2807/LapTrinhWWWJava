<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="todo-demo.jsp">
		<p>
			Add new item: <input type="text" name="theItem" />
		</p>
		<input type="submit" value="Submit" />
	</form>
	<%
	List<String> items = (List<String>) session.getAttribute("myToDoList");
	if (items == null) {
		items = new ArrayList<String>();
		session.setAttribute("myToDoList", items);
	}
	String theItem = request.getParameter("theItem");
	if (theItem != null) {
		items.add(theItem);
	}
	%>

	<hr/>
	<p>
		<b>To List Items: </b>
	</p>
	<ol>
		<%
		for (String temp : items) {
			if (!temp.isEmpty())
				out.println("<li>" + temp + "</li>");
		}
		%>
	</ol>
</body>
</html>