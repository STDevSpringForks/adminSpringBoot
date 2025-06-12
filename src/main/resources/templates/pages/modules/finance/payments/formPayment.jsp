<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
        <form:form id="formPayment" action="formPayment" method="post" modelAttribute="paymentSearchCriteria">

                <p>Pago</p>
		<p class="msgResult">${msgResult}</p>
		<form:errors path="*" cssClass="errorDiv" element="div"/>
		
		<div>
			<form:input path="amount"  placeholder="Amount"/>
			<form:errors path="amount" cssClass="errorField" />
		</div>
		
		<div>
			<form:input path="promoCode"  placeholder="Promo Code"/>
			<form:errors path="promoCode" cssClass="errorField" />
		</div>
		
		<input type="submit" value="Submit" />
		
	</form:form>
<script>
	$(function(){
		//$('form#formPayment input[name="amount"]').focus();
		moveCursorToEnd($('form#formPayment input[name="amount"]'));
	});
	
	//function
	function moveCursorToEnd(input) {
	    var originalValue = input.val();
	    input.val('');
	    input.blur().focus().val(originalValue);
	}
</script><%@ include file="/WEB-INF/views/includes/footer.jsp" %>
