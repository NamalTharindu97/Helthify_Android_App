package com.example.healthify.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthify.R;

public class bodyFatCalculatorHome extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_body_fat_calculator_home);
    }
    public void openForm(View view){

        Intent intent = new Intent(this, FormFile.class);
        startActivity(intent);
    }
    public void openRecords(View view){

        Intent intent = new Intent(this, MyRecords.class);
        startActivity(intent);
    }
}