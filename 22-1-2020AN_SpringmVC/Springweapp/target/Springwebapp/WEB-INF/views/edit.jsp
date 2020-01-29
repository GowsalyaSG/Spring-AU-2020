<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Updating Employee Details</title>
</head>
<body>
<a href = "<c:url value = "/home"/>">BackToHome</a>

<div style="background-color:powderblue;">
<form action="fetch" method="post">
Employee ID:
  <input type="text" name="id" >
  <input id="submit" type="submit" value="GetDetail">
</form> <br/>
</div>
<div style="background-color:pink;">
<span>Update Form</span>
<form action="editdata" method="post">
Employee ID:<input type="text" name="id"   value=${employee.id } >
  <br/>
Employee First name:<input type="text" name="fname" value=${employee.fname } >
  <br/>
Employee Last name:<input type="text" name="lname" value=${employee.lname }>
  <br/>
Employee Phone:<input type="tel" name="phone" value=${employee.phone }>
  <br/>
Employee Email:<input type="email" name="email" value=${employee.email }>
  <br/>
  <input id="submit" type="submit" value="Submit">
</form> 
</div>
<span>${result}</span>

</body>
</html>