package com.udacity.gradle.builditbigger;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.InterstitialAd;


/**
 * A placeholder fragment in free version of the app containing a simple view for displaying ads, interstitial ads
 * between activities and for loading jokes.
 */
public class MainActivityFragment extends Fragment implements View.OnClickListener {


    InterstitialAd mInterstitialAd;

    ProgressBar mProgressBar;
    public static final String LOG_TAG=MainActivityFragment.class.getSimpleName();

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

        AdView mAdView = (AdView) root.findViewById(R.id.adView);

        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);

        mProgressBar = (ProgressBar) root.findViewById(R.id.loading_indicator);
        mProgressBar.setVisibility(View.INVISIBLE);
        Button button = (Button) root.findViewById(R.id.joke_button);
        button.setOnClickListener(this);

        mInterstitialAd = new InterstitialAd(getActivity());
        mInterstitialAd.setAdUnitId(getString(R.string.interstitial_ad_unit_id));
        requestNewInterstitial();
        mInterstitialAd.setAdListener(new AdListener() {

            /**
             * When unable to load ad, fetch joke from asynctask
             * @param errorCode
             */
            @Override
            public void onAdFailedToLoad(int errorCode) {
                new EndpointsAsyncTask(getActivity(), null,mProgressBar).execute();
                requestNewInterstitial();
            }

            /**
             * Launch async task to fetch joke when ad is closed
             */
            @Override
            public void onAdClosed() {

                mProgressBar.setVisibility(View.VISIBLE);
                mProgressBar.setProgress(0);
                new EndpointsAsyncTask(getActivity(), null,mProgressBar).execute();
                requestNewInterstitial();
            }
        });

        return root;
    }


    /**
     * Method called on click of button for showing interstitial ad
     * @param v
     */
    @Override
    public void onClick(View v) {
        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            requestNewInterstitial();
        }
    }

    /**
     * Method to load interstitial ad
     */
    private void requestNewInterstitial() {
        if (!mInterstitialAd.isLoading() && !mInterstitialAd.isLoaded()) {
            AdRequest adRequest = new AdRequest.Builder()
                    .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                    .build();

            mInterstitialAd.loadAd(adRequest);
        }

    }


}
