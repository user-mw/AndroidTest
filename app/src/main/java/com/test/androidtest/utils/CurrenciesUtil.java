package com.test.androidtest.utils;

import android.text.TextUtils;

public class CurrenciesUtil {
    public static double generateRightAmount(String amountString) {
        double result = 0;

        if(!TextUtils.isEmpty(amountString)) {
            result  = Double.parseDouble(amountString);
        }

        return result;
    }
}
