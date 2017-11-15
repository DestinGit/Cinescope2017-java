<%--
    Document : HitParade.jsp
    Author : Timothé
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="fr.c2017.entities.HitParade"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/bootstrap-theme.min.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <title>HitParade.jsp</title>
    </head>


    <body>
        <!--HEADER-->
        <div class="row text-center">
            <header>
                <%@include file="Header.jsp" %>
            </header>
        </div>
        <!--FIN HEADER-->

        <!--NAV-->
        <div class="row coeurPage">
            <div class="col-lg-2">
                <nav>
                    <%@ include file="Nav.jsp" %>
                </nav>
            </div>
            <!--FIN NAV-->

            <div class="col-lg-8 col-lg-offset-1">
                <article id="articleHitParade">
                    <h2>Hit Parade du Public</h2>
                    <table border="1" class="table">
                        <thead>
                            <tr>
                                <th>Titre</th>
                                <th>Entrées de la semaine</th>
                                <th>Nombre de semaines</th>
                                <th>Total d'entrées</th>
                            </tr>
                        <tbody>
                            <c:forEach var="LHP" items="${tableau}">
                                <tr>
                                    <td>${LHP.lnom}</td>
                                    <td>${LHP.lentreeSe}</td>
                                    <td>${LHP.lsemaines}</td>
                                    <td>${LHP.lentreeTT}</td>
                                </tr>

                            </c:forEach>
                        </tbody>




                    </table>

                    </thead>
                    </table>
                </article>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-12">
                <footer>
                    <%@ include file="Footer.jsp" %>
                </footer>
            </div>
        </div>

        <script src="/Cinescope2017Web/js/bootstrap.min.js"></script>
    </body>
</html>