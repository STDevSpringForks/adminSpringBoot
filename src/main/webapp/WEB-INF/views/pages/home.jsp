<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<img src="${pageContext.request.contextPath}/resources/images/spring-logo.png">
<p>The time on the server is ${serverTime}</p>

<h1>Spring MVC Internationalization i18n Example</h1>
Language : <a href="?lang=en">English</a> | <a href="?lang=es">Español</a> | <a href="?lang=fr">French</a>
<p>${message}</p>
<p><spring:message code="welcome.greeting" arguments="${startMeeting}"/></p>
Current Locale : ${pageContext.response.locale} / ${locale}

<p><spring:message code="label_homepage" text="Homeee" /></p>