package com.lisak.match;

public class LeagueTableEntry {

    private String teamName;
    private int played;
    private int won;
    private int drawn;
    private int lost;
    private int goalsFor;
    private int goalsAgainst;
    private int goalDifference;
    private int points;

    public LeagueTableEntry(String teamName) {
        this.teamName = teamName;
    }

    public void handleMatchPlayed(Match match) {
        if (match != null && (match.getHomeTeam().equals(getTeamName()) || match.getAwayTeam().equals(getTeamName()))) {
            addGamePlayed();
            addGoalsAgainst(match.getGoalsAgainst(getTeamName()));
            addGoalsFor(match.getGoalsFor(getTeamName()));
            addMatchOutcome(match.getMatchOutcome(getTeamName()));
        }
    }

    private void addGamePlayed() {
        played++;
    }

    private void addGameWon() {
        won++;
    }

    private void addGameDrawn() {
        drawn++;
    }

    private void addGameLost() {
        lost++;
    }

    private void addGoalsFor(int val) {
        goalsFor += val;
    }

    private void addGoalsAgainst(int val) {
        goalsAgainst += val;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public int getPlayed() {
        return played;
    }

    public void setPlayed(int played) {
        this.played = played;
    }

    public int getWon() {
        return won;
    }

    public void setWon(int won) {
        this.won = won;
    }

    public int getDrawn() {
        return drawn;
    }

    public void setDrawn(int drawn) {
        this.drawn = drawn;
    }

    public int getLost() {
        return lost;
    }

    public void setLost(int lost) {
        this.lost = lost;
    }

    public int getGoalsFor() {
        return goalsFor;
    }

    public void setGoalsFor(int goalsFor) {
        this.goalsFor = goalsFor;
    }

    public int getGoalsAgainst() {
        return goalsAgainst;
    }

    public void setGoalsAgainst(int goalsAgainst) {
        this.goalsAgainst = goalsAgainst;
    }

    public int getGoalDifference() {
        goalDifference = goalsFor - goalsAgainst;
        return goalDifference;
    }

    public void setGoalDifference(int goalDifference) {
        this.goalDifference = goalDifference;
    }

    public int getPoints() {
        points = won * 3 + drawn;
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }



    /**
     * <p>
     * Overridden toString() method for some cleaner logs.
     * </p>
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("TeamName: ");
        sb.append(teamName);
        sb.append("\n");
        sb.append("Played: ");
        sb.append(played);
        sb.append("\n");
        sb.append("Won: ");
        sb.append(won);
        sb.append("\n");
        sb.append("Drawn: ");
        sb.append(drawn);
        sb.append("\n");
        sb.append("Lost: ");
        sb.append(lost);
        sb.append("\n");
        sb.append("GoalsFor: ");
        sb.append(goalsFor);
        sb.append("\n");
        sb.append("GoalsAgainst: ");
        sb.append(goalsAgainst);
        sb.append("\n");
        sb.append("GoalDifference: ");
        sb.append(getGoalDifference());
        sb.append("\n");
        sb.append("Points: ");
        sb.append(getPoints());
        sb.append("\n");
        sb.append("\n");
        return sb.toString();
    }

    private void addMatchOutcome(Match.MatchOutcome matchOutcome) {
        switch (matchOutcome) {
            case LOSS:
                addGameLost();
                break;
            case WIN:
                addGameWon();
                break;
            case DRAW:
                addGameDrawn();
                break;
        }
    }
}
