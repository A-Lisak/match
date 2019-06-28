package com.lisak.match;

public class Match {

    private String homeTeam;
    private String awayTeam;
    private int homeScore;
    private int awayScore;

    public Match(final String homeTeam, final String awayTeam, final int homeScore, final int awayScore) {
        if (homeTeam == null || homeTeam.trim().equals("") || awayTeam == null || awayTeam.trim().equals("")
                || homeScore < 0 || awayScore < 0) {
            throw new IllegalArgumentException(
                    "Unable to instantiate the Match class due to an invalid, supplied parameter");
        }

        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        this.homeScore = homeScore;
        this.awayScore = awayScore;
    }

    int getGoalsFor(String team) {
        if (isHomeTeam(team)) {
            return homeScore;
        } else {
            return awayScore;
        }
    }

    int getGoalsAgainst(String team) {
        if (isHomeTeam(team)) {
            return awayScore;
        } else {
            return homeScore;
        }
    }

    String getHomeTeam() {
        return homeTeam;
    }

    String getAwayTeam() {
        return awayTeam;
    }

    MatchOutcome getMatchOutcome(String team) {
        boolean homeTeam = isHomeTeam(team);
        if (homeScore > awayScore) {
            if (homeTeam) {
                return MatchOutcome.WIN;
            } else {
                return MatchOutcome.LOSS;
            }
        } else if (homeScore < awayScore) {
            if (homeTeam) {
                return MatchOutcome.LOSS;
            } else {
                return MatchOutcome.WIN;
            }
        } else {
            return MatchOutcome.DRAW;
        }
    }

    private boolean isHomeTeam(String team) {
        return homeTeam.equals(team);
    }

    public enum MatchOutcome {
        WIN, LOSS, DRAW
    }
}