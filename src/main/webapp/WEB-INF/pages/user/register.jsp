<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ taglib prefix= "spring" uri = "http://www.springframework.org/tags" %>
<%@ taglib prefix= "form" uri = "http://www.springframework.org/tags/form" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<form:form method = "post" modelAttribute = "user" action = "${url}">
UserId :<form:input path = "userId" type = "text" name = "userId"/>  <form:errors path = "userId" /><br> <br>
FirstName:<form:input path = "firstName" type = "text" name = "firstName"/> <form:errors path = "firstName"/> <br> <br>
Last Name:<form:input path = "lastName" type = "text" name = "lastName"/>  <form:errors path = "lastName"/> <br> <br>
Password :<form:input path = "password" type = "password" name = "password"/> <form:errors path = "password"/> <br> <br>
Phone Number :<form:input path = "phoneNumber" type = "text" name = "phoneNumber"/> <form:errors path = "phoneNumber"/> <br> <br>
Email : <form:input path = "email" type = "text" name = "email"/> <form:errors path = "email"/> <br> <br>
<form:input path = "" type = "submit" value = "register"/> <br> <br>
</form:form>
</body>
</html>