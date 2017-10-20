package com.sample.sam.concurrent_modules;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/**
 * Created by sam on 10/19/17.
 */

public class ConcurService {

    private ExecutorService executorService = Executors.newFixedThreadPool(3);
    private NetConnWorker netConnWorker;

    public ConcurService(){
        netConnWorker = new NetConnWorker("host_url");
    }

    private QueryRequest composeRequest(String sessonId){
        return new QueryRequest(sessonId);
    }

    public void putTaskToThread(String sessionId){
        Future<QueryRes> future = executorService.submit(new ConcurTask(sessionId));
        try{
            QueryRes res = future.get(5000, TimeUnit.MILLISECONDS);

        }catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
    }

    private class ConcurTask implements Callable<QueryRes>{

        private QueryRequest request;

        public ConcurTask(String sessonId){
            this.request = composeRequest(sessonId);
        }

        @Override
        public QueryRes call() throws Exception {
            return netConnWorker.runQuery(this.request);
        }
    }

}
