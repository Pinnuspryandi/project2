package com.example.project;

import android.util.Log;

import java.util.ArrayList;

public class ReviewSingleton {
    private static ReviewSingleton review_instance;
    private ArrayList<ReviewDB> reviewss =  new ArrayList<>();


    public static ReviewSingleton getInstance() {
        if(review_instance == null)
            review_instance = new ReviewSingleton();
        Log.d("Singleton", "Created");
        return  review_instance;
    }

    public void add (ReviewDB reviewdb) {
        this.reviewss.add(reviewdb);
    }





    public ArrayList<ReviewDB> getReviewss()
    {
        return reviewss;
    }

    public void init(){

        reviewss.add(new ReviewDB(1,1,"MB001","Good","This library have a complete series of books"));
        reviewss.add(new ReviewDB(1,2,"MB002","Best Library","Best Library ever"));


    }
}
