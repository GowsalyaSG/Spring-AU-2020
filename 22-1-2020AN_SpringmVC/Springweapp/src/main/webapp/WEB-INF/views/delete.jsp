<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
</head>
<body>
<a href = "<c:url value = "/home"/>">BackToHome</a>

<div style="background-color:powderblue;">
<form action="deletedata" method="post">
 
  <span>Employee ID:</span>
  <input type="text" name="id" >
  <input id="submit" type="submit" value="Submit">
</form> <br/>

<span>${result}</span>

</div>
</body>
</html>