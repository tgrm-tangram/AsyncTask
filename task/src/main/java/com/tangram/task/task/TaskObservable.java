package com.tangram.task.task;

import android.support.annotation.NonNull;

import com.tangram.task.BaseObservable;

/**
 * 任务被观察者
 */
@SuppressWarnings({"unused"})
public abstract class TaskObservable<T> extends BaseObservable<TaskObserver<T>, T, TaskPublisher<T>> {
    @Override
    public void subscribe(@NonNull TaskObserver<T> observer) {
        mPublisher = new TaskPublisher<>(observer);
    }
}
