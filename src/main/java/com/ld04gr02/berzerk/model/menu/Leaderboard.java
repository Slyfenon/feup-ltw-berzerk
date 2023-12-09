package com.ld04gr02.berzerk.model.menu;

import java.io.*;
import java.util.ArrayList;

public class Leaderboard {
    private ArrayList<String> names;
    private ArrayList<Integer> scores;

    public Leaderboard() throws IOException {
        names = new ArrayList<>();
        scores = new ArrayList<>();
        readFromFile("/src/main/resources/Leaderboard.brd");
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void readFromFile(String filePath) {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String mapLocation = rootPath + filePath;

            BufferedReader bufferedReader = new BufferedReader(new FileReader(mapLocation));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = line.split(",");

                if (values.length == 2) {
                    String name = values[0].trim();
                    int score = Integer.parseInt(values[1].trim());

                    names.add(name);
                    scores.add(score);
                }
            }

            bufferedReader.close();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }

    public boolean addToLeaderboard(String name, int score) {
        for (int i = 0; i < 10; i++) {
            if(score >= scores.get(i)) {
                scores.add(i, score);
                names.add(i, name);
                scores.remove(scores.size() - 1);
                names.remove(names.size() - 1);
                return true;
            }
        }
        return false;
    }

    public void writeToFile(String filePath) {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String mapLocation = rootPath + filePath;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mapLocation));

            // Writing names and scores to the file
            for (int i = 0; i < names.size(); i++) {
                String line = names.get(i) + "," + scores.get(i);
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Add a new line for the next entry
            }

            bufferedWriter.close(); // Close the BufferedWriter when done
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}