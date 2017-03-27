package com.tangram.task;

import com.tangram.task.interfaces.OnError;
import com.tangram.task.scheduler.CachedThreadScheduler;
import com.tangram.task.scheduler.MainThreadScheduler;
import com.tangram.task.scheduler.Scheduler;

/**
 * 发布者
 */
public abstract class Publisher<T, O extends Observer<T>> implements Cancelable , OnError {
    final protected Scheduler.Worker mMainWorker = MainThreadScheduler.getScheduler().createWorker();
    final protected O  mObserver;
    private Cancelable mCurrentCancelable;
    final private Scheduler.Worker mWorker;
    private volatile boolean mCanceled;

    public Publisher(O observer) {
        mObserver = observer;
        mWorker = CachedThreadScheduler.getScheduler().createWorker();
    }

    @Override
    final public void cancel() {
        mCanceled = true;
        if (mCurrentCancelable != null) {
            mCurrentCancelable.cancel();
            mCurrentCancelable = null;
        }
    }

    @Override
    final public boolean isCanceled() {
        return mCanceled;
    }

    final public void publish(Runnable runnable) {
        try {
            mCurrentCancelable = mWorker.schedule(runnable);
        } catch (Throwable e) {
            onError(e);
        }
    }

    final protected void schedule(Runnable run) {
        if (!mCanceled) {
            mMainWorker.schedule(run);
        }
    }
}
