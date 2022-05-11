package com.example.healthify.BMI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.healthify.BodyFat.DbHandler;
import com.example.healthify.BodyFat.MainActivity;
import com.example.healthify.R;

import java.text.DecimalFormat;

public class BmiForm extends AppCompatActivity {

    EditText feet;
    EditText inches;
    EditText bmi_weight;
    TextView bmi_result;

    int FEET;
    int INCHES;
    int BMI_WEIGHT;

    TextView result;
    Context context;
    DbHandler_BMI db;

    private static final DecimalFormat df = new DecimalFormat("0.00");




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_form);

        feet = findViewById(R.id.ed_bmi_height_feet);
        inches = findViewById(R.id.ed_bmi_inches);
        bmi_weight = findViewById(R.id.ed_bmi_weight);
        bmi_result = findViewById(R.id.bmi_result);

    }


    public void calculteBmi(View view){

        String Feet = feet.getText().toString();
        String Inches = inches.getText().toString();
        String Bmi_weight = bmi_weight.getText().toString();

        FEET = Integer.parseInt(Feet);
        INCHES = Integer.parseInt(Inches);
        BMI_WEIGHT = Integer.parseInt(Bmi_weight);

        BMI bmi = new BMI(FEET,INCHES,BMI_WEIGHT);
        double bmiResult = bmi.bmiCalculation();

        String f1 = Double.toString(bmiResult);

        bmi_result.setText(f1);

    }


    public void openRecords(View view){

        Intent intent = new Intent(this, bmiRecords.class);

        String Feet = feet.getText().toString();
        String Inches = inches.getText().toString();
        String Bmi_weight = bmi_weight.getText().toString();

        FEET = Integer.parseInt(Feet);
        INCHES = Integer.parseInt(Inches);
        BMI_WEIGHT = Integer.parseInt(Bmi_weight);

        BMI bmi = new BMI(FEET,INCHES,BMI_WEIGHT);
        double bmiResult = bmi.bmiCalculation();
        String date = bmi.getDateTime();

        String f1 = Double.toString(Double.parseDouble(df.format(bmiResult)));


        context=this;
        db = new DbHandler_BMI(context);
        BMIModel bmiModel = new BMIModel(f1,FEET,INCHES,BMI_WEIGHT,date);
        db.AddBMI(bmiModel);

        startActivity(intent);


    }
    public void openHome(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}