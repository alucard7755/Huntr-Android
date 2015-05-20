package com.sungard.droid.huntr;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;


public class SelectGame extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //getActionBar().setDisplayHomeAsUpEnabled(true);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_game);

        populateListView();
        registerClick();
        
    }



    private void populateListView() {
        //create list of items
        String[] myGames = {"Mavs Suck", "Sic em Bears", "SunGard Peeps", "Droid Supremacy"};

        //build adapter
        ArrayAdapter<String> zeAdapter = new ArrayAdapter<String>(
                this,                   //context for activity
                R.layout.game_list,     //layout to be used (create)
                myGames);               //items to be displayed

        //configure list view
        ListView list = (ListView) findViewById(R.id.listView);
        list.setAdapter(zeAdapter);

    }

    private void registerClick() {
        ListView list = (ListView) findViewById(R.id.listView);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View viewClicked, int position, long id) {
                TextView textView = (TextView) viewClicked;
                String message = "You selected " + textView.getText().toString();
                Toast.makeText(SelectGame.this, message, Toast.LENGTH_LONG).show();

            }
        });
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
