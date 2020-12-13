<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> hello web </h1>
<br/>
<%= "hello expression" %>	<br/>
<%! public int x = 22; %>	<br/>
<%= "value of x is"+x %>	<br/>
<%= new Integer(23) %>	<br/>
<%= new String("new hello") %>	<br/>
<%= 25*4 %>	<br/>
<%= 25>4 %>


</body>
</html>