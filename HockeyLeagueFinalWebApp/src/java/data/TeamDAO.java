/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import bean.Team;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dujun
 */
public class TeamDAO {

    //insert team's data
    public void createTeam(Team team) {
        String sql = "INSERT INTO dbhockeyleague.teams (team_name) values ('" + team.getName() + "')";

        DBManager dbm = new DBManager();
        dbm.executeUpdate(sql);
    }

    //delete team's data
    public void deleteTeam(String name) {
        String sql = "DELETE FROM dbhockeyleague.teams WHERE team_name='" + name + "'";
        
        DBManager dbm = new DBManager();
        dbm.executeUpdate(sql);
    }

    //teams ArrayList
    public ArrayList<Team> retrieveAllTeams() {
        ArrayList<Team> teams = new ArrayList<Team>();
        String sql = "SELECT * FROM dbhockeyleague.teams";
        try {
            DBManager dbm = new DBManager();
            ResultSet rs = dbm.executeQuery(sql);
            while (rs.next()) {
                Team t = new Team();
                t.setName(rs.getString("team_name"));
                teams.add(t);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving people" + e);
        }
        return teams;
    }
}
