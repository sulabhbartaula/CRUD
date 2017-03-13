<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List,com.crud.model.Student,com.crud.dao.StudentDAO,com.crud.dao.StudentDAOImpl" %>
<% 
StudentDAO dao = new StudentDAOImpl();
List<Student> students = dao.getAllStudents();
%>
<%=students %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Show All Students</title>
</head>
<body>
	<h1>Show All Students</h1>
	<hr>
	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>First Name</th>
				<th>Last Name</th>
				<th>Course</th>
				<th>Year</th>
				<th colspan="2">Action</th>
			</tr>
		</thead>

		<tbody>
				<c:forEach items="${students}" var="student">
				<tr>
				<td><c:out value="${student.studentId}" /> </td>
				<td><c:out value="${student.firstName}" /></td>
				<td><c:out value="${student.lastName}" /></td>
				<td><c:out value="${student.course}" /></td>
				<td><c:out value="${student.year}" /></td>
				<td><a href="/StudentController?action=update&studentId=<c:out value="${student.studentId}"/>">Update</a></td>
				<td><a href="/StudentController?action=delete&studentId=<c:out value="${student.studentId}"/>">Delete</a></td>
				</tr>
				</c:forEach>
		</tbody>

	</table>
	<p><a href="/CRUD/StudentController?action=insert">Add Student</a></p>

</body>
</html>