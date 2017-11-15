<%--
    Document : Accueil.jsp
    Author : pascal
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/main.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/css/bootstrap.min.css" />
        <link rel="stylesheet" type="text/css" href="/Cinescope2017Web/jquery/jquery-ui.css" />
        <script src="/Cinescope2017Web/jquery/jquery.js"></script>
        <script src="/Cinescope2017Web/jquery/jquery-ui.js"></script>

        <title>Accueil.jsp</title>
    </head>

    <body>
        <div class="row"><!--  header-->
            <%@ include file="Header.jsp" %>           
        </div><!--  FIN  header-->
        <div class="row">
            <div class="col-md-2">
                <%@ include file="Nav.jsp" %>
            </div>
            <div class="col-md-8 col-md-offset-1">
                <article id="articleAccueil">
                    <img src="/Cinescope2017Web/images/cinema.jpg" alt="Photo" title="Photo" widht="100%" class="img-responsive"/>
                    <br><br>
                    <label class="messageOrange">
                        ${message}
                    </label>

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
