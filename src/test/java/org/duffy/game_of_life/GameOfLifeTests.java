package org.duffy.game_of_life;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class GameOfLifeTests {

    @Test
    void start() {
        // Given
        List<Pair> starts = Arrays.asList(
                new Pair(5, 4),
                new Pair(4, 5),
                new Pair(5, 5),
                new Pair(6, 5),
                new Pair(5, 6)
                );

        // When
        GameOfLife.start(starts);
    }
}