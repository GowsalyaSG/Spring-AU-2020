<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
table {
  font-family: arial, sans-serif;
  border-collapse: collapse;
  width: 100%;
}

td, th {
  border: 1px solid #dddddd;
  text-align: left;
  padding: 8px;
}

tr:nth-child(even) {
  background-color: #dddddd;
}
</style>
</head>
<body>

<table>
<a href = "<c:url value = "/home"/>">BackToHome</a>
<tr>
<th>EmployeeID</th>
<th>Employee FirstName</th>
<th>Employee LastName</th>
<th>Employee Email</th>
<th>Employee Phone</th>
</tr>
<c:forEach items = "${employee}" var="employee">
<tr>      
        <td><c:out value = "${employee.id}"/></td>
        <td><c:out value = "${employee.fname }"/></td>
        <td><c:out value = "${employee.lname }"/></td>
        <td><c:out value = "${employee.email }"/></td>
        <td><c:out value = "${employee.phone }"/></td>  
    </tr>      
  </c:forEach>

</table>
</body>
</html>