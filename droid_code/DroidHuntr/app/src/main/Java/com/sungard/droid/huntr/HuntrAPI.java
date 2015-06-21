package com.sungard.droid.huntr;

import android.content.Context;
import android.content.DialogInterface;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AlertDialog;
import android.util.Log;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;

import java.io.Reader;
import java.io.StringReader;
import java.util.ArrayList;

// HUNTR API Calls Supported
// GET  <host>/api/game/scoreboard/<gameID>
// GET  <host>/api/clues/<gameID>
// GET  <host>/api/clues/<gameID>/<clueID>
// POST <host>/api/answers/location/<clueID>/<teamID>/<playerName> with params("latitude","longitude")

public class HuntrAPI {

    // Wrapper Class for API calls and other utility functions

    private String mGameID;
    private String mTeamID;
    private String mUserID;
    private String BASE_URL="http://huntr-api.herokuapp.com/";
    private AsyncHttpClient scoreboardclient = new AsyncHttpClient();
    private AsyncHttpClient gamelistclient = new AsyncHttpClient();
    private AsyncHttpClient cluelistclient = new AsyncHttpClient();
    private ArrayList standings = new ArrayList();
    public /*private*/ ScoreBoard scoreboard = new ScoreBoard();
    private ArrayList games = new ArrayList();
    private ArrayList clues = new ArrayList();
    private boolean standingsRetrieved=false;
    private boolean gamesRetrieved=false;
    private boolean cluesRetrieved=false;


    public HuntrAPI HuntrAPI(){
        this.mGameID="";
        this.mTeamID="";
        this.mUserID="";
        this.BASE_URL="http://huntr-api.herokuapp.com/";
        return this;
    }

    public HuntrAPI HuntrAPI(String gameID, String teamID, String userID){
        this.mGameID=gameID;
        this.mTeamID=teamID;
        this.mUserID=userID;
        this.BASE_URL="http://huntr-api.herokuapp.com/";
        return this;
    }

    public HuntrAPI withGameID(String gameID){
        this.mGameID=gameID;
        return this;
    }

    public HuntrAPI withUserID(String userID){
        this.mUserID=userID;
        return this;
    }

    public HuntrAPI withTeamID(String teamID){
        this.mTeamID=teamID;
        return this;
    }

    public String getGameID(){
        return this.mGameID;
    }

    public String getUserID(){
        return this.mUserID;
    }

    public String getTeamID(){
        return this.mTeamID;
    }

    public void setGameID(String gameID){
        this.mGameID=gameID;
    }

    public void setUserID(String userID){
        this.mUserID=userID;
    }

    public void setTeamID(String teamID){
        this.mTeamID=teamID;
    }

    public boolean isNetworkActive(Context currentContext){
        boolean isActive=false;
        ConnectivityManager connMgr =
                (ConnectivityManager) currentContext.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connMgr.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isConnected()) {
            // We have a network connection so return true
            isActive = true;
        } else {
            // Warn that we need network connectivity
            isActive = false;
            new AlertDialog.Builder(currentContext)
                    .setTitle("Network Connectivity")
                    .setMessage("Please be sure that you are connected to the internet and try again.")
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            // Do Nothing - User needs to activate network (WiFi or Cellular data)
                            // Maybe open up Network settings here?
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
        return isActive;
    }

    public interface StandingsResponseHandler{
        public void onSuccess(ArrayList response);
        public void onFailure(ArrayList response);
    }

    public class APIStandingsResponseHandler implements StandingsResponseHandler{
        //public void onSuccess(String response){
        //    Log.d("APIResponseHandler", "onSuccess String:"+response);
        //}

        public void onSuccess(ArrayList response){
            Log.d("APIResponseHandler", "onSuccess ArrayList:"+response.toString());
        }

        //public void onSuccess(JsonArray response){
        //    Log.d("APIResponseHandler", "onSuccess JsonArray:"+response.getAsString());
        //}

        //public void onSuccess(JsonObject response){
        //    Log.d("APIResponseHandler", "onSuccess JsonObject:"+response.getAsString());
        //}

        //public void onFailure(String response){
        //    Log.d("APIResponseHandler", "onFailure String:"+response);
        //}

        public void onFailure(ArrayList response){
            Log.d("APIResponseHandler", "onFailure ArrayList:"+response.toString());
        }

        //public void onFailure(JsonArray response){
        //    Log.d("APIResponseHandler", "onFaiure JsonArray:"+response.getAsString());
        //}

        //public void onFailure(JsonObject response){
        //    Log.d("APIResponseHandler", "onFaiure JsonObject:"+response.getAsString());
        //}

    }

    public void getStandingsList(final Context currentContext, final String gameID, final StandingsResponseHandler responseHandler){
        standingsRetrieved=false;
        scoreboardclient.get(BASE_URL + "api/game/scoreboard/" + gameID, null,
                new AsyncHttpResponseHandler() {
                    // When the response returned by REST has Http response code '200'
                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          byte[] response) {
                        try {

                            String example = new String(response);

                            Gson g = new Gson();
                            JsonParser parser = new JsonParser();
                            Reader reader = new StringReader(example);
                            //Reader serialreader = new StringReader(example);

                            //scoreboard = g.fromJson(serialreader, ScoreBoard.class);
                            JsonArray myScoreArray = g.fromJson(reader, JsonArray.class);
                            JsonObject myScore;

                            //try {
                            standings.clear();
                            for (int i = 0; i < myScoreArray.size(); i++) {
                                myScore = myScoreArray.get(i).getAsJsonObject();
                                ScoreBoardEntry myEntry = g.fromJson(myScore, ScoreBoardEntry.class);
                                scoreboard.addEntry(myEntry);
                                //Log.d("JSONLog", myScore.get("name").getAsString());
                                standings.add(String.valueOf(myScore.get("ranking") + ". " + myScore.get("name").getAsString()));
                            }
                            standingsRetrieved = true;
                            responseHandler.onSuccess(standings);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    // When the response returned by REST has Http response code other than '200'
                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          byte[] content, Throwable error) {
                        // Hide Progress Dialog
                        standingsRetrieved = true;
                        //prgDialog.hide();
                        // When Http response code is '404'
                        if (statusCode == 404) {
                            Toast.makeText(currentContext.getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code is '500'
                        else if (statusCode == 500) {
                            Toast.makeText(currentContext.getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code other than 404, 500
                        else {
                            Toast.makeText(currentContext.getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                        }
                        responseHandler.onFailure(standings);
                    }
                });

    }


    public interface GamesResponseHandler{
        public void onSuccess(ArrayList response);
        public void onFailure(ArrayList response);
    }

    public class APIGamesResponseHandler implements GamesResponseHandler{
        //public void onSuccess(String response){
        //    Log.d("APIResponseHandler", "onSuccess String:"+response);
        //}

        public void onSuccess(ArrayList response){
            Log.d("APIGamesResponseHandler", "onSuccess ArrayList:"+response.toString());
        }

        //public void onSuccess(JsonArray response){
        //    Log.d("APIResponseHandler", "onSuccess JsonArray:"+response.getAsString());
        //}

        //public void onSuccess(JsonObject response){
        //    Log.d("APIResponseHandler", "onSuccess JsonObject:"+response.getAsString());
        //}

        //public void onFailure(String response){
        //    Log.d("APIResponseHandler", "onFailure String:"+response);
        //}

        public void onFailure(ArrayList response){
            Log.d("APIGamesResponseHandler", "onFailure ArrayList:"+response.toString());
        }

        //public void onFailure(JsonArray response){
        //    Log.d("APIResponseHandler", "onFaiure JsonArray:"+response.getAsString());
        //}

        //public void onFailure(JsonObject response){
        //    Log.d("APIResponseHandler", "onFaiure JsonObject:"+response.getAsString());
        //}

    }

    public void getGamesList(final Context currentContext, /*final String gameID,*/ final GamesResponseHandler responseHandler){
        gamelistclient.get(BASE_URL + "api/games/simple", null,
                new AsyncHttpResponseHandler() {
                    // When the response returned by REST has Http response code '200'
                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          byte[] response) {
                        try {

                            String example = new String(response);

                            Gson g = new Gson();
                            JsonParser parser = new JsonParser();
                            Reader reader = new StringReader(example);

                            JsonArray myGameArray = g.fromJson(reader, JsonArray.class);
                            JsonObject myGame;

                            //try {
                            games.clear();
                            for (int i = 0; i < myGameArray.size(); i++) {
                                myGame = myGameArray.get(i).getAsJsonObject();
                                Log.d("JSONLog", myGame.get("name").getAsString());
                                games.add(myGame.get("name").getAsString());
                            }
                            responseHandler.onSuccess(games);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    // When the response returned by REST has Http response code other than '200'
                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          byte[] content, Throwable error) {
                        // Hide Progress Dialog
                        //prgDialog.hide();
                        // When Http response code is '404'
                        if (statusCode == 404) {
                            Toast.makeText(currentContext.getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code is '500'
                        else if (statusCode == 500) {
                            Toast.makeText(currentContext.getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code other than 404, 500
                        else {
                            Toast.makeText(currentContext.getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                        }
                        responseHandler.onFailure(games);
                    }
                });

    }

    public interface CluesResponseHandler{
        public void onSuccess(ArrayList response);
        public void onFailure(ArrayList response);
    }

    public class APICluesResponseHandler implements CluesResponseHandler{
        //public void onSuccess(String response){
        //    Log.d("APIResponseHandler", "onSuccess String:"+response);
        //}

        public void onSuccess(ArrayList response){
            Log.d("APICluesResponseHandler", "onSuccess ArrayList:"+response.toString());
        }

        //public void onSuccess(JsonArray response){
        //    Log.d("APIResponseHandler", "onSuccess JsonArray:"+response.getAsString());
        //}

        //public void onSuccess(JsonObject response){
        //    Log.d("APIResponseHandler", "onSuccess JsonObject:"+response.getAsString());
        //}

        //public void onFailure(String response){
        //    Log.d("APIResponseHandler", "onFailure String:"+response);
        //}

        public void onFailure(ArrayList response){
            Log.d("APICluesResponseHandler", "onFailure ArrayList:"+response.toString());
        }

        //public void onFailure(JsonArray response){
        //    Log.d("APIResponseHandler", "onFaiure JsonArray:"+response.getAsString());
        //}

        //public void onFailure(JsonObject response){
        //    Log.d("APIResponseHandler", "onFaiure JsonObject:"+response.getAsString());
        //}

    }

    public void getCluesList(final Context currentContext, final String gameID, final CluesResponseHandler responseHandler){
        cluelistclient.get(BASE_URL + "api/clues/" +gameID, null,
                new AsyncHttpResponseHandler() {
                    // When the response returned by REST has Http response code '200'
                    @Override
                    public void onSuccess(int statusCode, Header[] headers,
                                          byte[] response) {
                        try {

                            String example = new String(response);

                            Gson g = new Gson();
                            JsonParser parser = new JsonParser();
                            Reader reader = new StringReader(example);

                            JsonArray myClueArray = g.fromJson(reader, JsonArray.class);
                            JsonObject myClue;

                            //try {
                            clues.clear();
                            for (int i = 0; i < myClueArray.size(); i++) {
                                myClue = myClueArray.get(i).getAsJsonObject();
                                Log.d("JSONLog", myClue.get("description").getAsString()+ " (" + String.valueOf(myClue.get("type")) +")");
                                clues.add(myClue.get("description").getAsString() + " (" + myClue.get("type").getAsString() +")" );
                            }
                            responseHandler.onSuccess(clues);

                        } catch (Exception e) {
                            // TODO Auto-generated catch block
                            e.printStackTrace();
                        }
                    }

                    // When the response returned by REST has Http response code other than '200'
                    @Override
                    public void onFailure(int statusCode, Header[] headers,
                                          byte[] content, Throwable error) {
                        // Hide Progress Dialog
                        //prgDialog.hide();
                        // When Http response code is '404'
                        if (statusCode == 404) {
                            Toast.makeText(currentContext.getApplicationContext(), "Requested resource not found", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code is '500'
                        else if (statusCode == 500) {
                            Toast.makeText(currentContext.getApplicationContext(), "Something went wrong at server end", Toast.LENGTH_LONG).show();
                        }
                        // When Http response code other than 404, 500
                        else {
                            Toast.makeText(currentContext.getApplicationContext(), "Unexpected Error occcured! [Most common Error: Device might not be connected to Internet or remote server is not up and running]", Toast.LENGTH_LONG).show();
                        }
                        responseHandler.onFailure(clues);
                    }
                });

    }


}


