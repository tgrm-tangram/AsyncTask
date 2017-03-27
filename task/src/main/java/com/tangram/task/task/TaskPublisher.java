package com.tangram.task.task;

import android.support.annotation.NonNull;

import com.tangram.task.Functions;
import com.tangram.task.Publisher;

/**
 * 任务发布者
 */
final class TaskPublisher<T> extends Publisher<T, TaskObserver<T>> implements TaskObserver<T> {

    public TaskPublisher(TaskObserver<T> observer) {
        super(observer);
    }

    @Override
    public void onStart() {
        schedule(Functions.toStartRun(mObserver));
    }

    @Override
    public void onNext(@NonNull T t) {
        schedule(Functions.toNextRun(mObserver, t));
    }

    @Override
    public void onComplete() {
        schedule(Functions.toCompleteRun(mObserver));
    }

    @Override
    public void onError(Throwable e) {
        schedule(Functions.toErrorRun(mObserver, e));
    }
}
