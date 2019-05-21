package com.example.rkumar1.first_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.util.Log;

public class Timeline extends AppCompatActivity {

    DataBaseHelper db;
    private TextView tvEmail;
    //private SharedPreferences sp;
    private static final String TAG = "Timeline";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_timeline);
        db=new DataBaseHelper(this);

         tvEmail = (TextView) findViewById(R.id.txtEmail);

        /* TextView email5= tvEmail;
         Cursor cursor = db.fetch(" ");
        // cursor.moveToFirst();

        Users users=new Users();
        users.setEmail(cursor.getString(cursor.getColumnIndex(String.valueOf(email5))));*/

         //tvEmail.setText(cursor.getString(cursor.getColumnIndex()));
       // SharedPreferences prefs = getSharedPreferences(MY_PREFS_NAME, MODE_PRIVATE);
        SharedPreferences sp=getSharedPreferences("login", MODE_PRIVATE);
        /*String restoredText = sp.getString("text", null);
        if (restoredText != null) {
            String name = sp.getString("name",null);
        }*/
        String value = sp.getString("name", "");
        Log.d(TAG, value);











       /* DataBaseHelper dbManager = new DataBaseHelper(getActivity());
        dbManager.open();

        Cursor cursor = dbManager.fetch();
        cursor.moveToFirst();
        final TextView email = (TextView) getActivity().findViewById(R.id.email);
        email.setText(cursor.getString(0));*/


        /*Intent intent = getIntent();
        // Receiving the Data

        String email5 = intent.getStringExtra("eemail");
        Log.e("Timeline",  email5);

        // Displaying Received data
        txtEmail.setText(email5);*/



    }
}
