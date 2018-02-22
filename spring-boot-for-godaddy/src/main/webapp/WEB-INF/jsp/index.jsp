<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html lang="en">
<head>

    <spring:url value="/js/save.js" var="springJs" />
    <link href="${springJs}" rel="stylesheet" />
    <c:url value="/js/save.js" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

    <spring:url value="/css/main.css" var="springCss" />
    <link href="${springCss}" rel="stylesheet" />
    <c:url value="/css/main.css" var="jstlCss" />
    <link href="${jstlCss}" rel="stylesheet" />

</head>
<body>

<div class="container">

    <div class="starter-template">
        <h1>Spring Boot with MySQL</h1>
        <h2>Message: ${message}</h2>
    </div>

</div>

<script type="text/javascript" src="webjars/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</body>

</html>