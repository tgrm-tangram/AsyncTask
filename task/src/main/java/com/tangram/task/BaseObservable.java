package com.tangram.task;

import android.support.annotation.NonNull;


/**
 * 被观察者基类
 */
public abstract class BaseObservable<O extends Observer<T> , T, P extends Publisher<T, O>> implements Observable<O>{
    protected P mPublisher;

    @Override
    final public void publish(){
        if (mPublisher != null) {
            mPublisher.publish(this);
        }
    }

    @Override
    final public void run() {
        try {
            //noinspection unchecked
            call((O) mPublisher);
        } catch (InterruptedException e) {
            // nothing
        } catch (Throwable throwable) {
            mPublisher.onError(throwable);
        }
    }

    @Override
    abstract public void subscribe(@NonNull O o);

    @Override
    final public void cancel() {
        if (mPublisher != null) {
            mPublisher.cancel();
        }
    }

    @Override
    final public boolean isCanceled() {
        return mPublisher != null && mPublisher.isCanceled();
    }
}
