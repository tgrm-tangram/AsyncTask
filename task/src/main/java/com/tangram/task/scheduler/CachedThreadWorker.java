package com.tangram.task.scheduler;

import com.tangram.task.Cancelable;
import com.tangram.task.Canceled;
import com.tangram.task.FutureCancelable;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/**
 * 缓存线程工作器
 */
public class CachedThreadWorker implements Scheduler.Worker{
    private final ExecutorService executor;
    private volatile boolean mCanceled;

    public CachedThreadWorker(ExecutorService executor) {
        this.executor = executor;
    }

    @Override
    public void cancel() {
        mCanceled = true;
    }

    @Override
    public boolean isCanceled() {
        return mCanceled;
    }

    @Override
    public Cancelable schedule(Runnable run) {

        if (mCanceled) {
            return Canceled.instance;
        }

        Future<?> f;
        f = executor.submit(run);

        return new FutureCancelable(f, true);
    }
}
