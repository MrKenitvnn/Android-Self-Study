package com.ken.dagger2.part1;

/**
 * Created by HN on 22/09/16.
 */
public class HelloServiceManager implements HelloService {


    @Override
    public String greet(String userName) {
        return "Hello " + userName;
    }

}
