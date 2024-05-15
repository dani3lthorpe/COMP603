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
    }

    public static void main(String[] args) {
        establishConnection();
        createPlayerTable();
        createRecentPrizeTable();
        createHighPrizeTable();
        createTotalStatTable();
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

    public static void createPlayerTable() {
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

    public static void createRecentPrizeTable() {
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
    
    
    public static void createHighPrizeTable() {
        try ( Statement statement = conn.createStatement()) {
            String createHighPrize = "create table HIGHPRIZE ("
                    + "NAME VARCHAR(20), "
                    + "HIGHPRIZE_ONE INT, "
                    + "HIGHPRIZE_TWO INT,"
                    + "HIGHPRIZE_THREE INT,"
                    + "HIGHPRIZE_FOUR INT,"
                    + "HIGHPRIZE_FIVE INT)";
            statement.executeUpdate(createHighPrize);
            
            String sqlInsert = "insert into HIGHPRIZE values "
                    + "('dan', 200001189, 50000, 35651, 35650, 30185),"
                    + "('ryan', 7099, 0, 0, 0, 0),"
                    + "('luke', 10190, 0, 0, 0, 0),"
                    + "('joe', 9066, 0, 0, 0, 0),"
                    + "('lourdes', 77502, 20680, 10166, 8915, 6),"
                    + "('droun', 36525, 8845, 5880, 0, 0)";

            statement.executeUpdate(sqlInsert);
            System.out.println("HighPrize Table created");

        } catch (SQLException ex) {
            if (ex.getSQLState().equals("X0Y32")) {
                System.out.println("HighPrize Table already exists");
            } else {
                Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
     public static void createTotalStatTable() {
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
    
    public static void getPlayers() {
        try {
            Statement statement = conn.createStatement();

            String query = "SELECT NAME, TOTALSCORE, HIGHSCORE FROM PLAYER";

            ResultSet resultSet = statement.executeQuery(query);

            while (resultSet.next()) {
                String name = resultSet.getString("NAME");
                int totalScore = resultSet.getInt("TOTALSCORE");
                int highScore = resultSet.getInt("HIGHSCORE");
                System.out.println(name + ": ");
                System.out.println("Total Score: ");
                System.out.println("High Score: ");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
