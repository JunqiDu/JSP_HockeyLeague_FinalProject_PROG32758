<%-- 
    Document   : index
    Created on : 2020-4-12, 15:36:55
    Author     : dujun
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hockey League</title>
    </head>
    <body>
        <h1>Hockey League</h1>
        <form action="HockeyLeagueControllerServlet" method="GET">
            <input type="submit" name="action" value="Teams">
            <br><input type="submit" name="action" value="Games">
            <br><input type="submit" name="action" value="Standings">
        </form>
    </body>
</html>
