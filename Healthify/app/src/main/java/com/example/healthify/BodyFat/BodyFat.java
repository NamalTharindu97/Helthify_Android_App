package com.example.healthify.BodyFat;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class BodyFat {


    private String gender;
    private int age ;
    private int height;
    private int waist;
    private int hip;
    private int neck;
    private int weight;

    public BodyFat(String gender, int age, int height, int waist, int hip,int neck,int weight) {

        this.gender = gender;
        this.age = age;
        this.height = height;
        this.waist = waist;
        this.hip = hip;
        this.neck = neck;
        this.weight = weight;
    }

    public BodyFat(int age, int height, int waist, int hip, int neck, int weight) {
        this.age = age;
        this.height = height;
        this.waist = waist;
        this.hip = hip;
        this.neck = neck;
        this.weight = weight;
    }

    public BodyFat() {

    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHip() {
        return hip;
    }

    public void setHip(int hip) {
        this.hip = hip;
    }

    public int getNeck() {
        return neck;
    }

    public void setNeck(int neck) {
        this.neck = neck;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public double calculate() {

        if (this.gender.equals("male")) {

            double result = 86.010 * Math.log10(this.waist - this.neck) - 70.041 * Math.log10(this.height) + 30.30;
            int value = (int) result;
            return value;


        } else {
            double result = 163.205 * Math.log10(this.waist + this.hip - this.neck) - 97.684 * Math.log10(this.height) - 104.912;
            int value = (int) result;
            return value;
        }
    }

    public double updateCalculation(){

        double result = 86.010 * Math.log10(this.waist - this.neck) - 70.041 * Math.log10(this.height) + 30.30;
        int value = (int) result;
        return value;
    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}

