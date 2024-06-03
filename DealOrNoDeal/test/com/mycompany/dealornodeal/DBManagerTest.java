/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.sql.Connection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author hidan
 */
public class DBManagerTest {

    private DBManager dataBaseTest;

    public DBManagerTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        dataBaseTest = new DBManager();
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of getConnection method, of class DBManager. Test if getConnection
     * gets a connection
     */
    @Test
    public void testGetConnection() {
        System.out.println("getConnection");
        Connection expResult = null;
        Connection result = DBManager.getConnection();
        assertNotNull(result);
    }

    /**
     * Test of getConnection method, of class DBManager. Test if getConnection
     * follows singleton design pattern
     */
    @Test
    public void testGetConnectionSingleton() {
        System.out.println("getConnection");
        Connection result1 = DBManager.getConnection();
        Connection result2 = DBManager.getConnection();
        assertSame(result1, result2);
    }

    /**
     * Test of closeConnection method, of class DBManager.
     */
    @Test
    public void testCloseConnection() {
        System.out.println("closeConnection");
        Connection conn1 = DBManager.getConnection();
        DBManager.closeConnection();
        Connection conn2 = DBManager.getConnection();
        
        assertNotSame(conn1, conn2);
    }

    /**
     * Test of loadPlayers method, of class DBManager.
     */
    @Test
    public void testLoadPlayers() {
        System.out.println("loadPlayers");
        HashMap<String, Player> result = dataBaseTest.loadPlayers();
        assertNotNull(result);
    }

    /**
     * Test of loadRecentPrizes method, of class DBManager.
     */
    @Test
    public void testLoadRecentPrizes() {
        System.out.println("loadRecentPrizes");
        HashMap<String, int[]> result = dataBaseTest.loadRecentPrizes();
        assertNotNull(result);
    }

    /**
     * Test of loadHighPrizes method, of class DBManager.
     */
    @Test
    public void testLoadHighPrizes() {
        System.out.println("loadHighPrizes");
        HashMap result = dataBaseTest.loadHighPrizes();
        assertNotNull(result);
    }

    /**
     * Test of loadGlobalTotalPrizes method, of class DBManager.
     */
    @Test
    public void testLoadGlobalTotalPrizes() {
        System.out.println("loadGlobalTotalPrizes");
        HashMap result = dataBaseTest.loadGlobalTotalPrizes();
        assertNotNull(result);
    }

    /**
     * Test of loadGlobalHighPrizes method, of class DBManager.
     */
    @Test
    public void testLoadGlobalHighPrizes() {
        System.out.println("loadGlobalHighPrizes");
        HashMap result = dataBaseTest.loadGlobalHighPrizes();
        assertNotNull(result);
    }

    /**
     * Test of loadTotalStats method, of class DBManager.
     */
    @Test
    public void testLoadTotalStats() {
        System.out.println("loadTotalStats");
        int[] result = dataBaseTest.loadTotalStats();
        assertNotNull(result);
    }
}
