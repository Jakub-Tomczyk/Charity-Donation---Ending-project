<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="pl">
<head>
    <meta charset="UTF-8"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
    <meta http-equiv="X-UA-Compatible" content="ie=edge"/>
    <title>Register</title>

    <link rel="stylesheet" href="<c:url value="resources/css/style.css"/>"/>
</head>
<body>
<%@include file="header.jsp" %>
<html>
<head>
    <title>403</title>
</head>
<body>
    <h1>Nie masz autoryzacji do przeglądania zawartości tej strony.</h1>
</body>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</html>
