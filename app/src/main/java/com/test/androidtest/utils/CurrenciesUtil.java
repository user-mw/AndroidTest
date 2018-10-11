package com.test.androidtest.utils;

import android.text.TextUtils;

public class CurrenciesUtil {
    public static double generateRightAmount(String amountString) {
        double result = 0;

        if(!TextUtils.isEmpty(amountString)) {
            try {
                result  = Double.parseDouble(amountString);
            } catch (NumberFormatException exc) {
                exc.printStackTrace();
            }
        }

        return result;
    }
}
