package com.tangram.task;

/**
 * 取消
 */
public interface Cancelable {

    void cancel();

    boolean isCanceled();
}
