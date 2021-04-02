package com.rainmonth;

/**
 * @author randy
 * @date 2021/4/2 1:57 下午
 */
public interface DownloadCallback {
    void onDownloadStart();

    void onDownloadProgressChange(long now, long total);

    void onDownloadError();

    void onDownloadComplete();
}
