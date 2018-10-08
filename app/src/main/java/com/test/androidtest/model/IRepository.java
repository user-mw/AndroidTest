package com.test.androidtest.model;

import io.reactivex.Observable;
import io.reactivex.Single;

public interface IRepository {
//    Single<ApiResponse> loadCurrencies(String baseCurrency);
    Observable<ApiResponse> loadCurrencies(String baseCurrency);
}
