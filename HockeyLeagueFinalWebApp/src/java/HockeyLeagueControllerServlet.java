/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import bean.Game;
import bean.Team;
import data.GameDAO;
import data.TeamDAO;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author dujun
 */
@WebServlet(urlPatterns = {"/HockeyLeagueControllerServlet"})
public class HockeyLeagueControllerServlet extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String action = request.getParameter("action");

        //index servlet
        if (action.equals("Teams")) {
            response.sendRedirect("showTeams.jsp");
        } else if (action.equals("Games")) {
            response.sendRedirect("showGames.jsp");
        } else if (action.equals("Standings")) {
            response.sendRedirect("showStandings.jsp");
        }

        //showTeams servlet
        if (action.equals("Add Team")) {
            response.sendRedirect("addTeam.jsp");
        } else if (action.equals("Delete")) {
            String name = request.getParameter("team_name");
            
            TeamDAO teamDAO = new TeamDAO();
            teamDAO.deleteTeam(name);

            response.sendRedirect("showTeams.jsp");
        }

        //addTeam servlet
        if (action.equals("Save Team")) {
            Team team = new Team();
            team.setName(request.getParameter("name"));

            TeamDAO teamDAO = new TeamDAO();
            teamDAO.createTeam(team);

            response.sendRedirect("showTeams.jsp");
        }

        //showGames servlet
        if (action.equals("Add Game")) {
            response.sendRedirect("addGame.jsp");
        }

        //addGame servlet
        if (action.equals("Save Game")) {
            Game game = new Game();
            game.setWin(request.getParameter("winner"));
            game.setLose(request.getParameter("loser"));

            GameDAO gameDAO = new GameDAO();
            gameDAO.createGame(game);

            response.sendRedirect("showGames.jsp");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
