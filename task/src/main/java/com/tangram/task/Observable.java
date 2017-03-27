package com.tangram.task;

import android.support.annotation.NonNull;

/**
 * 被观察者
 * @param <O> 观察者泛型
 */
@SuppressWarnings("unused")
public interface Observable <O extends Observer> extends Observer, Runnable ,Cancelable{

    /**
     * 发布
     */
    void publish();

    /**
     * 订阅
     * @param observer 观察者
     */
    void subscribe(@NonNull O observer);

    /**
     * 开始运行
     * @param observer 观察者
     */
    void call(@NonNull O observer) throws Throwable;

}
