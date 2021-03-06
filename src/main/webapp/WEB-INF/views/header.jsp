<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
<header class="header--main-page">
    <nav class="container container--70">
        <sec:authorize access="hasRole('ROLE_ADMIN') or hasRole('ROLE_USER')">
            <ul class="nav--actions">
                <li class="logged-user">
                    Witaj <b><security:authorize access="isAuthenticated()">
                             <security:authentication property="principal.username"/>
                             </security:authorize></b>
                    <ul class="dropdown">
                        <li>
                            <a href="#">Profil</a>
                        </li>
                        <li>
                            <a href="#">Moje zbiórki</a>
                        </li>
                        <li>
                            <form action="<c:url value="/logout"/>" method="post">
                                <input class="btn btn--small2 btn--without-border" type="submit" value="Wyloguj">
                                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                            </form>
                        </li>
                    </ul>
                </li>
            </ul>
        </sec:authorize>

        <sec:authorize access="isAnonymous()">
            <ul class="nav--actions">
                <li><a href="/login" class="btn btn--small btn--without-border">Zaloguj</a></li>
                <li><a href="/createAccount" class="btn btn--small btn--highlighted">Załóż konto</a></li>
            </ul>
        </sec:authorize>


        <ul>
            <li><a href="/" class="btn btn--without-border active">Start</a></li>
            <li><a href="#" class="btn btn--without-border">O co chodzi?</a></li>
            <li><a href="#" class="btn btn--without-border">O nas</a></li>
            <li><a href="#" class="btn btn--without-border">Fundacje i organizacje</a></li>
            <li><a href="#" class="btn btn--without-border">Kontakt</a></li>
        </ul>
    </nav>

    <div class="slogan container container--90">
        <div class="slogan--item">
            <h1>
                Zacznij pomagać!<br/>
                Oddaj niechciane rzeczy w zaufane ręce.
            </h1>
        </div>
    </div>
    <script src="<c:url  value="/resources/js/app.js"/>"></script>
</header>
