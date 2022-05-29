package com.tvmaze.ui.entity;

public class Show {
    private String showName;
    private String episodeName;
    public Show(String showName, String episodeName) {
        this.showName = showName;
        this.episodeName = episodeName;
    }

    public String getShowName() {
        return showName;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    @Override
    public String toString() {
        return "Show{ name: " + showName + " " +
                ", episode: " + episodeName  +
                '}';
    }
}
