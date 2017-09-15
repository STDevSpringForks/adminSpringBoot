<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<h3>Hola, <span>${profile.name}</span></h3>
<h4>Tweets List</h4>
<ul>
	<c:forEach var="entry" items="${tweets}">
		<li>
	       <div class="tweet-container">
	           <p>${entry.user.name}</p>
	           <p>${entry.user.profileImageUrl}</p>
	           <p>${entry.user.description}</p>
	           <p>${entry.user.location}</p>
	        </div>
	    </li>
	</c:forEach>
</ul>
<h3>Hello, ${twitterProfile.name}!</h3>
<h4>These are your friends:</h4>
<ul>
	<c:forEach var="entry" items="${friends}">
		<li>
	       <div class="tweet-container">
	           <p>${entry.name}</p>
	        </div>
	    </li>
	</c:forEach>
</ul>
 <style type="text/css">
     .tweet-container {
         border: gray solid 1px;
         border-radius: 3px;
         margin: 20px 10px;
         padding: 10px;
         box-shadow: #c3c3c3 2px 2px 5px 0px;
     }

     body { font-family: Roboto; }

 </style>