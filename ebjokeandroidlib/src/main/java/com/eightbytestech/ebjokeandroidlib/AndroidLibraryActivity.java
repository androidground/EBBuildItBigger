package com.eightbytestech.ebjokeandroidlib;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class AndroidLibraryActivity extends AppCompatActivity {

    public final static String INTENT_KEY = "JOKE_INTENT_KEY";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_library);

        TextView jokeText = (TextView) findViewById(R.id.jokeTextView);

        Intent intent = getIntent();
        String text = intent.getStringExtra(INTENT_KEY);
        jokeText.setText(text);
    }
}
