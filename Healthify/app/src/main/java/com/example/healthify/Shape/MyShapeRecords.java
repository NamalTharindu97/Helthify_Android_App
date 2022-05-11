package com.example.healthify.Shape;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.example.healthify.BMI.BMIModel;
import com.example.healthify.BMI.DbHandler_BMI;
import com.example.healthify.BodyFat.MainActivity;
import com.example.healthify.R;

import java.util.ArrayList;
import java.util.List;

public class MyShapeRecords extends AppCompatActivity {

    ListView listview;
    List<ShapeModel> ShapeModels;
    Context context;
    DbHandler_Shape db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_shape_records);

        listview = findViewById(R.id.Shape_list);
        context=this;
        db = new DbHandler_Shape(context);

        ShapeModels = new ArrayList<>();
        ShapeModels = db.getAllBodyShape();

        ShapeAdaptor shapeAdaptor = new ShapeAdaptor(context,R.layout.single_shape_row,ShapeModels);
        listview.setAdapter(shapeAdaptor);

    }


    public void openShapeUpdate(View view){

        Intent intent = new Intent(this,ShapeUpdateForm.class);
        context=this;
        db = new DbHandler_Shape(context);

        ShapeModels = new ArrayList<>();
        ShapeModels = db.getAllBodyShape();
        ShapeModel sm;
        sm = ShapeModels.get(listview.getFirstVisiblePosition());
        intent.putExtra("id" , String.valueOf(sm.getId()));

        startActivity(intent);
    }
    public void ShapeDelete(View view){

        Intent intent = new Intent(this,MyShapeRecords.class);
        context=this;
        db = new DbHandler_Shape(context);

        ShapeModels = new ArrayList<>();
        ShapeModels = db.getAllBodyShape();
        ShapeModel sp;
        sp = ShapeModels.get(listview.getFirstVisiblePosition());

        db.deleteShapeRecords(sp.getId());

        LayoutInflater li = getLayoutInflater();
        View layout = li.inflate(R.layout.new_delete_toast , findViewById(R.id.update_toast_id));

        Toast toast = new Toast(this);
        toast.setDuration(Toast.LENGTH_LONG);
        toast.setGravity(Gravity.CENTER,0,0);
        toast.setView(layout);
        toast.show();
        startActivity(intent);
    }
    public void OpenHome(View view){

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }

}