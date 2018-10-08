package com.test.androidtest.model;

public class CurrencyItem {
    private double mValue;
    private String mAbbreviation;
    private String mFullName;

    public CurrencyItem(double value, String abbreviation, String fullName) {
        mValue = value;
        mAbbreviation = abbreviation;
        mFullName = fullName;
    }

    public double getValue() {
        return mValue;
    }

    public String getAbbreviation() {
        return mAbbreviation;
    }

    public String getFullName() {
        return mFullName;
    }
}
