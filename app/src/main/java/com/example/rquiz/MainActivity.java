package com.example.rquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    //Initialise variables
    ImageView mImageView;
    Button mBtnLogin, mBtnRegister, mForgetPassword;
    TextInputEditText mUsername, mPassword;
    DatabaseHelper DB;

    //Declare share preference
    private SharedPreferences mSP;

    //Key to access value
    private final String LOGGED_IN_KEY = "logged_in";

    //Declare file name, username and Password
    public static final String filename = "login_status";
    public static final String Username = "username";
    public static final String Password = "password";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        //Find resources by id
        mImageView = findViewById(R.id.imageView);
        mBtnRegister = findViewById(R.id.signUp_btn);
        mBtnLogin = findViewById(R.id.login_btn);
        mUsername = findViewById(R.id.username);
        mPassword = findViewById(R.id.password);
        mForgetPassword = findViewById(R.id.forgetPassword_btn);

        //Call database helper
        DB = new DatabaseHelper(this);

        //Set animation for logo
        Animation animation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.bounce);
        mImageView.startAnimation(animation);

        //If the application is run the first time, then it will create the file
        //Object will refer to existing file if file if created
        SharedPreferences mSP = getSharedPreferences(filename, Context.MODE_PRIVATE);

        //If shared preference has username
        if(mSP.contains(Username)){
            //Go to home page without log in
            Intent i = new Intent(MainActivity.this, Subject.class);
            //Store username data in getUser
            i.putExtra("getUser", mSP.getString(Username, ""));
            startActivity(i);
        }

        //If forget password button is clicked
        mForgetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to forget password page
                Intent intent = new Intent(MainActivity.this, ForgetPassword.class);
                startActivity(intent);
            }
        });

        //If register button is clicked
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Go to register page
                Intent i = new Intent(MainActivity.this, Register.class);
                startActivity(i);
            }
        });

        //If login button is clicked
        mBtnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get text of variables
                String user = mUsername.getText().toString();
                String pass = mPassword.getText().toString();

                //Check for empty validation
                if (user.equals("") || pass.equals("")) {
                    //Toast error message
                    Toast.makeText(MainActivity.this, "Empty fields!", Toast.LENGTH_SHORT).show();
                } else {
                    //Check user exists
                    boolean checkUserPass = DB.checkLogin(user, pass);
                    if (checkUserPass == true) {
                        //If exist, save user in shared preference
                        SharedPreferences.Editor mSP_Editor = mSP.edit();
                        mSP_Editor.putString(Username, user);
                        mSP_Editor.putString(Password, pass);
                        mSP_Editor.commit();
                        mSP_Editor.putBoolean(LOGGED_IN_KEY, true);

                        //Apply the changes
                        mSP_Editor.apply();

                        //Toast success message
                        Toast.makeText(MainActivity.this, "Successful login!", Toast.LENGTH_SHORT).show();
                        //Go to home page
                        Intent i = new Intent(getApplicationContext(), Subject.class);
                        //Store username data in getUser
                        i.putExtra("getUser", user);
                        startActivity(i);
                    } else {
                        //Toast error message
                        Toast.makeText(MainActivity.this, "Invalid credentials!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });

    }
}

