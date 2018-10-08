package com.test.androidtest.dependencies;

import com.test.androidtest.screens.MainScreenFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {ViewModelModule.class})
public interface IViewModelComponent {
    void inject(MainScreenFragment fragment);
}
