<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@include file="header.jsp" %>
<section class="login-page">
    <h2>Zaloguj się</h2>
        <div class="form-group">
            <input type="name" name="username" placeholder="Użytkownik"/>

        </div>
        <div class="form-group">
            <input type="password" name="password" placeholder="Hasło"/>

            <!--<a href="#" class="btn btn--small btn--without-border reset-password">Przypomnij hasło</a> -->
        </div>

        <div class="form-group form-group--buttons">
            <a href="/CreateAccount" class="btn btn--without-border">Załóż konto</a>
            <button class="btn" type="submit">Zaloguj się</button>
        </div>
</section>
<%@include file="footer.jsp" %>
<script src="<c:url value="/resources/js/app.js"/>"></script>
</body>
</html>

