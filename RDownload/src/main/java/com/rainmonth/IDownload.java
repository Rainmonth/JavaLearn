package com.rainmonth;

import java.util.List;

/**
 * @author randy
 * @date 2021/4/2 1:49 下午
 */
public interface IDownload {
    void start();

    void start(int taskId);

    void start(List<Integer> taskIds);

    void pause();

    void pause(int taskId);

    void pause(List<Integer> taskIds);

    void cancel(boolean delete);

    void cancel(int taskId, boolean delete);
}
