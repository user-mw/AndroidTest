package com.test.androidtest.model;

import android.graphics.drawable.Drawable;

public class CurrencyItem {
    private double mValue;
    private String mAbbreviation;
    private String mFullName;
    private Drawable mFlagResource;

    public CurrencyItem(double value, String abbreviation) {
        mValue = value;
        mAbbreviation = abbreviation;
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

    public void setFullName(String fullName) {
        mFullName = fullName;
    }

    public Drawable getFlagResource() {
        return mFlagResource;
    }

    public void setFlagResource(Drawable flagResource) {
        mFlagResource = flagResource;
    }
}
