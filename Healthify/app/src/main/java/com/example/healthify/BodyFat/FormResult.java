package com.example.healthify.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.healthify.R;


public class FormResult extends AppCompatActivity {

    TextView result;
    Context context;
    DbHandler db;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form_result);

        result = findViewById(R.id.bodyFatResult);

        Intent intent = getIntent();

        Bundle bundle = intent.getExtras();

        String FinalResult = bundle.getString("final");
        String date = bundle.getString("date");
        String gender = bundle.getString("gender");
        String age = bundle.getString("age");
        String height = bundle.getString("height");
        String waist = bundle.getString("waist");
        String hip = bundle.getString("hip");
        String neck = bundle.getString("neck");
        String weight = bundle.getString("weight");

        result.setText(FinalResult);

        int AGE = Integer.parseInt(age);
        int HEIGHT = Integer.parseInt(height);
        int WAIST = Integer.parseInt(waist);
        int HIP = Integer.parseInt(hip);
        int NECK = Integer.parseInt(neck);
        int WEIGHT = Integer.parseInt(weight);

        context=this;
        db = new DbHandler(context);

        FatModel fatModel = new FatModel(FinalResult,AGE,HEIGHT,WAIST,HIP,NECK,WEIGHT,date);
        db.AddBodyFat(fatModel);

    }


    public void GenerateToast(View view){

        Intent i = new Intent(this, bodyFatCalculatorHome.class);



        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.new_toast , findViewById(R.id.update_toast_id));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        toast.show();

        startActivity(i);

    }
    public void Cancel(View view){
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}