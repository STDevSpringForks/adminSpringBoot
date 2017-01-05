<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

	<div class="ui form">
		<form:form id="viewContact" action="viewContact" method="post" modelAttribute="contactForm" >
	
			<p class="msgResult">${msgResult}</p>
			<form:errors path="*" cssClass="errorDiv" element="div"/>
			
			<div class="ten wide field">
				<label for="fullName">Full Name</label>
				<form:input path="fullName"  placeholder="Full Name"/>
				<form:errors path="fullName" cssClass="errorField" />
			</div>
			
			<div class="ten wide field">
				<label for="email">Email</label>
				<form:input path="email"  placeholder="Email"/>
				<form:errors path="email" cssClass="errorField" />
			</div>
			
			<div class="ten wide field">
				<label for="comment">Comment</label>
				<form:input path="comment"  placeholder="Comment"/>
				<form:errors path="comment" cssClass="errorField" />
			</div>
			
			<div class="ten wide field">
				<label for="info">Info</label>
				<form:select path="zoneId">
				 	<form:options items="${zoneIdsList}" />
				</form:select>
			</div>
	
			<hr>
			<input class="ui basic blue button" type="submit" value="Submit"  />
			
		</form:form>
	</div>