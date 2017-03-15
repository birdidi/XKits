package com.cxy.android.xkits;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2016/11/28 0028.
 */
public class ThreadUtil {

    private static final ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
    private static final ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(10);
    private static final ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

    public static void executeMore(Runnable runnable) {
        cachedThreadPool.execute(runnable);
    }

    public static void executeSingle(Runnable runnable) {
        singleThreadExecutor.execute(runnable);
    }

    public static void schedule(Runnable runnable, long delay, TimeUnit timeUnit) {
        scheduledThreadPool.schedule(runnable, delay, timeUnit);
    }
}
