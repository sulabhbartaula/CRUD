<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Add New Student</title>
</head>
<body>
	<form action="/CRUD/StudentController" method="POST">
		
			<div>
				<label for="studentId">Student ID</label> <input type="text"
					name="studentId" value="<c:out value="${student.studentId}" />"
					readonly="readonly" placeholder="Student ID" />
			</div>
			<div>
                <label for="firstName">First Name</label> <input type="text"
                    name="firstName" value="<c:out value="${student.firstName}" />"
                    placeholder="First Name" />
            </div>
            <div>
                <label for="lastName">Last Name</label> <input type="text"
                    name="lastName" value="<c:out value="${student.lastName}" />"
                    placeholder="Last Name" />
            </div>
            <div>
                <label for="course">Course</label> <input type="text" name="course"
                    value="<c:out value="${student.course}" />" placeholder="Course" />
            </div>
            <div>
                <label for="year">Year</label> <input type="text" name="year"
                    value="<c:out value="${student.year}" />" placeholder="Year" />
            </div>
            <div>
                <input type="submit" value="Submit" />
            </div>
	</form>
</body>
</html>