package com.test.androidtest.utils;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPreferencesUtil {

    private static final String BASE_CURRENCY_KEY = "BaseCurrency";
    private static final String BASE_CURRENCY_AMOUNT_KEY = "BaseCurrencyAmount";

    private SharedPreferences mPreferences;

    public SharedPreferencesUtil(Context context) {
        mPreferences = context.getSharedPreferences("CurrenciesOptions", Context.MODE_PRIVATE);
    }

    public void changeBaseCurrency(String newBaseCurrency) {
        mPreferences.edit()
                .putString(BASE_CURRENCY_KEY, newBaseCurrency)
                .apply();
    }

    public String getBaseCurrency() {
        return mPreferences.getString(BASE_CURRENCY_KEY, "EUR");
    }

    public void changeBaseCurrencyAmount(double newAmount) {
        mPreferences.edit()
                .putString(BASE_CURRENCY_AMOUNT_KEY, String.valueOf(newAmount))
                .apply();
    }

    public double getBaseCurrencyAmount() {
        return Double.parseDouble(mPreferences.getString(BASE_CURRENCY_AMOUNT_KEY, "1"));
    }
}
