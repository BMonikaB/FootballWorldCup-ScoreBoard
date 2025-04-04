package com.scoreboard;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ScoreBoardTest {

    @Test
    void testStartAndFinishGame() {
        ScoreBoard board = new ScoreBoard();
        board.startGame("Mexico", "Canada");
        board.startGame("Spain", "Brazil");
        assertEquals(2, board.getSummary().size());
        board.finishGame("Mexico", "Canada");
        assertEquals(1, board.getSummary().size());
    }

    @Test
    void testUpdateScoreAndSummary() {
        ScoreBoard board = new ScoreBoard();
        board.startGame("Mexico", "Canada");
        board.updateScore("Mexico", "Canada", 0, 5);
        board.startGame("Spain", "Brazil");
        board.updateScore("Spain", "Brazil", 10, 2);
        board.startGame("Germany", "France");
        board.updateScore("Germany", "France", 2, 2);
        List<Match> summary = board.getSummary();

        assertEquals("Spain 10 - Brazil 2", summary.get(0).toString());
        assertEquals("Mexico 0 - Canada 5", summary.get(1).toString());
        assertEquals("Germany 2 - France 2", summary.get(2).toString());
    }
}
