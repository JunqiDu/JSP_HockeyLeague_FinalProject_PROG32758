<%-- 
    Document   : showTeams
    Created on : 2020-4-12, 15:37:27
    Author     : dujun
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="bean.Team"%>
<%@page import="data.TeamDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hockey League</title>
    </head>
    <body>
        <h1>Teams</h1>
        <form action="HockeyLeagueControllerServlet" method="GET">
            <input type="submit" name="action" value="Add Team">
            <table>
                <tr>
                    <th>Team</th>
                    <th>Delete</th>
                </tr>
                <%
                    TeamDAO teamDAO = new TeamDAO();
                    ArrayList<Team> teams = teamDAO.retrieveAllTeams();

                    for (Team t : teams) {
                %>
                <tr>
                    <td><%=t.getName()%></td>
                    <td><input type="submit" name="action" value="Delete"></td>
                </tr>
                <%
                    }
                %>
            </table>
        </form>
    </body>
</html>
