package com.eightbytestech.ebbuilditbigger;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;

import com.eightbytestech.ebbuilditbigger.EndpointsAsyncTask;
import com.eightbytestech.ebbuilditbigger.OnJokeReceivedListener;
import com.eightbytestech.ebbuilditbigger.R;
import com.eightbytestech.ebjokeandroidlib.AndroidLibraryActivity;


public class MainActivityFragment extends Fragment implements OnJokeReceivedListener {
    private ProgressBar progressBar;

    public MainActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_main, container, false);

        Button button = (Button) root.findViewById(R.id.tellJokeButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startJokeActivity();
            }
        });

        progressBar = (ProgressBar) root.findViewById(R.id.progressBar);

        return root;
    }

    @Override
    public void onReceived(String joke) {
        progressBar.setVisibility(View.INVISIBLE);
        Intent intent = new Intent(getActivity(), AndroidLibraryActivity.class);
        intent.putExtra(AndroidLibraryActivity.INTENT_KEY, joke);
        startActivity(intent);
    }

    public void startJokeActivity(){
        progressBar.setVisibility(View.VISIBLE);
        new EndpointsAsyncTask().execute(this);
    }
}
