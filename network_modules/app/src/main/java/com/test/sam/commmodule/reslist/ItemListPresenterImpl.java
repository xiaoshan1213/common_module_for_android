package com.test.sam.commmodule.reslist;

import android.util.Log;

import com.test.sam.commmodule.Models.ModelItem;

import java.util.List;

import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by sam on 7/3/17.
 */

public class ItemListPresenterImpl implements ItemListPresenter {


    private ResListInteractor resListInteractor;
    private ItemListView view;
    private Subscription subscription;

    public ItemListPresenterImpl(ResListInteractor interactor) {
        this.resListInteractor = interactor;
    }

    @Override
    public void displayItems() {

        subscription = resListInteractor.fetchItem().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(this::onItemFetchSuccess, this::onItemFetchFail);
    }

    @Override
    public void setView(ItemListView view) {

        this.view = view;
        displayItems();
    }

    @Override
    public void destroy() {

        view = null;

    }

    private void onItemFetchSuccess (List<ModelItem> items) {
        Log.d("presnetIMpl_success", items.toString());
        view.showItems(items);
    }

    private void onItemFetchFail (Throwable e) {

    }
}
