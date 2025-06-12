<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<div class="ui form">
	<form:form action="viewSerializable" method="post"
		modelAttribute="serializableGeneralSearchCriteria">
		<div class="ten wide field">
			<form:errors path="*" cssClass="errorDiv" element="div" />
			<div class="field">
				<label for="search">Search</label>
				<form:input type="text" path="search" placeholder="Search" />
			</div>
			<input class="ui basic blue button" type="submit" value="Submit" />
		</div>
	</form:form>
</div><%@ include file="/WEB-INF/views/includes/footer.jsp" %>
