package com.test.androidtest.dependencies;

import com.test.androidtest.screens.CurrenciesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ItemModule {
    private CurrenciesAdapter.IOnItemClick mItemClick;
    private CurrenciesAdapter.IOnItemChangeAmount mOnItemChangeAmount;

    public ItemModule(CurrenciesAdapter.IOnItemClick itemClick, CurrenciesAdapter.IOnItemChangeAmount onItemChangeAmount) {
        mItemClick = itemClick;
        mOnItemChangeAmount = onItemChangeAmount;
    }

    @Provides
    public CurrenciesAdapter.IOnItemClick provideItemClick() {
        return mItemClick;
    }

    @Provides
    public CurrenciesAdapter.IOnItemChangeAmount provideOnItemChangeAmount() {
        return mOnItemChangeAmount;
    }
}
