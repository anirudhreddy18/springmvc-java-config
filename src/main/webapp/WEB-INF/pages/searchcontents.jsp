<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
    <c:choose>
      <c:when test="${isList}">
       	<c:forEach items = "${productsAfterSearch}" var = "prod">
       	<tr>
         <td>Product Name : <c:out value = "${prod.productName}"></c:out></td> <br> <br>
         <td>Product Cost : <c:out value = "${prod.productCost}"></c:out></td> <br> <br>
         
        <tr>
       	</c:forEach>
      </c:when>
      <c:otherwise>
           <tr>
               <td>Product Name : <c:out value = "${productsAfterSearch.productName}"></c:out></td> <br> <br>
         	   <td>Product Cost : <c:out value = "${productsAfterSearch.productCost}"></c:out></td> <br> <br>
           </tr>    
      </c:otherwise>
    </c:choose> 
</form>
</body>
</html>