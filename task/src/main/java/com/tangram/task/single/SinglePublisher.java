package com.tangram.task.single;

import android.support.annotation.NonNull;

import com.tangram.task.Functions;
import com.tangram.task.Publisher;

/**
 * 单任务发布者
 */
final class SinglePublisher<T> extends Publisher<T, SingleObserver<T>> implements SingleObserver<T> {

    public SinglePublisher(SingleObserver<T> observer) {
        super(observer);
    }

    @Override
    public void onSuccess(@NonNull T t) {
        schedule(Functions.toSuccessRun(mObserver, t));
    }

    @Override
    public void onError(Throwable e) {
        schedule(Functions.toErrorRun(mObserver, e));
    }
}
