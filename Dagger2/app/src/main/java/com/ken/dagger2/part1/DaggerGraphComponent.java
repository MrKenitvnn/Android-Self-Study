package com.ken.dagger2.part1;

import javax.inject.Singleton;
import dagger.Component;

/**
 * Created by HN on 22/09/16.
 */
@Singleton
@Component(modules = {MainModule.class})
public interface DaggerGraphComponent {

    void inject (MainActivity mainActivity);

    static final class Initializer {
        private Initializer () {

        }

        public static DaggerGraphComponent init (DaggerApplication app) {
            return DaggerDaggerGraphComponent.builder()
                    .mainModule(new MainModule(app))
                    .build();
        }
    }

}
