package com.tangram.task.scheduler;

import android.support.annotation.NonNull;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 *  缓存线程池
 */
public final class CachedThreadScheduler implements Scheduler {

    private static final String THREAD_NAME_PREFIX = "AsyncTaskThread-";
    private static final int CPU_COUNT = Runtime.getRuntime().availableProcessors();
    private static final int CORE_POOL_SIZE = CPU_COUNT * 2 + 1;
    private static final long KEEP_ALIVE_TIME = 30; //无任务时存活时间 单位（秒）
    private static final int MAX_POOL_SIZE = CPU_COUNT * 2 + 1; //最大线程数
    private static final BlockingQueue<Runnable> sPoolWorkQueue = new LinkedBlockingQueue<>(256);
    private static final ThreadPoolExecutor EXECUTOR;

    private static final class Holder {
        static final Scheduler SCHEDULER = new CachedThreadScheduler();
    }

    public static Scheduler getScheduler() {
        return Holder.SCHEDULER;
    }

    private CachedThreadScheduler() {

    }

    static {
        EXECUTOR = new ThreadPoolExecutor(CORE_POOL_SIZE, MAX_POOL_SIZE,
                KEEP_ALIVE_TIME, TimeUnit.SECONDS, sPoolWorkQueue,
                new NewTreadFactory(THREAD_NAME_PREFIX));
        EXECUTOR.allowCoreThreadTimeOut(true);
    }

    @NonNull
    @Override
    public Worker createWorker() {
        return new CachedThreadWorker(EXECUTOR);
    }

    @Override
    public void shutdown() {
        if (!EXECUTOR.isShutdown()) {
            EXECUTOR.shutdownNow();
        }
    }
}
