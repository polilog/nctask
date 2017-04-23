<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Ingredients</title>
    <link href="<c:url value="resources/css/jquery.dataTables.min.css"/>" rel="stylesheet">
</head>
<body>
<table id="ingredients" class="display" cellspacing="0" width="100%">
    <thead>
    <tr>
        <th>Name</th>
        <th>Caloricity</th>
        <th>Weight</th>
    </tr>
    </thead>
    <tfoot>
    <tr>
        <th>Name</th>
        <th>Caloricity</th>
        <th>Weight</th>
    </tr>
    </tfoot>
    <tbody>
    <c:forEach items="${ingredients}" var="ingredient">
        <tr>
            <td>${ingredient.name}</td>
            <td>${ingredient.caloricity}</td>
            <td>${ingredient.weight}</td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<script src="<c:url value="resources/js/lib/jquery-1.12.4.js"/>"></script>
<script src="<c:url value="resources/js/lib/jquery.dataTables.min.js"/>"></script>
<script src="<c:url value="resources/js/ingredients.js"/>"></script>
<form method="get" action="/add">
    <input type="submit" value="Add">
    <input type="hidden" name="id" value="${id}">
</form>
</body>
</html>

