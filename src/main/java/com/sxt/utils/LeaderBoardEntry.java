package com.sxt.utils;

public class LeaderBoardEntry implements Comparable<LeaderBoardEntry> {
    //We need a sortable Object for processing our leaderboard,
    // so I believe this is a reasonable class to have. -K

    private final String name;
    private final Integer score;
    //TODO Stats on drones, fighters, completion time.

    public LeaderBoardEntry(Integer score, String name) {
        this.score = score;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getScore() {
        return String.valueOf(score);
    }

    @Override
    public int compareTo(LeaderBoardEntry otherEntry) {
        return Integer.compare(this.score, otherEntry.score);
    }
}
