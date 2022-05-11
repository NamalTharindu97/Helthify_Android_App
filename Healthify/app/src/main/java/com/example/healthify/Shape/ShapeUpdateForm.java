package com.example.healthify.Shape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthify.BMI.BMI;
import com.example.healthify.BMI.BMIModel;
import com.example.healthify.BMI.DbHandler_BMI;
import com.example.healthify.R;

public class ShapeUpdateForm extends AppCompatActivity {

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
        setContentView(R.layout.activity_shape_update_form);

        bust = findViewById(R.id.ed_shape_bust);
        waist = findViewById(R.id.ed_shape_waist);
        high_hip = findViewById(R.id.ed_shape_Hight_hip);
        hip = findViewById(R.id.ed_shape_hip);
        shape_result = findViewById(R.id.Shape_result);

        context=this;
        db = new DbHandler_Shape(context);
        String id = getIntent().getStringExtra("id");

        ShapeModel shapeModel = db.getSingleShape(Integer.parseInt(id));

        String Bust = Integer.toString(shapeModel.getBust());
        String weist = Integer.toString(shapeModel.getWaist());
        String High = Integer.toString(shapeModel.getHigh_hip());
        String Hip = Integer.toString(shapeModel.getHip());

        bust.setText(Bust);
        waist.setText(weist);
        high_hip.setText(High);
        hip.setText(Hip);
        shape_result.setText(shapeModel.getResult());
    }
    public void shapeCalculateUpdate(View view){

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

    public void UpdateShape(View view){

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
        String id = getIntent().getStringExtra("id");

        ShapeModel shapeModel = new ShapeModel(Integer.parseInt(id),shapeResult,BUST,WAIST,HIGH_HIP,HIP,date);
        db.updateSingleShape(shapeModel);

        startActivity(intent);
    }



}