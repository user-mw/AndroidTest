package com.test.androidtest.dependencies;

import android.content.Context;

import com.test.androidtest.utils.SharedPreferencesUtil;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class PreferencesModule {

    private SharedPreferencesUtil mPreferencesUtil;

    public PreferencesModule(Context context) {
        mPreferencesUtil = new SharedPreferencesUtil(context);
    }

    @Provides
    @Singleton
    public SharedPreferencesUtil provideSharedPreferencesUtil() {
        return mPreferencesUtil;
    }
}
