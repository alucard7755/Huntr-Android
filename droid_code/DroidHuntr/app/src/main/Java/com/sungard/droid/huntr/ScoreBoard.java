package com.sungard.droid.huntr;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class ScoreBoard {
// Class to hold response for one team from <Server>/api/game/scoreboard/<game_id_string>
// Actual response is an un-named JsonArray of ScoreBoardEntry objects

    @Expose
    private List<ScoreBoardEntry> entries = new ArrayList<ScoreBoardEntry>();

    /**
     *
     * @return
     * The entries
     */
    public List<ScoreBoardEntry> getEntries() {
        return entries;
    }

    /**
     *
     * @param entries
     * The entries
     */
    public void setEntries(List<ScoreBoardEntry> entries) {
        this.entries = entries;
    }

    public ScoreBoard withEntries(List<ScoreBoardEntry> entries) {
        this.entries = entries;
        return this;
    }

    public void addEntry(ScoreBoardEntry newEntry) {
        this.entries.add(newEntry);
        return;
    }

    public String toString() {
        return "[ScoreBoard Entries] " + entries ;
    }
}