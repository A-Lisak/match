package com.lisak.match;

import java.util.*;

public class LeagueTable {


    private List<LeagueTableEntry> leagueTableList;
    private List<Match> matches;

    public LeagueTable(final List<Match> matches) {
        this.matches = matches;
    }

    /**
     * Get the ordered list of league table entries for this league table.
     *
     * @return leagueTableList
     */
    public List<LeagueTableEntry> getTableEntries() {
        if (matches == null || matches.isEmpty()) {
            throw new IllegalArgumentException("The supplied match list is null or empty!");
        }

        leagueTableList = new ArrayList<>();
        Collection<String> teamList = new HashSet<>();

        matches.forEach(match -> {
            teamList.add(match.getHomeTeam());
            teamList.add(match.getAwayTeam());
        });
        teamList.forEach(teamName -> {
            LeagueTableEntry tableEntry = new LeagueTableEntry(teamName);
            matches.stream()
                    .filter(match -> (teamName.equals(match.getHomeTeam()) || teamName.equals(match.getAwayTeam())))
                    .forEach(filteredMatch -> {
                        tableEntry.handleMatchPlayed(filteredMatch);
                    });
            leagueTableList.add(tableEntry);
        });

        if (leagueTableList != null && !leagueTableList.isEmpty()) {
            Collections.sort(leagueTableList, new TableComparator().reversed());
        }
        return new ArrayList<>(leagueTableList);
    }
}