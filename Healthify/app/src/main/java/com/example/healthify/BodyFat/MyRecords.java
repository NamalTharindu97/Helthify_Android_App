package com.example.healthify.BodyFat;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healthify.R;

import java.util.ArrayList;
import java.util.List;

public class MyRecords extends AppCompatActivity {

    private ListView listview;
    private List<FatModel> fatModels;
    Context context;
    private DbHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_records);

        listview = findViewById(R.id.list_view_id);
        context=this;
        db = new DbHandler(context);

        fatModels = new ArrayList<>();
        fatModels = db.getAllBodyFats();
        bodyFatAdaptor adaptor = new bodyFatAdaptor(context,R.layout.single_row_fat,fatModels);
        listview.setAdapter(adaptor);


    }



    public void openDeleteToast(View view){
        Intent intent = new Intent(this,MyRecords.class);


        context=this;
        db = new DbHandler(context);

        fatModels = new ArrayList<>();
        fatModels = db.getAllBodyFats();
        FatModel ft;
        ft = fatModels.get(listview.getFirstVisiblePosition());

        db.deleteFatModels(ft.getId());



        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.new_delete_toast , findViewById(R.id.update_toast_id));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        toast.show();

        startActivity(intent);
    }
    public void openUpdateForm(View view){

        Intent intent = new Intent(this, UpdateForm.class);

        context=this;
        db = new DbHandler(context);

        fatModels = new ArrayList<>();
        fatModels = db.getAllBodyFats();
        FatModel ft;
        ft = fatModels.get(listview.getFirstVisiblePosition());
        intent.putExtra("id" , String.valueOf(ft.getId()));


        startActivity(intent);
    }
    public void openHomeForm(View view){
        Intent intent = new Intent(this, MainActivity.class);

        startActivity(intent);
    }
}