<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>GetAllEmployee</title>
</head>
<body>
<h1 style="color:blue;text-align:center">LIST OF EmployeeS</h1>
	<c:choose>
		<c:when test="${!empty pageData }">
			<table border="1" bgcolor="cyan" align="center">
				<tr bgcolor="pink">
					<th>eno</th><th>ename</th><th>desg</th><th>salary</th><th>deptno</th><th>Operations</th>
				</tr>
				<c:forEach var="emp" items="${pageData.getContent() }">
					<tr>
						<td>${emp.empno }</td>
						<td>${emp.ename }</td>
						<td>${emp.job }</td>
						<td>${emp.sal }</td>
						<td>${emp.deptno }</td>
						<td><a href="edit_employee?eno=${emp.empno }">edit</a>
						<a href="delete_employee?eno=${emp.empno }">delete</a></td>
					</tr>
				</c:forEach>
			</table>
		
			<p style="text-align:center;">
				<c:forEach var="i" begin="1" end="${pageData.getTotalPages()}" step="1">
					[<a href="emp_report?page=${i-1 }">${i}</a>]
				</c:forEach>
			</p>
		</c:when>
		<c:otherwise>
			<h3>Records not found</h3>
		</c:otherwise>
	</c:choose>
	<h1 style="color:green;text-align:center">${resultMsg}</h1>
	<h1 style="color:red;text-align:center"><a href="insert_employee">Add Employee</a></h1>
	<h1 style="color:red;text-align: center"><a href="./">GoHome</a></h1>
</body>
</html>