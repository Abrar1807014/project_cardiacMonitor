package com.example.myapplication;

public class Model {
    String Date, Time, systolic, diastolic, bpm, comment, user_comment;

    public Model() {
    }


    public Model(String date, String time, String systolic, String diastolic, String bpm, String comment, String user_comment) {
        Date = date;
        Time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.bpm = bpm;
        this.comment = comment;
        this.user_comment = user_comment;
    }

    public String getUser_comment() {
        return user_comment;
    }

    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    public String getDate() {
        return Date;
    }

    public String getTime() {
        return Time;
    }

    public String getSystolic() {
        return systolic;
    }

    public String getDiastolic() {
        return diastolic;
    }

    public String getBpm() {
        return bpm;
    }

    public String getComment() {
        return comment;
    }

    public void setDate(String date) {
        Date = date;
    }

    public void setTime(String time) {
        Time = time;
    }

    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
