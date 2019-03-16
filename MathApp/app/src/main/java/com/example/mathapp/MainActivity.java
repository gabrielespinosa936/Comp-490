/*
Gabriel Espinosa
 */
package com.example.mathapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private Button mathButton,mathTutorialButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mathButton = findViewById(R.id.mathQuizButton);
        mathTutorialButton = findViewById(R.id.tutorialButton);


        mathButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent mathIntent = new Intent(MainActivity.this, MathQuizActivity.class);
                startActivity(mathIntent);

            }
        });

        mathTutorialButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tutorialIntent = new Intent(MainActivity.this,MathTutorial.class);
                startActivity(tutorialIntent);
            }
        });



    }
}
