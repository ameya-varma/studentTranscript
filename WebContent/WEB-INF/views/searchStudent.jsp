<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!-- Displays search page.  User enters student ID and the action is forwared to studentTranscript -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Search Student</title>
</head>
<body>
<form:form method="GET" action="/studentTranscript/search.html" modelAttribute="studentInformation">
<table>
<tr>
<td>
<c:out value="${studentInformation.userName}"></c:out>
</td>
</tr>
<tr>
<td>
<a href="<c:url value="j_spring_security_logout" />">  
    Logout</a>  
</td>
</tr>
</table>
<table>
<tr>
<td>Search Student</td>
</tr>
<tr>
<td><form:label path="studentExternalID">Student ID : </form:label></td>
<td><form:input path="studentExternalID" value="${studentInformation.studentExternalID}"/></td>
</tr>
<tr>
<td colspan="3"><input type="submit" value="search" /></td> 
</tr>
<tr>Search with student IDs - 1234 and MS456</tr>
</table>


</form:form>

</body>
</html>