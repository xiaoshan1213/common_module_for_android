package com.test.sam.commmodule.reslist;

import com.test.sam.commmodule.network.RequestHandler;

import dagger.Module;
import dagger.Provides;

/**
 * Created by sam on 7/3/17.
 */

@Module
public class ListModule {

    @Provides
    ResListInteractor provideResListInteractor (RequestHandler requestHandler){
        return new ResListImpl(requestHandler);
    }

    @Provides
    ItemListPresenter provideItemListPresenter (ResListInteractor interactor){
        return new ItemListPresenterImpl(interactor);
    }

}
