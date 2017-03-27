package com.tangram.task;

import android.support.annotation.NonNull;

import com.tangram.task.interfaces.OnComplete;
import com.tangram.task.interfaces.OnError;
import com.tangram.task.interfaces.OnNext;
import com.tangram.task.interfaces.OnNext2;
import com.tangram.task.interfaces.OnNext3;
import com.tangram.task.interfaces.OnNext4;
import com.tangram.task.interfaces.OnNext5;
import com.tangram.task.interfaces.OnNext6;
import com.tangram.task.interfaces.OnNext7;
import com.tangram.task.interfaces.OnNext8;
import com.tangram.task.interfaces.OnNext9;
import com.tangram.task.interfaces.OnStart;
import com.tangram.task.interfaces.OnSuccess;


/**
 * 转换接口
 */
@SuppressWarnings("unused")
public class Functions {

    /**
     * onStart接口转换为 Runnable
     */
    public static Runnable toStartRun (@NonNull final OnStart onStart) {
        return new Runnable() {
            @Override
            public void run() {
                onStart.onStart();
            }
        };
    }

    /**
     * onError接口转换为 Runnable
     */
    public static Runnable toErrorRun (@NonNull final OnError onError, @NonNull final Throwable throwable) {
        return new Runnable() {
            @Override
            public void run() {
                onError.onError(throwable);
            }
        };
    }

    /**
     * OnComplete接口转换为 Runnable
     */
    public static Runnable toCompleteRun (@NonNull final OnComplete onComplete) {
        return new Runnable() {
            @Override
            public void run() {
                onComplete.onComplete();
            }
        };
    }

    /**
     * onSuccess接口转换为 Runnable
     */
    public static <T> Runnable toSuccessRun (@NonNull final OnSuccess<T> onSuccess, @NonNull final T t) {
        return new Runnable() {
            @Override
            public void run() {
                onSuccess.onSuccess(t);
            }
        };
    }

    /**
     * OnNext接口转换为 Runnable
     * @param t 参数
     */
    public static <T> Runnable toNextRun (@NonNull final OnNext<T> onNext, @NonNull final T t) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t);
            }
        };
    }

    /**
     * OnNext2接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     */
    public static <T1, T2> Runnable toNext2Run (@NonNull final OnNext2<T1, T2> onNext,
                                                @NonNull final T1 t1, @NonNull final T2 t2) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2);
            }
        };
    }

    /**
     * OnNext3接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     */
    public static <T1, T2, T3> Runnable toNext3Run (@NonNull final OnNext3<T1, T2, T3> onNext,
                                                    @NonNull final T1 t1, @NonNull final T2 t2,
                                                    @NonNull final T3 t3) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3);
            }
        };
    }

    /**
     * OnNext4接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     * @param t4 参数4
     */
    public static <T1, T2, T3, T4> Runnable toNext4Run (@NonNull final OnNext4<T1, T2, T3, T4> onNext,
                                                        @NonNull final T1 t1, @NonNull final T2 t2,
                                                        @NonNull final T3 t3, @NonNull final T4 t4) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3, t4);
            }
        };
    }

    /**
     * OnNext5接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     * @param t4 参数4
     * @param t5 参数5
     */
    public static <T1, T2, T3, T4, T5> Runnable toNext5Run (@NonNull final OnNext5<T1, T2, T3, T4, T5> onNext,
                                                            @NonNull final T1 t1, @NonNull final T2 t2,
                                                            @NonNull final T3 t3, @NonNull final T4 t4,
                                                            @NonNull final T5 t5) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3, t4, t5);
            }
        };
    }

    /**
     * OnNext6接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     * @param t4 参数4
     * @param t5 参数5
     * @param t6 参数6
     */
    public static <T1, T2, T3, T4, T5, T6> Runnable toNext6Run (@NonNull final OnNext6<T1, T2, T3, T4, T5, T6> onNext,
                                                                @NonNull final T1 t1, @NonNull final T2 t2,
                                                                @NonNull final T3 t3, @NonNull final T4 t4,
                                                                @NonNull final T5 t5, @NonNull final T6 t6) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3, t4, t5, t6);
            }
        };
    }

    /**
     * OnNext7接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     * @param t4 参数4
     * @param t5 参数5
     * @param t6 参数6
     * @param t7 参数7
     */
    public static <T1, T2, T3, T4, T5, T6, T7> Runnable toNext7Run (@NonNull final OnNext7<T1, T2, T3, T4, T5, T6, T7> onNext,
                                                                    @NonNull final T1 t1, @NonNull final T2 t2,
                                                                    @NonNull final T3 t3, @NonNull final T4 t4,
                                                                    @NonNull final T5 t5, @NonNull final T6 t6,
                                                                    @NonNull final T7 t7) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3, t4, t5, t6, t7);
            }
        };
    }

    /**
     * OnNext8接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     * @param t4 参数4
     * @param t5 参数5
     * @param t6 参数6
     * @param t7 参数7
     * @param t8 参数8
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8> Runnable toNext8Run (@NonNull final OnNext8<T1, T2, T3, T4, T5, T6, T7, T8> onNext,
                                                                        @NonNull final T1 t1, @NonNull final T2 t2,
                                                                        @NonNull final T3 t3, @NonNull final T4 t4,
                                                                        @NonNull final T5 t5, @NonNull final T6 t6,
                                                                        @NonNull final T7 t7, @NonNull final T8 t8) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3, t4, t5, t6, t7, t8);
            }
        };
    }

    /**
     * OnNext9接口转换为 Runnable
     * @param t1 参数1
     * @param t2 参数2
     * @param t3 参数3
     * @param t4 参数4
     * @param t5 参数5
     * @param t6 参数6
     * @param t7 参数7
     * @param t8 参数8
     * @param t9 参数9
     */
    public static <T1, T2, T3, T4, T5, T6, T7, T8, T9> Runnable toNext9Run (@NonNull final OnNext9<T1, T2, T3, T4, T5, T6, T7, T8, T9> onNext,
                                                                            @NonNull final T1 t1, @NonNull final T2 t2,
                                                                            @NonNull final T3 t3, @NonNull final T4 t4,
                                                                            @NonNull final T5 t5, @NonNull final T6 t6,
                                                                            @NonNull final T7 t7, @NonNull final T8 t8,
                                                                            @NonNull final T9 t9) {
        return new Runnable() {
            @Override
            public void run() {
                onNext.onNext(t1, t2, t3, t4, t5, t6, t7, t8, t9);
            }
        };
    }
}
