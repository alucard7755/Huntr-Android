package com.sungard.droid.huntr; /**
 * Created by Daniel.Ellis on 5/17/2015.
 */

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;


import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.sungard.droid.huntr.R;


public class createuser extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);
    }
    public void createUser(View view) {
        Intent intent = new Intent(this, selectteam.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);

        //TODO insert API call to add new user
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_createuser, menu);
        return true;
    }

   // @Override
    //public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();

        //noinspection SimplifiableIfStatement
       // if (id == R.id.action_settings) {
         //   return true;
       // }

      //  return super.onOptionsItemSelected(item);
   // }
}
