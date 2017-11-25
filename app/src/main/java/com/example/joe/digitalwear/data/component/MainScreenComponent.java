package com.example.joe.digitalwear.data.component;

import com.example.joe.digitalwear.data.module.MainScreenModule;
import com.example.joe.digitalwear.mainscreen.MainActivity;
import com.example.joe.digitalwear.util.CustomScope;

import dagger.Component;

@CustomScope
@Component(dependencies = NetComponent.class, modules = MainScreenModule.class)
public interface MainScreenComponent {
    void inject (MainActivity activity);
}
