package com.lisak.match;

import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;

public class TableComparator implements Comparator<LeagueTableEntry> {

    public int compare(LeagueTableEntry o1, LeagueTableEntry o2) {

        if (o1 == o2) {
            return 0;
        }

        if (o1.getPoints() < o2.getPoints()) {
            return -1;
        } else if (o1.getPoints() > o2.getPoints()) {
            return 1;
        }

        if (o1.getGoalDifference() < o2.getGoalDifference()) {
            return -1;
        } else if (o1.getGoalDifference() > o2.getGoalDifference()) {
            return 1;
        }

        if (o1.getGoalsFor() < o2.getGoalsFor()) {
            return -1;
        } else if (o1.getGoalsFor() > o2.getGoalsFor()) {
            return 1;
        }

        Collator stringCollator = Collator.getInstance(Locale.ENGLISH);
        if (stringCollator.compare(o1.getTeamName(), o2.getTeamName()) > 0) {
            return -1;
        } else if (stringCollator.compare(o1.getTeamName(), o2.getTeamName()) < 0) {
            return 1;
        }

        return 0;
    }
}