package com.tangram.task.scheduler;

import android.support.annotation.NonNull;

import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 线程工厂
 */
public final class NewTreadFactory extends AtomicLong implements ThreadFactory {

    private static final long serialVersionUID = -2694007615437167523L;

    private final String prefix;

    public NewTreadFactory(String prefix) {
        this.prefix = prefix;
    }

    @Override
    public Thread newThread(@NonNull Runnable r) {
        Thread t = new Thread(r, prefix + incrementAndGet());
        t.setDaemon(true);
        return t;
    }
}
