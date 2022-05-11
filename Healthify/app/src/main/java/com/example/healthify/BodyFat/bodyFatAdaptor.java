package com.example.healthify.BodyFat;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.healthify.R;

import java.util.List;

public class bodyFatAdaptor extends ArrayAdapter<FatModel> {


        Context context;
        private int resource;
        List<FatModel> fatModels;

    bodyFatAdaptor(Context context , int resource , List<FatModel> fatModels ){
        super(context , resource , fatModels);

        this.context = context;
        this.resource = resource;
        this.fatModels = fatModels;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View row = inflater.inflate(resource,parent,false);



        TextView Age = row.findViewById(R.id.textView12);
        TextView Height = row.findViewById(R.id.textView13);
        TextView Neck = row.findViewById(R.id.textView14);
        TextView Waist = row.findViewById(R.id.textView15);
        TextView Hip = row.findViewById(R.id.textView16);
        TextView Weight = row.findViewById(R.id.textView17);
        TextView date = row.findViewById(R.id.result_txt2);
        TextView result = row.findViewById(R.id.result_txt);


        FatModel fatModel = fatModels.get(position);

        String age = Integer.toString(fatModel.getAge());
        String height = Integer.toString(fatModel.getHeight());
        String neck = Integer.toString(fatModel.getNeck());
        String waist = Integer.toString(fatModel.getWeist());
        String hip = Integer.toString(fatModel.getHip());
        String weight = Integer.toString(fatModel.getWeight());

        Age.setText(age);
        Height.setText(height);
        Neck.setText(neck);
        Waist.setText(waist);
        Hip.setText(hip);
        Weight.setText(weight);
        date.setText(fatModel.getDate());
        result.setText(fatModel.getResult());


        return row;

    }
}






















