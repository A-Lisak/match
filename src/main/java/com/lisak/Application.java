package com.lisak;


import com.lisak.match.LeagueTable;
import com.lisak.match.Match;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {

        Application application = new Application();
        application.initialise();
    }

    private void initialise() {

        List<Match> matches = new ArrayList<>();

        matches.add(new Match("Arsenal", "Chelsea", 3, 1));
        matches.add(new Match("Chelsea", "Manchester", 1, 2));
        matches.add(new Match("Manchester", "Arsenal", 1, 1));
        matches.add(new Match("Tottenham", "Chelsea", 3, 1));
        matches.add(new Match("Argentina", "Manchester", 1, 2));
        matches.add(new Match("West ham", "Arsenal", 1, 1));

        LeagueTable leagueTable = new LeagueTable(matches);
        System.out.println(leagueTable.getTableEntries().toString());
    }
}