package com.test.androidtest.dependencies;

import com.test.androidtest.model.CurrenciesRepository;
import com.test.androidtest.model.IRepository;
import com.test.androidtest.preferences.IPreferencesRepository;
import com.test.androidtest.preferences.PreferencesRepository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    IRepository provideRepository(CurrenciesRepository repository) {
        return repository;
    }

    @Provides
    @Singleton
    IPreferencesRepository providePreferencesRepository(PreferencesRepository preferencesRepository) {
        return preferencesRepository;
    }
}
