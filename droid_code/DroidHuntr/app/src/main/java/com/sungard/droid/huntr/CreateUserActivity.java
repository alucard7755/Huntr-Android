package com.sungard.droid.huntr; /**
 * Created by Daniel.Ellis on 5/17/2015.
 */

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;


import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class CreateUserActivity extends ActionBarActivity implements View.OnClickListener{

    private Button createUserButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_createuser);
        createUserButton = (Button) findViewById(R.id.button_createuser);
        createUserButton.setOnClickListener(this);
    }

    /*public void createUser(View view) {
        Intent intent = new Intent(this, SelectTeamActivity.class);
        //EditText editText = (EditText) findViewById(R.id.edit_message);
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
         //Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_createuser, menu);
        return true;
    }


    @Override
    public void onClick(View v) {
        //if button clicked, check which one
        if(v.equals(createUserButton)){
            //if take picture button, open camera
            EditText editUser = (EditText) findViewById(R.id.edit_username);
            Toast.makeText(this, "Create User" + editUser.toString(),
                    Toast.LENGTH_SHORT).show();
            Intent toTeamIntnet = new Intent(this, SelectTeamActivity.class);

            toTeamIntnet.putExtra("userName", editUser.toString());

            // TODO: adjust these calls for the HuntR API

            startActivity(toTeamIntnet);
        }
    }
}
