package com.example.androidapplication;

public class MatcheDatas {
    private String matcheName;
    private int matcheImg;

    public MatcheDatas(int matcheImg, String matcheName) {
        this.matcheImg = matcheImg;
        this.matcheName = matcheName;
    }

    public String getMatcheName() {
        return matcheName;
    }

    public void setMatchesName(String matcheName) {
        this.matcheName = matcheName;
    }

    public int getMatcheImg() {
        return matcheImg;
    }

    public void setMatchesImg(int matcheImg) {
        this.matcheImg = matcheImg;
    }



}
