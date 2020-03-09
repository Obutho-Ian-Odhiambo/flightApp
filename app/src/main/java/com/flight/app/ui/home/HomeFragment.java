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
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.flight.app.DiscoverREPO;
import com.flight.app.DiscoverRecyclerAdapter;
import com.flight.app.R;
import com.flight.app.bookflight;
import com.flight.app.placesproject.MapActivity;
import com.flight.app.placesproject.PermissionsActivity;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private FloatingActionButton checkin_flight, book_flight, flight_schedule, book_hotel;

    Integer[] homeimage1 = {R.mipmap.imagetwo, R.mipmap.home_image};
    ArrayList<DiscoverREPO> arrayList;
    DiscoverRecyclerAdapter adapter;
    private RecyclerView recyclerview;
    private TextView search_layout;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,@Nullable Bundle savedInstanceState) {

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
        checkin_flight = root.findViewById(R.id.checkfloatingActionButton2);
        book_flight = root.findViewById(R.id.flightfloatingActionButton);
        flight_schedule = root.findViewById(R.id.schedulesfloatingActionButton3);
        book_hotel = root.findViewById(R.id.hotelfloatingActionButton4);

        // set snack bars for all the cards, "coming soon".
        checkin_flight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Snackbar.make(v, "Coming Soon", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
                Intent intent = new Intent(getActivity(), PermissionsActivity.class);
                startActivity(intent);
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

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);;

        recyclerview = view.findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager1 = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        recyclerview.setLayoutManager(layoutManager1);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setNestedScrollingEnabled(false);


        arrayList = new ArrayList<>();


        for (int i = 0; i < homeimage1.length; i++) {
            DiscoverREPO discoverREPO = new DiscoverREPO(homeimage1[i]);
            arrayList.add(discoverREPO);
        }
        adapter = new DiscoverRecyclerAdapter(getContext(), arrayList);
        recyclerview.setAdapter(adapter);


    }
}