package com.example.healthify.BMI;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.healthify.BodyFat.FatModel;
import com.example.healthify.R;

import java.util.List;

public class BMI_Adaptor extends ArrayAdapter<BMIModel> {
    Context context;
    private int resource;
    List<BMIModel> bmiModels;

    BMI_Adaptor(Context context , int resource , List<BMIModel> bmiModels ){
        super(context,resource,bmiModels);

        this.context = context;
        this.resource = resource;
        this.bmiModels = bmiModels;


    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);



        TextView date = row.findViewById(R.id.bmi_id_date);
        TextView result = row.findViewById(R.id.bmi_id_bmi);
        TextView feet = row.findViewById(R.id.bmi_id_height_feet);
        TextView inches = row.findViewById(R.id.bmi_id_height_inches);
        TextView weight = row.findViewById(R.id.bmi_id_weight);



        BMIModel bmiModel = bmiModels.get(position);


        String Feet = Integer.toString(bmiModel.getFeet());
        String Inches = Integer.toString(bmiModel.getInches());
        String Weight = Integer.toString(bmiModel.getWeight());

        date.setText(bmiModel.getDate());
        result.setText(bmiModel.getResult());
        feet.setText(Feet);
        inches.setText(Inches);
        weight.setText(Weight);


        return row;
    }
}
