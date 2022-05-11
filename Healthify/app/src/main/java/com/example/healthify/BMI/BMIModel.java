package com.example.healthify.BMI;

public class BMIModel {
    private int id;
    private String result;
    private int feet;
    private int inches;
    private int weight;
    private String date;

    public BMIModel() {
    }

    public BMIModel(int id, String result, int feet, int inches, int weight, String date) {
        this.id = id;
        this.result = result;
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
        this.date = date;
    }

    public BMIModel(String result, int feet, int inches, int weight, String date) {
        this.result = result;
        this.feet = feet;
        this.inches = inches;
        this.weight = weight;
        this.date = date;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
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

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
