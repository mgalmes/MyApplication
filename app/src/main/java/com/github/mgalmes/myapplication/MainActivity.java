package com.github.mgalmes.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MotionEventCompat;

import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("MainActivity", "Hello World");
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        System.out.println(event);

        int action = event.getAction();

        switch (action) {
            case (MotionEvent.ACTION_DOWN):
                toast("Action was DOWN");
                return true;
            case (MotionEvent.ACTION_MOVE):
                toast("Action was MOVE");
                return true;
            case (MotionEvent.ACTION_UP):
                toast("Action was UP");
                return true;
            case (MotionEvent.ACTION_CANCEL):
                toast("Action was CANCEL");
                return true;
            case (MotionEvent.ACTION_OUTSIDE):
                toast("Movement occurred outside bounds " +
                        "of current screen element");
                return true;
            default:
                return super.onTouchEvent(event);
        }
    }

    private void toast(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.text);
        textView.setText(text);
    }
}