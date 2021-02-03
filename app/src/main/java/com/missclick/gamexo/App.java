package com.missclick.gamexo;

import android.app.Application;

import com.missclick.gamexo.di.AppComponent;
import com.missclick.gamexo.di.DaggerAppComponent;
import com.missclick.gamexo.di.module.AppModule;

public class App extends Application {

    public static AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = initializeDagger();
    }

    private AppComponent initializeDagger(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .build();
    }

}
