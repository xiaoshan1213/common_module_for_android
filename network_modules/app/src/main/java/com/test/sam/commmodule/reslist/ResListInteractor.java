package com.test.sam.commmodule.reslist;

import com.test.sam.commmodule.Models.ModelItem;

import java.util.List;

import rx.Observable;

/**
 * Created by sam on 7/3/17.
 */

public interface ResListInteractor {

    Observable<List<ModelItem>> fetchItem();
}
