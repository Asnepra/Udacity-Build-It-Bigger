package com.example.ankit.builditbiggerp4.paid;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.ankit.builditbiggerp4.JokeAsyncTask;
import com.example.ankit.builditbiggerp4.R;

public class MainActivity extends AppCompatActivity {
    Button jokeButton;
    String joke = "Main Activity ";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        jokeButton = (Button) findViewById(R.id.tel_joke_button);
    }

    @Override
    protected void onStart() {
        super.onStart();
        jokeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new JokeAsyncTask(MainActivity.this).execute();
            }
        });
    }
}
