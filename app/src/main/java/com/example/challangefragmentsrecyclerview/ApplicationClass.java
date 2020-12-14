package com.example.challangefragmentsrecyclerview;

import android.app.Application;

import java.util.ArrayList;

public class ApplicationClass extends Application {
    public static ArrayList<Car> cars;
    @Override
    public void onCreate() {
        super.onCreate();
        cars=new ArrayList<Car>();
        cars.add(new Car("mercedes","Polo","arushi","123"));
        cars.add(new Car("nissan","E200","Shubham","1234)"));
        cars.add(new Car("volkswagen","E180","Samridhi","6655"));
        cars.add(new Car("mercedes","Polo","arushi","123"));
        cars.add(new Car("nissan","E200","Shubham","1234)"));
        cars.add(new Car("volkswagen","E180","Samridhi","6655"));
    }
}
