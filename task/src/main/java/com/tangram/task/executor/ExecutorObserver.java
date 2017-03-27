package com.tangram.task.executor;

import com.tangram.task.Observer;
import com.tangram.task.interfaces.OnComplete;
import com.tangram.task.interfaces.OnError;

/**
 * 执行器观察者
 */
public interface ExecutorObserver extends Observer<Void>, OnError, OnComplete {

}
