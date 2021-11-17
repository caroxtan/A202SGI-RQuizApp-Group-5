package com.example.rquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    //Initialise variable
    private Button mBtnReturn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about);

        //Find resource by id
        mBtnReturn = findViewById(R.id.btnReturn);

        //If press the return button, it will return to home page
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //Call the toolbar action menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.drawer_menu, menu);
        return true;
    }

    //Call the items in toolbar action menu
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        //Receive username data from getUser
        Intent newIntent = getIntent();
        String getUsername = newIntent.getStringExtra("getUser");
        //Switch case for each item in toolbar action menu
        switch(item.getItemId()){
            //Go to home page
            case R.id.nav_home:
                Intent homeIntent = new Intent(AboutActivity.this, Subject.class);
                //Store username data in getUser
                homeIntent.putExtra("getUser", getUsername);
                startActivity(homeIntent);
                break;

            //Go to history page
            case R.id.nav_history:
                Intent historyIntent = new Intent(AboutActivity.this, History.class);
                //Store username data in getUser
                historyIntent.putExtra("getUser", getUsername);
                startActivity(historyIntent);
                break;

            //Go to settings page
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(AboutActivity.this, Settings.class);
                //Store username in getUser
                settingsIntent.putExtra("getUser", getUsername);
                startActivity(settingsIntent);
                break;

           //Call the email link
            case R.id.nav_contact:
                Intent mail = new Intent(Intent.ACTION_SENDTO);
                mail.setType("text/plain");
                mail.setData(Uri.parse("mailto:"));
                mail.putExtra(Intent.EXTRA_EMAIL  , new String[]{"recipient@gmail.com"});
                mail.putExtra(Intent.EXTRA_SUBJECT, "Mail Subject");
                mail.putExtra(Intent.EXTRA_TEXT   , "massage");
                mail.setPackage("com.google.android.gm");
                try {
                    startActivity(Intent.createChooser(mail, "Send mail..."));
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(AboutActivity.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
                }

                break;

            //Call the share link
            case R.id.nav_share:
                Intent intentShare = new Intent(Intent.ACTION_SEND);
                intentShare.setType("text/plain");
                intentShare.putExtra(Intent.EXTRA_SUBJECT, "RQuiz");
                String shareMessage= "Try out the RQuiz to practice your subjects!\n\n";
                shareMessage = shareMessage + "https://play.google.com/store/apps/details?id=" + BuildConfig.APPLICATION_ID;
                intentShare.putExtra(Intent.EXTRA_TEXT, shareMessage);
                startActivity(Intent.createChooser(intentShare, "Choose one"));
                break;

           //Remain in about page
            case R.id.nav_about:
                Intent aboutIntent = new Intent(AboutActivity.this, AboutActivity.class);
                //Store username data in getUser
                aboutIntent.putExtra("getUser", getUsername);
                startActivity(aboutIntent);
                break;

            //Logout from app
            case R.id.nav_logout:
                //Create new preferences to file then call editor
                SharedPreferences preferences = getSharedPreferences("login_status", Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = preferences.edit();
                //The editor is used to clear the key and value
                editor.clear();
                editor.apply();

                //Return to login page
                Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}
