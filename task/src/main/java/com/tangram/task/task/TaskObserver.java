package com.tangram.task.task;

import com.tangram.task.Observer;
import com.tangram.task.interfaces.OnComplete;
import com.tangram.task.interfaces.OnError;
import com.tangram.task.interfaces.OnNext;
import com.tangram.task.interfaces.OnStart;

/**
 * 任务观察者
 */
public interface TaskObserver<T> extends Observer<T>, OnStart, OnNext<T>, OnError, OnComplete {

}
