package com.example.joe.digitalwear.data.component;

import com.example.joe.digitalwear.data.module.AppModule;
import com.example.joe.digitalwear.data.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {
    Retrofit retrofit();
}
