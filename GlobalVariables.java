package com.example.joris.spotvogel;


import android.app.Application;

public class GlobalVariables extends Application {

    public String size = "";
    public String color = "Green";
    public String beakShape = "";

    public GlobalVariables(){
        ;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBeakShape() {
        return beakShape;
    }

    public void setBeakShape(String beakShape) {
        this.beakShape = beakShape;
    }
}
