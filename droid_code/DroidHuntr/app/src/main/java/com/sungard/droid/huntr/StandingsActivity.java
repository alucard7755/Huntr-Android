package com.sungard.droid.huntr;

import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;


public class StandingsActivity extends ActionBarActivity implements NavigationDrawerFragment.NavigationDrawerCallbacks {


    private NavigationDrawerFragment mNavigationDrawerFragment;

    private CharSequence mTitle;

    ListView standListView;
    ArrayAdapter mArrayAdapter;
    ArrayList mStandList = new ArrayList();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_standings);

        mNavigationDrawerFragment = (NavigationDrawerFragment)
                getSupportFragmentManager().findFragmentById(R.id.navigation_drawer);
        mTitle = getTitle();

        // Set up the drawer.
        mNavigationDrawerFragment.setUp(
                R.id.navigation_drawer,
                (DrawerLayout) findViewById(R.id.drawer_layout_standings));

        //TODO: Need to make API call to bring down teams and their rankings
        //Fake Teams in a list for demonstration
        mArrayAdapter = new ArrayAdapter(this,
                android.R.layout.simple_list_item_1,
                mStandList);
        mStandList.add("1. Mavericks");
        mStandList.add("2. Some Other B-Ball team");
        mStandList.add("3. Lame-o McGees");
        standListView = (ListView) findViewById(R.id.standings_listView);
        standListView.setAdapter(mArrayAdapter);

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

    @Override
    public void onNavigationDrawerItemSelected(int position) {
        switch (position) {
            case 0:
                mTitle = getString(R.string.title_section1);
                Log.d("omg android", position + "CluesActivity");
                startActivity(new Intent(this, CluesActivity.class));
                return;
            case 1:
                //mTitle = getString(R.string.title_section2);
                Log.d("omg android", position + "Standings" );
                //startActivity(new Intent(this, StandingsActivity.class));
                return;
            case 2:
                mTitle = getString(R.string.title_section3);
                Log.d("omg android", position + "Chat");
                startActivity(new Intent(this, ChatActivity.class));
                return;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        if (!mNavigationDrawerFragment.isDrawerOpen()) {
            // Only show items in the action bar relevant to this screen
            // if the drawer is not showing. Otherwise, let the drawer
            // decide what to show in the action bar.
            getMenuInflater().inflate(R.menu.menu_standings, menu);
            restoreActionBar();
            return true;
        }
        return super.onCreateOptionsMenu(menu);
    }


    public void restoreActionBar() {
        ActionBar actionBar = getSupportActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_STANDARD);
        actionBar.setDisplayShowTitleEnabled(true);
        actionBar.setTitle(mTitle);
    }

}
