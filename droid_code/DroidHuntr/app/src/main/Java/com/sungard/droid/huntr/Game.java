package com.sungard.droid.huntr;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Game {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String name;
    @SerializedName("__v")
    @Expose
    private long V;
    @Expose
    private String endDate;
    @Expose
    private String startDate;
    @Expose
    private List<Team> teams = new ArrayList<Team>();
    @Expose
    private List<Clue> clues = new ArrayList<Clue>();
    @Expose
    private String createDate;
    @Expose
    private String status;

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

    public Game withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     *
     * @return
     * The name
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     * The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public Game withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The V
     */
    public long getV() {
        return V;
    }

    /**
     *
     * @param V
     * The __v
     */
    public void setV(long V) {
        this.V = V;
    }

    public Game withV(long V) {
        this.V = V;
        return this;
    }

    /**
     *
     * @return
     * The endDate
     */
    public String getEndDate() {
        return endDate;
    }

    /**
     *
     * @param endDate
     * The endDate
     */
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public Game withEndDate(String endDate) {
        this.endDate = endDate;
        return this;
    }

    /**
     *
     * @return
     * The startDate
     */
    public String getStartDate() {
        return startDate;
    }

    /**
     *
     * @param startDate
     * The startDate
     */
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public Game withStartDate(String startDate) {
        this.startDate = startDate;
        return this;
    }

    /**
     *
     * @return
     * The teams
     */
    public List<Team> getTeams() {
        return teams;
    }

    /**
     *
     * @param teams
     * The teams
     */
    public void setTeams(List<Team> teams) {
        this.teams = teams;
    }

    public Game withTeams(List<Team> teams) {
        this.teams = teams;
        return this;
    }

    /**
     *
     * @return
     * The clues
     */
    public List<Clue> getClues() {
        return clues;
    }

    /**
     *
     * @param clues
     * The clues
     */
    public void setClues(List<Clue> clues) {
        this.clues = clues;
    }

    public Game withClues(List<Clue> clues) {
        this.clues = clues;
        return this;
    }

    /**
     *
     * @return
     * The createDate
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     *
     * @param createDate
     * The createDate
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Game withCreateDate(String createDate) {
        this.createDate = createDate;
        return this;
    }

    /**
     *
     * @return
     * The status
     */
    public String getStatus() {
        return status;
    }

    /**
     *
     * @param status
     * The status
     */
    public void setStatus(String status) {
        this.status = status;
    }

    public Game withStatus(String status) {
        this.status = status;
        return this;
    }

    @Override
    public String toString(){
        return "[Game] _id: "+Id
                +", name: "+name
                +", __v: "+V
                +", createDate: "+createDate
                +", startDate: "+startDate
                +", endDate: "+endDate
                +", status: "+status
                +", teams: " +teams
                ;
    }

}

