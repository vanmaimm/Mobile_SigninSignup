package com.example.signupandsigninandroid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText username, password, confirm_password;
    Button signup, signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        confirm_password = (EditText) findViewById(R.id.confirm_password);
        signin = (Button) findViewById(R.id.sign_in);
        signup = (Button) findViewById(R.id.sign_up);
        DB = new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String confirm = confirm_password.getText().toString();

                if(user.equals("")||pass.equals("")||confirm.equals("")){
                    Toast.makeText(MainActivity.this, "Please fill out all fields", Toast.LENGTH_SHORT).show();
                }else {
                    if(pass.equals(confirm)){
                        Boolean checkUser = DB.checkUsername(user);
                        if(checkUser==false){
                           Boolean insert = DB.insertData(user,pass);
                           if(insert==true){
                               Toast.makeText(MainActivity.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
                               Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                               startActivity(intent);
                           }else {
                               Toast.makeText(MainActivity.this, "Sign Up Failed", Toast.LENGTH_SHORT).show();
                           }
                        }else {
                            Toast.makeText(MainActivity.this, "User already exists! Please SignIn", Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(MainActivity.this, "Password is not matching", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}