package com.test.androidtest.dependencies;

import com.google.gson.Gson;
import com.test.androidtest.BuildConfig;
import com.test.androidtest.model.IRevolutApiWorker;
import com.test.androidtest.utils.CurrenciesUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {

    @Provides
    @Singleton
    OkHttpClient provideClient() {
        return new OkHttpClient().newBuilder().build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new Gson();
    }

    @Provides
    @Singleton
    Retrofit provideRetrofitInstance(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(BuildConfig.REVOLUT_API_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .build();
    }

    @Provides
    public IRevolutApiWorker provideRevolutApiWorker(Retrofit retrofitInstance) {
        return retrofitInstance.create(IRevolutApiWorker.class);
    }

    @Provides
    @Singleton
    public CurrenciesUtil provideCurrenciesUtil() {
        return new CurrenciesUtil();
    }
}
