package com.example.healthify.Shape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;


import com.example.healthify.BMI.BMIModel;
import com.example.healthify.BMI.DbHandler_BMI;
import com.example.healthify.R;

public class ShapeForm extends AppCompatActivity {

    EditText bust;
    EditText waist;
    EditText high_hip;
    EditText hip;
    TextView shape_result;

    int BUST;
    int WAIST;
    int HIGH_HIP;
    int HIP;

    Context context;
    DbHandler_Shape db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shape_form);


        bust = findViewById(R.id.ed_shape_bust);
        waist = findViewById(R.id.ed_shape_waist);
        high_hip = findViewById(R.id.ed_shape_Hight_hip);
        hip = findViewById(R.id.ed_shape_hip);
        shape_result = findViewById(R.id.Shape_result);

    }


    public void ShapeCalculate(View view){

        String Bust = bust.getText().toString();
        String Waist = waist.getText().toString();
        String High_hip = high_hip.getText().toString();
        String Hip = hip.getText().toString();

        BUST = Integer.parseInt(Bust);
        WAIST = Integer.parseInt(Waist);
        HIGH_HIP = Integer.parseInt(High_hip);
        HIP = Integer.parseInt(Hip);

        ShapeBody shapeBody = new ShapeBody(BUST,WAIST,HIGH_HIP,HIP);
        String shapeResult = shapeBody.ShapeCalculation();
        shape_result.setText(shapeResult);


    }

    public void openShapeRecords(View view){

        Intent intent = new Intent(this,MyShapeRecords.class);
        String Bust = bust.getText().toString();
        String Waist = waist.getText().toString();
        String High_hip = high_hip.getText().toString();
        String Hip = hip.getText().toString();

        BUST = Integer.parseInt(Bust);
        WAIST = Integer.parseInt(Waist);
        HIGH_HIP = Integer.parseInt(High_hip);
        HIP = Integer.parseInt(Hip);

        ShapeBody shapeBody = new ShapeBody(BUST,WAIST,HIGH_HIP,HIP);
        String shapeResult = shapeBody.ShapeCalculation();
        shape_result.setText(shapeResult);

        String date = shapeBody.getDateTime();

        context=this;
        db = new DbHandler_Shape(context);
        ShapeModel shapeModel = new ShapeModel(shapeResult,BUST,WAIST,HIGH_HIP,HIP,date);
        db.AddBodyShape(shapeModel);


        startActivity(intent);
    }
}