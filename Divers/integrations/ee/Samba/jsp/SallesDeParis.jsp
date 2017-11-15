<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/bootstrap/css/bootstrap.min.css" >
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/DataTables/datatables.min.css"/>
        <title>Les Salles De Paris</title>
    </head>

    <body>
        <header>
            <%@ include file="Header.jsp" %>
        </header>
        <div class="row">

            <div class="col-md-2">
                <%@ include file="Nav.jsp" %>
            </div>

            <div class="col-md-offset-1 col-md-8">

                <article id="articleAccueil">
                    <h2>Les Salle de Paris</h2>

                    <div class="container-fluid">
                        <div class="col-xs-12">
                            <div class="table-responsive">
                                <table class="table table-bordered table-hover" id="cinemas">
                                    <thead>
                                        <tr>
                                            <th>Cinemas</th>
                                            <th>Metro</th>
                                            <th>Code Arrondissement</th>
                                            <th>Arrondissement</th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <c:forEach var="salle" items="${SallesDeParis}" >
                                            <tr>
                                                <td>${salle.nom_cinema}</td>
                                                <td>${salle.nom_station_metro}</td>
                                                <td>${salle.code_arrondissement}</td>
                                                <td>${salle.nom_arrondissement}</td>
                                            </tr>
                                        </c:forEach>
                                    </tbody>
                                </table>
                            </div><!--end of .table-responsive-->
                        </div>
                    </div>
                </article>
            </div>

        </div>

        <footer >
            <%@ include file="Footer.jsp" %>
        </footer>


        <script src="/Cinescope2017Web/css/bootstrap/js/jquery-3.2.1.min.js" ></script>
        <script src="/Cinescope2017Web/css/bootstrap/js/bootstrap.js" ></script>  
        <script type="text/javascript" src="/Cinescope2017Web/css/DataTables/datatables.min.js"></script>
        <script src="/Cinescope2017Web/js/salleDeCinemas.js"></script>
    </body>

</html>
