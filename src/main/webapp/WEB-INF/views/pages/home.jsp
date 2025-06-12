<%@ include file="/WEB-INF/views/includes/header.jsp" %>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png">

<h1>Ejemplo de Spring Boot</h1>
<p>${message}</p>
<p>Comenzamos la reunión a las ${startMeeting}</p>

<%@ include file="/WEB-INF/views/includes/footer.jsp" %>
