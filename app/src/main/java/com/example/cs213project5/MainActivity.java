package com.example.cs213project5;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

/**
 * @author Christian Rodriguez, Yazhini Shanmugam
 *
 * MainActivity, Main Activity class for the entire app
 */
public class MainActivity extends AppCompatActivity {

    /**
     * Method called upon app start-up
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * Open the NJSM Activity
     * @param view NJSM view
     */
    public void openNJSMMenu(View view) {
        Intent intent = new Intent(this, NJSMActivity.class);
        startActivity(intent);
    }

    /**
     * Open the MAM Activity
     * @param view MAM view
     */
    public void openMAMMenu(View view) {
        Intent intent = new Intent(this, MAMActivity.class);
        startActivity(intent);
    }

    /**
     * Open the NMOA Activity
     * @param view NMOA view
     */
    public void openNMOAMenu(View view) {
        Intent intent = new Intent(this, NMOAActivity.class);
        startActivity(intent);
    }

    /**
     * Open the MM Activity
     * @param view MM view
     */
    public void openMMMenu(View view) {
        Intent intent = new Intent(this, MMActivity.class);
        startActivity(intent);
    }


}