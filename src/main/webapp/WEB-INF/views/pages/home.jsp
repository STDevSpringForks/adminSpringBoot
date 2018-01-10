<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png">

<h1>Spring Boot Internacionalización i18n Ejemplo</h1>
Lenguaje : <a href="?lang=en">Ingles</a> | <a href="?lang=es">Español</a> | <a href="?lang=fr">Frances</a>
<p>${message}</p>
<p><spring:message code="welcome.greeting" arguments="${startMeeting}"/></p>
Current Locale : ${pageContext.response.locale} / ${locale}

<p><spring:message code="label_homepage" text="Inicio" /></p>