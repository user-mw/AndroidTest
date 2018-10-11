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

    private MutableLiveData<List<CurrencyItem>> mCurrencies = new MutableLiveData<>();
    private ScheduledExecutorService mExecutorService;
    private int mEditablePosition = -1;
    private double mFreezingAmount = -1.0;
    private double mOriginalAmount = 0.0;

    @Inject
    public MainScreenViewModel() {

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

                    result.add(new CurrencyItem(amount, base));

                    for(Map.Entry<String, Double> value : apiResponse.getRates().entrySet()) {
                        result.add(new CurrencyItem(amount * value.getValue(), value.getKey()));
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
                        if(mCurrencies.getValue() != null && mEditablePosition != -1 && mFreezingAmount != -1.0) {
                            mOriginalAmount = currencies.get(mEditablePosition).getValue();
                            currencies.get(mEditablePosition).setValue(mFreezingAmount);
                        }

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

    public void setEditablePosition(int editablePosition, double amount) {
        mEditablePosition = editablePosition;
        mFreezingAmount = amount;
    }

    public void changeBaseCurrency(String newBaseCurrency, String amount) {
        mPreferencesRepository.changeBaseCurrencyValue(newBaseCurrency);
        double rightAmount = CurrenciesUtil.generateRightAmount(amount);
        mPreferencesRepository.changeBaseCurrencyAmount(rightAmount);
    }

    public void changeAmount(String newAmount) {
        double amount = CurrenciesUtil.generateRightAmount(newAmount);
        mPreferencesRepository.changeBaseCurrencyAmount(amount);
    }

    public void detach() {
        mExecutorService.shutdownNow();
    }

    public MutableLiveData<List<CurrencyItem>> getCurrencies() {
        return mCurrencies;
    }

    public void setFreezingAmount(double freezingAmount, int position) {
        if(position == mEditablePosition) {
            if(freezingAmount > 0.0) {
                double amount = mPreferencesRepository.getBaseCurrencyAmount();

                double unit;

                if(mFreezingAmount != 0) {
                    unit = amount / mFreezingAmount;
                    mPreferencesRepository.changeBaseCurrencyAmount(unit * freezingAmount);
                    mFreezingAmount = freezingAmount;
                } else {
                    mPreferencesRepository.changeBaseCurrencyAmount(mOriginalAmount / mFreezingAmount);
                }
            }
        }

    }
}
