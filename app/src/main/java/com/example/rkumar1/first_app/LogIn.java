package com.example.rkumar1.first_app;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LogIn extends AppCompatActivity {
    DataBaseHelper db;
    private EditText email1;
    private EditText password1;
    private Button sign;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.login);
        db=new DataBaseHelper(this);

        email1=(EditText)findViewById(R.id.email);
        password1=(EditText) findViewById(R.id.password);
        sign=(Button)findViewById(R.id.login);

        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1 = email1.getText().toString();
                String s2 = password1.getText().toString();

                if(s1.equals("")|| s2.equals("")){
                    Toast.makeText(getApplicationContext(),"Please Fill up the Details",Toast.LENGTH_SHORT).show();
                }
                else{
                    Boolean ChkEmailPass = db.emailPass(s1,s2);
                    if(ChkEmailPass==true){
                        Toast.makeText(getApplicationContext(),"Login Successfully",Toast.LENGTH_SHORT).show();
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Email or Password Inncorrect",Toast.LENGTH_SHORT).show();
                    }
                }
                email1.getText().clear();
                password1.setText(null);

            }



        });


    }

}
