/*
Gabriel Espinosa
 */

package com.example.mathapp;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MathQuizActivity extends AppCompatActivity {

    private Questions mathQuestions = new Questions();
    private TextView questions;
    private RadioGroup answers;
    private RadioButton answer1,answer2,answer3;
    private int checkAnswer = 0;
    int counter = 0;
    final String TAG = "MathQuizActivity";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_math_quiz);

        questions = findViewById(R.id.question);
        answers = findViewById(R.id.answers);
        answer1 = findViewById(R.id.answer1);
        answer2 = findViewById(R.id.answer2);
        answer3 = findViewById(R.id.answer3);
        Button submitButton = findViewById(R.id.submit);

        newProblem();
        answers.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                Log.d(TAG,"radiogroup clicked");

                switch (checkedId)
                {
                    case R.id.answer1:
                        checkAnswer = 1;
                        break;
                    case R.id.answer2:
                        checkAnswer = 2;
                        break;
                    case R.id.answer3:
                        checkAnswer = 3;
                        break;
                }Log.d(TAG, "answer " + checkAnswer + " selected");
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean checkingAnswer;
                switch (checkAnswer)
                {
                    case 1:
                        checkingAnswer = mathQuestions.isCorrect(mathQuestions.getAnswerArr().get(0));
                        theResult(checkingAnswer);
                        break;
                    case 2:
                        checkingAnswer = mathQuestions.isCorrect(mathQuestions.getAnswerArr().get(1));
                        theResult(checkingAnswer);
                        break;
                    case 3:
                        checkingAnswer = mathQuestions.isCorrect(mathQuestions.getAnswerArr().get(2));
                        theResult(checkingAnswer);
                        break;
                        default:
                            break;
                }answers.clearCheck();
                checkAnswer = 0;
            }
        });

    }

    @Override
    protected void onResume() {
        super.onResume();
        counter++;
    }

    @Override
    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
        outState.putInt("counter",counter);
        Log.d("VIVZ", counter + " was saved");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        counter = savedInstanceState.getInt("counter");
        Log.d("VIVZ", counter + " was restored");

    }

    private void theResult(boolean anser)
    {
        if(anser)
        {
            Toast.makeText(this, "Correct",Toast.LENGTH_SHORT).show();
        }else{
            Toast.makeText(this, "Incorrect",Toast.LENGTH_SHORT).show();
        }newProblem();
    }
    private void newProblem()
    {
        questions.setText(mathQuestions.setProblem());
        answer1.setText(mathQuestions.getAnswerArr().get(0)+" ");
        answer2.setText(mathQuestions.getAnswerArr().get(1)+" ");
        answer3.setText(mathQuestions.getAnswerArr().get(2)+" ");
    }


}
