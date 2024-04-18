package org.example.model.score;

import java.io.*;

public class ScoreRead {
    FileInputStream fi;
    ObjectInputStream oi;

    public ScoreRead() throws IOException {
        File score = new File("src/main/resources/score/Score.txt");

        //IF THE FILE DON'T EXIST
        if (score.createNewFile()) {
            FileOutputStream f = new FileOutputStream(score);
            ObjectOutputStream o = new ObjectOutputStream(f);
            o.writeObject(new ScoreList());
        }
        fi = new FileInputStream(score);
        oi = new ObjectInputStream(fi);

    }

    public ScoreList read() throws IOException, ClassNotFoundException {
        ScoreList scoreList = (ScoreList) oi.readObject();
        oi.close();
        fi.close();
        return scoreList;
    }
}
