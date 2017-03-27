package com.tangram.task.interfaces;

import android.support.annotation.NonNull;

/**
 * 成功
 */
public interface OnSuccess<T> {
    void onSuccess(@NonNull T t);
}
