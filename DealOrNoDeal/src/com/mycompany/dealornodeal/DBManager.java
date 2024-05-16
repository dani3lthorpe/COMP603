/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author hidan
 */
public class DBManager {

    private static final String USER_NAME = "group69";
    private static final String PASSWORD = "abcd";
    private static final String URL = "jdbc:derby:DealOrNoDealDB;create=true";

    private static Connection conn;

    public DBManager() {
        establishConnection();
        this.createPlayerTable();
        this.createRecentPrizeTable();
        this.createHighPrizeTable();
        this.createTotalStatTable();
    }

    private static void establishConnection() {
        try {
            conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
            System.out.println(URL + " connected...");
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
    }

    public void closeConnections() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public Connection getConn() {
        return conn;
    }

    public ResultSet queryDB(String sql) {
        ResultSet resultSet = null;

        try {
            Statement statement = conn.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        ResultSet resultSet = null;

        try {
            Statement statement = conn.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createPlayerTable() {
        try ( Statement statement = conn.createStatement()) {
            String createPlayer = "create table PLAYER ("
                    + "NAME VARCHAR(20), "
                    + "TOTALSCORE INT, "
                    + "HIGHSCORE INT)";
            statement.executeUpdate(createPlayer);
            statement.close();
            System.out.println("Player Table created");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("X0Y32")) {
                System.out.println("Player Table already exists");
            }
        }

    }

    public void createRecentPrizeTable() {
        try ( Statement statement = conn.createStatement()) {
            String createRecentPrize = "create table RECENTPRIZE ("
                    + "NAME VARCHAR(20), "
                    + "RECENTPRIZE_ONE INT, "
                    + "RECENTPRIZE_TWO INT,"
                    + "RECENTPRIZE_THREE INT,"
                    + "RECENTPRIZE_FOUR INT,"
                    + "RECENTPRIZE_FIVE INT)";
            statement.executeUpdate(createRecentPrize);
            System.out.println("RecentPrize Table created");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("X0Y32")) {
                System.out.println("RecentPrize Table already exists");
            } else {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public void createHighPrizeTable() {
        try ( Statement statement = conn.createStatement()) {
            String createHighPrize = "create table HIGHPRIZE ("
                    + "NAME VARCHAR(20), "
                    + "HIGHPRIZE_ONE INT, "
                    + "HIGHPRIZE_TWO INT,"
                    + "HIGHPRIZE_THREE INT,"
                    + "HIGHPRIZE_FOUR INT,"
                    + "HIGHPRIZE_FIVE INT)";
            statement.executeUpdate(createHighPrize);
            System.out.println("HighPrize Table created");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("X0Y32")) {
                System.out.println("HighPrize Table already exists");
            } else {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void createTotalStatTable() {
        try ( Statement statement = conn.createStatement()) {
            String createTotalStat = "create table TOTALSTAT ("
                    + "GAME_NAME VARCHAR(20),"
                    + "TOTAL_GAMES INT, "
                    + "TOTAL_PRIZES INT)";
            statement.executeUpdate(createTotalStat);
        } catch (SQLException ex) {
            if (ex.getSQLState().equals("X0Y32")) {
                System.out.println("TotalStat Table already exists");
            } else {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public HashMap<String, Player> loadPlayers() {
        HashMap<String, Player> players = new HashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, TOTALSCORE, HIGHSCORE FROM PLAYER";
            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int totalPrize = resultSet.getInt("TOTALSCORE");
                int highPrize = resultSet.getInt("HIGHSCORE");
                players.put(name, new Player(name, totalPrize, highPrize));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }

    public HashMap<String, int[]> loadRecentPrizes() {
        HashMap<String, int[]> recentPrizes = new HashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, RECENTPRIZE_ONE, RECENTPRIZE_TWO, "
                    + "RECENTPRIZE_THREE, RECENTPRIZE_FOUR,"
                    + "RECENTPRIZE_FIVE FROM RECENTPRIZE";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int[] prizes = new int[5];
                String name = resultSet.getString("NAME");
                prizes[0] = resultSet.getInt("RECENTPRIZE_ONE");
                prizes[1] = resultSet.getInt("RECENTPRIZE_TWO");
                prizes[2] = resultSet.getInt("RECENTPRIZE_THREE");
                prizes[3] = resultSet.getInt("RECENTPRIZE_FOUR");
                prizes[4] = resultSet.getInt("RECENTPRIZE_FIVE");
                recentPrizes.put(name, prizes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recentPrizes;
    }

    public HashMap<String, int[]> loadHighPrizes() {
        HashMap<String, int[]> highPrizes = new HashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, HIGHPRIZE_ONE, HIGHPRIZE_TWO, "
                    + "HIGHPRIZE_THREE, HIGHPRIZE_FOUR,"
                    + "HIGHPRIZE_FIVE FROM HIGHPRIZE";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                int[] prizes = new int[5];
                String name = resultSet.getString("NAME");
                prizes[0] = resultSet.getInt("HIGHPRIZE_ONE");
                prizes[1] = resultSet.getInt("HIGHPRIZE_TWO");
                prizes[2] = resultSet.getInt("HIGHPRIZE_THREE");
                prizes[3] = resultSet.getInt("HIGHPRIZE_FOUR");
                prizes[4] = resultSet.getInt("HIGHPRIZE_FIVE");
                highPrizes.put(name, prizes);
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return highPrizes;
    }

    public HashMap<String, Integer> loadGlobalTotalPrizes() {
        HashMap<String, Integer> globalTotalPrizes = new HashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, TOTALSCORE FROM PLAYER"
                    + " ORDER BY TOTALSCORE DESC";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                globalTotalPrizes.put(resultSet.getString("NAME"), resultSet.getInt("TOTALSCORE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return globalTotalPrizes;
    }

    public HashMap<String, Integer> loadGlobalHighPrizes() {
        HashMap<String, Integer> globalHighPrizes = new HashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, HIGHSCORE FROM PLAYER"
                    + " ORDER BY HIGHSCORE DESC";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                globalHighPrizes.put(resultSet.getString("NAME"), resultSet.getInt("HIGHSCORE"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return globalHighPrizes;
    }

    public int[] loadTotalStats() {
        int[] totalStats = new int[2];

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT GAME_NAME, TOTAL_GAMES, "
                    + "TOTAL_PRIZES FROM TOTALSTAT";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                if (resultSet.getString("GAME_NAME").equals("DealOrNoDeal")) {
                    totalStats[0] = resultSet.getInt("TOTAL_GAMES");
                    totalStats[1] = resultSet.getInt("TOTAL_PRIZES");
                }
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalStats;
    }

}
