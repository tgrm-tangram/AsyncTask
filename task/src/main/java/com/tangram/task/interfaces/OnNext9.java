package com.tangram.task.interfaces;

import android.support.annotation.NonNull;

/**
 * 下一步 8个参数
 */
public interface OnNext9<T1, T2, T3, T4, T5, T6, T7, T8, T9> {

    void onNext(@NonNull T1 t1,@NonNull T2 t2,@NonNull T3 t3,@NonNull T4 t4,@NonNull T5 t5,
                @NonNull T6 t6,@NonNull T7 t7,@NonNull T8 t8,@NonNull T9 t9);

}
