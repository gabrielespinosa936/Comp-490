package com.example.mathapp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Questions {
    private Random rando = new Random();
    private static int correctAnswer = 0;
    private static List<Integer> answerArr = new ArrayList<>();

    String setProblem()
    {
        answerArr.clear();
        int leftAdder = rando.nextInt(100)+1;
        int rightAdder = rando.nextInt(100)+1;
        correctAnswer = leftAdder + rightAdder;

        int incorrectAns1 = rando.nextInt(100) + 1;
        int incorrectAns2 = rando.nextInt(200) + 1;

        if(incorrectAns1 == correctAnswer)
        {
            incorrectAns1 = incorrectAns1 + rando.nextInt(25)+1;
        }
        if(incorrectAns2 == correctAnswer)
        {
        incorrectAns2 = incorrectAns2 + rando.nextInt(25) + 1;
        }
        if(incorrectAns1 == incorrectAns2)
        {
            incorrectAns1 = incorrectAns1 + rando.nextInt(25)+1;
        }
        answerArr.add(correctAnswer);
        answerArr.add(incorrectAns1);
        answerArr.add(incorrectAns2);
        Collections.sort(answerArr);
        return leftAdder + " + " + rightAdder + " = ?";

    }
    boolean isCorrect(int var)
    {
        return correctAnswer == var;
    }
    List<Integer>getAnswerArr()
    {
        return answerArr;
    }


}
