package com.tangram.task.interfaces;

import android.support.annotation.NonNull;

/**
 * 下一步 6个参数
 */
public interface OnNext6<T1, T2, T3, T4, T5, T6> {

    void onNext(@NonNull T1 t1, @NonNull T2 t2, @NonNull T3 t3, @NonNull T4 t4,
                @NonNull T5 t5, @NonNull T6 t6);

}
