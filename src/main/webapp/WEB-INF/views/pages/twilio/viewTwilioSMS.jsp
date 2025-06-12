<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
	<div class="ui form">
		<form:form id="formTwilio" action="viewTiwilioSMS" method="post" modelAttribute="twilioSMSSearchCriteria">
			<div class="ten wide field">
				<p class="msgResult">${msgResult}</p>
				<form:errors path="*" cssClass="errorDiv" element="div"/>
				<div class="field">
					<label for="phoneNumberTo">Phone Number To</label>
					<div class="ui labeled input">
					  <div title="For now, only Mexico" class="ui label">+521</div>
					  <form:input path="phoneNumberTo" />
					</div>
				</div>
				<div class="field">
					<label for="message">Message</label>
					<form:textarea path="body" rows="5" cols="30" placeholder="Message" />
				</div>
				<input class="ui basic blue button" type="submit" value="Submit" />
			</div>
		</form:form>
	</div>
<script>
	var formTwilioPhoneNumberTo = $('form#formTwilio input[name="phoneNumberTo"]')
	var formTwilioBody = $('form#formTwilio textarea[name="body"]');
	
	$(function(){
		formTwilioPhoneNumberTo.mask('(000) 000-0000', {
			'translation': {
				0: {pattern: /[0-9*]/}
			}
		});
		moveCursorToEnd(formTwilioPhoneNumberTo);
	});
	
	formTwilioPhoneNumberTo.keyup(function(){
		var phoneNumberToLenth = formTwilioPhoneNumberTo.cleanVal().length;
		console.log(phoneNumberToLenth);
		if(phoneNumberToLenth == 10){
			formTwilioBody.focus();
		}
	});
	
</script><%@ include file="/WEB-INF/views/includes/footer.jsp" %>
