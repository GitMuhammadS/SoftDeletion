<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>AddEmployee</title>
<script type="text/javascript" src="js/form_validation.js">
	
</script>
</head>
<body>
	<h1 style="color:blue;text-align:center">Register Employee</h1>
	<form:form modelAttribute="emp" onsubmit="return validate(frm)">
	<%-- <p style="color:red;text-align:center">
		<form:errors path="*"/>
	</p> --%>
		<table border="0" bgcolor="cyan" align="center">
			<tr>
				<td>Employee Name</td>
				<td><form:input path="ename"/><form:errors path="ename" cssStyle="color:red"/><span id="enameErr" style="color:red;"></span></td>
			</tr>
			<tr>
				<td>Employee Desg</td>
				<td><form:input path="job"/><form:errors path="job" cssStyle="color:red"/><span id="enameErr" style="color:red;"></span></td>
			</tr>
			
			<tr>
				<td>Employee salary</td>
				<td><form:input path="sal"/><form:errors path="sal" cssStyle="color:red"/><span id="enameErr" style="color:red;"></span></td>
			</tr>
			
			<tr>
				<td>Employee deptno</td>
				<td><form:input path="deptno"/><form:errors path="deptno" cssStyle="color:red"/><span id="enameErr" style="color:red;"></span></td>
			</tr>
			
			<tr>
				<td><input type="submit"/></td>
				<td><input type="reset"/></td>
			</tr>
		</table>
	</form:form>
</body>
</html>