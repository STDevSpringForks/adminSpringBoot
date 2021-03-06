<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<p><spring:message code="lbl.validatePalindromo" text="Validar Palindromo" /></p>
	<div class="ui form">
		<form:form id="palindromeForm" action="viewPalindrome" method="post" modelAttribute="palindromeSearchCriteria" >
			<div class="ten wide field">
				<p class="msgResult">${msgResult}</p>
				<form:errors path="*" cssClass="errorDiv" element="div"/>
				
				<div class="field">
					<label for="phrase">Phrase</label>
					<form:input id="phrase" path="phrase"  placeholder="phrase"/>
				</div>
				<div class="field">
					<form:errors cssClass="errorField"  path="phrase" />
				</div>
				<input class="ui basic blue button" type="submit" value="Validate Phrase" />
			</div>
		</form:form>
	</div>