package com.sungard.droid.huntr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ScoreBoardEntry {

    @SerializedName("_id")
    @Expose
    private String Id;    // TEAM id
    @Expose
    private String name;  // TEAM Name
    @Expose
    private long ranking; // TEAM Ranking
    @Expose
    private long score;   // TEAM Score

    /**
     * @return The Id
     */
    public String getId() {
        return Id;
    }

    /**
     * @param Id The _id
     */
    public void setId(String Id) {
        this.Id = Id;
    }

    public ScoreBoardEntry withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     * @return The name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name The name
     */
    public void setName(String name) {
        this.name = name;
    }

    public ScoreBoardEntry withName(String name) {
        this.name = name;
        return this;
    }

    /**
     * @return The ranking
     */
    public long getRanking() {
        return ranking;
    }

    /**
     * @param ranking The ranking
     */
    public void setRanking(long ranking) {
        this.ranking = ranking;
    }

    public ScoreBoardEntry withRanking(long ranking) {
        this.ranking = ranking;
        return this;
    }

    /**
     * @return The score
     */
    public long getScore() {
        return score;
    }

    /**
     * @param score The score
     */
    public void setScore(long score) {
        this.score = score;
    }

    public ScoreBoardEntry withScore(long score) {
        this.score = score;
        return this;
    }

}
