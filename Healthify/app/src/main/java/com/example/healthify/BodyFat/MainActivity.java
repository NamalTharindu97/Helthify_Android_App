package com.example.healthify.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.healthify.BMI.BmiForm;
import com.example.healthify.R;
import com.example.healthify.Shape.ShapeForm;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void openBodyFatHome(View view){

        Intent intent = new Intent(this, bodyFatCalculatorHome.class);
        startActivity(intent);
    }
    public void Cancel(View view){
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
    public void openBmiHome(View view){

        Intent intent = new Intent(this, BmiForm.class);
        startActivity(intent);
    }
    public void openShapeForm(View view){

        Intent intent = new Intent(this, ShapeForm.class);
        startActivity(intent);
    }


}