package release.java.com.test.xyz.dagger;

import com.ken.dagger2.part1.HelloService;

/**
 * Created by HN on 22/09/16.
 */
public class HelloServiceReleaseManager implements HelloService {


    @Override
    public String greet(String userName) {
        return "Hello: " + userName + " ! [Release]";
    }
}
