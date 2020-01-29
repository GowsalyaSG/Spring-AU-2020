<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>User Details</title>
</head>

<body>

<a href="<c:url value='/home'/>">BackToHome</a>
<div style="background-color:pink;">
Employee Id:<p>${employee.id }</p>
Employee FirstName:<p>${employee.fname }</p>
Employee LastName:<p>${employee.lname }</p>
Employee Email:<p>${employee.email }</p>
Employee Phone:<p>${employee.phone }</p>
</div>
</body>
</html>
