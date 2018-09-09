package com.example.acer.myapplicationiu;

public class Rating {
    int doc_id;
    String doc_name;
    double doc_rating;

    public void setDoc_id(int doc_id) {
        this.doc_id = doc_id;
    }

    public void setDoc_name(String doc_name) {
        this.doc_name = doc_name;
    }

    public void setDoc_rating(double doc_rating) {
        this.doc_rating = doc_rating;
    }

    public int getDoc_id() {
        return doc_id;
    }

    public String getDoc_name() {
        return doc_name;
    }

    public double getDoc_rating() {
        return doc_rating;
    }

    public Rating(int doc_id, String doc_name, double doc_rating) {
        this.doc_id = doc_id;
        this.doc_name = doc_name;
        this.doc_rating = doc_rating;
    }
    public Rating()
    {

    }

}

