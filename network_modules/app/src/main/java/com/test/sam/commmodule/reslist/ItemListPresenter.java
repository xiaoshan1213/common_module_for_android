package com.test.sam.commmodule.reslist;

/**
 * Created by sam on 7/3/17.
 */

public interface ItemListPresenter {

    void displayItems();
    void setView(ItemListView view);
    void destroy();

}
