package com.example.rquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.appcompat.app.AppCompatActivity;

public class Register extends AppCompatActivity {

    //Initialise variables
    TextInputEditText mEtName, mEtPhone, mEtUsername, mEtPassword, mEtCPassword;
    Button mBtnRegister;
    DatabaseHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find resources by id
        mEtName = findViewById(R.id.etName);
        mEtPhone = findViewById(R.id.etPhone);
        mEtUsername = findViewById(R.id.etUsername);
        mEtPassword = findViewById(R.id.etPassword);
        mEtCPassword = findViewById(R.id.etCPassword);
        mBtnRegister = findViewById(R.id.btnRegister);
        DB = new DatabaseHelper(this);

        //Register button
        mBtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Initialise variables
                String user = mEtUsername.getText().toString();
                String password = mEtPassword.getText().toString();
                String cPassword = mEtCPassword.getText().toString();
                String name = mEtName.getText().toString();
                String phone = mEtPhone.getText().toString();

                //Initialise format for password
                String passwordFormat = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#&()–[{}]:;',?/*~$^+=<>]).{6,}$";

                //Check validation for name empty field
                if (mEtName.getText().toString().isEmpty()) {
                    //Print error message
                    Toast.makeText(Register.this, "First name is required!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for phone empty field
                else if (mEtPhone.getText().toString().isEmpty()) {
                    //Print error message
                    Toast.makeText(Register.this, "Phone number is required!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for short phone number length
                else if (mEtPhone.length() < 10) {
                    //Print error message
                    Toast.makeText(Register.this, "Phone number is too short!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for long phone number length
                else if (mEtPhone.length() > 11) {
                    //Print error message
                    Toast.makeText(Register.this, "Phone number is too long!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for username empty field
                else if (mEtUsername.getText().toString().isEmpty()) {
                    //Print error message
                    Toast.makeText(Register.this, "Username is required!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for password empty field
                else if (mEtPassword.getText().toString().isEmpty()) {
                    //Print error message
                    Toast.makeText(Register.this, "Password is required!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for password length
                else if (mEtPassword.length() < 8) {
                    //Print error message
                    Toast.makeText(Register.this, "Password length is too short!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for password format
                else if (!mEtPassword.getText().toString().trim().matches(passwordFormat)) {
                    //Print error message
                    Toast.makeText(Register.this, "Password is too weak!", Toast.LENGTH_SHORT).show();
                }
                //Check validation for confirm password
                else if (mEtCPassword.getText().toString().isEmpty()) {
                    //Print error message
                    Toast.makeText(Register.this, "Please repeat your password", Toast.LENGTH_SHORT).show();
                } else {
                    //If password is the same as confirm password
                    if (password.equals(cPassword)) {
                        boolean checkUser = DB.checkUsername(user);
                        if (checkUser == false) {
                            //Insert data into database
                            boolean insert = DB.insertData(user, name, phone, password);
                            if (insert == true) {
                                //Print success message
                                Toast.makeText(Register.this, "Registration successful!", Toast.LENGTH_SHORT).show();
                                //Go to MainActivity
                                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                                startActivity(intent);
                            } else {
                                //Print error message
                                Toast.makeText(Register.this, "Registration failed!", Toast.LENGTH_SHORT).show();
                            }
                        } else {
                            //Print error message
                            Toast.makeText(Register.this, "User already exists!", Toast.LENGTH_SHORT).show();
                        }
                    } else {
                        //Print error message
                        Toast.makeText(Register.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }

    //Cancel button
    public void btnCancel_clicked (View view){
        //Print cancellation message
        Toast.makeText(Register.this, "Registration cancelled!", Toast.LENGTH_SHORT).show();
        //Go to MainActivity
        Intent i = new Intent(Register.this, MainActivity.class);
        startActivity(i);
    }

}




