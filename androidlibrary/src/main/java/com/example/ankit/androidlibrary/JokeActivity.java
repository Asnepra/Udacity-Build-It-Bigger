package com.example.ankit.androidlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by Ankit on 9/3/2016.
 */
public class JokeActivity extends AppCompatActivity {
    TextView jokeView;
    String joke = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.joke_activity_main);
        jokeView = (TextView) findViewById(R.id.joke_view_lib_android);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Intent intent = getIntent();
        joke = intent.getStringExtra("Joke");
        jokeView.setText(joke);
    }
}
