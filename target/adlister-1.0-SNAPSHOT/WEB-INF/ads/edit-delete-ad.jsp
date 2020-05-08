<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <%--    <jsp:include page="/WEB-INF/partials/head.jsp">--%>
    <%--        <jsp:param name="title" value="Create a new Ad" />--%>
    <%--    </jsp:include>--%>
</head>
<body>
<div class="container">
    <h1>Edit your ad</h1>
    <form action="/ad/edit-delete" method="post">
        <div class="form-group">
            <label for="title">Title</label>
            <input id="title" name="title" class="form-control" type="text">
        </div>
        <div class="form-group">
            <label for="description">Description</label>
            <textarea id="description" name="description" class="form-control" type="text"></textarea>
        </div>
        <input type="hidden" value="${ad.id}" name="id">


        <div class="form-group">


            <div class="input-group mb-3">
                <div class="input-group-prepend">
                    <c:forEach var="cat" items="${categories}">
                        <div class="input-group-text"> ${cat}
                            <input type="checkbox" aria-label="Checkbox for following text input">
                        </div>
                    </c:forEach>
                </div>
            </div>


        </div>

        <input type="submit" class="btn btn-block btn-primary">

    </form>
</div>
</body>
</html>

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
