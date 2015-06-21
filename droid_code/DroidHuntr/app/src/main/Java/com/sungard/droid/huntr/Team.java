package com.sungard.droid.huntr;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Team {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String name;
    @Expose
    private List<Player> players = new ArrayList<Player>();
    @Expose
    private long ranking;
    @Expose
    private long score;

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

    public Team withId(String Id) {
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

    public Team withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The players
     */
    public List<Player> getPlayers() {
        return players;
    }

    /**
     *
     * @param players
     * The players
     */
    public void setPlayers(List<Player> players) {
        this.players = players;
    }

    public Team withPlayers(List<Player> players) {
        this.players = players;
        return this;
    }

    /**
     *
     * @return
     * The ranking
     */
    public long getRanking() {
        return ranking;
    }

    /**
     *
     * @param ranking
     * The ranking
     */
    public void setRanking(long ranking) {
        this.ranking = ranking;
    }

    public Team withRanking(long ranking) {
        this.ranking = ranking;
        return this;
    }

    /**
     *
     * @return
     * The score
     */
    public long getScore() {
        return score;
    }

    /**
     *
     * @param score
     * The score
     */
    public void setScore(long score) {
        this.score = score;
    }

    public Team withScore(long score) {
        this.score = score;
        return this;
    }

}
