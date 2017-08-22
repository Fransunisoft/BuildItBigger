package com.udacity.gradle.builditbigger;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Button;
import android.widget.Toast;

import com.udacity.gradle.builditbigger.EndpointsAsyncTask;

/**
 * A placeholder fragment containing a simple view in paid version of the app(without ads)  for loading jokes.
 */
public class MainActivityFragment extends Fragment  implements View.OnClickListener {

    EndpointsAsyncTask endpointsAsyncTask;
    ProgressBar mProgressBar;

    /**
     *
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        mProgressBar = (ProgressBar) root.findViewById(R.id.loading_indicator);
        mProgressBar.setVisibility(View.INVISIBLE);
        Button button = (Button) root.findViewById(R.id.joke_button);
        button.setOnClickListener(this);
        return root;
    }

    /**
     *
     * @param v
     */
    @Override
    public void onClick(View v) {
        mProgressBar.setVisibility(View.VISIBLE);
        mProgressBar.setProgress(0);
        new EndpointsAsyncTask(getActivity(), null,mProgressBar).execute();
    }
}
