package com.flight.app.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.flight.app.R;
import com.flight.app.bookflight;
import com.google.android.material.snackbar.Snackbar;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private CardView search_flight, book_flight, flight_schedule, book_hotel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);

//        final TextView textView = root.findViewById(R.id.text_home);
//        homeViewModel.getText().observe(this, new Observer<String>() {
//            @Override
//            public void onChanged(@Nullable String s) {
//                textView.setText(s);
//            }
//        });


        // assign card buttons
        search_flight = root.findViewById(R.id.search_flights_card);
        book_flight = root.findViewById(R.id.book_flight_card);
        flight_schedule = root.findViewById(R.id.flight_schedule_card);
        book_hotel = root.findViewById(R.id.book_hotel_card);

        // set snack bars for all the cards, "coming soon".
        search_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Coming Soon", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        book_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Coming Soon", Snackbar.LENGTH_LONG).show();
                Intent bookflightpage = new Intent(getActivity(), bookflight.class);
                startActivity(bookflightpage);
            }
        });

        flight_schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Coming Soon", Snackbar.LENGTH_LONG).show();
            }
        });

        book_hotel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Coming Soon", Snackbar.LENGTH_LONG).show();
            }
        });

        Button fab = root.findViewById(R.id.yourtripbtn);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Your Trips appear here", Snackbar.LENGTH_LONG).show();
            }
        });

        return root;
    }
}