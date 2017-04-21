<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<div class="ui container">
	<h1>Create new Person</h1>
	<div class="ui form">
	<form:form action="viewPerson" modelAttribute="personListDetailsEntity">
		<div class="ten wide field">
			<p class="msgResult">${msgResult}</p>
			<form:errors path="*" cssClass="errorDiv" element="div"/>
				
			<div class="field">
				<label for="first_name">First Name</label>
				<form:input path="firstName" placeholder="First Name" />
			</div>
			<div class="field">
				<form:errors cssClass="errorField"  path="firstName" />
			</div>
			<div class="field">
				<label for="last_name">Last Name</label>
				<form:input path="lastName" placeholder="Last Name" />
			</div>
			<div class="field">
				<form:errors cssClass="errorField"  path="lastName" />
			</div>
			<div class="field">
				<label for="dender">Gender</label>
				<form:input path="gender" placeholder="gender" />
			</div>
			<div class="field">
				<form:errors cssClass="errorField"  path="gender" />
			</div>
			<div class="field">
				<label for="email">Email</label>
				<form:input path="email" placeholder="Email" />
			</div>
			<div class="field">
				<form:errors cssClass="errorField"  path="email" />
			</div>
			<input class="ui basic blue button" type="submit" value="Submit">
		</div>
	</form:form>
	</div>
</div>