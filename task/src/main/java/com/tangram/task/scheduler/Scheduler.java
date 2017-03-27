package com.tangram.task.scheduler;


import com.tangram.task.Cancelable;

/**
 * 线程调度
 */
public interface Scheduler {

    Worker createWorker();

    @SuppressWarnings("unused")
    void shutdown();

    interface Worker extends Cancelable {
        Cancelable schedule(Runnable run);
    }
}
