package com.test.androidtest.preferences;

import com.test.androidtest.utils.SharedPreferencesUtil;

import javax.inject.Inject;

public class PreferencesRepository implements IPreferencesRepository {

    @Inject
    SharedPreferencesUtil mPreferencesUtil;

    @Inject
    public PreferencesRepository() {

    }

    @Override
    public void changeBaseCurrencyValue(String newValue) {
        mPreferencesUtil.changeBaseCurrency(newValue);
    }

    @Override
    public String getBaseCurrencyValue() {
        return mPreferencesUtil.getBaseCurrency();
    }

    @Override
    public void changeBaseCurrencyAmount(double newAmount) {
        mPreferencesUtil.changeBaseCurrencyAmount(newAmount);
    }

    @Override
    public double getBaseCurrencyAmount() {
        return mPreferencesUtil.getBaseCurrencyAmount();
    }
}
