/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import bean.Game;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author dujun
 */
public class GameDAO {

    //insert game's data
    public void createGame(Game game) {
        String sql = "INSERT INTO dbhockeyleague.games (game_win, game_lose) values ('" + game.getWin() + "', '" + game.getLose() + "')";

        DBManager dbm = new DBManager();
        dbm.executeUpdate(sql);
    }

    //games ArrayList
    public ArrayList<Game> retrieveAllGames() {
        ArrayList<Game> games = new ArrayList<Game>();
        String sql = "SELECT * FROM dbhockeyleague.games";
        try {
            DBManager dbm = new DBManager();
            ResultSet rs = dbm.executeQuery(sql);
            while (rs.next()) {
                Game game = new Game();
                game.setWin(rs.getString("game_win"));
                game.setLose(rs.getString("game_lose"));
                games.add(game);
            }
        } catch (Exception e) {
            System.out.println("Error retrieving games: " + e);
        }
        return games;
    }
}
