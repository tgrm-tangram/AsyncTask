package com.tangram.task.scheduler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

import com.tangram.task.Cancelable;
import com.tangram.task.Canceled;

/**
 * 主线程调度器
 */
public class MainThreadScheduler implements Scheduler {

    private static final class MainHolder {
        static final Scheduler SCHEDULER = new MainThreadScheduler(new Handler(Looper.getMainLooper()));
    }

    public static Scheduler getScheduler() {
        return MainHolder.SCHEDULER;
    }

    private Handler mHandler;

    private MainThreadScheduler(Handler handler) {
        mHandler = handler;
    }

    @Override
    public Worker createWorker() {
        return new MainThreadWorker(mHandler);
    }

    @Override
    public void shutdown() {

    }

    private static class MainThreadWorker implements Worker {
        private final Handler mHandler;
        private volatile boolean canceled;

        public MainThreadWorker(Handler handler) {
            mHandler = handler;
        }

        @Override
        public Cancelable schedule(Runnable run) {

            if (canceled) {
                return Canceled.instance;
            }

            ScheduledRunnable scheduled = new ScheduledRunnable(mHandler, run);

            Message message = Message.obtain(mHandler, scheduled);
            message.obj = this;

            mHandler.sendMessage(message);

            if (canceled) {
                mHandler.removeCallbacks(scheduled);
                return Canceled.instance;
            }

            return scheduled;
        }

        @Override
        public void cancel() {
            mHandler.removeCallbacksAndMessages(this);
            canceled = true;
        }

        @Override
        public boolean isCanceled() {
            return canceled;
        }
    }

    private static final class ScheduledRunnable implements Runnable, Cancelable {
        private final Handler mHandler;
        private volatile boolean mCanceled;
        private final Runnable mRunnable;


        ScheduledRunnable(Handler handler, Runnable runnable) {
            this.mHandler = handler;
            this.mRunnable = runnable;
        }

        @Override
        public void run() {

            if (mCanceled) {
                return;
            }

            try {
                mRunnable.run();
            } catch (Throwable t) {
                IllegalStateException ie =
                        new IllegalStateException("Fatal Exception thrown on Scheduler.", t);
                Thread thread = Thread.currentThread();
                thread.getUncaughtExceptionHandler().uncaughtException(thread, ie);
            }
        }

        @Override
        public void cancel() {
            mCanceled = true;
            mHandler.removeCallbacks(this);
        }

        @Override
        public boolean isCanceled() {
            return mCanceled;
        }
    }
}
