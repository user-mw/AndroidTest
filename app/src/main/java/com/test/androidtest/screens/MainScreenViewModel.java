package com.test.androidtest.screens;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.text.TextUtils;
import android.util.Log;

import com.test.androidtest.model.CurrencyItem;
import com.test.androidtest.model.IRepository;
import com.test.androidtest.preferences.IPreferencesRepository;
import com.test.androidtest.utils.CurrenciesUtil;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MainScreenViewModel extends ViewModel {

    private final static String LOG_TAG = "ViewModel loadData";
    private final static int DELAY = 0;
    private final static int RATE = 1;

    @Inject
    IRepository mRepository;

    @Inject
    IPreferencesRepository mPreferencesRepository;

    @Inject
    CurrenciesUtil mCurrenciesUtil;

    private MutableLiveData<String> mSimpleTitle = new MutableLiveData<>();
    private MutableLiveData<List<CurrencyItem>> mCurrencies = new MutableLiveData<>();
    private ScheduledExecutorService mExecutorService;

    @Inject
    public MainScreenViewModel() {
        mSimpleTitle.postValue("Title");
    }

    public void loadNewData() {
        mExecutorService = Executors.newScheduledThreadPool(1);

        mExecutorService.scheduleAtFixedRate(() -> loadData(), DELAY, RATE, TimeUnit.SECONDS);
    }

    private void loadData() {
        mRepository.loadCurrencies(mPreferencesRepository.getBaseCurrencyValue())
                .flatMap(apiResponse -> {
                    List<CurrencyItem> result = new ArrayList<>();

                    String base = mPreferencesRepository.getBaseCurrencyValue();
                    double amount = mPreferencesRepository.getBaseCurrencyAmount();

                    result.add(new CurrencyItem(amount, base, "Russian Ruble"));

                    for(Map.Entry<String, Double> value : apiResponse.getRates().entrySet()) {
                        result.add(new CurrencyItem(amount * value.getValue(), value.getKey(), "Russian Ruble"));
                    }

                    return io.reactivex.Observable.fromArray(result);
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<CurrencyItem>>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                        Log.d(LOG_TAG, "onSubscribe called");
                    }

                    @Override
                    public void onNext(List<CurrencyItem> currencies) {
                        mCurrencies.postValue(currencies);
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.e(LOG_TAG, "onError called");
                    }

                    @Override
                    public void onComplete() {
                        Log.d(LOG_TAG, "onComplete called");
                    }
                });
    }

    public void changeBaseCurrency(String newBaseCurrency) {
        mPreferencesRepository.changeBaseCurrencyValue(newBaseCurrency);
    }

    public void changeAmount(String newAmount) {
        double amount = 0;

        if(!TextUtils.isEmpty(newAmount)) {
            amount  = Double.parseDouble(newAmount);
        }

        mPreferencesRepository.changeBaseCurrencyAmount(amount);
    }

    public void detach() {
        mExecutorService.shutdownNow();
    }

    public MutableLiveData<String> getSimpleTitle() {
        return mSimpleTitle;
    }

    public MutableLiveData<List<CurrencyItem>> getCurrencies() {
        return mCurrencies;
    }
}
