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
	<form>
		<tr>
			<td>Purchase Id : <c:out value="${purchase.orderId}"></c:out></td>
			<br>
			<td>Purchasee Name Id : <c:out
					value="${purchase.user.firstName}"></c:out></td>
			<br>
			<td>Purchasee Name Id : <c:out value="${purchase.user.lastName}"></c:out></td>
			<br>
			<td><c:forEach items="${purchase.items}" var="item">
					<tr>
						<td>Product Name : <c:out value="${item.key.productName}"></c:out></td>
						<br>
						<td>Quantity : <c:out value="${item.value}"></c:out>
						</td>
						<br>
						<td>Cost : <c:out
								value="${item.value * item.key.productCost}"></c:out></td>
						<br>
					</tr>
				</c:forEach>
				<td>Purchase Cost : <c:out value="${purchase.totalCost}"></c:out></td>
			<br>
			</td>
			
		</tr>

	</form>
</body>
</html>