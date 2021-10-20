<%-- 
    Document   : addTeam
    Created on : 2020-4-12, 15:38:27
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
        <h1>Add Team</h1>
        <form action="HockeyLeagueControllerServlet" method="GET">
            Name: <input type="text" name="name">
            <br><input type="submit" name="action" value="Save Team">
        </form>
    </body>
</html>
