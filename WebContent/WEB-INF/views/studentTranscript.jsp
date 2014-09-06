<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<!-- Displays the student transcript -->
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Student Transcript</title>
</head>
<c:if test="${!empty studentInformation}">
<table align="left">
	<tr>
	<c:out value="${studentInformation[0].userName}"></c:out>
	</tr>
	<tr>
	<a href="<c:url value="j_spring_security_logout" />">Logout</a>
	</tr>
</table>
</c:if>
<h2>Institute : Herguan University</h2>
<h3>Student Information</h3>
<body>
<c:if test="${!empty studentInformation}">
<table>
		<tr>
			<td>Student First Name : <c:out value="${studentInformation[0].studentFirstName}"/></td>
		</tr>	
		<tr>
			<td>Student Last Name : <c:out value="${studentInformation[0].studentLastName}"/></td>
		</tr>
		<tr>	
			<td>Student Id : <c:out value="${studentInformation[0].studentExternalID}"/></td>
		</tr>
		<tr>	
			<td>Degree Name : <c:out value="${studentInformation[0].degree}"/></td>
		</tr>
		<tr>	
			<td>Degree Start Year : <c:out value="${studentInformation[0].degreeStartYear}"/></td>
		</tr>
		<tr>	
			<td>Degree Graduation Year : <c:out value="${studentInformation[0].graduationYear}"/></td>
		</tr>
		</table>
		
<h4>COURSES</h4>
		<table>
		<tr>
		<th>COURSE NAME</th>
		<th>GRADE</th>
		<th>SEMESTER</th>
		<th>YEAR</th>
		</tr>
		<c:forEach items="${studentInformation}" var="studentInformation">
			<tr>
				<td><c:out value="${studentInformation.courseName}"/></td>
				<td><c:out value="${studentInformation.grade}"/></td>
				<td><c:out value="${studentInformation.semester}"/></td>
				<td><c:out value="${studentInformation.year}"/></td>
			
			</tr>
			</c:forEach>
	</table>
	</c:if>
	<c:if test="${!empty studentInformation}">
	<!-- This will send the transcript which is rendered in XML -->
	<!-- The request is forwarded to rest-servlet mapped to the controller -->
	<form:form method="GET" action="/studentTranscript/send.xml" modelAttribute="studentInformation">
	<input type="hidden" name="studentExternalID" value="${studentInformation[0].studentExternalID}"/>
	<input type="submit" value="send" />
	</form:form>
	</c:if>	
	
	
</body>
</html>