package com.example.ankit.builditbiggerp4.free;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ankit.builditbiggerp4.JokeAsyncTask;
import com.example.ankit.builditbiggerp4.R;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;

public class MainActivity extends AppCompatActivity {
    AdView mAdView;
    Button jokeButton;
    String joke = "Main Activity Free";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeButton = (Button) findViewById(R.id.tel_joke_button);
        mAdView = (AdView) findViewById(R.id.adView);
    }

    @Override
    protected void onStart() {
        super.onStart();
        // Create an ad request. Check logcat output for the hashed device ID to
        // get test ads on a physical device. e.g.
        // "Use AdRequest.Builder.addTestDevice("ABCDEF012345") to get test ads on this device."
        AdRequest adRequest = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)
                .build();
        mAdView.loadAd(adRequest);
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeAsyncTask(MainActivity.this).execute();
            }
        });
    }
}
