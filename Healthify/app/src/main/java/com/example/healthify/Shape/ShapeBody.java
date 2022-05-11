package com.example.healthify.Shape;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ShapeBody {

    private int bust ;
    private int waist;
    private int high_hip;
    private int hip ;




    public ShapeBody() {
    }

    public ShapeBody(int bust, int waist, int high_hip, int hip) {
        this.bust = bust;
        this.waist = waist;
        this.high_hip = high_hip;
        this.hip = hip;
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

    public String ShapeCalculation(){

       if ((bust - hip) <= 1 && (hip - bust) < 3.6 && (bust - waist) >= 9 || (hip - waist) >= 10){
            return "Hourglass";
        } else if ((hip - bust) >= 3.6 && (hip - bust) < 10 && (hip - waist) >= 9 && (high_hip/waist) < 1.193){
            return "Bottom_hourglass";
        } else if ((bust - hip) > 1 && (bust - hip) < 10 && (bust - waist) >= 9){
            return "Top_hourglass";
        } else if ((hip - bust) > 2 && (hip - waist) >= 7 && (high_hip/waist) >= 1.193){
            return "Spoon";
        } else if ((hip - bust) >= 3.6 && (hip - waist) < 9) {
            return "Triangle";
        } else if ((bust - hip) >= 3.6 && (bust - waist) < 9) {
            return "Inverted_triangle";
        }else if ((hip - bust) < 3.6 && (bust - hip) < 3.6 && (bust - waist) < 9 && (hip - waist) < 10){
            return "Rectangle";
        }else

        return "wrong";

    }

    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
