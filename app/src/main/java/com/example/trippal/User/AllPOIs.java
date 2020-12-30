package com.example.trippal.User;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.trippal.R;

public class AllPOIs extends AppCompatActivity {

    ImageView backBtn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        getWindow().setFlags( WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN );
        setContentView( R.layout.activity_all_p_o_is );


        //Hooks
        backBtn = findViewById( R.id.back_pressed_pois );
        backBtn.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AllPOIs.super.onBackPressed();
            }
        } );
    }
}