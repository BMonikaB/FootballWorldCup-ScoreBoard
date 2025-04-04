package com.scoreboard;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class ScoreBoard {

    private final List<Match> matches = new ArrayList<>();

    public void startGame(String homeTeamName, String awayTeamName) {
        try {
            Thread.sleep(10); //mili
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        matches.add(new Match(homeTeamName, awayTeamName));
    }
//public void startGame(String homeTeamName, String awayTeamName) {
//    matches.add(new Match(homeTeamName, awayTeamName));
//}

    public void finishGame(String homeTeamName, String awayTeamName) {
        matches.removeIf(m -> m.getHomeTeamName().equals(homeTeamName) && m.getAwayTeamName().equals(awayTeamName));
    }

    public void updateScore(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) throws ClassNotFoundException {
        Match match = matches.stream().filter(s -> s.getHomeTeamName().equals(homeTeamName)
                && s.getAwayTeamName().equals(awayTeamName)).findFirst().orElseThrow(() -> new ClassNotFoundException("Not Found"));
        ;
        match.updateScore(homeTeamScore,awayTeamScore);
    }

    public List<Match> getSummary() {
        return matches.stream()
                .sorted(Comparator.comparingInt(Match::totalScore).reversed()
                        .thenComparing((m1, m2) -> m2.getStartTime().compareTo(m1.getStartTime())))
                .collect(Collectors.toList());
    }

}
