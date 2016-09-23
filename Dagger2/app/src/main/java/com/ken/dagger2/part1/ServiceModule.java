package com.ken.dagger2.part1;

import com.ken.dagger2.HelloServiceDebugManager;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by HN on 23/09/16.
 */

@Module
public class ServiceModule {

    @Provides
    @Singleton
    HelloService provideHelloService () {
        return new HelloServiceDebugManager();
    }

}
