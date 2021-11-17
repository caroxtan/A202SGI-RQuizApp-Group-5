package com.example.rquiz;

public class HistoryList {

    //Initialise variables
    private String subName;
    private String score;

    //Constructor
    public HistoryList(String subName, String score){
        this.subName = subName;
        this.score = score;
    }

    //Getter for subject name
    public String getSubName() {
        return subName;
    }

    //Setter for subject name
    public void setSubName(String subName) {
        this.subName = subName;
    }

    //Getter for subject name
    public String getScore() {
        return score;
    }

    //Setter for subject name
    public void setScore(String score) { this.score = score;}

}

