package com.test.androidtest.dependencies;

import android.graphics.drawable.Drawable;

import com.test.androidtest.screens.CurrenciesAdapter;

import java.util.HashMap;

import dagger.Module;
import dagger.Provides;

@Module
public class ItemModule {
    private CurrenciesAdapter.IOnItemClick mItemClick;
    private CurrenciesAdapter.IOnItemChangeAmount mOnItemChangeAmount;
    private HashMap<String, String> mCurrenciesNames;
    private HashMap<String, Drawable> mCurrenciesFlags;

    public ItemModule(CurrenciesAdapter.IOnItemClick itemClick, CurrenciesAdapter.IOnItemChangeAmount onItemChangeAmount,
                      HashMap<String, String> currenciesNames, HashMap<String, Drawable> currenciesFlags) {
        mItemClick = itemClick;
        mOnItemChangeAmount = onItemChangeAmount;
        mCurrenciesNames = currenciesNames;
        mCurrenciesFlags = currenciesFlags;
    }

    @Provides
    public CurrenciesAdapter.IOnItemClick provideItemClick() {
        return mItemClick;
    }

    @Provides
    public CurrenciesAdapter.IOnItemChangeAmount provideOnItemChangeAmount() {
        return mOnItemChangeAmount;
    }

    @Provides
    public HashMap<String, String> getCurrenciesNames() {
        return mCurrenciesNames;
    }

    @Provides
    public HashMap<String, Drawable> getCurrenciesFlags() {
        return mCurrenciesFlags;
    }
}
