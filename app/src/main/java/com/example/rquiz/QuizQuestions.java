package com.example.rquiz;


import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class QuizQuestions<str> extends AppCompatActivity {

    //Initialise variables
    private QuestionList mQuestionList = new QuestionList();
    private TextView tvQuesNo;
    private TextView mQuestion;
    private TextView mScore;
    private Button mBtnChoice1;
    private Button mBtnChoice2;
    private Button mBtnChoice3;
    private Button mBtnChoice4;
    private ImageView mQuesImg;
    private String mAnswer;
    private int mScorePoint = 0;
    private int mQuesNo = 0;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_questions);

        //Find resources by id
        tvQuesNo = findViewById(R.id.questionNo);
        mBtnChoice1 = findViewById(R.id.btnChoice1);
        mBtnChoice2 = findViewById(R.id.btnChoice2);
        mBtnChoice3 = findViewById(R.id.btnChoice3);
        mBtnChoice4 = findViewById(R.id.btnChoice4);
        mScore = findViewById(R.id.score);
        mQuestion = findViewById(R.id.question);
        mQuesImg = findViewById(R.id.quesImage);

        //Update question function
        updateQuestion();

        //If button choice 1 is clicked
        mBtnChoice1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice1.getText() == mAnswer) {
                    //Score increases by 1 if correct
                    mScorePoint = mScorePoint + 1;
                    //Update question function
                    updateQuestion();
                    //Toast success message if correct
                    Toast.makeText(QuizQuestions.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast fail message if incorrect
                    Toast.makeText(QuizQuestions.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    //Update question function
                    updateQuestion();
                }
            }
        });

        //If button choice 2 is clicked
        mBtnChoice2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice2.getText() == mAnswer) {
                    //Score increases by 1 if correct
                    mScorePoint = mScorePoint + 1;
                    //Update question function
                    updateQuestion();
                    //Toast success message if correct
                    Toast.makeText(QuizQuestions.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast fail message if incorrect
                    Toast.makeText(QuizQuestions.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    //Update question function
                    updateQuestion();
                }
            }
        });

        //If button choice 3 is clicked
        mBtnChoice3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice3.getText() == mAnswer) {
                    //Sore increases by 1 if correct
                    mScorePoint = mScorePoint + 1;
                    //Update question function
                    updateQuestion();
                    //Toast success message if correct
                    Toast.makeText(QuizQuestions.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast fail message if incorrect
                    Toast.makeText(QuizQuestions.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    //Update question function
                    updateQuestion();
                }
            }
        });

        //If button choice 4 is clicked
        mBtnChoice4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mBtnChoice4.getText() == mAnswer) {
                    //Score increases by 1 if correct
                    mScorePoint = mScorePoint + 1;
                    //Update question function
                    updateQuestion();
                    //Toast success message if correct
                    Toast.makeText(QuizQuestions.this, "Correct!", Toast.LENGTH_SHORT).show();
                } else {
                    //Toast fail message if incorrect
                    Toast.makeText(QuizQuestions.this, "Incorrect!", Toast.LENGTH_SHORT).show();
                    //Update question function
                    updateQuestion();
                }
            }
        });
    }

    //Update question function
    private void updateQuestion () {

        //Get subject data from subject
        Intent intent = getIntent();
        int subject = intent.getIntExtra("subject", 0);
        //Get username data from getUser
        String getUsername = intent.getStringExtra("getUser");

        //If Maths subject was chosen
        if (subject == 0) {
            if (mQuesNo < mQuestionList.getLengthMaths()) {
                //Set text and image for questions
                mQuestion.setText(mQuestionList.getQuestionMaths(mQuesNo));
                mBtnChoice1.setText(mQuestionList.getChoice1Maths(mQuesNo));
                mBtnChoice2.setText(mQuestionList.getChoice2Maths(mQuesNo));
                mBtnChoice3.setText(mQuestionList.getChoice3Maths(mQuesNo));
                mBtnChoice4.setText(mQuestionList.getChoice4Maths(mQuesNo));
                mQuesImg.setImageResource(mQuestionList.getImageMaths(mQuesNo));

                //Get correct answer for Maths
                mAnswer = mQuestionList.getCorrectMaths(mQuesNo);
                //Increase question number
                mQuesNo++;
                //Set text for question number
                tvQuesNo.setText("Question " + mQuesNo);
            } else {
                //Toast message if last question
                Toast.makeText(QuizQuestions.this, "Last Question!", Toast.LENGTH_SHORT).show();
                //Go to score page
                Intent i = new Intent(QuizQuestions.this, Score.class);
                //Store username, score, question length and subject name
                i.putExtra("getUser", getUsername);
                i.putExtra("scoreMaths", mScorePoint);
                i.putExtra("total", mQuestionList.getLengthMaths());
                i.putExtra("subject",0);
                startActivity(i);
            }
            //Set text for score after each question
            mScore.setText("Score: " + mScorePoint + "/" + mQuestionList.getLengthMaths());
        //If Science subject was chosen
        } else if (subject == 1) {
            if (mQuesNo < mQuestionList.getLengthScience()) {
                //Set text and image for questions
                mQuestion.setText(mQuestionList.getQuestionScience(mQuesNo));
                mBtnChoice1.setText(mQuestionList.getChoice1Science(mQuesNo));
                mBtnChoice2.setText(mQuestionList.getChoice2Science(mQuesNo));
                mBtnChoice3.setText(mQuestionList.getChoice3Science(mQuesNo));
                mBtnChoice4.setText(mQuestionList.getChoice4Science(mQuesNo));
                mQuesImg.setImageResource(mQuestionList.getImageScience(mQuesNo));

                //Get correct answer for Science
                mAnswer = mQuestionList.getCorrectScience(mQuesNo);
                //Increase question number
                mQuesNo++;
                //Set text for question number
                tvQuesNo.setText("Question " + mQuesNo);
            } else {
                //Toast message if last question
                Toast.makeText(QuizQuestions.this, "Last Question!", Toast.LENGTH_SHORT).show();
                //Go to score page
                Intent i = new Intent(QuizQuestions.this, Score.class);
                //Store username, score, question length and subject name
                i.putExtra("getUser", getUsername);
                i.putExtra("scoreScience", mScorePoint);
                i.putExtra("total", mQuestionList.getLengthScience());
                i.putExtra("subject",1);
                startActivity(i);
            }
            //Set text for score after each question
            mScore.setText("Score: " + mScorePoint + "/" + mQuestionList.getLengthScience());
        //If BM subject was chosen
        } else if (subject == 2) {
            if (mQuesNo < mQuestionList.getLengthBM()) {
                //Set text and image for questions
                mQuestion.setText(mQuestionList.getQuestionBM(mQuesNo));
                mBtnChoice1.setText(mQuestionList.getChoice1BM(mQuesNo));
                mBtnChoice2.setText(mQuestionList.getChoice2BM(mQuesNo));
                mBtnChoice3.setText(mQuestionList.getChoice3BM(mQuesNo));
                mBtnChoice4.setText(mQuestionList.getChoice4BM(mQuesNo));
                mQuesImg.setImageResource(mQuestionList.getImageBM(mQuesNo));

                //Get correct answer for BM
                mAnswer = mQuestionList.getCorrectBM(mQuesNo);
                //Increase question number
                mQuesNo++;
                //Set text for question number
                tvQuesNo.setText("Question " + mQuesNo);
            } else {
                //Toast message if last question
                Toast.makeText(QuizQuestions.this, "Last Question!", Toast.LENGTH_SHORT).show();
                //Go to score page
                Intent i = new Intent(QuizQuestions.this, Score.class);
                //Store username, point, question length and subject name
                i.putExtra("getUser", getUsername);
                i.putExtra("scoreBM", mScorePoint);
                i.putExtra("total", mQuestionList.getLengthBM());
                i.putExtra("subject",2);
                startActivity(i);
            }
            //Set text for score after each question
            mScore.setText("Score: " + mScorePoint + "/" + mQuestionList.getLengthBM());
        //If English subject was chosen
        } else if (subject == 3) {
            if (mQuesNo < mQuestionList.getLengthEng()) {
                //Set text and image for questions
                mQuestion.setText(mQuestionList.getQuestionEng(mQuesNo));
                mBtnChoice1.setText(mQuestionList.getChoice1Eng(mQuesNo));
                mBtnChoice2.setText(mQuestionList.getChoice2Eng(mQuesNo));
                mBtnChoice3.setText(mQuestionList.getChoice3Eng(mQuesNo));
                mBtnChoice4.setText(mQuestionList.getChoice4Eng(mQuesNo));
                mQuesImg.setImageResource(mQuestionList.getImageEng(mQuesNo));

                //Get correct answer for English
                mAnswer = mQuestionList.getCorrectEng(mQuesNo);
                //Increase question number
                mQuesNo++;
                //Set text for question number
                tvQuesNo.setText("Question " + mQuesNo);
            } else {
                //Toast message if last question
                Toast.makeText(QuizQuestions.this, "Last Question!", Toast.LENGTH_SHORT).show();
                //Go to score page
                Intent i = new Intent(QuizQuestions.this, Score.class);
                //Store username, score, question length and subject
                i.putExtra("getUser", getUsername);
                i.putExtra("scoreEng", mScorePoint);
                i.putExtra("total", mQuestionList.getLengthEng());
                i.putExtra("subject",3);
                startActivity(i);
            }
            //Set text for score after each question
            mScore.setText("Score: " + mScorePoint + "/" + mQuestionList.getLengthEng());
        }
    }

}

