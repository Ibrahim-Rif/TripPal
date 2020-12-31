package com.example.trippal.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.trippal.R;

public class DescriputionMap extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        TextView title;
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_descripution_map );

         title = findViewById( R.id.title );

        String t = getIntent().getStringExtra("title");
        title.setText(t);
    }
}