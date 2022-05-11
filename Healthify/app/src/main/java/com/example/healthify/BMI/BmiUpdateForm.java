package com.example.healthify.BMI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthify.BodyFat.DbHandler;
import com.example.healthify.BodyFat.FatModel;
import com.example.healthify.R;

import java.text.DecimalFormat;
import java.util.List;

public class BmiUpdateForm extends AppCompatActivity {

    EditText update_feet;
    EditText update_inches;
    EditText update_weight;
    TextView update_result;

    int FEET;
    int INCHES;
    int BMI_WEIGHT;


    Context context;
    DbHandler_BMI db;

    private static final DecimalFormat df = new DecimalFormat("0.00");


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_update_form);

        update_feet = findViewById(R.id.update_feet);
        update_inches = findViewById(R.id.update_inches);
        update_weight = findViewById(R.id.update_weight);
        update_result = findViewById(R.id.update_result);

        context=this;
        db = new DbHandler_BMI(context);
        String id = getIntent().getStringExtra("id");

        BMIModel bmiModel = db.getSingleBMI(Integer.parseInt(id));

        String feet = Integer.toString(bmiModel.getFeet());
        String inches = Integer.toString(bmiModel.getInches());
        String weight = Integer.toString(bmiModel.getWeight());

        update_feet.setText(feet);
        update_inches.setText(inches);
        update_weight.setText(weight);
        update_result.setText(bmiModel.getResult());


    }
    public void bmiUpdate(View view){

        Intent intent = new Intent(this, bmiRecords.class);

        String Feet = update_feet.getText().toString();
        String Inches = update_inches.getText().toString();
        String Bmi_weight = update_weight.getText().toString();

        FEET = Integer.parseInt(Feet);
        INCHES = Integer.parseInt(Inches);
        BMI_WEIGHT = Integer.parseInt(Bmi_weight);

        BMI bmi = new BMI(FEET,INCHES,BMI_WEIGHT);
        double bmiResult = bmi.bmiCalculation();
        String date = bmi.getDateTime();

        String f1 = Double.toString(Double.parseDouble(df.format(bmiResult)));


        context=this;
        db = new DbHandler_BMI(context);
        String id = getIntent().getStringExtra("id");

        BMIModel bmiModel = new BMIModel(Integer.parseInt(id),f1,FEET,INCHES,BMI_WEIGHT,date );
        db.updateSingleBMI(bmiModel);


        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.update_toast , findViewById(R.id.update_toast_id));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        toast.show();

        startActivity(intent);
    }
    public void calculteBmi(View view){


        String Feet = update_feet.getText().toString();
        String Inches = update_inches.getText().toString();
        String Bmi_weight = update_weight.getText().toString();

        FEET = Integer.parseInt(Feet);
        INCHES = Integer.parseInt(Inches);
        BMI_WEIGHT = Integer.parseInt(Bmi_weight);

        BMI bmi = new BMI(FEET,INCHES,BMI_WEIGHT);
        double bmiResult = bmi.bmiCalculation();
        String date = bmi.getDateTime();

        String f1 = Double.toString(Double.parseDouble(df.format(bmiResult)));
        update_result.setText(f1);


    }
}