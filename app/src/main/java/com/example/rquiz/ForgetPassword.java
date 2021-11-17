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

public class ForgetPassword extends AppCompatActivity {

    //Call DatabaseHelper
    DatabaseHelper DB;

    //Initialise variables
    private Button mNextBtn;
    private TextInputEditText mPhoneNo;
    private ImageView mClose;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forget_password);

        //Find resources by id
        mNextBtn = findViewById(R.id.next_btn);
        mPhoneNo = findViewById(R.id.phoneNo);
        mClose = findViewById(R.id.close);
        DB = new DatabaseHelper(this);

        //If next button is clicked
        mNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               //Get text of mPhoneNo and store in phoneNo
               String phoneNo = mPhoneNo.getText().toString();

               //Check if phone number exists
               boolean checkPhone = DB.checkPhone(phoneNo);

               //If phone number exists
                if(checkPhone == true)
                {
                    //Go to reset password page
                    Intent intent = new Intent(ForgetPassword.this, ResetPassword.class);
                    //Store phone number data in phone
                    intent.putExtra("phone", phoneNo);
                    startActivity(intent);
                }
                else {
                    //Toast message if phone number does not exist
                    Toast.makeText(ForgetPassword.this, "Phone number not found! Please enter a correct phone No.!", Toast.LENGTH_SHORT).show();
                }
            }
        });

        //If close button is pressed, it will return to login page
        mClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

    }
}
