package com.test.androidtest.utils;

import java.util.Locale;

public class CurrenciesStringUtil {
    public static String generateAmountString(double amount) {
        if(amount % 1 == 0.0) {
            return String.format(Locale.ENGLISH, "%." + 0 + "f", amount);
        }

        return String.format(Locale.ENGLISH, "%." + 2 + "f", amount);
    }
}
