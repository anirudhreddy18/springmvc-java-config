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

<h3> Categories</h3>

<form>
    <c:choose>
      <c:when test="${isList}">
       	<c:forEach items = "${categories}" var = "cat">
       	<tr>
         <td>Category Id : <c:out value = "${cat.categoryId}"></c:out></td> <br> <br>
         <td>Category Name : <c:out value = "${cat.categoryName}"></c:out></td> <br> <br>
        <tr>
       	</c:forEach>
      </c:when>
      <c:otherwise>
           <tr>
               <td>Category Id : <c:out value = "${category.categoryId}"></c:out></td> <br> <br>
         	   <td>Category Name : <c:out value = "${category.categoryName}"></c:out></td> <br> <br>
           </tr>    
      </c:otherwise>
    </c:choose> 
</form>
</body>
</html>