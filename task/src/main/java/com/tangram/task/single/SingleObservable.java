package com.tangram.task.single;

import android.support.annotation.NonNull;

import com.tangram.task.BaseObservable;

/**
 * 任务被观察者
 */
@SuppressWarnings({"unused"})
public abstract class SingleObservable<T> extends BaseObservable<SingleObserver<T>, T, SinglePublisher<T>> {

    @Override
    public void subscribe(@NonNull SingleObserver<T> observer) {
        mPublisher = new SinglePublisher<>(observer);
    }
}
