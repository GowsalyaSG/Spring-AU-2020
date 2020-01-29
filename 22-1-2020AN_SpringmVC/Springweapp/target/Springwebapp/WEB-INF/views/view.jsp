<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View</title>
</head>

<body style="background-color:powderblue;">
<a href = "<c:url value = "/home"/>">BackToHome</a>
<form action="viewdata" method="post">
 
  <span>Employee Id:</span>
  <input type="text" name="id" >
  <input id="submit" type="submit" value="Submit">
</form> <br/>
<div style="background-color:pink;">
Employee Id:<p>${employee.id }</p>
Employee FirstName:<p>${employee.fname }</p>
Employee LastName:<p>${employee.lname }</p>
Employee Email:<p>${employee.email }</p>
Employee Phone:<p>${employee.phone }</p>
</div>
</body>
</html>
