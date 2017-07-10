package com.example.joris.spotvogel;


import android.app.IntentService;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;

public class SearchService extends IntentService{
    int mStartMode;

    public String size = "";
    public String color = "";
    public String beakShape = "";

    public SearchService() {
        super("SearchService");
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {

    }

    public void onCreate() {
        Log.d("Hallo", "OnCreate werkt..");

    }


    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("Hallo", "OnStartCommand werkt..");
        Log.d("size", size);
        Log.d("color", color);
        Log.d("beak", beakShape);
        return mStartMode;
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
