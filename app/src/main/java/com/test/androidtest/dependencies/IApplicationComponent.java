package com.test.androidtest.dependencies;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ApplicationModule.class, PreferencesModule.class, RepositoryModule.class})
public interface IApplicationComponent {
    IViewModelComponent plusViewModelComponent(ViewModelModule module);
}
