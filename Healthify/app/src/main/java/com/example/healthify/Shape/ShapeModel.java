package com.example.healthify.Shape;

public class ShapeModel {
    private int id;
    private String result;
    private int bust;
    private int waist;
    private int high_hip;
    private int hip;
    private String date;

    public ShapeModel() {
    }

    public ShapeModel(int id, String result, int bust, int waist, int high_hip, int hip, String date) {
        this.id = id;
        this.result = result;
        this.bust = bust;
        this.waist = waist;
        this.high_hip = high_hip;
        this.hip = hip;
        this.date = date;
    }

    public ShapeModel(String result, int bust, int waist, int high_hip, int hip, String date) {
        this.result = result;
        this.bust = bust;
        this.waist = waist;
        this.high_hip = high_hip;
        this.hip = hip;
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

    public int getBust() {
        return bust;
    }

    public void setBust(int bust) {
        this.bust = bust;
    }

    public int getWaist() {
        return waist;
    }

    public void setWaist(int waist) {
        this.waist = waist;
    }

    public int getHigh_hip() {
        return high_hip;
    }

    public void setHigh_hip(int high_hip) {
        this.high_hip = high_hip;
    }

    public int getHip() {
        return hip;
    }

    public void setHip(int hip) {
        this.hip = hip;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
