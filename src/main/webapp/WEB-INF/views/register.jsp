<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<section class="login-page">
    <h2>Załóż konto</h2>
    <form:form method="post" modelAttribute="user" action="createAccount">
        <div class="form-group">
            <form:input path="username" placeholder="Użytkownik"/>
        </div>
        <div class="form-group">
            <form:input path="email" placeholder="Email"/>
        </div>
        <div class="form-group">
            <form:password path="password" placeholder="Hasło" />
        </div>

        <div class="form-group form-group--buttons">
            <a href="login" class="btn btn--without-border">Zaloguj się</a>
            <button class="btn" type="submit">Załóż konto</button>
        </div>
    </form:form>
</section>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>