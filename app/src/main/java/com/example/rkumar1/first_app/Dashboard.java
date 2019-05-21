package com.example.rkumar1.first_app;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Dashboard extends AppCompatActivity {
    DataBaseHelper db;
    private ImageView timeline;
    private ImageView friendList;
    private ImageView chat;
    private ImageView music;
    private ImageView galary;
    private ImageView map;
    private ImageView weather;
    private ImageView setting;
    private TextView email4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_dashboard);
        db = new DataBaseHelper(this);

        timeline=(ImageView)findViewById(R.id.iv_timeline);
        friendList=(ImageView)findViewById(R.id.iv_friendlist);
        chat=(ImageView)findViewById(R.id.iv_chat);
        music=(ImageView)findViewById(R.id.iv_music);
        galary=(ImageView)findViewById(R.id.iv_galary);
        map=(ImageView)findViewById(R.id.iv_map);
        weather=(ImageView)findViewById(R.id.iv_weather);
        setting=(ImageView)findViewById(R.id.iv_setting);
        email4=(TextView)findViewById(R.id.tv_email4);

        timeline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(Dashboard.this,Timeline.class);
                startActivity(intent);

               //Intent nextScreen = new Intent(getApplicationContext(), Timeline.class);

                //Sending data to another Activity

               // nextScreen.putExtra("eemail", email4.getText().toString());

                //Log.e("n", String.valueOf(email4.getText()));

                //startActivity(nextScreen);

            }
        });

    }
}
