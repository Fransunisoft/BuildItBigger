package com.udacity.gradle.builditbigger.jokeconsumerlib;

import android.os.Bundle;

import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Main activity as part of android library  for displaying joke passed as an intent from app
 */

public class ConsumerMainActivity extends AppCompatActivity {

    public static final  String JOKE_INTENT = "JOKE_INTENT";

    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_consumer);

        if(getIntent()!=null &&getIntent().getStringExtra(JOKE_INTENT)!=null)
        {
            TextView jokeTextView = (TextView) findViewById(R.id.joke_text);
            jokeTextView.setText(getIntent().getStringExtra(JOKE_INTENT));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_joke_consumer, menu);
        return true;
    }

}
