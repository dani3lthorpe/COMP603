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
    private static final String URL = "jdbc:derby:DealOrNoDealDB_Ebd;create=true";

    private Statement statement;
    private Connection conn;

    public DBManager() {
        establishConnection();
    }

    private void establishConnection() {
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

        Connection connection = this.conn;
        statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            resultSet = statement.executeQuery(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        return resultSet;
    }

    public void updateDB(String sql) {

        Connection connection = this.conn;
        statement = null;
        ResultSet resultSet = null;

        try {
            statement = connection.createStatement();
            statement.executeUpdate(sql);

        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }

    public void createPlayersTable() {
        try {
            statement = conn.createStatement();
            String newTableName = "PLAYER";
            this.checkExistedTable(newTableName);
            String sqlCreate = "create table " + newTableName + " (NAME VARCHAR(20), TOTALSCORE INT, HIGHSCORE INT)";
            statement.executeUpdate(sqlCreate);

            String sqlInsert = "insert into " + newTableName + " values("
                    + "'dan', 400709729, 200001189),"
                    + "('ryan', 14198, 7099),"
                    + "('luke', 20380, 10190)"
                    + "('joe', 18132, 9066)"
                    + "('lourdes', 234538, 77502)"
                    + "('droun', 133106, 36525)";
            statement.executeUpdate(sqlInsert);
            statement.close();
            System.out.println("Table created");

            String query = "SELECT NAME, TOTALSCORE, HIGHSCORE FROM " + newTableName;

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
            Logger.getLogger(DBManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void checkExistedTable(String name) {
        try {
            DatabaseMetaData dbmd;
            dbmd = this.conn.getMetaData();
            String[] types = {"TABLE"};
            statement = conn.createStatement();
            ResultSet rs = dbmd.getTables(null, null, null, types);
            while (rs.next()) {
                String table_name = rs.getString("TABLE_NAME");
                System.out.println(table_name);
                if (table_name.equalsIgnoreCase(name)) {
                    statement.executeUpdate("Drop table " + name);
                    System.out.println("Table " + name + " has been deleted.");
                    break;
                }
            }
            rs.close();

        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }

}
