package com.pivot.schoolvideos.dao;

import java.sql.Date;

public class Mood {
    private String studentID;
    private Date createDate;
    private int happy;
    private int sad;
    private int anger;
    private int horror;
    private int disgust;
    private int dull;
    private int anxious;

    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public int getHappy() {
        return happy;
    }

    public void setHappy(int happy) {
        this.happy = happy;
    }

    public int getSad() {
        return sad;
    }

    public void setSad(int sad) {
        this.sad = sad;
    }

    public int getAnger() {
        return anger;
    }

    public void setAnger(int anger) {
        this.anger = anger;
    }

    public int getHorror() {
        return horror;
    }

    public void setHorror(int horror) {
        this.horror = horror;
    }

    public int getDisgust() {
        return disgust;
    }

    public void setDisgust(int disgust) {
        this.disgust = disgust;
    }

    public int getDull() {
        return dull;
    }

    public void setDull(int dull) {
        this.dull = dull;
    }

    public int getAnxious() {
        return anxious;
    }

    public void setAnxious(int anxious) {
        this.anxious = anxious;
    }
}
