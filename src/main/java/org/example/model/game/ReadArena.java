package org.example.model.game;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadArena {
    private final List<String> lines;

    public ReadArena (File file) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(file));
        lines = readLines(reader);
    }

    private List<String> readLines(BufferedReader reader) throws IOException {
        List<String> lines = new ArrayList<>();
        for (String line; (line = reader.readLine()) != null; )
            lines.add(line);
        return lines;
    }

    public char[][] readMap(){

        char[][] readMap = new char[lines.size()][lines.get(0).length()];

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            for (int j = 0; j < line.length(); j++) {
                readMap[i][j] = line.charAt(j);
            }
        }

        return readMap;
    }

}
