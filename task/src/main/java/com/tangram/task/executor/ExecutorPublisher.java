package com.tangram.task.executor;

import com.tangram.task.Functions;
import com.tangram.task.Publisher;

/**
 * 执行器发布者
 */
final class ExecutorPublisher extends Publisher<Void, ExecutorObserver> implements ExecutorObserver {

    public ExecutorPublisher(ExecutorObserver observer) {
        super(observer);
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
