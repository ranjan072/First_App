package com.example.rkumar1.first_app;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper db;
    private Button fb;
    private Button tw;
    private Button signup;
    private TextView sig;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        db = new DataBaseHelper(this);

        fb = (Button) findViewById(R.id.face);
        tw = (Button) findViewById(R.id.twit);
        signup = (Button) findViewById(R.id.signup);
        sig=(TextView)findViewById(R.id.register1);


        sp = getSharedPreferences("login", MODE_PRIVATE);

        if (sp.getBoolean("logged", false)) {
            goToNew();
        } else {

            sig.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    goToNew();
                    sp.edit().putBoolean("logged", true).apply();
                    SharedPreferences.Editor editor = sp.edit();
                    editor.putString("name", "raj@");
                    editor.commit();

                }
            });
        }
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (MainActivity.this,LogIn.class);
                startActivity(intent);
            }
        });

            signup.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(MainActivity.this, SignUp.class);
                    startActivity(intent);
                }
            });


    }
        public void goToNew(){
            Intent intent = new Intent(this,Dashboard.class);
           // intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            //intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            startActivity(intent);
            finish();
        }
}
