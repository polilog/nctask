
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Salads</title>
    <link href="<c:url value="resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
<form action="/salads" method="post">
<table id="salads" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th></th>
        <th>#</th>
        <th>Name</th>
        <th>Weight</th>
        <th>Calories</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th></th>
        <th>#</th>
        <th>Name</th>
        <th>Weight</th>
        <th>Calories</th>
    </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${salads}" var="salad">
        <tr>
            <td><input type="checkbox" name="delete" value="${salad.getId()}"></td>
            <td>${salads.indexOf(salad) + 1}</td>
            <td><a href="ingredients?id=${salad.getId()}" target="_blank">${salad.name}</a></td>
            <td>${salad.countWeight()}</td>
            <td>${salad.countCalories()}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="<c:url value="resources/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="resources/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="resources/js/salads.js"/>"></script>
<input type="submit" value="Delete">
</form>
</body>
</html>
