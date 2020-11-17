package com.github.mgalmes.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.github.mgalmes.myapplication.model.Answer;
import com.github.mgalmes.myapplication.model.Question;

public class MainActivity extends AppCompatActivity {

    private final Quiz quiz = new Quiz(new Question[] {
            new Question("What's 2+2",new Answer("4",true),new Answer("3",false)),
            new Question("What's 2+5",new Answer("3",false),new Answer("7",true)),
            new Question("What's 11-5",new Answer("16",false),new Answer("6",true)),
            new Question("What's 66+33",new Answer("99",true),new Answer("100",false)),
    });
    private View.OnClickListener option1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectAnswer(quiz.getCurrentQuestion().getOption1());
        }
    };
    private View.OnClickListener option2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            selectAnswer(quiz.getCurrentQuestion().getOption2());
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeQuestion(quiz.getQuestionList().get(0));
        Log.d("MainActivity", "Hello World");

        Button prev = findViewById(R.id.prevQuestion);
        Button next = findViewById(R.id.nextQuestion);
        prev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = quiz.getQuestionList().indexOf(quiz.getCurrentQuestion());
                if (index==0) return;
                changeQuestion(quiz.getQuestionList().get(index-1));
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int index = quiz.getQuestionList().indexOf(quiz.getCurrentQuestion());
                if (index==quiz.getQuestionList().size()-1) return;
                changeQuestion(quiz.getQuestionList().get(index+1));
            }
        });
    }

    private void changeQuestion(Question question) {
        quiz.setCurrentQuestion(question);
        showQuestionText(question.getText());
        showOptionsText(question.getOption1().getText(),question.getOption2().getText());
    }

    private void selectAnswer(Answer answer) {
        System.out.println(answer.getText());
        if (answer.isCorrect()) {
            toast("Correct!");
        } else {
            toast("Incorrect!");
        }
    }

    private void showQuestionText(String text) {
        TextView textView = findViewById(R.id.question);
        textView.setText(text);
    }

    private void showOptionsText(String opt1, String opt2) {
        Button button1 = findViewById(R.id.opt1);
        Button button2 = findViewById(R.id.opt2);
        button1.setText(opt1);
        button2.setText(opt2);
        button1.setOnClickListener(option1Listener);
        button2.setOnClickListener(option2Listener);
    }

    private void toast(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
    }
}