package com.example.healthify.Shape;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.healthify.BMI.BMIModel;
import com.example.healthify.R;
import com.example.healthify.Shape.ShapeModel;

import java.util.List;

public class ShapeAdaptor extends ArrayAdapter<ShapeModel> {

    Context context;
    private int resource;
    List<ShapeModel> ShapeModels;

    ShapeAdaptor(Context context , int resource ,List<ShapeModel> ShapeModels ){
        super(context,resource,ShapeModels);

        this.context = context;
        this.resource = resource;
        this.ShapeModels = ShapeModels;


    }
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);



        TextView shape_date = row.findViewById(R.id.shape_date);
        TextView shape_Shape = row.findViewById(R.id.shape_Shape);
        TextView shape_bust = row.findViewById(R.id.shape_bust);
        TextView shape_waist = row.findViewById(R.id.shape_waist);
        TextView shape_high_hip = row.findViewById(R.id.shape_high_hip);
        TextView shape_hip = row.findViewById(R.id.shape_hip);



        ShapeModel ShapeModel = ShapeModels.get(position);


        String bust = Integer.toString(ShapeModel.getBust());
        String waist = Integer.toString(ShapeModel.getWaist());
        String high_hip = Integer.toString(ShapeModel.getHigh_hip());
        String hip = Integer.toString(ShapeModel.getHip());

        shape_date.setText(ShapeModel.getDate());
        shape_Shape.setText(ShapeModel.getResult());
        shape_bust.setText(bust);
        shape_waist.setText(waist);
        shape_high_hip.setText(high_hip);
        shape_hip.setText(hip);


        return row;
    }
}
