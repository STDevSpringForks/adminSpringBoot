<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<div>
		<%-- When the form is loaded Spring MVC call generalProfile.getFirstName,etc. --%>
		<form:form action="addProfile" modelAttribute="generalProfile">
			First Name: <form:input path="firstName"/>
			Last Name: <form:input path="lastName"/>
			<form:select path="sexo">
				<form:option value="M" label="Masculino"/>
				<form:option value="F" label="Femenino"/>
			</form:select>
<%-- 			<form:select path="country"> --%>
<%-- 				<form:options items="${generalProfile.countryOptions}"/> --%>
<%-- 			</form:select> --%>
			<form:select path="country"> 
			 	<form:options items="${theCountryOptions}" />
			</form:select>
			Chivas <form:radiobutton path="equipo" value="Chivas"/>
			America <form:radiobutton path="equipo" value="America"/>
			Pumas <form:radiobutton path="equipo" value="Pumas"/>
			Toluca <form:radiobutton path="equipo" value="Toluca"/>
			
			Microsoft <form:checkbox path="checkSO" value="Microsoft" />
			Linux <form:checkbox path="checkSO" value="Linux" />
			Mac<form:checkbox path="checkSO" value="Mac" />
			
			<input type="submit" value="Submit"/>
			<%-- When the form is submitted Spring MVC call generalProfile.setFirstName,etc. --%>
		</form:form>
		
		
		New profile is created successful:
	${generalProfile.firstName} ${generalProfile.lastName} 
	
	<ul>
		<c:forEach var="tmp" items="${generalProfile.checkSO}">
			<li>${tmp}</li>
		</c:forEach>
	</ul>
	</div>