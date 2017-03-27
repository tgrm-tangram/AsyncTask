package com.tangram.task.interfaces;

import android.support.annotation.NonNull;

/**
 * 下一步 1个参数
 */
public interface OnNext<T> {

    void onNext(@NonNull T t);

}
