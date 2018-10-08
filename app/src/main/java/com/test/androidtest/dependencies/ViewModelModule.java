package com.test.androidtest.dependencies;

import android.arch.lifecycle.ViewModel;
import android.arch.lifecycle.ViewModelProviders;
import android.support.v4.app.Fragment;

import com.test.androidtest.screens.MainScreenViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class ViewModelModule {
    private Fragment mLifeCycleOwner;

    public ViewModelModule(Fragment fragment) {
        mLifeCycleOwner = fragment;
    }


    @Provides
    public ViewModel provideMainScreenViewModel() {
        return ViewModelProviders.of(mLifeCycleOwner).get(MainScreenViewModel.class);
    }
}
