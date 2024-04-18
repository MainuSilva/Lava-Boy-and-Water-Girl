package org.example.model.score;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ScoreSave {
    ObjectOutputStream o;
    FileOutputStream f;

    public ScoreSave() throws IOException {
        f = new FileOutputStream(new File("src/main/resources/score/Score.txt"));
        o = new ObjectOutputStream(f);
    }

    public void writeInFile(ScoreList scoreList) throws IOException {
        o.writeObject(scoreList);
        o.close();
        f.close();
    }

}
