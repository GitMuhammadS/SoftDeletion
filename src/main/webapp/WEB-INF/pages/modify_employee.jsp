<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>

<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Modify_Employee</title>
<script type="text/javascript" src="js/form_validation.js">
	
</script>
</head>
<body>
	<h1 style="color:blue;text-align:center">Update The Form</h1>
		<form:form modelAttribute="emp" onsubmit="return validate(frm)">
		<%-- <p style="color:red;text-align:center">
		<form:errors path="*"/> --%>
	</p>
			<table align="center" bgcolor="cyan" >
				<tr>
					<td>Employee No</td>
					<td><form:input path="empno" readonly="true"/></td>
				</tr>
				
				<tr>
					<td>Employee Name</td>
					<td><form:input path="ename"/><form:errors path="ename" cssStyle="color:red"/><span id="enameErr" style="color:red;"></span></td>
				</tr>
				
				<tr>
					<td>Employee Job</td>
					<td><form:input path="job"/><form:errors path="job" cssStyle="color:red"/><span id="jobErr" style="color:red;"></span></td>
				</tr>
				
				<tr>
					<td>Employee Salary</td>
					<td><form:input path="sal"/><form:errors path="sal" cssStyle="color:red"/><span id="salErr" style="color:red;"></span></td>
				</tr>
				
				<tr>
					<td>Employee Deptno</td>
					<td><form:input path="deptno"/><form:errors path="deptno" cssStyle="color:red"/><span id="deptnoErr" style="color:red;"></span></td>
				</tr>
				
				<tr>
					<td><input type="submit" value="Edit Employee"/></td>
					<td><input type="reset" value="reset"></td>
				</tr>
				
			</table>
		</form:form>
</body>
</html>