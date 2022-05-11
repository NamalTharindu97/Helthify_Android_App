package com.example.healthify.BMI;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BMI {
    private int feet ;
    private int inches;
    private int bmi_weight;

    public BMI() {
    }

    public BMI(int feet, int inches, int bmi_weight) {
        this.feet = feet;
        this.inches = inches;
        this.bmi_weight = bmi_weight;
    }

    public int getFeet() {
        return feet;
    }

    public void setFeet(int feet) {
        this.feet = feet;
    }

    public int getInches() {
        return inches;
    }

    public void setInches(int inches) {
        this.inches = inches;
    }

    public int getBmi_weight() {
        return bmi_weight;
    }

    public void setBmi_weight(int bmi_weight) {
        this.bmi_weight = bmi_weight;
    }


    public double bmiCalculation(){


        double HeightInCm =  (((feet*12) + inches) * 2.5);
        double HeightInM  = (HeightInCm / 100 );

       double BMIVaL = bmi_weight / (HeightInM * HeightInM);
       return BMIVaL;
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
