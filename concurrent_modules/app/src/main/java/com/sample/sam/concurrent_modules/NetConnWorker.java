package com.sample.sam.concurrent_modules;

import java.util.concurrent.Callable;

/**
 * Created by sam on 10/19/17.
 */

public class NetConnWorker {

    private String hosturl;

    public NetConnWorker(String url){
        hosturl = url;
    }

    private class ParseQueryTask implements Callable<QueryRes> {

        QueryRequest request;
        String url;

        public ParseQueryTask(QueryRequest request, String url){
            this.request = request;
            this.url = url;
        }

        @Override
        public QueryRes call() throws Exception {
            return parseQuery(request, url);
        }
    }

    public QueryRes runQuery(QueryRequest request){
        try{
            QueryRes res = new ParseQueryTask(request, hosturl).call();
            return res;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public QueryRes parseQuery(QueryRequest request, String hosturl) {
        // query http or other
        return null;
    }
}
