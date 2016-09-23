package com.ken.dagger2.part1;

import android.app.Application;

import com.ken.dagger2.HelloServiceDebugManager;

import javax.inject.Singleton;
import dagger.Module;
import dagger.Provides;

/**
 * Created by HN on 22/09/16.
 */

@Module
public class MainModule {

    DaggerApplication app;


    public MainModule (DaggerApplication application) {
        app = application;
    }

    @Provides
    @Singleton
    protected Application provideApplication () {
        return app;
    }

    @Provides
    @Singleton
    HelloService provideHelloService () {
        return new HelloServiceDebugManager();
    }

}
