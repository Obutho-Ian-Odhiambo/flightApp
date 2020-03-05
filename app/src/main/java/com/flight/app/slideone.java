package com.flight.app;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import com.flight.app.R;

public class slideone extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_one);

        button = findViewById(R.id.slideonebtn);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent slide2 = new Intent(slideone.this, slidetwo.class);
                startActivity(slide2);
            }
        });

    }

}
