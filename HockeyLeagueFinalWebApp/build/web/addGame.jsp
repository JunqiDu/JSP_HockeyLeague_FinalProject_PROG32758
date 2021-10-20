<%-- 
    Document   : addGame
    Created on : 2020-4-12, 15:38:38
    Author     : dujun
--%>

<%@page import="bean.Team"%>
<%@page import="java.util.ArrayList"%>
<%@page import="data.TeamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hockey League</title>
    </head>
    <body>
        <h1>Add Game</h1>
        <form action="HockeyLeagueControllerServlet" method="GET">
            Winner: <select name="winner">
                <%
                    TeamDAO teamDAO = new TeamDAO();
                    ArrayList<Team> teams = teamDAO.retrieveAllTeams();

                    for (Team t : teams) {
                %>
                <option value="<%=t.getName()%>"><%=t.getName()%></option>
                <%
                    }
                %>
            </select>
            <br>Loser: <select name="loser">
                <%
                    for (Team t : teams) {
                %>
                <option value="<%=t.getName()%>"><%=t.getName()%></option>
                <%
                    }
                %>
            </select>
            <br><input type="submit" name="action" value="Save Game">
        </form>
    </body>
</html>
