package com.test.androidtest.dependencies;

import com.test.androidtest.screens.CurrenciesAdapter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ItemModule.class})
public interface IItemComponent {
    void inject(CurrenciesAdapter adapter);
}
