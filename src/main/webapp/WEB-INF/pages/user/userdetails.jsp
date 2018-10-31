<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form  method = "post"  action = "<%=request.getContextPath()  %>/users/<%=session.getAttribute("userId") %>">

		<tr>
			<td>User Id : <input type = "text"  name = "userId" value = "${user.userId}" readOnly></td> <br> <br>
			<td>First Name : <input type="text" name = "firstName" value="${user.firstName}"
				 /></td>
			<br>
			<br>
			<td>Last Name : <input type="text" name = "lastName" value="${user.lastName}" /></td>
			<br>
			<br>
			<td>Password : <input type="password" name = "password" value="${user.password}" /></td>
			<br>
			<br>
			<td>Phone Number : <input type="text" name = "phoneNumber"
				value="${user.phoneNumber}" /></td>
			<br>
			<br>
			<td>Email : <input type="text" name = "email" value="${user.email}" /></td>
			<br>
			<br>
		</tr>
		
		<input type = "submit" value = "update"/>
	</form>

</body>
</html>