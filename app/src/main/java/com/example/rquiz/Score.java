package com.example.rquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class Score extends AppCompatActivity {

    //Initialise variables
    private TextView mScore;
    private TextView mBestScore;
    private Button mBtnReturn, mBtnViewHistory;

    //Call ScoreDatabase
    ScoreDatabase ScoreDatabase;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        //Find resources by id
        mScore=findViewById(R.id.score);
        mBestScore=findViewById(R.id.bestScore);
        mBtnReturn=findViewById(R.id.btnReturn);
        mBtnViewHistory=findViewById(R.id.btnViewHistory);
        ScoreDatabase = new ScoreDatabase(this);

        //Get subject score, question length, subject name and username
        Intent intent = getIntent();
        int scoreEng = intent.getIntExtra("scoreEng", 0);
        int scoreScience = intent.getIntExtra("scoreScience", 0);
        int scoreBM = intent.getIntExtra("scoreBM", 0);
        int scoreMaths = intent.getIntExtra("scoreMaths", 0);
        int total = intent.getIntExtra("total", 0);
        int subject = intent.getIntExtra("subject", 0);
        String getUsername = intent.getStringExtra("getUser");

        //Set default values for preferences
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false);

        //Get default shared preferences
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        //If Maths was chosen
        if (subject == 0) {
            //If switch is turned off, start a new quiz without saving history
            if (!sharedPref.getBoolean("switch_example", true)) {
                //Disable view history button
                mBtnViewHistory.setVisibility(View.INVISIBLE);

                //Set score text
                mScore.setText("Score: " + scoreMaths + "/" + total);

                //Get best score for Maths in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreMaths = mypref.getInt("bestScoreMaths", 0);

                if (bestScoreMaths >= scoreMaths)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreMaths + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreMaths + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreMaths", scoreMaths);
                editor.commit();
            } else {
                //Set score text
                mScore.setText("Score: " + scoreMaths + "/" + total);
                //Set subject name text
                String sub = "Mathematics";

                //Get best score for Maths in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreMaths = mypref.getInt("bestScoreMaths", 0);

                //Set score text for database
                String scoreText = scoreMaths + "/" + total;
                //Insert data into database
                ScoreDatabase.insertData(getUsername, sub, scoreText);
                if (bestScoreMaths >= scoreMaths)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreMaths + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreMaths + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreMaths", scoreMaths);
                editor.commit();
            }
            //If Science was chosen
        } else if (subject == 1) {
            //If switch is turned off, start a new quiz without saving history
            if (!sharedPref.getBoolean("switch_example", true)) {
                //Disable view history button
                mBtnViewHistory.setVisibility(View.INVISIBLE);

                //Set score text
                mScore.setText("Score: " + scoreScience + "/" + total);

                //Get best score for Science in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreScience = mypref.getInt("bestScoreScience", 0);

                if (bestScoreScience >= scoreScience)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreScience + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreScience + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreScience", scoreScience);
                editor.commit();
            }else {
                //Set score text
                mScore.setText("Score: " + scoreScience + "/" + total);
                //Set subject name text
                String sub = "Science";

                //Get best score for Science in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreScience = mypref.getInt("bestScoreScience", 0);

                //Set score text for database
                String scoreText = scoreScience + "/" + total;
                //Insert data into database
                ScoreDatabase.insertData(getUsername, sub, scoreText);
                if (bestScoreScience >= scoreScience)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreScience + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreScience + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreScience", scoreScience);
                editor.commit();
            }
            //If BM was chosen
        } else if (subject == 2) {
            //If switch is turned off, start a new quiz without saving history
            if (!sharedPref.getBoolean("switch_example", true)) {
                //Disable view history button
                mBtnViewHistory.setVisibility(View.INVISIBLE);

                //Set score text
                mScore.setText("Score: " + scoreBM + "/" + total);

                //Get best score for BM in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreBM = mypref.getInt("bestScoreBM", 0);

                if (bestScoreBM >= scoreBM)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreBM + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreBM + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreBM", scoreBM);
                editor.commit();
            }else {
                //Set score text
                mScore.setText("Score: " + scoreBM + "/" + total);
                //Set subject name text
                String sub = "BM";

                //Get best score for BM in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreBM = mypref.getInt("bestScoreBM", 0);

                //Set score text for database
                String scoreText = scoreBM + "/" + total;
                //Insert data into database
                ScoreDatabase.insertData(getUsername, sub, scoreText);
                if (bestScoreBM >= scoreBM)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreBM + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreBM + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreBM", scoreBM);
                editor.commit();
            }
            //If English was chosen
        } else if (subject == 3) {
            //If switch is turned off, start a new quiz without saving history
            if (!sharedPref.getBoolean("switch_example", true)) {
                //Disable view history button
                mBtnViewHistory.setVisibility(View.INVISIBLE);

                //Set text score
                mScore.setText("Score: " + scoreEng + "/" + total);

                //Get best score for English in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreEng = mypref.getInt("bestScoreEng", 0);

                if (bestScoreEng >= scoreEng)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreEng + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreEng + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreEng", scoreEng);
                editor.commit();
            }else {
                //Set text score
                mScore.setText("Score: " + scoreEng + "/" + total);
                //Set subject name
                String sub = "English";

                //Get best score for English in shared preferences
                SharedPreferences mypref = getPreferences(MODE_PRIVATE);
                int bestScoreEng = mypref.getInt("bestScoreEng", 0);

                //Set score text for database
                String scoreText = scoreEng + "/" + total;
                //Insert data into database
                ScoreDatabase.insertData(getUsername, sub, scoreText);
                if (bestScoreEng >= scoreEng)
                    //If best score is higher than score, no changes to best score
                    mBestScore.setText("Personal Best: " + bestScoreEng + "/" + total);
                else
                    //If score is higher than best score, replace with score
                    mBestScore.setText("Personal Best: " + scoreEng + "/" + total);

                //Save new best score in shared preferences
                SharedPreferences.Editor editor = mypref.edit();
                editor.putInt("bestScoreEng", scoreEng);
                editor.commit();
            }
        }


        //Return button
        mBtnReturn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to home page
                Intent intent = new Intent(Score.this, Subject.class);
                //Store username in getUser
                intent.putExtra("getUser", getUsername);
                startActivity(intent);
            }
        });

        //View history button
        mBtnViewHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Go to history page
                Intent intent = new Intent(Score.this, History.class);
                //Store username in getUser
                intent.putExtra("getUser", getUsername);
                startActivity(intent);
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
                Intent homeIntent = new Intent(Score.this, Subject.class);
                //Store username data in getUser
                homeIntent.putExtra("getUser", getUsername);
                startActivity(homeIntent);
                break;

            //Go to history page
            case R.id.nav_history:
                Intent historyIntent = new Intent(Score.this, History.class);
                //Store username data in getUser
                historyIntent.putExtra("getUser", getUsername);
                startActivity(historyIntent);
                break;

            //Go to settings page
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(Score.this, Settings.class);
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
                    Toast.makeText(Score.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
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
                Intent aboutIntent = new Intent(Score.this, AboutActivity.class);
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