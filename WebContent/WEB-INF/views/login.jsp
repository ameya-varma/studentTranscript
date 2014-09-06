<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd"><html>
<!-- Displays the login page. Spring security has been used to pass the login credentials -->
<!-- If login failed this page will be displayed with an error message -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Transcript Search Login</title>
</head>

<body onload='document.loginForm.j_username.focus();'>

<c:if test="${not empty error}">
		<div class="error">
			Your login attempt was not successful, try again.<br /> 
			Reason: ${sessionScope["SPRING_SECURITY_LAST_EXCEPTION"].message}
		</div>
	</c:if>
	
	<form name='loginForm' action="<c:url value='j_spring_security_check' />"
			method='POST'>
		<table>
			<tr>
				<td>User Name:</td>
				<td><input type='text' name='j_username' value=''></td>
			</tr>
			<tr>
				<td>Password:</td>
				<td><input type='password' name='j_password' /></td>
			</tr>
			<tr>
				<td colspan='2'><input name="submit" type="submit" value="submit" /></td>
			</tr>
			<tr>Please login with username :root password :password</tr>
		</table>
		</form>

</body></html>