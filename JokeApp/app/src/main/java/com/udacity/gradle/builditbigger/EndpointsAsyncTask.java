package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.udacity.gradle.builditbigger.jokeconsumerlib.ConsumerMainActivity;
import com.udacity.gradle.builditbigger.backend.myApi.MyApi;
import com.google.api.client.extensions.android.http.AndroidHttp;
import com.google.api.client.extensions.android.json.AndroidJsonFactory;

import java.io.IOException;

/**
 * Asynctask to pull joke from backend which in turns makes request to jokeproducer library
 */
public class EndpointsAsyncTask extends AsyncTask<Void, Integer, String> {
    private static MyApi myApiService = null;
    private Context context;
    AsyncTaskResponse asyncTaskResponse;
    ProgressBar mProgressBar;
    public static final String LOG_TAG = EndpointsAsyncTask.class.getSimpleName();

    /**
     * @param context
     * @param asyncTaskResponse
     * @param progressBar
     */
    EndpointsAsyncTask(Context context, AsyncTaskResponse asyncTaskResponse, ProgressBar progressBar) {
        this.context = context;
        this.asyncTaskResponse = asyncTaskResponse;
        mProgressBar = progressBar;

    }

    /**
     *
     * @param params
     * @return
     */
    @Override
    protected String doInBackground(Void... params) {
        if (myApiService == null) {
            MyApi.Builder builder = new MyApi.Builder(AndroidHttp.newCompatibleTransport(), new AndroidJsonFactory(), null)
                    .setRootUrl("https://myjokes-1214.appspot.com/_ah/api/");

            myApiService = builder.build();
        }

        publishProgress(0);
        try {
            return myApiService.sayHi().execute().getData();

        } catch (IOException e) {
            return e.getMessage();
        }
    }

    /**
     * Publish progress status to progress bar
     * @param values
     */
    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);

    }

    /**
     * After fetching joke, launch joke consumer android library for displaying the joke
     * @param result
     */
    @Override
    protected void onPostExecute(String result) {
        if (mProgressBar != null) {
            mProgressBar.setVisibility(View.INVISIBLE);
        }
        Intent intent = new Intent(context, ConsumerMainActivity.class);
        intent.putExtra(ConsumerMainActivity.JOKE_INTENT, result);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);
        if (asyncTaskResponse != null) {
            asyncTaskResponse.getTaskResponse(result);
        }

    }


    public static interface AsyncTaskResponse {
        public void getTaskResponse(String response);
    }


}
