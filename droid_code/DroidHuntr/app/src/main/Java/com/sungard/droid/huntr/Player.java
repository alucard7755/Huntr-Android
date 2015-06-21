package com.sungard.droid.huntr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Player {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String name;
    @Expose
    private String apnToken;
    @Expose
    private Breadcrumbs breadcrumbs = new Breadcrumbs();

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

    public Player withId(String Id) {
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

    public Player withName(String name) {
        this.name = name;
        return this;
    }

    /**
     *
     * @return
     * The apnToken
     */
    public String getApnToken() {
        return apnToken;
    }

    /**
     *
     * @param apnToken
     * The apnToken
     */
    public void setApnToken(String apnToken) {
        this.apnToken = apnToken;
    }

    public Player withApnToken(String apnToken) {
        this.apnToken = apnToken;
        return this;
    }

    /**
     *
     * @return
     * The breadcrumbs
     */
    public Breadcrumbs getBreadcrumbs() {
        return breadcrumbs;
    }

    /**
     *
     * @param breadcrumbs
     * The breadcrumbs
     */
    public void setBreadcrumbs(Breadcrumbs breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
    }

    public Player withBreadcrumbs(Breadcrumbs breadcrumbs) {
        this.breadcrumbs = breadcrumbs;
        return this;
    }

    public String toString() {
        return  "[Player] _id: " + Id +
                "name: "+ name+
                "apnToken: "+ apnToken +
                "breadcrumbs: " + breadcrumbs;

    }
}