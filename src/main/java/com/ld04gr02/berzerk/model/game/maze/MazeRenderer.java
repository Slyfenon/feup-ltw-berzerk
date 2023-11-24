package com.ld04gr02.berzerk.model.game.maze;

import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class MazeRenderer {

    private final String level;
    private List<String> rows;
    public MazeRenderer(String level) throws IOException {
        this.level = level;
        URL resource = MazeRenderer.class.getResource("mazes/"+ level + ".lvl");
        BufferedReader bufferedReader = new BufferedReader(new FileReader(resource.getFile()));
        rows = renderRows(bufferedReader);
    }

    private List<String> renderRows(BufferedReader bufferedReader) throws IOException {
        List<String> rows = new ArrayList<>();
        for(String row; (row = bufferedReader.readLine()) != null;){
            rows.add(row);
        }
        return rows;
    }

}
