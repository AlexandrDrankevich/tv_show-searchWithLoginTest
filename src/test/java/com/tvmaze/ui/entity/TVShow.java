package com.tvmaze.ui.entity;

public class TVShow {
    private String showName;
    private String episodeName;
    private String episodeNumber;

    public TVShow(String showName, String episodeName, String episodeNumber) {
        this.showName = showName;
        this.episodeName = episodeName;
        this.episodeNumber = episodeNumber;
    }

    public String getShowName() {
        return showName;
    }

    public String getEpisodeName() {
        return episodeName;
    }

    public String getEpisodeNumber() {
        return episodeNumber;
    }

    @Override
    public String toString() {
        return "Show{ name: " + showName + " " +
                ", episode: " + episodeName + " " + episodeNumber +
                '}';
    }
}
