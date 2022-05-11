package com.example.healthify.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.example.healthify.R;

import java.text.DecimalFormat;

public class FormFile extends AppCompatActivity {

    EditText et_gender;
    EditText et_age;
    EditText et_height;
    EditText et_waist;
    EditText et_hip;
    EditText et_neck;
    EditText et_weight;


    int AGE;
    int HEIGHT;
    int WAIST;
    int HIP;
    int NECK;
    int WEIGHT;

    private static final DecimalFormat df = new DecimalFormat("0.00");
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_file);

        et_gender = findViewById(R.id.et_gender);
        et_age = findViewById(R.id.et_age);
        et_height = findViewById(R.id.et_height);
        et_waist = findViewById(R.id.et_waist);
        et_hip = findViewById(R.id.et_hip);
        et_neck = findViewById(R.id.et_neck);
        et_weight = findViewById(R.id.et_weight);



    }
    public void openFormResult(View view){

        Intent intent = new Intent(this, FormResult.class);


        String gender = et_gender.getText().toString();
        String age = et_age.getText().toString();
        String height = et_height.getText().toString();
        String waist = et_waist.getText().toString();
        String hip = et_hip.getText().toString();
        String neck = et_neck.getText().toString();
        String weight = et_weight.getText().toString();


        AGE = Integer.parseInt(age);
        HEIGHT = Integer.parseInt(height);
        WAIST = Integer.parseInt(waist);
        HIP = Integer.parseInt(hip);
        NECK = Integer.parseInt(neck);
        WEIGHT = Integer.parseInt(weight);

        BodyFat b1 = new BodyFat(gender,AGE,HEIGHT,WAIST,HIP,NECK,WEIGHT);
        double finalResult =  b1.calculate();

        String f1 = Double.toString(Double.parseDouble(df.format(finalResult)));
        String Age = Integer.toString(AGE);
        String Height = Integer.toString(HEIGHT);
        String Waist = Integer.toString(WAIST);
        String Hip = Integer.toString(HIP);
        String Neck = Integer.toString(NECK);
        String Weight = Integer.toString(WEIGHT);

       // intent.putExtra("final" , f1);

        String date = b1.getDateTime();


        Bundle bundle = new Bundle();
        bundle.putString("date" , date);
        bundle.putString("gender" , gender);
        bundle.putString("final" , f1);
        bundle.putString("age" , Age);
        bundle.putString("height" , Height);
        bundle.putString("waist" , Waist);
        bundle.putString("hip" , Hip);
        bundle.putString("neck" , Neck);
        bundle.putString("weight" , Weight);
        intent.putExtras(bundle);


        startActivity(intent);
    }
}