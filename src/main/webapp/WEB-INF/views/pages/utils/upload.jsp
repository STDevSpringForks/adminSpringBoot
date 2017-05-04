<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<h1>Spring MVC multi files upload example</h1>

	<div class="ui form">
	
	
		<form:form method="POST" action="${pageContext.request.contextPath}/uploadMulti"
           modelAttribute="uploadForm" enctype="multipart/form-data">

    <input type="file" name="files" /><br/>
    <input type="file" name="files" /><br/>
    <input type="file" name="files" /><br/><br/>
    <input type="submit" value="Submit" />

</form:form>
	</div>