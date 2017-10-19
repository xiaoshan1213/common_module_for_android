package com.test.sam.commmodule;

import android.app.Application;

import com.test.sam.commmodule.network.NetworkModule;
import com.test.sam.commmodule.reslist.ListComponent;
import com.test.sam.commmodule.reslist.ListModule;

/**
 * Created by sam on 7/6/17.
 */

public class BaseApplication extends Application {

    private ListComponent listComponent;
    private AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        appComponent = createAppComponent();
    }

    public AppComponent createAppComponent(){
        return DaggerAppComponent.builder()
                .appModule(new AppModule(this))
                .networkModule(new NetworkModule())
                .build();
    }

    public ListComponent createListComponent(){

        listComponent = appComponent.plus(new ListModule());
        return listComponent;
    }
}
