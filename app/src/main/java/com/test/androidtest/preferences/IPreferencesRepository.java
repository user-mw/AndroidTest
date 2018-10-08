package com.test.androidtest.preferences;

public interface IPreferencesRepository {
    void changeBaseCurrencyValue(String newValue);
    String getBaseCurrencyValue();
    void changeBaseCurrencyAmount(double newAmount);
    double getBaseCurrencyAmount();
}
