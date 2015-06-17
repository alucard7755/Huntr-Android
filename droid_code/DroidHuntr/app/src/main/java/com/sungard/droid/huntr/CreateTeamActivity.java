package com.sungard.droid.huntr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateTeamActivity extends ActionBarActivity implements View.OnClickListener{

    private Button createTeamButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createteam);

        createTeamButton = (Button) findViewById(R.id.button_createteam);
        createTeamButton.setOnClickListener(this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_createteam, menu);
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


    @Override
    public void onClick(View v) {
        //if button clicked, check which one
        if(v.equals(createTeamButton)) {
            //if take picture button, open camera
            EditText editTeam = (EditText) findViewById(R.id.edit_message2);
            Toast.makeText(this, "Create Team" + editTeam.toString(),
                    Toast.LENGTH_SHORT).show();
            Intent toTeamIntnet = new Intent(this, CluesActivity.class);

            toTeamIntnet.putExtra("teamName", editTeam.toString());

            // TODO: adjust these calls for the HuntR API

            startActivity(toTeamIntnet);
        }
    }
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
}

