package com.example.healthify.BodyFat;

public class FatModel {

   private int id;
   private String result;
   private int age;
   private int height;
   private int weist;
   private int hip;
   private int neck;
   private int weight;
   private String date;

    public FatModel() {

    }

    public FatModel(int id, String result, int age, int height, int weist, int hip, int neck, int weight) {
        this.id = id;
        this.result = result;
        this.age = age;
        this.height = height;
        this.weist = weist;
        this.hip = hip;
        this.neck = neck;
        this.weight = weight;
    }

    public FatModel(int id, String result, int age, int height, int weist, int hip, int neck, int weight, String date) {
        this.id = id;
        this.result = result;
        this.age = age;
        this.height = height;
        this.weist = weist;
        this.hip = hip;
        this.neck = neck;
        this.weight = weight;
        this.date = date;
    }

    public FatModel(String result, int age, int height, int weist, int hip, int neck, int weight, String date) {
        this.result = result;
        this.age = age;
        this.height = height;
        this.weist = weist;
        this.hip = hip;
        this.neck = neck;
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

    public int getWeist() {
        return weist;
    }

    public void setWeist(int weist) {
        this.weist = weist;
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

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
