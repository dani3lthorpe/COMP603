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
import java.util.LinkedHashMap;
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

    private static Connection conn = null;

    // Constructor for DBManager, gets connection to databse, if the connection is not null (successfully connected) it creates tables. If the connection was null it prints an error message
    public DBManager() {
        conn = getConnection();
        if (conn != null) {
            createTables();
        } else {
            System.err.println("Failed to connect to database");
        }
    }

    //uses singleton design pattern to create a connection to database if conn is null. Returns conn
    public static Connection getConnection() {
        try {
            if (conn == null) {
                conn = DriverManager.getConnection(URL, USER_NAME, PASSWORD);
                System.out.println(URL + " connected...");
            }
        } catch (SQLException ex) {
            System.err.println("SQLException: " + ex.getMessage());
        }
        return conn;
    }

    //closes connenction to database if not null and open
    public static void closeConnection() {
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
            conn = null;
            System.out.println("Connection Closed");
        }
    }

    //creates tables in databasse if not already created
    public void createTables() {
        try {
            boolean players = false;
            boolean recentPrizes = false;
            boolean highestPrizes = false;
            boolean totalGameStats = false;
            DatabaseMetaData metaData = conn.getMetaData();
            ResultSet resultSet = metaData.getTables(null, null, null, new String[]{"TABLE"});

            while (resultSet.next()) {
                String name = resultSet.getString("TABLE_NAME");
                if (name.equals("PLAYER")) {
                    players = true;
                } else if (name.equals("RECENTPRIZE")) {
                    recentPrizes = true;
                } else if (name.equals("HIGHPRIZE")) {
                    highestPrizes = true;
                } else if (name.equals("TOTALSTAT")) {
                    totalGameStats = true;
                }
            }

            if (!players) {
                createPlayerTable();
            } else {
                System.out.println("Player Table already exists");
            }
            if (!recentPrizes) {
                createRecentPrizeTable();
            } else {
                System.out.println("RecentPrize Table already exists");
            }
            if (!highestPrizes) {
                createHighPrizeTable();
            } else {
                System.out.println("HighPrize Table already exists");
            }
            if (!totalGameStats) {
                createTotalStatTable();
            } else {
                System.out.println("TotalStat Table already exists");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //creates player table in database
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

    //creates recentPrizes table in database
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
            statement.close();
            System.out.println("RecentPrize Table created");

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    //creates highprize table in database
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
            statement.close();
            System.out.println("HighPrize Table created");

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //creates totalstat table in database
    public void createTotalStatTable() {
        try ( Statement statement = conn.createStatement()) {
            String createTotalStat = "create table TOTALSTAT ("
                    + "GAME_NAME VARCHAR(20),"
                    + "TOTAL_GAMES INT, "
                    + "TOTAL_PRIZES INT)";
            statement.executeUpdate(createTotalStat);
            statement.close();
            System.out.println("HighPrize Table created");
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //loads players from database into a hashmap, returns players hashmap
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
            
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return players;
    }

    //loads recent prizes from database into a hashmap, returns recent prizes hashmap
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
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return recentPrizes;
    }
    
    //loads recent prizes from database into a hashmap, returns recent prizes hashmap
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
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return highPrizes;
    }

    //loads global total prizes from database into linked hashmap, returns hashmap
    public LinkedHashMap<String, Integer> loadGlobalTotalPrizes() {
        LinkedHashMap<String, Integer> globalTotalPrizes = new LinkedHashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, TOTALSCORE FROM PLAYER"
                    + " ORDER BY TOTALSCORE DESC";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                globalTotalPrizes.put(resultSet.getString("NAME"), resultSet.getInt("TOTALSCORE"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return globalTotalPrizes;
    }
    
    //loads global high prizes from database into linked hashmap, returns hashmap
    public LinkedHashMap<String, Integer> loadGlobalHighPrizes() {
        LinkedHashMap<String, Integer> globalHighPrizes = new LinkedHashMap<>();

        try {
            Statement statement = conn.createStatement();
            String query = "SELECT NAME, HIGHSCORE FROM PLAYER"
                    + " ORDER BY HIGHSCORE DESC";
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                globalHighPrizes.put(resultSet.getString("NAME"), resultSet.getInt("HIGHSCORE"));
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return globalHighPrizes;
    }

    //loads total stats from database and returns it as int array
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
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
        return totalStats;
    }

    //updates player highscore and totalscore in hashmap before updating the database from hashmap, 
    //takes players hashmap player object as parameter
    public void updateScore(HashMap<String, Player> players, Player player) {
        players.put(player.getName(), player);
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM PLAYER WHERE NAME = '" + player.getName() + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                query = "UPDATE PLAYER SET TOTALSCORE = " + player.getTotalPrizes()
                        + ", HIGHSCORE = " + player.getHighestPrize()
                        + " WHERE NAME =  '" + player.getName() + "'";
                statement.executeUpdate(query);
                System.out.println("player updated.");
            } else {
                query = "INSERT INTO PLAYER (NAME, TOTALSCORE, HIGHSCORE) VALUES ('" + player.getName() + "', " + player.getTotalPrizes() + ", " + player.getHighestPrize() + ")";
                statement.executeUpdate(query);
                System.out.println("player created");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //updates recent prizes in hashmap before updating database from hashmap, 
    //takes recentPrizes hashmap and player object as input
    public void updateRecentPrizes(HashMap<String, int[]> recentPrizes, Player player) {
        recentPrizes.put(player.getName(), player.getRecentPrizes());
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM RECENTPRIZE WHERE NAME = '" + player.getName() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            int[] prizes = player.getRecentPrizes();

            if (resultSet.next()) {
                query = "UPDATE RECENTPRIZE SET RECENTPRIZE_ONE = " + prizes[0]
                        + ", RECENTPRIZE_TWO = " + prizes[1]
                        + ", RECENTPRIZE_THREE = " + prizes[2]
                        + ", RECENTPRIZE_FOUR = " + prizes[3]
                        + ", RECENTPRIZE_FIVE = " + prizes[4]
                        + " WHERE NAME =  '" + player.getName() + "'";
                statement.executeUpdate(query);
                System.out.println("RecentPrize updated.");
            } else {
                query = "INSERT INTO RECENTPRIZE (NAME, RECENTPRIZE_ONE, RECENTPRIZE_TWO, RECENTPRIZE_THREE, RECENTPRIZE_FOUR, "
                        + "RECENTPRIZE_FIVE) VALUES ('"
                        + player.getName() + "', "
                        + prizes[0] + ", "
                        + prizes[1] + ", "
                        + prizes[2] + ", "
                        + prizes[3] + ", "
                        + prizes[4] + ")";
                statement.executeUpdate(query);
                System.out.println("Player's RecentPrizes created");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    //updates high prizes in hashmap before updating the database from hashmap, 
    //takes highPrizes hashmap and player object as input
    public void updateHighPrizes(HashMap<String, int[]> highPrizes, Player player) {
        highPrizes.put(player.getName(), player.getHighPrizes());
        try {
            Statement statement = conn.createStatement();
            String query = "SELECT * FROM HIGHPRIZE WHERE NAME = '" + player.getName() + "'";
            ResultSet resultSet = statement.executeQuery(query);
            int[] prizes = player.getHighPrizes();

            if (resultSet.next()) {
                query = "UPDATE HIGHPRIZE SET HIGHPRIZE_ONE = " + prizes[0]
                        + ", HIGHPRIZE_TWO = " + prizes[1]
                        + ", HIGHPRIZE_THREE = " + prizes[2]
                        + ", HIGHPRIZE_FOUR = " + prizes[3]
                        + ", HIGHPRIZE_FIVE = " + prizes[4]
                        + " WHERE NAME =  '" + player.getName() + "'";
                statement.executeUpdate(query);
                System.out.println("HighPrize updated.");
            } else {
                query = "INSERT INTO HIGHPRIZE (NAME, HIGHPRIZE_ONE, HIGHPRIZE_TWO, HIGHPRIZE_THREE, HIGHPRIZE_FOUR, "
                        + "HIGHPRIZE_FIVE) VALUES ('"
                        + player.getName() + "', "
                        + prizes[0] + ", "
                        + prizes[1] + ", "
                        + prizes[2] + ", "
                        + prizes[3] + ", "
                        + prizes[4] + ")";
                statement.executeUpdate(query);
                System.out.println("Player's HighPrizes created");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    //updates totalStats in int array before updating the database from int array, 
    //takes totalStats int array and gamemode object as input
    public void updateTotalStats(int[] totalStats, GameMode game) {
        totalStats[0] += game.getTotalGames();
        totalStats[1] += game.getTotalPrizes();

        try {
            Statement statement = conn.createStatement();
            String gameName = "DealOrNoDeal";
            String query = "SELECT * FROM TOTALSTAT WHERE GAME_NAME = '" + gameName + "'";
            ResultSet resultSet = statement.executeQuery(query);

            if (resultSet.next()) {
                query = "UPDATE TOTALSTAT SET TOTAL_GAMES = " + totalStats[0] + ", TOTAL_PRIZES = " + totalStats[1] + " WHERE GAME_NAME =  '" + gameName + "'";
                statement.executeUpdate(query);
                System.out.println("GameStats updated.");
            } else {
                query = "INSERT INTO TOTALSTAT (GAME_NAME, TOTAL_GAMES, TOTAL_PRIZES) VALUES ('" + gameName + "', " + totalStats[0] + ", " + totalStats[1] + ")";
                statement.executeUpdate(query);
                System.out.println("GameStats created");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
