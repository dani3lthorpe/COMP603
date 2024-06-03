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
     * than the highest Prizes if it doesn't save the offer
     */
    @Test
<<<<<<< Updated upstream
    public void testDisplayOffer() {
        System.out.println("displayOffer");
        GameMode instance = null;
        instance.displayOffer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of acceptOffer method, of class GameMode.
     */
    @Test
    public void testAcceptOffer() {
        System.out.println("acceptOffer");
        GameMode instance = null;
        instance.acceptOffer();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of openYourCase method, of class GameMode.
     */
    @Test
    public void testOpenYourCase() {
        System.out.println("openYourCase");
        GameMode instance = null;
        instance.openYourCase();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlayer method, of class GameMode.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        GameMode instance = null;
        Player expResult = null;
        Player result = instance.getPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getCases method, of class GameMode.
     */
    @Test
    public void testGetCases() {
        System.out.println("getCases");
        GameMode instance = null;
        ArrayList<Case> expResult = null;
        ArrayList<Case> result = instance.getCases();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalGames method, of class GameMode.
     */
    @Test
    public void testGetTotalGames() {
        System.out.println("getTotalGames");
        GameMode instance = null;
        int expResult = 0;
        int result = instance.getTotalGames();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getTotalPrizes method, of class GameMode.
     */
    @Test
    public void testGetTotalPrizes() {
        System.out.println("getTotalPrizes");
        GameMode instance = null;
        int expResult = 0;
        int result = instance.getTotalPrizes();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalGames method, of class GameMode.
     */
    @Test
    public void testSetTotalGames() {
        System.out.println("setTotalGames");
        int totalGames = 0;
        GameMode instance = null;
        instance.setTotalGames(totalGames);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setTotalPrizes method, of class GameMode.
     */
    @Test
    public void testSetTotalPrizes() {
        System.out.println("setTotalPrizes");
        int totalPrizes = 0;
        GameMode instance = null;
        instance.setTotalPrizes(totalPrizes);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGameData method, of class GameMode.
     */
    @Test
    public void testGetGameData() {
        System.out.println("getGameData");
        GameMode instance = null;
        GameData expResult = null;
        GameData result = instance.getGameData();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPrize method, of class GameMode.
     */
    @Test
    public void testGetPrize() {
        System.out.println("getPrize");
        GameMode instance = null;
        ArrayList expResult = null;
        ArrayList result = instance.getPrizes();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newRound method, of class GameMode.
     */
    @Test
    public void testNewRound() {
        System.out.println("newRound");
        GameMode instance = null;
        instance.newRound();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    public class GameModeImpl extends GameMode {

        public GameModeImpl() {
            super(null, null, null);
        }

        public void newRound() {
=======
    public void testAcceptSmallerOffer() {
        System.out.println("acceptSmallerOffer");
        gameModeTest.getGameData().setCurrentOffer(-10);
        gameModeTest.acceptOffer();
        for (int highPrize : gameModeTest.getPlayer().getHighPrizes()) {
            assertNotEquals(highPrize, -10);
>>>>>>> Stashed changes
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
