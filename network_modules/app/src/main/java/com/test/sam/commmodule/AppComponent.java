package com.test.sam.commmodule;

import com.test.sam.commmodule.network.NetworkModule;
import com.test.sam.commmodule.reslist.ListComponent;
import com.test.sam.commmodule.reslist.ListModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by sam on 7/6/17.
 */
@Singleton
@Component(modules = {
        AppModule.class,
        NetworkModule.class})
public interface AppComponent {

    ListComponent plus(ListModule listModule);
}
