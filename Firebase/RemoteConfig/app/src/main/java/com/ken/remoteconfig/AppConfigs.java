package com.ken.remoteconfig;

import com.google.firebase.remoteconfig.FirebaseRemoteConfig;

/**
 * Created by HN on 08/12/2016.
 */

public class AppConfigs {

    private static AppConfigs mInstance;
    private FirebaseRemoteConfig mFirebaseRemoteConfig;

    private AppConfigs () {

    }

    public static AppConfigs getInstance () {
        if (mInstance == null) {
            mInstance = new AppConfigs();
        }
        return mInstance;
    }


    public void setConfig (FirebaseRemoteConfig firebaseRemoteConfig) {
        this.mFirebaseRemoteConfig = firebaseRemoteConfig;
    }


    // asdsd
    public FirebaseRemoteConfig getConfig () {
        return this.mFirebaseRemoteConfig;
    }

}
