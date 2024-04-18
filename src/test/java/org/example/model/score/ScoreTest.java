package org.example.model.score;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreTest {
    Score score;

    @BeforeEach
    public void score() {
        score = new Score(200, 3);
    }

    @Test
    public void stars() {
        assertEquals(3, score.getStars());
    }

    @Test
    public void time() {
        assertEquals(200, score.getTime());
    }

}
