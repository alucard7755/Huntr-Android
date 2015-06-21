package com.sungard.droid.huntr;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import org.json.JSONObject;
import com.google.gson.GsonBuilder;
import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.google.gson.JsonObject;

import java.util.ArrayList;


public class CluesActivity extends ActionBarActivity
        implements NavigationDrawerFragment.NavigationDrawerCallbacks, AdapterView.OnItemClickListener {

    /**
     * Fragment managing the behaviors, interactions and presentation of the navigation drawer.
     */
    private NavigationDrawerFragment mNavigationDrawerFragment;

    /**
     * Used to store the last screen title. For use in {@link #restoreActionBar()}.
     */
    private CharSequence mTitle;
    ListView clueListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mClueList = new ArrayList();
    //HuntrAPI mAPI = new HuntrAPI();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_clues);

        HuntrAPI mAPI = ((HuntrApplication)getApplicationContext()).getHuntrAPI();

        ActionBar actionBar = getSupportActionBar();


        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout));


        //Access the list and set the listener to it
        clueListView = (ListView) findViewById(R.id.cluelistView);
        clueListView.setOnItemClickListener(this);


        //Fake clues in a list for demonstration
        //TODO: change to API call to populate the list
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mClueList);
        if (mAPI.isNetworkActive(this))
        {
            mAPI.getCluesList(this, "53a5df155fbcd10200831406",
                    new HuntrAPI.CluesResponseHandler() {
                        @Override
                        public void onSuccess(ArrayList response) {
                            mClueList.clear();
                            for (int i = 0; i < response.size(); i++) {
                                mClueList.add(response.get(i));
                            }
                            ;
                            clueListView = (ListView) findViewById(R.id.cluelistView);
                            clueListView.setAdapter(mArrayAdapter);

                        }

                        @Override
                        public void onFailure(ArrayList response) {
                            mClueList.clear();
                            mClueList.add("*** No Response from Server ***");
                            clueListView = (ListView) findViewById(R.id.cluelistView);
                            clueListView.setAdapter(mArrayAdapter);

                            //standListView = (ListView) findViewById(R.id.standings_listView);
                            //standListView.setAdapter(mArrayAdapter);

                        }
                    });


        }

        //mClueList.add("Testing");
        //mClueList.add("Testing2");
        //mClueList.add("Testing3");
        //clueListView = (ListView) findViewById(R.id.cluelistView);
        //clueListView.setAdapter(mArrayAdapter);

    }

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        // update the main content by replacing fragments
        /*FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.container, PlaceholderFragment.newInstance(position + 1))
                .commit();
        */
        switch (position) {
            case 0:
                //mTitle = getString(R.string.title_section1);
                Log.d("omg android", position + "CluesActivity");
                //startActivity(new Intent(this, CluesActivity.class));
                return;
            case 1:
                //mTitle = getString(R.string.title_section2);
                Log.d("omg android", position + "Standings" );
                startActivity(new Intent(this, StandingsActivity.class));
                return;
            case 2:
                mTitle = getString(R.string.title_section3);
                Log.d("omg android", position + "Chat");
                startActivity(new Intent(this, ChatActivity.class));
                return;
        }

    }


    //public void onSectionAttached(int number) {
    //}

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        // Log the item's position and contents
        // to the console in Debug
        Log.d("omg android", position + ": " + mClueList.get(position));

        // 12. Now that the user's chosen a book, grab the cover data
        //JSONObject jsonObject = (JSONObject) mJSONAdapter.getItem(position);
        //String coverID = jsonObject.optString("cover_i","");

        // create an Intent to take you over to a new DetailActivity
        Intent detailIntent = new Intent(this, ClueDetailActivity.class);

        // pack away the data about the cover
        // into your Intent before you head out
        detailIntent.putExtra("clueID", mClueList.get(position).toString());

        // TODO: adjust these calls for the HuntR API

        // start the next Activity using your prepared Intent
        startActivity(detailIntent);
    }



    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.game_home, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            startActivity(new Intent(this, SettingsActivity.class));
            return true;
        }

        return super.onOptionsItemSelected(item);
    }



}
