package com.test.sam.commmodule.reslist;

import com.test.sam.commmodule.Models.ModelItem;
import com.test.sam.commmodule.network.Api;
import com.test.sam.commmodule.network.RequestGenerator;
import com.test.sam.commmodule.network.RequestHandler;

import org.json.JSONException;

import java.io.IOException;
import java.util.List;

import okhttp3.Request;
import rx.Observable;

/**
 * Created by sam on 7/3/17.
 */

public class ResListImpl implements ResListInteractor{

    private RequestHandler requestHandler;

    ResListImpl (RequestHandler requestHandler) {
        this.requestHandler = requestHandler;
    }


    @Override
    public Observable<List<ModelItem>> fetchItem() {

        return Observable.fromCallable(this::getItemList);
    }

    private List<ModelItem> getItemList () throws IOException, JSONException {

        return fetchItemList(Api.GET_RESULTS);

    }

    private List<ModelItem> fetchItemList(String url) throws IOException, JSONException{

        Request request = RequestGenerator.get(url);
        String response = requestHandler.request(request);
        return ResListParser.parse(response);

    }
}
