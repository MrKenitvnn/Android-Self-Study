package com.ken.hellojni;

/**
 * Created by HN on 19/12/2016.
 */

public class EncodeAESUtil {

    public static EncodeAESUtil mInstance;

    public EncodeAESUtil() {};

    public static EncodeAESUtil getInstance () {
        if (mInstance == null) {
            mInstance = new EncodeAESUtil();
        }
        return mInstance;
    }

    static {
        //System.loadLibrary("hello-jni");
        System.loadLibrary("jni-lib-name");
    }


    private native String getCodeFromJni ();


    public String getCode () {
        return getCodeFromJni();
    }


}
