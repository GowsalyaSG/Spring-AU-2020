<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home page</title>
<style>

</style>
</head>
<body>
<div style="background-color:powderblue;">
<h2 >Options :</h2>
<ul>
<li><a href = "<c:url value = "/home"/>">Home</a><br/></li>
<li><a href = "<c:url value = "/viewall"/>">View Employee Details</a><br/></li>
<li><a href = "<c:url value = "/view"/>">View EmployeeById</a><br/></li>
<li><a href = "<c:url value = "/edit"/>">UpdateById</a><br/></li>
<li><a href = "<c:url value = "/delete"/>">DeleteById</a><br/></li>
</ul>
<br/>
</div>
<div style="background-color:pink;" >
<p>Insert Employee Detail You Want </p>
<form action="login" method="post">
 
  Employee ID:
  <input type="text" name="id">
  <br/><br/>
  <span>First name:</span>
  <input type="text" name="fname">
  <br/><br/>
  <span>Last name:</span>
  <input type="text" name="lname" >
  <br/><br/>
  <span>Phone:</span>
  <input type="tel" name="phone" >
  <br/><br/>
  <span>Email:</span>
  <input type="email" name="email" >
  <br/><br/>
  <input id="submit" type="submit" value="Submit">
</form> 
</div>
</body>
</html>