package com.murach.newsreader;

import android.app.Fragment;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

/**
 * Created by michelle on 04/06/17.
 */

public class ItemFragment extends Fragment implements View.OnClickListener  {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getActivity().setContentView(R.layout.activity_item);

        // get references to widgets
        TextView titleTextView = (TextView) getActivity().findViewById(R.id.titleTextView);
        TextView pubDateTextView = (TextView) getActivity().findViewById(R.id.pubDateTextView);
        TextView descriptionTextView = (TextView) getActivity().findViewById(R.id.descriptionTextView);
        TextView linkTextView = (TextView) getActivity().findViewById(R.id.linkTextView);

        // get the intent
        Intent intent = getActivity().getIntent();

        // get data from the intent
        String pubDate = intent.getStringExtra("pubdate");
        String title = intent.getStringExtra("title");
        String description = intent.getStringExtra("description").replace('\n', ' ');

        // display data on the widgets
        pubDateTextView.setText(pubDate);
        titleTextView.setText(title);
        descriptionTextView.setText(description);

        // set listener
        linkTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        // get the intent
        Intent intent = getActivity().getIntent();

        // get the Uri for the link
        String link = intent.getStringExtra("link");
        Uri viewUri = Uri.parse(link);

        // create the intent and start it
        Intent viewIntent = new Intent(Intent.ACTION_VIEW, viewUri);
        startActivity(viewIntent);
    }
}
