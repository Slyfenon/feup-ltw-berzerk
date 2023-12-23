package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.io.IOException;

public class LeaderboardTests extends Assertions {
    private Leaderboard leaderboard;

    @BeforeEach
    public void setUp() throws IOException {
        leaderboard = new Leaderboard("/src/main/resources/LeaderboardTest.brd");
    }

    @Test
    public void leaderBoardTest() throws IOException {
        leaderboard.writeToFile("/src/main/resources/LeaderboardTest.brd");
        assertEquals(10, leaderboard.getNames().size());
        assertEquals(10, leaderboard.getScores().size());
    }

    @Test
    public void addToLeaderboardTest() {
        assertTrue(leaderboard.addToLeaderboard("John", 250));
        assertFalse(leaderboard.addToLeaderboard("John", 249));
        leaderboard.addToLeaderboard("John", 9950);
        assertEquals("John", leaderboard.getNames().get(0));
        assertEquals(9950, leaderboard.getScores().get(0));
    }
}
