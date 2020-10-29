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

    private void toast(String text) {
        Toast.makeText(getApplicationContext(),text,Toast.LENGTH_SHORT).show();
        TextView textView = findViewById(R.id.text);
        textView.setText(text);
    }
}