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
	<h3>Cart</h3>
	
		<a href="<%=request.getContextPath()%>/purchase">View Purchase</a>
	

	<form method="post" action="<%=request.getContextPath()%>/placeOrder">
		<c:forEach items="${cart.items}" var="item">
			<tr>
				<td>Product Name : <c:out value="${item.key.productName}"></c:out></td>
				<br>
				<td>Quantity : <c:out value="${item.value}"></c:out>
				</td>
				<br>
				<td>Cost : <c:out value="${item.value * item.key.productCost}"></c:out></td>
				<br>
			</tr>

			<tr>
				<td>Total Cost : <c:out value="${total}"></c:out>
				</td>
			</tr>
		</c:forEach>

		<input type="submit" value="Place Order" /> <br> <br>

	</form>
</body>
</html>