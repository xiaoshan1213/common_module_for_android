package com.test.sam.commmodule.reslist;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Scope;

/**
 * Created by sam on 7/6/17.
 */

@Scope
@Retention(RetentionPolicy.RUNTIME)
public @interface ListScope {
}
