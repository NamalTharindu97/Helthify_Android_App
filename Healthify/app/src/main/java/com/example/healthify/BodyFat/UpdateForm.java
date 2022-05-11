package com.example.healthify.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;


import com.example.healthify.BodyFat.BodyFat;
import com.example.healthify.BodyFat.DbHandler;
import com.example.healthify.BodyFat.FatModel;
import com.example.healthify.BodyFat.MyRecords;
import com.example.healthify.R;

import java.util.List;

public class UpdateForm extends AppCompatActivity {

    EditText up_age;
    EditText up_height;
    EditText up_waist;
    EditText up_hip;
    EditText up_neck;
    EditText up_weight;

    Button update;


    ListView listview;
    List<FatModel> fatModels;
    Context context;
    DbHandler db;

    int AGE;
    int HEIGHT;
    int WAIST;
    int HIP;
    int NECK;
    int WEIGHT;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_form);

        up_age = findViewById(R.id.up_age);
        up_height = findViewById(R.id.up_height);
        up_waist = findViewById(R.id.up_waist);
        up_hip = findViewById(R.id.up_hip);
        up_neck = findViewById(R.id.up_neck);
        up_weight = findViewById(R.id.up_weight);

        context=this;
        db = new DbHandler(context);
        String id = getIntent().getStringExtra("id");


        FatModel ft = db.getSingleFatModel(Integer.parseInt(id));

        String age = Integer.toString(ft.getAge());
        String height = Integer.toString(ft.getHeight());
        String waist = Integer.toString(ft.getWeist());
        String hip = Integer.toString(ft.getHip());
        String neck = Integer.toString(ft.getNeck());
        String weight = Integer.toString(ft.getWeight());

        up_age.setText(age);
        up_height.setText(height);
        up_waist.setText(waist);
        up_hip.setText(hip);
        up_neck.setText(neck);
        up_weight.setText(weight);

        update = findViewById(R.id.Update_btn);

     /*   update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String update_age = up_age.getText().toString();
                String update_height = up_height.getText().toString();
                String update_waist = up_waist.getText().toString();
                String update_hip = up_hip.getText().toString();
                String update_neck = up_neck.getText().toString();
                String update_weight = up_weight.getText().toString();

                AGE = Integer.parseInt(update_age);
                HEIGHT = Integer.parseInt(update_height);
                WAIST = Integer.parseInt(update_waist);
                HIP = Integer.parseInt(update_hip);
                NECK = Integer.parseInt(update_neck);
                WEIGHT = Integer.parseInt(update_weight);

                BodyFat b1 = new BodyFat(AGE,HEIGHT,WAIST,HIP,NECK,WEIGHT);
                double finalResult =  b1.calculate();
                String update_result = Double.toString(finalResult);

                FatModel ft = new FatModel(Integer.parseInt(id),update_result,AGE,HEIGHT,WAIST,HIP,NECK,WEIGHT );



                startActivity(new Intent(context,MyRecords.class));
            }
        });*/

    }

    public void UpdateCalculation(View view){
        Intent intent = new Intent(this, MyRecords.class);

        String update_age = up_age.getText().toString();
        String update_height = up_height.getText().toString();
        String update_waist = up_waist.getText().toString();
        String update_hip = up_hip.getText().toString();
        String update_neck = up_neck.getText().toString();
        String update_weight = up_weight.getText().toString();

        AGE = Integer.parseInt(update_age);
        HEIGHT = Integer.parseInt(update_height);
        WAIST = Integer.parseInt(update_waist);
        HIP = Integer.parseInt(update_hip);
        NECK = Integer.parseInt(update_neck);
        WEIGHT = Integer.parseInt(update_weight);

        BodyFat b1 = new BodyFat(AGE,HEIGHT,WAIST,HIP,NECK,WEIGHT);
        double finalResult =  b1.updateCalculation();
        String update_result = Double.toString(finalResult);

        String id = getIntent().getStringExtra("id");
        String date = b1.getDateTime();

        FatModel fatModel = new FatModel(Integer.parseInt(id),update_result,AGE,HEIGHT,WAIST,HIP,NECK,WEIGHT,date );
        context=this;
        db = new DbHandler(context);
        db.updateSingleBodyFat(fatModel);

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.update_toast , findViewById(R.id.update_toast_id));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        toast.show();

        startActivity(intent);
    }


}