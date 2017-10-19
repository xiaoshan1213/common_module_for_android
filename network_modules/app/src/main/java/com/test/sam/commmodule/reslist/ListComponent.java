package com.test.sam.commmodule.reslist;

import dagger.Subcomponent;

/**
 * Created by sam on 7/6/17.
 */
@ListScope
@Subcomponent(modules = {ListModule.class})
public interface ListComponent {

    ItemListFragment inject(ItemListFragment fragment);
}
