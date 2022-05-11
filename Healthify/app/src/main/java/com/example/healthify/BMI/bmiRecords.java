package com.example.healthify.BMI;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healthify.BodyFat.DbHandler;
import com.example.healthify.BodyFat.FatModel;
import com.example.healthify.BodyFat.MyRecords;
import com.example.healthify.R;

import java.util.ArrayList;
import java.util.List;

public class bmiRecords extends AppCompatActivity {

    private ListView listview;
    private List<BMIModel> bmiModels;
    Context context;
    private DbHandler_BMI db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi_records);

        listview = findViewById(R.id.bmi_list_view);
        context=this;
        db = new DbHandler_BMI(context);

        bmiModels = new ArrayList<>();
        bmiModels = db.getAllBMI();

        BMI_Adaptor bmi_adaptor = new BMI_Adaptor(context,R.layout.single_row_bmi,bmiModels);
        listview.setAdapter(bmi_adaptor);

    }

    public void bmidelete(View view){
        Intent intent = new Intent(this,bmiRecords.class);
        context=this;
        db = new DbHandler_BMI(context);

        bmiModels = new ArrayList<>();
        bmiModels = db.getAllBMI();
        BMIModel bm;
        bm = bmiModels.get(listview.getFirstVisiblePosition());

        db.deleteBmiRecords(bm.getId());

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.new_delete_toast , findViewById(R.id.update_toast_id));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        toast.show();
        startActivity(intent);
    }

    public void updateNavigate(View view){

        Intent intent = new Intent(this, BmiUpdateForm.class);

        context=this;
        db = new DbHandler_BMI(context);

        bmiModels = new ArrayList<>();
        bmiModels = db.getAllBMI();
        BMIModel bm;
        bm = bmiModels.get(listview.getFirstVisiblePosition());
        intent.putExtra("id" , String.valueOf(bm.getId()));


        startActivity(intent);
        startActivity(intent);
    }



    public void bmiHomeNavigate(View view){

        Intent intent = new Intent(this, BmiForm.class);
        startActivity(intent);
    }

}