package com.sungard.droid.huntr;

import android.app.Application;

// Instantiate a shared Application class to help keep things in sync (like API the calls)
public class HuntrApplication extends Application {

    private HuntrAPIClient mHuntrAPIClient=new HuntrAPIClient();

    public String currentGameID = "55424a2ade24bf0300383b7e";
    public String currentGameName = "Android Rocks";
    public String currentPlayerID = "55825ecffe412b0300f61ac3";
    public String currentPlayerName = "John Frazier";
    public String currentTeamID = "55825eb1fe412b0300f61ac1";
    public String currentTeamName = "Johns Test2";

    public ScoreBoard currentScoreBoard=new ScoreBoard();

    public HuntrAPIClient getHuntrAPI(){
        return mHuntrAPIClient;
    }
    public void setHuntrAPI(HuntrAPIClient huntrAPIClient){
        mHuntrAPIClient=huntrAPIClient;
    }

}
