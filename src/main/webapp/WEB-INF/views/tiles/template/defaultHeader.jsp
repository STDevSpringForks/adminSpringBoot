<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page session="false"%>
<html>
<head>
<%-- Check the best way to include the main resources --%>
<%--
<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-3.1.1.min.js"></script>
<link href="${pageContext.request.contextPath}/resources/uiframeworks/semanticUI/semantic.min.css" rel="stylesheet"/>
<script src="${pageContext.request.contextPath}/resources/uiframeworks/semanticUI/semantic.min.js"></script>
--%>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.7/semantic.min.js"></script>
<link href="https://cdnjs.cloudflare.com/ajax/libs/semantic-ui/2.1.7/semantic.min.css" rel="stylesheet" type="text/css"/>

<link href="${pageContext.request.contextPath}/resources/css/my-test.css" rel="stylesheet" type="text/css" >
<script src="${pageContext.request.contextPath}/resources/js/simple-test.js"></script>

<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.8/jquery.mask.min.js"></script>

<link href="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/css/dataTables.jqueryui.min.css" rel="stylesheet" type="text/css" >
<script src="https://cdnjs.cloudflare.com/ajax/libs/datatables/1.10.15/js/jquery.dataTables.min.js"></script>

</head>
<body>
<jsp:include page="/WEB-INF/views/includes/navigatorHeader.jsp"/>
