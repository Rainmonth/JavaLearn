package com.rainmonth.concurrent;

import java.util.concurrent.*;

/**
 * 了解 Future
 *
 * @author randy
 * @date 2021/6/9 10:11 上午
 */
public class FutureDemo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2, new ThreadFactory() {
            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r);
            }
        });

        SearchTextImpl searchText = new SearchTextImpl();

        long startTime = System.currentTimeMillis();
        System.out.println("startTime:" + startTime);
        Future<String> future = executor.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return searchText.searchText("a");
            }
        });

//        FutureTask<String> task = new FutureTask<String>(new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                return searchText.searchText("a");
//            }
//        });
//        executor.execute(task);
        searchText.doSomethingElse();

        try {
            System.out.println("搜索的结果：");
            System.out.println(future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }
        long endTime = System.currentTimeMillis();
        System.out.println("endTime:" + endTime + ", cost:" + (endTime - startTime));
    }
}

interface ISearchText {
    String searchText(String searchKey);
}

class SearchTextImpl implements ISearchText {

    @Override
    public String searchText(String searchKey) {
        try {
            System.out.println("sleep for 3 seconds...");
            Thread.sleep(3000);
            if (searchKey != null) {
                if (searchKey.startsWith("a")) {
                    return "result of searchKey: a, [apple]";
                } else {
                    return "result of searchKey:" + searchKey + ", [others]";
                }
            } else {
                return "searchKey is null";
            }
        } catch (Exception e) {
            return null;
        }
    }

    public void doSomethingElse() {
        System.out.println("doSomethingElse: reading books while waiting search result");
//        for (int i = 0;i<10000;i++) {
//            System.out.println(i);
//        }
        try {
            System.out.println("sleep for 1 second...");
            Thread.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
