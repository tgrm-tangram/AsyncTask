package com.tangram.task;

/**
 * 已经取消
 */
final public class Canceled implements Cancelable {

    public static Canceled instance = new Canceled();

    private Canceled() {

    }

    @Override
    public void cancel() {

    }

    @Override
    public boolean isCanceled() {
        return true;
    }
}
