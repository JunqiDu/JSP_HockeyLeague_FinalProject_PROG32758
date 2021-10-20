<%-- 
    Document   : showGames
    Created on : 2020-4-12, 15:37:38
    Author     : dujun
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.Game"%>
<%@page import="data.GameDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hockey League</title>
    </head>
    <body>
        <h1>Games</h1>
        <form action="HockeyLeagueControllerServlet" method="GET">
            <input type="submit" name="action" value="Add Game">
            <table>
                <tr>
                    <th>Win</th>
                    <th>Lose</th>
                </tr>
                <%
                    GameDAO gameDAO = new GameDAO();
                    ArrayList<Game> games = gameDAO.retrieveAllGames();

                    for (Game g : games) {
                %>
                <tr>
                    <td><%=g.getWin()%></td>
                    <td><%=g.getLose()%></td>
                </tr>
                <%
                    }
                %>
            </table>
        </form>
    </body>
</html>
