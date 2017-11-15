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
        <title>Accueil.jsp</title>
    </head>

    <body>
        <div class="row"><!--  header-->
            <div class="col-md-12">
                <%@ include file="Header.jsp" %>
            </div>
        </div><!--  FIN  header-->
        <div class="row">
            <div class="col-md-2">
                <%@ include file="Nav.jsp" %>
            </div>
            <div class="col-md-8 col-md-offset-1">
                <article id="articleAccueil">
                    <h4>Box Office</h4>
                    
                    <label class="messageOrange">
                        ${message[1]}
                    </label>

                </article>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-md">
                <%@ include file="Footer.jsp" %>
            </div>
        </div>
        <script href="/Cinescope2017Web/js/bootstrap.min.js"></script>
    </body>

</html>
