package com.example.count_app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String KEY = "0";

    static int count = 0;

    public void increment(View view) {
        count++;
        display(count);
    }

    private void display(int count) {
        TextView textView = findViewById(R.id.textView);
        textView.setText("" + String.format("%04d", count));
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        outState.putInt(KEY, count);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        int textViewText = savedInstanceState.getInt(KEY);
        TextView textView = findViewById(R.id.textView);
        textView.setText(String.format("%04d", textViewText));
    }
}