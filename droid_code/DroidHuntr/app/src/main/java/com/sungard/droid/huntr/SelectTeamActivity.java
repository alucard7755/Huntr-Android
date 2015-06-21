package com.sungard.droid.huntr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Spinner;

import java.util.ArrayList;


public class SelectTeamActivity extends ActionBarActivity implements AdapterView.OnItemClickListener, View.OnClickListener {

    ListView teamListView;
    ArrayAdapter mTeamAdapter;
    ArrayList mTeamList = new ArrayList();
    Button selectNewTeam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_selectteam);

        teamListView = (ListView) findViewById(R.id.teamListView);
        teamListView.setOnItemClickListener(this);

        selectNewTeam = (Button) findViewById(R.id.button_createteam);
        selectNewTeam.setOnClickListener(this);


        //Fake clues in a list for demonstration
        mTeamList.add("Mavs");
        mTeamList.add("UTD Comets");
        mTeamList.add("Baylor Bears... I guess");
        //TODO: change to API call to populate the list
        mTeamAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mTeamList);
                
        teamListView = (ListView) findViewById(R.id.teamListView);
        teamListView.setAdapter(mTeamAdapter);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_selectteam, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

/*    public void createTeam(View view) {
        Intent intent = new Intent(this, CreateTeamActivity.class);
        startActivity(intent);
    }

    public void selectTeam(View view) {
        Spinner mySpinner = (Spinner)findViewById(R.id.spinner);
        String txtFromSpinner = mySpinner.getSelectedItem().toString();

        //TODO add API call to add user to team

        Intent intent = new Intent(this, CreateTeamActivity.class);
        startActivity(intent);
    }*/
    
    @Override
    protected void onResume() {
        super.onResume();
        //locationManager.requestLocationUpdates(provider, 400, 1, this);
    } // end on resume

    /* Remove the locationlistener updates when Activity is paused */
    @Override
    protected void onPause() {
        super.onPause();
        //locationManager.removeUpdates(this);
    } //end on pause

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.d("omg android", position + ": " + mTeamList.get(position));

        // 12. Now that the user's chosen a book, grab the cover data
        //JSONObject jsonObject = (JSONObject) mJSONAdapter.getItem(position);
        //String coverID = jsonObject.optString("cover_i","");

        // create an Intent to take you over to a new DetailActivity
        Intent detailIntent = new Intent(this, CluesActivity.class);

        // pack away the data about the cover
        // into your Intent before you head out
        detailIntent.putExtra("teamName", mTeamList.get(position).toString());

        // TODO: adjust these calls for the HuntR API

        // start the next Activity using your prepared Intent
        startActivity(detailIntent);
    }

    @Override
    public void onClick(View v) {
        if(v.equals(selectNewTeam)){
            Intent newTeamIntent = new Intent(this, CreateTeamActivity.class);
            startActivity(newTeamIntent);
        }

    }
}
