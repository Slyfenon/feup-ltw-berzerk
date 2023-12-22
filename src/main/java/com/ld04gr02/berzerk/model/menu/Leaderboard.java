package com.ld04gr02.berzerk.model.menu;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.regex.Pattern;

public class Leaderboard extends Menu{
    private ArrayList<String> names;
    private ArrayList<Integer> scores;

    public Leaderboard(String filePath) throws IOException {
        names = new ArrayList<>();
        scores = new ArrayList<>();
        readFromFile(filePath);
    }

    public ArrayList<String> getNames() {
        return names;
    }

    public ArrayList<Integer> getScores() {
        return scores;
    }

    public void readFromFile(String filePath) throws IOException {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String mapLocation = rootPath + filePath;

            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(mapLocation), StandardCharsets.UTF_8));
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                String[] values = Pattern.compile(Pattern.quote(",")).splitAsStream(line).toArray(String[]::new);

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
            System.err.println("Error starting the game:  " + e.getMessage());
            throw new IOException("Error reading the file", e);
        }
    }

    public boolean addToLeaderboard(String name, int score) {
        if(!name.isEmpty()) {
            for (int i = 0; i < names.size(); i++) {
                if (score >= scores.get(i)) {
                    scores.add(i, score);
                    names.add(i, name);
                    scores.remove(scores.size() - 1);
                    names.remove(names.size() - 1);
                    return true;
                }
            }
        }
        return false;
    }

    public void writeToFile(String filePath) throws IOException {
        try {
            String rootPath = new File(System.getProperty("user.dir")).getPath();
            String mapLocation = rootPath + filePath;

            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(mapLocation, StandardCharsets.UTF_8));

            // Writing names and scores to the file
            for (int i = 0; i < names.size(); i++) {
                String line = names.get(i) + "," + scores.get(i);
                bufferedWriter.write(line);
                bufferedWriter.newLine(); // Add a new line for the next entry
            }

            bufferedWriter.close(); // Close the BufferedWriter when done
        } catch (IOException e) {
            System.err.println("Error starting the game:  " + e.getMessage());
            throw new IOException("Error reading the file", e);
        }
    }
}