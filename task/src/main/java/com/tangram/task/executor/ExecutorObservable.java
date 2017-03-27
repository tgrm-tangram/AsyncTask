package com.tangram.task.executor;

import android.support.annotation.NonNull;

import com.tangram.task.BaseObservable;

/**
 * 执行器被观察者
 */
@SuppressWarnings({"unused"})
public abstract class ExecutorObservable extends BaseObservable<ExecutorObserver, Void, ExecutorPublisher> {
    @Override
    public void subscribe(@NonNull ExecutorObserver observer) {
        mPublisher = new ExecutorPublisher(observer);
    }
}
