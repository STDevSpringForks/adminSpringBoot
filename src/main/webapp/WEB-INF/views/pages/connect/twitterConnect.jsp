<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
		<span th:if="${social_provider_error}">Provider error (maybe you need to configure the app id and secret?)</span>
		<form action="<c:url value="/connect/twitter" />" method="POST">
    <p>You haven't created any connections with Twitter yet. Click the button to create
       a connection between your account and your Twitter profile.
       (You'll be redirected to Twitter where you'll be asked to authorize the connection.)</p>
    <p><button type="submit"><img src="<c:url value="/resources/social/twitter/signin.jpg" />"/>
    </button></p>
</form>
