package com.ken.dagger2;

import com.ken.dagger2.part1.HelloService;

/**
 * Created by HN on 22/09/16.
 */
public class HelloServiceDebugManager implements HelloService {

    @Override
    public String greet(String userName) {
        return "hello: " + userName + " ! [Debug]";
    }
}
