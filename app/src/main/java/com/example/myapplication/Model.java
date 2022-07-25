package com.example.myapplication;

/**
 * model class for holding
 * constructors
 * getter
 * setter
 * for the data stored in databse
 */
public class Model {
    public String Date, Time, systolic, diastolic, bpm, comment, user_comment;

    /**
     * default constructor
     */
    public Model() {
    }


    /**
     * constructor
     * @param date
     * @param time
     * @param systolic
     * @param diastolic
     * @param bpm
     * @param comment
     * @param user_comment
     * data kept in firebase database
     */
    public Model(String date, String time, String systolic, String diastolic, String bpm, String comment, String user_comment) {
        Date = date;
        Time = time;
        this.systolic = systolic;
        this.diastolic = diastolic;
        this.bpm = bpm;
        this.comment = comment;
        this.user_comment = user_comment;
    }

    /**
     * getter for user_comment
     * @return
     */
    public String getUser_comment() {
        return user_comment;
    }

    /**
     * setter for user_comment
     * @param user_comment
     */
    public void setUser_comment(String user_comment) {
        this.user_comment = user_comment;
    }

    /**
     * getter date of submission
     * @return
     */
    public String getDate() {
        return Date;
    }

    /**
     * getter time of submission
     * @return
     */
    public String getTime() {
        return Time;
    }

    /**
     * getter for systolic pressure
     * @return
     */
    public String getSystolic() {
        return systolic;
    }

    /**
     * getter for diastolic pressure
     * @return
     */
    public String getDiastolic() {
        return diastolic;
    }

    /**
     * getter for bpm
     * @return
     */
    public String getBpm() {
        return bpm;
    }

    /**
     * getter for comment/waring sign
     * @return
     */
    public String getComment() {
        return comment;
    }

    /**
     * setter date of submission
     * @param date
     */
    public void setDate(String date) {
        Date = date;
    }

    /**
     * setter time of submission
     * @param time
     */
    public void setTime(String time) {
        Time = time;
    }

    /**
     * setter for systolic pressure
     * @param systolic
     */
    public void setSystolic(String systolic) {
        this.systolic = systolic;
    }

    /**
     * setter for diastolic pressure
     * @param diastolic
     */
    public void setDiastolic(String diastolic) {
        this.diastolic = diastolic;
    }

    /**
     * setter for bpm
     * @param bpm
     */
    public void setBpm(String bpm) {
        this.bpm = bpm;
    }

    /**
     * setter for comment/ warning sign
     * @param comment
     */
    public void setComment(String comment) {
        this.comment = comment;
    }
}
