package com.tangram.task;

import java.util.concurrent.Future;
import java.util.concurrent.atomic.AtomicReference;

/**
 * 能取消的 Future
 */
final public class FutureCancelable extends AtomicReference<Future<?>> implements Cancelable {

    private static final long serialVersionUID = 5284304987173995174L;
    private final boolean allowInterrupt;

    public FutureCancelable(Future<?> run, boolean allowInterrupt) {
        super(run);
        this.allowInterrupt = allowInterrupt;
    }

    @Override
    public void cancel() {
        Future<?> f = getAndSet(null);
        if (f != null) {
            f.cancel(allowInterrupt);
        }
    }

    @Override
    public boolean isCanceled() {
        Future<?> f = get();
        return f == null || f.isDone();
    }
}
