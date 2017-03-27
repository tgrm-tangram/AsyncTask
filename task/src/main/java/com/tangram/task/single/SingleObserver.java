package com.tangram.task.single;

import com.tangram.task.Observer;
import com.tangram.task.interfaces.OnError;
import com.tangram.task.interfaces.OnSuccess;

/**
 * 单任务 观察者接口
 */
public interface SingleObserver<T> extends Observer<T>, OnSuccess<T>, OnError {

}
