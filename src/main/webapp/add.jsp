<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add</title>
</head>
<body>
<form action="/add" method="post">
    <input type="hidden" name="id" value="${id}">
    <p>Name: <input type="text"name="name" value="name"></p>
    <p>Weight: <input type="text" name="weight" value="weight"></p>
    <p>Caloricity: <input type="text" name="caloricity" value="caloricuty"></p>
    <input type="submit" value="Add">
</form>
</body>
</html>
