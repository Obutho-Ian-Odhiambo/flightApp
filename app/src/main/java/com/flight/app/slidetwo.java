package com.flight.app;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class slidetwo extends AppCompatActivity {

    private Button buttton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.slide_two);

        buttton = findViewById(R.id.slidetwobtn);

        buttton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent slide3 = new Intent(slidetwo.this, slidethree.class);
                startActivity(slide3);
            }
        });

    }
}
