package com.test.androidtest.model;

import io.reactivex.Observable;
import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface IRevolutApiWorker {

//    @GET("/latest")
//    Single<ApiResponse> getCurrencies(@Query("base") String mainCurrency);
    @GET("/latest")
    Observable<ApiResponse> getCurrencies(@Query("base") String mainCurrency);
}
