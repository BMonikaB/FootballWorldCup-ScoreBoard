package com.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final List<Match> matches = new ArrayList<>();

    public void startGame(String homeTeamName, String awayTeamName) {
        matches.add(new Match(homeTeamName, awayTeamName));
    }

    public void finishGame(String homeTeamName, String awayTeamName) {
        matches.removeIf(m -> m.getHomeTeamName().equals(homeTeamName) && m.getAwayTeamName().equals(awayTeamName));
    }

    public void updateScore(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) {
        for (Match match : matches) {
            if (match.getHomeTeamName().equals(homeTeamName) && match.getAwayTeamName().equals(awayTeamName)) {
                match.updateScore(homeTeamScore, awayTeamScore);
                break;
            }
        }
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::totalScore).reversed()
                        .thenComparing(Match::getStartTime).reversed())
                .collect(Collectors.toList());
    }
}
