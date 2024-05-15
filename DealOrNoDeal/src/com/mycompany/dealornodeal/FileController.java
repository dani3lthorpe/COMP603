/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.dealornodeal;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;

/**
 * File controller class controls all the file reading and writing
 *
 * @author group69
 */
public class FileController {

    //Reads the list of players and their total prizes and highest prize stats from the players file
    //saves this data in a players hashmap and returns the hashmap
    public HashMap<String, Player> loadPlayers() {
        HashMap<String, Player> players = new HashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./resources/players.txt"));
            String line;
            while ((line = br.readLine()) != null) {
                String[] split = line.split("/", 3);
                String name = split[0];
                int totalPrize = Integer.parseInt(split[1]);
                int highPrize = Integer.parseInt(split[2]);

                players.put(name, new Player(name, totalPrize, highPrize));
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }

        return players;
    }

    //reads a set of 5 prizes got a user from a file then saves it in a hashMap
    //takes the files path as a parameter and returns a userPrizes hashmap
    public HashMap<String, int[]> loadUserPrizes(String path) {
        HashMap<String, int[]> userPrizes = new HashMap<>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(path));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("/", 7);
                String name = split[0];
                int[] prizes = new int[5];
                for (int i = 0; i < 5; i++) {
                    prizes[i] = Integer.parseInt(split[i + 1]);
                }
                userPrizes.put(name, prizes);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }

        return userPrizes;
    }
    
        //reads the players files and saves all the players in a hashmap sorted by their total prizes stat
    //returns the globalTotalPrizes hashmap
    public HashMap<String, Integer> loadGlobalTotalPrizes() {
        HashMap<String, Integer> globalTotalPrizes = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<String, Integer> sortedGlobalTotalPrizes = new LinkedHashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./resources/players.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("/", 3);
                String name = split[0];
                int prize = Integer.parseInt(split[1]);

                globalTotalPrizes.put(name, prize);
            }

            for (HashMap.Entry<String, Integer> entry : globalTotalPrizes.entrySet()) {
                temp.add(entry.getValue());
            }
            Collections.sort(temp, Collections.reverseOrder());

            int count = 0;
            for (int num : temp) {
                for (HashMap.Entry<String, Integer> entry : globalTotalPrizes.entrySet()) {
                    if (count < 5) {
                        if (entry.getValue().equals(num)) {
                            sortedGlobalTotalPrizes.put(entry.getKey(), num);
                            count++;
                        }
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }
        return sortedGlobalTotalPrizes;
    }

    //reads the players files and saves all the players in a hashmap sorted by their highest prizes stat
    //returns the globalHighPrizes hashmap
    public HashMap<String, Integer> loadGlobalHighPrizes() {
        HashMap<String, Integer> globalHighPrizes = new HashMap<>();
        ArrayList<Integer> temp = new ArrayList<>();
        HashMap<String, Integer> sortedHighPrizes = new LinkedHashMap<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader("./resources/players.txt"));
            String line;

            while ((line = br.readLine()) != null) {
                String[] split = line.split("/", 3);
                String name = split[0];
                int prize = Integer.parseInt(split[2]);

                globalHighPrizes.put(name, prize);
            }

            for (HashMap.Entry<String, Integer> entry : globalHighPrizes.entrySet()) {
                temp.add(entry.getValue());
            }
            Collections.sort(temp, Collections.reverseOrder());

            int count = 0;
            for (int num : temp) {
                for (HashMap.Entry<String, Integer> entry : globalHighPrizes.entrySet()) {
                    if (count < 5) {
                        if (entry.getValue().equals(num)) {
                            sortedHighPrizes.put(entry.getKey(), num);
                            count++;
                        }
                    }
                }
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }
        return sortedHighPrizes;
    }

    //reads the totalStats file and saves the total games played and total prizes won in an int array
    //returns the totalStats array
    public int[] loadTotalStats() {
        int[] totalStats = new int[2];

        try {
            BufferedReader br = new BufferedReader(new FileReader("./resources/totalStats.txt"));
            String line = "";
            while ((line = br.readLine()) != null) {
                String[] split = line.split("/", 2);

                totalStats[0] = Integer.parseInt(split[0]);
                totalStats[1] = Integer.parseInt(split[1]);
            }
            br.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found" + e.getMessage());
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());
        }
        return totalStats;
    }

    //adds the player to the players hashmap before updating the players file with the players name and prizes
    //seperates name and scores with /, takes playerlsit and player as parameters
    public void updateScore(HashMap<String, Player> players, Player player) {
        players.put(player.getName(), player);

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/players.txt"));
            for (Player p : players.values()) {
                bw.write(p.getName().toLowerCase() + "/" + p.getTotalPrizes() + "/" + p.getHighestPrize());
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());

        }
    }

    //adds the players recent prizes to the recentPrizes hashmap before updating the recentPrizes file
    //seperates name and scores with /, takes recentPrizes hashmap and player as parameters
    public void updateRecentPrizes(HashMap<String, int[]> recentPrizes, Player player) {
        recentPrizes.put(player.getName(), player.getRecentPrizes());

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/recentPrizes.txt"));
            for (HashMap.Entry<String, int[]> entry : recentPrizes.entrySet()) {
                String name = entry.getKey();
                int[] prizes = entry.getValue();

                bw.write(name.toLowerCase() + "/");
                for (int i = 0; i < prizes.length; i++) {
                    bw.write(prizes[i] + "/");
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());

        }
    }

    //adds the players highest prizes to the highprizes hashmap before updating the highPrizes file
    //seperates name and scores with /, takes highPrizes hashmap and player as parameters
    public void updateHighPrizes(HashMap<String, int[]> highPrizes, Player player) {
        highPrizes.put(player.getName(), player.getHighPrizes());

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/highPrizes.txt"));
            for (HashMap.Entry<String, int[]> entry : highPrizes.entrySet()) {
                String name = entry.getKey();
                int[] prize = entry.getValue();

                bw.write(name.toLowerCase() + "/");
                for (int i = 0; i < prize.length; i++) {
                    bw.write(prize[i] + "/");
                }
                bw.newLine();
            }
            bw.close();
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());

        }
    }

    //updates the total stats files with the new totals games played and total prizes from the GameMode
    //takes totalStats int array and gamemode object as parameters 
    public void updateTotalStats(int[] totalStats, GameMode game) {
        totalStats[0] = game.getTotalGames();
        totalStats[1] = game.getTotalPrizes();

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter("./resources/totalStats.txt"));
            bw.write(totalStats[0] + "/" + totalStats[1]);
            bw.newLine();
            bw.close();
        } catch (IOException e) {
            System.out.println("Error while reading file" + e.getMessage());

        }
    }

}
