package com.test.sam.commmodule.reslist;

import com.test.sam.commmodule.Models.ModelItem;

import java.util.List;

/**
 * Created by sam on 7/3/17.
 */

public interface ItemListView {

    void showItems(List<ModelItem> items);
    void onItemSelected(ModelItem item);

}
