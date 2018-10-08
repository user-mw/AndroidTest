package com.test.androidtest;

import android.app.Application;

import com.test.androidtest.dependencies.ApplicationModule;
import com.test.androidtest.dependencies.DaggerIApplicationComponent;
import com.test.androidtest.dependencies.IApplicationComponent;
import com.test.androidtest.dependencies.PreferencesModule;
import com.test.androidtest.dependencies.RepositoryModule;

public class MainApplication extends Application {

    private static IApplicationComponent sApplicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();

        sApplicationComponent = DaggerIApplicationComponent.builder()
                .applicationModule(new ApplicationModule())
                .preferencesModule(new PreferencesModule(this))
                .build();
    }

    public static IApplicationComponent getApplicationComponent() {
        return sApplicationComponent;
    }
}
