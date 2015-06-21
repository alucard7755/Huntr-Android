package com.sungard.droid.huntr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Answer {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private double longitude;
    @Expose
    private double latitude;
    @Expose
    private String picture;
    @Expose
    private String pending;
    @Expose
    private String playerName;
    @Expose
    private String teamID;
    @Expose
    private boolean correctFlag;

    /**
     *
     * @return
     * The Id
     */
    public String getId() {
        return Id;
    }

    /**
     *
     * @param Id
     * The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    public Answer withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     *
     * @return
     * The longitude
     */
    public double getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public Answer withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    /**
     *
     * @return
     * The latitude
     */
    public double getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public Answer withLatitude(double latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     *
     * @return
     * The picture
     */
    public String getPicture() {
        return picture;
    }

    /**
     *
     * @param picture
     * The picture
     */
    public void setPicture(String picture) {
        this.picture = picture;
    }

    public Answer withPicture(String picture) {
        this.picture = picture;
        return this;
    }

    /**
     *
     * @return
     * The pending
     */
    public String getPending() {
        return pending;
    }

    /**
     *
     * @param pending
     * The pending
     */
    public void setPending(String pending) {
        this.pending = pending;
    }

    public Answer withPending(String pending) {
        this.pending = pending;
        return this;
    }

    /**
     *
     * @return
     * The playerName
     */
    public String getPlayerName() {
        return playerName;
    }

    /**
     *
     * @param playerName
     * The playerName
     */
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public Answer withPlayerName(String playerName) {
        this.playerName = playerName;
        return this;
    }

    /**
     *
     * @return
     * The teamID
     */
    public String getTeamID() {
        return teamID;
    }

    /**
     *
     * @param teamID
     * The teamID
     */
    public void setTeamID(String teamID) {
        this.teamID = teamID;
    }

    public Answer withTeamID(String teamID) {
        this.teamID = teamID;
        return this;
    }

    /**
     *
     * @return
     * The correctFlag
     */
    public boolean isCorrectFlag() {
        return correctFlag;
    }

    /**
     *
     * @param correctFlag
     * The correctFlag
     */
    public void setCorrectFlag(boolean correctFlag) {
        this.correctFlag = correctFlag;
    }

    public Answer withCorrectFlag(boolean correctFlag) {
        this.correctFlag = correctFlag;
        return this;
    }

}