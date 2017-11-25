package com.example.joe.digitalwear;

import android.app.Application;

import com.example.joe.digitalwear.data.component.DaggerNetComponent;
import com.example.joe.digitalwear.data.component.NetComponent;
import com.example.joe.digitalwear.data.module.AppModule;
import com.example.joe.digitalwear.data.module.NetModule;

public class App extends Application {

    private NetComponent mNetComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule("http://jsonplaceholder.typicode.com/"))
                .build();
    }

    public NetComponent getNetComponent() {
        return mNetComponent;
    }
}
