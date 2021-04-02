package com.rainmonth;

import okhttp3.*;

import java.io.File;
import java.io.IOException;

/**
 * @author randy
 * @date 2021/4/2 1:28 下午
 */
public class ClientUtils {
    private static volatile OkHttpClient mInstance;

    /**
     * 双重检查锁定
     * 这种写法考虑了线程安全，将对singleton的null判断以及new的部分使用synchronized进行加锁。
     * 同时，对singleton对象使用volatile关键字进行限制，保证其对所有线程的可见性，并且禁止对其进行指令重排序优化。
     * 在单例中new的情况非常少，绝大多数都是可以并行的读操作。因此在加锁前多进行一次null检查就可以减少绝大多数的加锁操作，执行效率提高的目的也就达到了
     * 注意：双重检查锁法，不能在jdk1.5之前使用，
     * 而在Android平台上使用就比较放心了，一般Android都是jdk1.6以上，不仅修正了volatile的语义问题，还加入了不少锁优化，使得多线程同步的开销降低不少
     */
    public static OkHttpClient getOkHttpClient() {
        if (mInstance == null) {
            synchronized (ClientUtils.class) {
                if (mInstance == null) {
                    mInstance = new OkHttpClient();
                }
            }
        }
        return mInstance;
    }

    private ClientUtils() {

    }

    public void get(String url) {
        final Request request = new Request.Builder()
                .url(url)
                .get()
                .build();
        Call call = mInstance.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {

            }
        });
    }

    public void post(String url) {

    }

    public void upload(String url, File file) {

    }

    public void download(String url) {

    }
}
