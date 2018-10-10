package com.test.androidtest.model;

import com.google.gson.annotations.SerializedName;

import java.util.LinkedHashMap;

public class ApiResponse {

    @SerializedName("base")
    private String mBase;
    @SerializedName("date")
    private String mDate;
    @SerializedName("rates")
    private LinkedHashMap<String, Double> mRates;

    public String getBase() {
        return mBase;
    }

    public void setBase(String base) {
        mBase = base;
    }

    public String getDate() {
        return mDate;
    }

    public void setDate(String date) {
        mDate = date;
    }

    public LinkedHashMap<String, Double> getRates() {
        return mRates;
    }

    public void setRates(LinkedHashMap<String, Double> rates) {
        mRates = rates;
    }
}
