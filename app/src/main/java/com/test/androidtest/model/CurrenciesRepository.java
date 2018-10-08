package com.test.androidtest.model;

import javax.inject.Inject;

import io.reactivex.Observable;
import io.reactivex.Single;

public class CurrenciesRepository implements IRepository {

    @Inject
    IRevolutApiWorker mApiWorker;

    @Inject
    public CurrenciesRepository() {

    }

    @Override
//    public Single<ApiResponse> loadCurrencies(String baseCurrency) {
//        return mApiWorker.getCurrencies(baseCurrency);
//    }
    public Observable<ApiResponse> loadCurrencies(String baseCurrency) {
        return mApiWorker.getCurrencies(baseCurrency);
    }
}
