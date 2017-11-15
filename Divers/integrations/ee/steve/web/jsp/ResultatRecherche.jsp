<%--
    Document : ResultatRecherche.jsp
    Author : pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/jquery/jquery-ui.css" />
        <script src="/Cinescope2017Web/jquery/jquery.js"></script>
        <script src="/Cinescope2017Web/jquery/jquery-ui.js"></script>
        <title>ResultatRecherche.jsp</title>
    </head>

    <body>
        <div class="row"><!--  header-->
            <%@ include file="Header.jsp" %>           
        </div><!--  FIN  header-->
        <div class="row"><!--Nav-->
            <div class="col-md-2"><!--2/12-->
                <%@ include file="Nav.jsp" %>
            </div><!--FIN Nav-->
            <div class="col-md-8 col-md-offset-1"><!--10/12-->
                <article id="articleResultatRecherche">
                    <h3>Résultat de la recherche "<strong>${saisieDeRecherche}</strong>" : 
                        <c:choose>
                            <c:when test="${fn:length(ListFilmResultat)=='0'}">
                                Aucun résultat<%-- zéro film dans  ListFilmResultat --%>
                                <br />
                            </c:when>
                            <c:when test="${fn:length(ListFilmResultat)=='1'}">
                                <c:out value="${fn:length(ListFilmResultat)}" />  résultat trouvé<%-- nombre de films dans  ListFilmResultat --%>
                                <br />
                            </c:when> 
                            <c:otherwise>
                                <c:out value="${fn:length(ListFilmResultat)}" />  résultat trouvés<%-- nombre de films dans  ListFilmResultat --%>
                                <br />
                            </c:otherwise>
                        </c:choose>
                    </h3>
                    <br>
                    <br>
                    <div class="row">
                        <c:forEach var="film" items="${ListFilmResultat}"><!--forEach de la liste des films-->
                            <div class="col-md-6"><!--6/12 pour un affichage des résultats en 2 blocs responsives-->
                                <ul class="list-group">
                                    <li class="list-group-item list-group-item-success"> Titre du film : ${film.titreFilm}</li><!--pour chaque film  on affiche le titre,etc...-->
                                    <li class="list-group-item"> Année de sortie : ${film.annee}</li>
                                    <li class="list-group-item"> En ${film.couleur}</li>
                                    <li class="list-group-item"> Genre : ${film.genre}</li>
                                </ul>
                            </div>
                        </c:forEach>
                    </div>
                </article>
            </div>
        </div>


        <div class="row">
            <div class="col-lg-md">
                <%@ include file="Footer.jsp" %>
            </div>
        </div>
        <script src="/Cinescope2017Web/js/bootstrap.min.js"></script>
        <script src="/Cinescope2017Web/js/main.js"></script>
    </body>

</html>
