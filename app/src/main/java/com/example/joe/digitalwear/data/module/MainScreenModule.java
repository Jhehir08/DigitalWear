package com.example.joe.digitalwear.data.module;

import com.example.joe.digitalwear.mainscreen.MainScreenContract;
import com.example.joe.digitalwear.util.CustomScope;

import dagger.Module;
import dagger.Provides;

@Module
public class MainScreenModule {
    private final MainScreenContract.View mainView;

    public MainScreenModule(MainScreenContract.View mainView) {
        this.mainView = mainView;
    }

    @Provides
    @CustomScope
    MainScreenContract.View providesMainScreenContractView() {
        return mainView;
    }
}
