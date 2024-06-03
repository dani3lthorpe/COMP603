/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit4TestClass.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.util.ArrayList;
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
public class GameModeTest {

    private GameMode gameModeTest;
    private Player playerTest;

    public GameModeTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
        playerTest = new Player("User Name", 0, 0);
        gameModeTest = new NormalMode(playerTest);
    }

    @After
    public void tearDown() {
    }

    /**
     * Test of setCases method, of class GameMode. Tests if cases set properly
     */
    @Test
    public void testSetCases() {
        assertEquals(gameModeTest.getCases().size(), gameModeTest.getPrizes().size());
        for (int prize : gameModeTest.getPrizes()) {
            boolean found = false;
            for (Case c : gameModeTest.getCases()) {
                if (c.getPrize() == prize) {
                    found = true;
                }
            }
            assertTrue(found);
        }
    }

    /**
     * Test of removePrize method, of class GameMode. Tests if prize is removed
     * from array
     */
    @Test
    public void testRemovePrize() {
        System.out.println("removePrize");
        int prize = gameModeTest.getCases().get(2).getPrize();
        gameModeTest.removePrize(2);
        ArrayList<Integer> prizes = gameModeTest.getPrizes();
        for (int amount : prizes) {
            assertNotEquals(prize, amount);
        }
    }

    /**
     * Test of acceptOffer method, of class GameMode. Tests if offer is Smaller
     * than the highest Prizes if it doesn't saves it to highest prizes
     */
    public void testAcceptSmallerOffer() {
        System.out.println("acceptSmallerOffer");
        gameModeTest.getGameData().setCurrentOffer(-10);
        gameModeTest.acceptOffer();
        for (int highPrize : gameModeTest.getPlayer().getHighPrizes()) {
            assertNotEquals(highPrize, -10);
        }
    }

    /**
     * Test of acceptOffer method, of class GameMode. Tests if offer is Bigger
     * than the highest Prizes if it saves it to highest prizes
     */
    @Test
    public void testAcceptBiggerOffer() {
        System.out.println("acceptBiggerOffer");
        gameModeTest.getGameData().setCurrentOffer(5000000);
        gameModeTest.acceptOffer();
        boolean found = false;
        for (int highPrize : gameModeTest.getPlayer().getHighPrizes()) {
            if (highPrize == 5000000) {
                found = true;
            }
        }
        assertTrue(found);
    }

    /**
     * Test of openYourCase method, of class GameMode. Checks if it saves the
     * prize to highest prizes if it is bigger
     */
    @Test
    public void testOpenYourCaseBiggerPrize() {
        System.out.println("openYourCaseBiggerPrize");
        Case testCase = new Case(0, 5000000);
        gameModeTest.getGameData().setPlayerCase(testCase);
        gameModeTest.openYourCase();
        Boolean found = false;
        for (int highPrize : gameModeTest.getPlayer().getHighPrizes()) {
            if (highPrize == 5000000) {
                found = true;
            }
        }
        assertTrue(found);
    }

    /**
     * Test of openYourCase method, of class GameMode. Checks if it doesn't save
     * the prize to highest prizes if it is smaller
     */
    @Test
    public void testOpenYourCaseSmallerPrize() {
        System.out.println("openYourCaseSmallerPrize");
        Case testCase = new Case(0, 5000000);
        gameModeTest.getGameData().setPlayerCase(testCase);
        for (int highPrize : gameModeTest.getPlayer().getHighPrizes()) {
            assertNotEquals(highPrize, -10);
        }
    }


}
