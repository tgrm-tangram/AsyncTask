package com.tangram.task.interfaces;

import android.support.annotation.NonNull;

/**
 * 下一步 3个参数
 */
public interface OnNext3<T1, T2, T3> {

    void onNext(@NonNull  T1 t1, @NonNull T2 t2, @NonNull  T3 t3);

}
