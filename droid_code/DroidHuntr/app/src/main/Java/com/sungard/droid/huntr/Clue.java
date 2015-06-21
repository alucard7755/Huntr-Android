package com.sungard.droid.huntr;

import java.util.ArrayList;
import java.util.List;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Clue {

    @SerializedName("_id")
    @Expose
    private String Id;
    @Expose
    private String description;
    @Expose
    private String type;
    @Expose
    private List<Answer> answers = new ArrayList<Answer>();
    @Expose
    private long pointValue;
    @Expose
    private double latitude;
    @Expose
    private double longitude;

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

    public Clue withId(String Id) {
        this.Id = Id;
        return this;
    }

    /**
     *
     * @return
     * The description
     */
    public String getDescription() {
        return description;
    }

    /**
     *
     * @param description
     * The description
     */
    public void setDescription(String description) {
        this.description = description;
    }

    public Clue withDescription(String description) {
        this.description = description;
        return this;
    }

    /**
     *
     * @return
     * The type
     */
    public String getType() {
        return type;
    }

    /**
     *
     * @param type
     * The type
     */
    public void setType(String type) {
        this.type = type;
    }

    public Clue withType(String type) {
        this.type = type;
        return this;
    }

    /**
     *
     * @return
     * The answers
     */
    public List<Answer> getAnswers() {
        return answers;
    }

    /**
     *
     * @param answers
     * The answers
     */
    public void setAnswers(List<Answer> answers) {
        this.answers = answers;
    }

    public Clue withAnswers(List<Answer> answers) {
        this.answers = answers;
        return this;
    }

    /**
     *
     * @return
     * The pointValue
     */
    public long getPointValue() {
        return pointValue;
    }

    /**
     *
     * @param pointValue
     * The pointValue
     */
    public void setPointValue(long pointValue) {
        this.pointValue = pointValue;
    }

    public Clue withPointValue(long pointValue) {
        this.pointValue = pointValue;
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

    public Clue withLatitude(double latitude) {
        this.latitude = latitude;
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

    public Clue withLongitude(double longitude) {
        this.longitude = longitude;
        return this;
    }

    public String toString() {
        return "[Clue] _id: " +Id +
                //"latitude: " + latitude +
                //"longitude: " + longitude +  // Uh huh... no cheating!
                "type: " + type +
                "description: " + description +
                "point Value: " + pointValue;
    }
}