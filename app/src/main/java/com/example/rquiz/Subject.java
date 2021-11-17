package com.example.rquiz;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

public class Subject extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    //Initialise variables
    private ListView mListView;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mActionBarDrawerToggle;
    private Toolbar mToolbar;
    private NavigationView mNavView;
    private View mMenuHeader;
    private TextView mUsername;
    private ScoreDatabase ScoreDatabase;
    private DatabaseHelper db;

    @Override
    protected void onCreate(@NonNull Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.subject);

        //Find resources by id
        mListView = findViewById(R.id.listView);
        mToolbar = findViewById(R.id.toolbar);
        mDrawerLayout = findViewById(R.id.drawer_layout);
        mNavView = findViewById(R.id.nav_view);
        mMenuHeader = mNavView.getHeaderView(0);
        mUsername = mMenuHeader.findViewById(R.id.username);
        ScoreDatabase = new ScoreDatabase(this);
        db = new DatabaseHelper(this);

        //Get username from getUser
        Intent i = getIntent();
        String getUsername = i.getStringExtra("getUser");
        //Check setting preferences and retrieve the settings
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(getBaseContext());
        //Set text (player name)
        // check keys to retrieve player name
        mUsername.setText(sharedPref.getString("pref_player_name", "Player"));

        //aCtivate tool bar
        setSupportActionBar(mToolbar);
        //Disable the table at tool bar
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        //Let the view be in front of the activity
        mNavView.bringToFront();

        //Toggle drawer layout from toolbar
        mActionBarDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar,R.string.openNavDrawer,R.string.closeNavDrawer);

        //Toggle is the listener
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        mActionBarDrawerToggle.syncState();;

        //Set navigation
        mNavView.setNavigationItemSelectedListener(this);

        //Create arrayList
        ArrayList<SubjectName> arrayList = new ArrayList<>();

        //Add subject data into arrayList
        arrayList.add(new SubjectName(R.drawable.math, "Mathematics", "Level: Standard 1\nTopics: Numbers, Shapes" ));
        arrayList.add(new SubjectName(R.drawable.science, "Science", "Level: Standard 1\nTopic: Animals" ));
        arrayList.add(new SubjectName(R.drawable.bm, "BM", "Tahap: Darjah 1\nTopik: Ejaan" ));
        arrayList.add(new SubjectName(R.drawable.english, "English", "Level: Standard 1\nTopic: Vocabulary" ));

        //Adapt arrayList data into XML layout
        SubjectAdapter subjectAdapter = new SubjectAdapter(this,R.layout.list_row, arrayList);

        //Set adapter
        mListView.setAdapter(subjectAdapter);

        //If one of list view items is clicked
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Go to quiz questions page
                Intent intent = new Intent(Subject.this, QuizQuestions.class);
                //Store username in getUser
                intent.putExtra("getUser", getUsername);

                switch(position){
                    case 0:
                        //Toast the subject name
                        Toast.makeText(Subject.this, "Mathematics", Toast.LENGTH_SHORT).show();
                        //Assign index number to subject
                        intent.putExtra("subject", 0);
                        break;
                    case 1:
                        //Toast the subject name
                        Toast.makeText(Subject.this, "Science", Toast.LENGTH_SHORT).show();
                        //Assign index number to subject
                        intent.putExtra("subject", 1);
                        break;
                    case 2:
                        //Toast the subject name
                        Toast.makeText(Subject.this, "BM", Toast.LENGTH_SHORT).show();
                        //Assign index number to subject
                        intent.putExtra("subject", 2);
                        break;
                    case 3:
                        //Toast the subject name
                        Toast.makeText(Subject.this, "English", Toast.LENGTH_SHORT).show();
                        //Assign index number to subject
                        intent.putExtra("subject", 3);
                        break;
                }
                startActivity(intent);
            }
        });

    }

    //Open and close drawer
    @Override
    public void onBackPressed(){
        if (mDrawerLayout.isDrawerOpen(GravityCompat.START)) {
            mDrawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        //Receive username data from getUser
        Intent newIntent = getIntent();
        String getUsername = newIntent.getStringExtra("getUser");
        //Switch case for each item in toolbar action menu
        switch(item.getItemId()){
            //Go to home page
            case R.id.nav_home:
                Intent homeIntent = new Intent(Subject.this, Subject.class);
                //Store username data in getUser
                homeIntent.putExtra("getUser", getUsername);
                startActivity(homeIntent);
                break;

            //Go to history page
            case R.id.nav_history:
                Intent historyIntent = new Intent(Subject.this, History.class);
                //Store username data in getUser
                historyIntent.putExtra("getUser", getUsername);
                startActivity(historyIntent);
                break;

            //Go to settings page
            case R.id.nav_settings:
                Intent settingsIntent = new Intent(Subject.this, Settings.class);
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
                    Toast.makeText(Subject.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
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
                Intent aboutIntent = new Intent(Subject.this, AboutActivity.class);
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

        //drawer will close (drawer's job is done so done)
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }

}

