package com.test.androidtest.dependencies;

import com.test.androidtest.screens.CurrenciesAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class ItemModule {
    private CurrenciesAdapter.IOnItemClick mItemClick;

    public ItemModule(CurrenciesAdapter.IOnItemClick itemClick) {
        mItemClick = itemClick;
    }

    @Provides
    public CurrenciesAdapter.IOnItemClick getItemClick() {
        return mItemClick;
    }
}
