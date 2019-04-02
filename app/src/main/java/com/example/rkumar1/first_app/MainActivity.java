package com.example.rkumar1.first_app;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    DataBaseHelper db;
    private Button fb;
    private Button tw;
    private Button signup;
    private TextView sig;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);
        db=new DataBaseHelper(this);

        fb=(Button) findViewById(R.id.face);
        tw=(Button)findViewById(R.id.twit);
        signup=(Button)findViewById(R.id.signup);
        sig=(TextView)findViewById(R.id.register1);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SignUp.class);
                startActivity(intent);
            }
        });
        sig.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent (MainActivity.this,LogIn.class);
                startActivity(intent);
            }
        });


    }
}
