package com.example.rkumar1.first_app;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.util.Log;


public class SignUp extends AppCompatActivity {
    DataBaseHelper db;
    private EditText email2;
    private EditText password;
    private EditText cpassword;
    private Button reg;
    private TextView tvcancel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.signup);
        db=new DataBaseHelper(this);

        email2= (EditText) findViewById(R.id.eemail);
        password= (EditText) findViewById(R.id.pass);
        cpassword= (EditText) findViewById(R.id.cpass);
        reg= (Button) findViewById(R.id.register);
        tvcancel=(TextView)findViewById(R.id.cancel);



        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String s1=email2.getText().toString();
                String s2=password.getText().toString();
                String s3=cpassword.getText().toString();
                if(s1.equals("")|| s2.equals("")||s3.equals("")){
                    Toast.makeText(getApplicationContext()," Fields are empty",Toast.LENGTH_SHORT).show();
                }
                else{
                    if(s2.equals(s3)){
                        Boolean checkemail=db.checkEmail(s1);
                        if(checkemail==true){
                            Long obj =db.insert(s1,s2);
                            if(obj!=-1){
                                Toast.makeText(getApplicationContext(),"registered successfully",Toast.LENGTH_SHORT).show();
                                db.insert(s1,s2);
                                Intent intent = new Intent(SignUp.this, LogIn.class);

                                //Sending data to another Activity

                               // nextScreen.putExtra("eemail", email2.getText().toString());

                                //Log.e("n", String.valueOf(email2.getText()));

                                startActivity(intent);
                            }
                        }
                        else{
                            Toast.makeText(getApplicationContext(),"email already exists",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"password do not match",Toast.LENGTH_SHORT).show();
                    }
                }
                email2.setText(null);
                password.setText(null);
                cpassword.setText(null);
            }
        });
        tvcancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(SignUp.this,MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
