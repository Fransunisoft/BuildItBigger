package com.udacity.gradle.builditbigger;


import android.content.Context;
import android.test.ActivityInstrumentationTestCase2;
import android.test.ActivityTestCase;
import android.test.ActivityUnitTestCase;
import android.test.InstrumentationTestCase;
import android.test.TouchUtils;
import android.test.suitebuilder.annotation.LargeTest;
import android.test.suitebuilder.annotation.MediumTest;
import android.util.Log;
import android.widget.Button;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;


/**
 * Test to check Async Task correctly fetches joke from backend. Used CountDownLatch countDown() for decrementing the count with
 * await() block until the current count reaches zero
 */

public class AsyncTaskInstrumentationTest extends InstrumentationTestCase implements EndpointsAsyncTask.AsyncTaskResponse {

    public static final String LOG_TAG = AsyncTaskInstrumentationTest.class.getSimpleName();
    EndpointsAsyncTask endpointsAsyncTask;
    CountDownLatch countDownLatch;
    String mJoke;
    Context mContext;


    @Override
    protected void setUp() throws Exception {
        super.setUp();
        mContext = getInstrumentation().getTargetContext();
        countDownLatch = new CountDownLatch(1);
        endpointsAsyncTask = new EndpointsAsyncTask(mContext, AsyncTaskInstrumentationTest.this, null);
    }

    /**
     * Override getTaskResponse in EndpointsAsyncTask.AsyncTaskResponse to test response returned
     * @param response
     */
    @Override
    public void getTaskResponse(String response) {
        Log.v(LOG_TAG, "In testResult():" + response);
        countDownLatch.countDown();
        mJoke = response;
        assertTrue(response != null && !response.isEmpty());        //test if not null/non empty joke is returned
    }

    /**
     * Run asnc task  on Ui thread
     * @throws Throwable
     */
    public void testAsyncTask() throws Throwable {
        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                try {

                    endpointsAsyncTask.execute();
                    countDownLatch.await(30, TimeUnit.SECONDS);

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
