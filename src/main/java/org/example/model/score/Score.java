package org.example.model.score;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Score implements Serializable {
    private final LocalDateTime timeStamp; // to know the time the score was made
    private final double time;
    private final int stars;

    public Score(double time, int stars){
        this.stars = stars;
        this.time = time;
        this.timeStamp= LocalDateTime.now();
    }

    public double getTime() {
        return time;
    }

    public int getStars(){
        return stars;
    }

    public String getFormatTimeStamp(){
        return timeStamp.format(DateTimeFormatter.ofPattern("dd-MM-yy"));
    }
}
