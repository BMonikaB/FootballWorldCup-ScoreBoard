package com.scoreboard;

import java.time.LocalDateTime;
import java.util.Objects;

public class Match {

    private final String homeTeamName;
    private final String awayTeamName;
    private int homeTeamScore;
    private int awayTeamScore;
    private final LocalDateTime startTime;

    public Match(String homeTeamName, String awayTeamName) {
        this.homeTeamName = homeTeamName;
        this.awayTeamName = awayTeamName;
        this.homeTeamScore = 0;
        this.awayTeamScore = 0;
        this.startTime = LocalDateTime.now();
    }

    public void updateScore(int home, int away) {
        this.homeTeamScore = home;
        this.awayTeamScore = away;
    }

    public int totalScore() {
        return homeTeamScore + awayTeamScore;
    }


    public String getHomeTeamName() {
        return homeTeamName;
    }

    public String getAwayTeamName() {
        return awayTeamName;
    }

    public int getHomeTeamScore() {
        return homeTeamScore;
    }

    public void setHomeTeamScore(int homeTeamScore) {
        this.homeTeamScore = homeTeamScore;
    }

    public int getAwayTeamScore() {
        return awayTeamScore;
    }

    public void setAwayTeamScore(int awayTeamScore) {
        this.awayTeamScore = awayTeamScore;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Match match = (Match) o;
        return Objects.equals(homeTeamName, match.homeTeamName) && Objects.equals(awayTeamName, match.awayTeamName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(homeTeamName, awayTeamName);
    }

    @Override
    public String toString() {
        return homeTeamName + " " + homeTeamScore + " - " + awayTeamName + " " + awayTeamScore;
    }


}
