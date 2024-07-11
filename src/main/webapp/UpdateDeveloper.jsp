<%@page import="com.example.dto.Developer"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
	Developer d = (Developer) request.getAttribute("per");
	%>
	<form action="updatedeveloper" method="post">
		Id:<input type="number" name="id" placeholder="enter ur id"
			value="<%=d.getDeveloperId()%>" readonly="readonly"><br>
		<br> 
		Name:<input type="text" placeholder="enter ur name"
			name="developerName" value="<%=d.getDeveloperName()%>"><br>
		<br>
		 Company:<input type="text" placeholder="enter ur Company Name"
			name="companyName" value="<%=d.getCompanyName()%>"><br>
		<br>
		 Salary:<input type="number" placeholder="enter ur salary"
			name="salary" value="<%=d.getSalary()%>"><br>
		<br> 
		<br> <input type="submit" value="Update"><br>
		<br>
	</form>
</body>
</html>