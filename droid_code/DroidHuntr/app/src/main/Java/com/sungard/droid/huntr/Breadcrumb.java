package com.sungard.droid.huntr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Breadcrumb {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String timestamp;
    @Expose
    private String latitude;
    @Expose
    private String longitude;

    /**
     *
     * @return
     * The latitude
     */
    public String getLatitude() {
        return latitude;
    }

    /**
     *
     * @param latitude
     * The latitude
     */
    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public Breadcrumb withLatitude(String latitude) {
        this.latitude = latitude;
        return this;
    }

    /**
     *
     * @return
     * The longitude
     */
    public String getLongitude() {
        return longitude;
    }

    /**
     *
     * @param longitude
     * The longitude
     */
    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public Breadcrumb withLongitude(String longitude) {
        this.longitude = longitude;
        return this;
    }

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

    public Breadcrumb withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     *
     * @return
     * The timestamp
     */
    public String getTimestamp() {
        return timestamp;
    }

    /**
     *
     * @param timestamp
     * The timestamp
     */
    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public Breadcrumb withTimestamp(String timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String toString() {
        return "[Breadcrumb] _id: " +Id +
                "latitude: " + latitude +
                "longitude: " + longitude +
                "timestamp: " + timestamp;
    }
}