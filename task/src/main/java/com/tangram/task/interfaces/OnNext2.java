package com.tangram.task.interfaces;

import android.support.annotation.NonNull;

/**
 * 下一步 2个参数
 */
public interface OnNext2<T1, T2> {

    void onNext(@NonNull T1 t1, @NonNull  T2 t2);

}
