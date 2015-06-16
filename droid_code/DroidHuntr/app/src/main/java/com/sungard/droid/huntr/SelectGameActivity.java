package com.sungard.droid.huntr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class SelectGameActivity extends ActionBarActivity implements AdapterView.OnItemClickListener  {

    ListView teamListView;
    ArrayList mGameList = new ArrayList();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().setDisplayHomeAsUpEnabled(true);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);

        mGameList.add("Mavs Rule The World");
        mGameList.add("SunGard Peeps");
        mGameList.add("Droid Supremacy");

        ArrayAdapter<String> zeAdapter = new ArrayAdapter<String>(
                this,                   //context for activity
                R.layout.game_list,     //layout to be used (create)
                mGameList);               //items to be displayed

        teamListView = (ListView) findViewById(R.id.listView);
        teamListView.setAdapter(zeAdapter);
        teamListView.setOnItemClickListener(this);

    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Log the item's position and contents
        // to the console in Debug
        Log.d("omg android", position + ": " + mGameList.get(position));

        // 12. Now that the user's chosen a book, grab the cover data
        //JSONObject jsonObject = (JSONObject) mJSONAdapter.getItem(position);
        //String coverID = jsonObject.optString("cover_i","");

        // create an Intent to take you over to a new DetailActivity
        Intent detailIntent = new Intent(this, CreateUserActivity.class);

        // pack away the data about the cover
        // into your Intent before you head out
        detailIntent.putExtra("teamName", mGameList.get(position).toString());

        // TODO: adjust these calls for the HuntR API

        // start the next Activity using your prepared Intent
        startActivity(detailIntent);
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
}
