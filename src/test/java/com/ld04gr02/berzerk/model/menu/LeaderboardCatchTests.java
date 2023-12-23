package com.ld04gr02.berzerk.model.menu;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.nio.charset.StandardCharsets;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LeaderboardCatchTests {
    private final ByteArrayOutputStream errContent = new ByteArrayOutputStream();
    private final PrintStream originalErr = System.err;

    private Leaderboard leaderboard;

    @BeforeEach
    public void setUp() {
        System.setErr(new PrintStream(errContent, true, StandardCharsets.UTF_8));
    }

    @AfterEach
    public void tearDown() {
        System.setErr(originalErr);
    }

    @Test
    public void exceptionReadFromFileTest() throws IOException {
        leaderboard = new Leaderboard("");
        String errorMessage = errContent.toString(StandardCharsets.UTF_8).trim();
        assertTrue(errorMessage.startsWith("Error:"));
    }

    @Test
    public void exceptionWriteToFileTest() throws IOException {
        leaderboard = new Leaderboard("/src/main/resources/LeaderboardTest.brd");
        leaderboard.writeToFile("");
        String errorMessage = errContent.toString(StandardCharsets.UTF_8).trim();
        assertTrue(errorMessage.startsWith("Error:"));
    }

}
