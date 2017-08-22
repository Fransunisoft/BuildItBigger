package com.udacity.gradle.builditbigger.jokeconsumerlib;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;



/**
 * A placeholder fragment for displaying the joke
 */
public class JokeConsumerActivityFragment extends Fragment {

    public JokeConsumerActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_joke_consumer, container, false);
    }
}
