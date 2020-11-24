package com.gadleadershipboard;
public class Utils {
    public final String Name;
    public final int hours;
    public final int scores;
    public final String Country;
    public final String BatchUrl;

    public Utils(String name, int hours, int scores, String country, String batchUrl) {
        Name = name;
        this.hours = hours;
        this.scores = scores;
        Country = country;
        BatchUrl = batchUrl;
    }

    public String getName() {
        return Name;
    }

    public int getScores() {
        return scores;
    }

    public int getHours() {
        return hours;
    }

    public String getCountry() {
        return Country;
    }

    public String getBatchUrl() {
        return BatchUrl;
    }
}
