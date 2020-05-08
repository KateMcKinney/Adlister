<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <jsp:include page="/WEB-INF/partials/head.jsp">
        <jsp:param name="title" value="View an Ad" />
    </jsp:include>
    <style>
        * {
            color: #000;
        }
    </style>
</head>
<body>
<jsp:include page="/WEB-INF/partials/navbar.jsp" />
<div class="container">
    <h1>${sessionScope.ad}</h1>
    <h1>${ad.title}</h1>
    <p>${ad.description}</p>
</div>
</body>
</html>