package com.example.rquiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ResetPassword extends AppCompatActivity {

    //Call DatabaseHelper
    DatabaseHelper DB;

    //Initialise variables
    TextInputEditText mNewCrendential;
    Button mResetBtn;
    TextInputEditText mPassword, mConfirmPassword;
    ImageView mCloseBtn;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.reset_password);

        //Find resources by id
        mNewCrendential = findViewById(R.id.text_credentials);
        mPassword = findViewById(R.id.new_password);
        mConfirmPassword = findViewById(R.id.confirmPassword);
        mResetBtn = findViewById(R.id.resetBtn);
        mCloseBtn = findViewById(R.id.closeF);
        DB = new DatabaseHelper(this);

        //Get phone number
        Intent intent = getIntent();
        mNewCrendential.setText(intent.getStringExtra("phone"));

        //If reset button is clicked
        mResetBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Get text for variables
                String phone = mNewCrendential.getText().toString();
                String password = mPassword.getText().toString();
                String confirmPassword = mConfirmPassword.getText().toString();

                //If password equals confirm password
                if (password.equals(confirmPassword)) {
                    //Update database
                    //Replace old password with new password
                    boolean checkResetPassword = DB.updatePassword(phone, password);
                    if (checkResetPassword == true) {
                        //If success, go to login page
                        Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(intent);
                        //Toast success message
                        Toast.makeText(ResetPassword.this, "Password updated successfully!", Toast.LENGTH_SHORT).show();
                    } else {
                        //If fail, toast fail message
                        Toast.makeText(ResetPassword.this, "Password failed to update!", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    //Toast error message if password does not match
                    Toast.makeText(ResetPassword.this, "Password does not match!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //If close button is clicked, it will go back to login page
        mCloseBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
