package com.ken.dagger2.part1;

import android.app.Application;

/**
 * Created by HN on 22/09/16.
 */
public class DaggerApplication extends Application {

    private static DaggerGraphComponent graph;
    private static DaggerApplication instance;


    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
        buildComponentGraph();
    }


    public static DaggerGraphComponent component () {
        return graph;
    }

    public static void buildComponentGraph () {
        graph = DaggerGraphComponent.Initializer.init(instance);
    }

}
