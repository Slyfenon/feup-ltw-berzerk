package com.ld04gr02.berzerk.model.game.maze;

import com.ld04gr02.berzerk.model.game.elements.Robot;
import com.ld04gr02.berzerk.model.game.elements.StickMan;
import com.ld04gr02.berzerk.model.game.elements.Wall;

import java.io.*;
import java.net.URL;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class MazeRenderer implements MazeBuilder {

    private List<String> rows;

    @Override
    public Maze createMaze(String name) throws IOException {
        String rootPath = new File(System.getProperty("user.dir")).getPath();
        String mapLocation = rootPath + "/src/main/resources/mazes/" + name;
        BufferedReader bufferedReader = Files.newBufferedReader(Paths.get(mapLocation), Charset.defaultCharset());
        rows = renderRows(bufferedReader);
        Maze maze = new Maze(getWidth(), getHeight());
        maze.setStickMan(createStickMan());
        maze.setRobots(createRobots());
        maze.setWalls(createWalls());
        return maze;
    }
    private List<String> renderRows(BufferedReader bufferedReader) throws IOException {
        List<String> rows = new ArrayList<>();
        for(String row; (row = bufferedReader.readLine()) != null;){
            rows.add(row);
        }
        return rows;
    }

    private StickMan createStickMan() {
        for (int y = 0; y < rows.size(); y++) {
            String line = rows.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'S')
                    return new StickMan(x, y);
        }
        return null;
    }

    private List<Robot> createRobots() {
        List<Robot> robots = new ArrayList<Robot>();
        for (int y = 0; y < rows.size(); y++) {
            String line = rows.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == 'R'){
                    robots.add(new Robot(x,y));
                }
        }
        return robots;
    }

    private List<Wall> createWalls() {
        List<Wall> walls = new ArrayList<Wall>();
        for (int y = 0; y < rows.size(); y++) {
            String line = rows.get(y);
            for (int x = 0; x < line.length(); x++)
                if (line.charAt(x) == '#'){
                    walls.add(new Wall(x,y));
                }
        }
        return walls;
    }

    private int getWidth() {
        return rows.get(0).length();
    }
    private int getHeight() {
        return rows.size();
    }

}
