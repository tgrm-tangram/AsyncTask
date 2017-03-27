package com.tangram.ex;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import com.tangram.task.executor.ExecutorObservable;
import com.tangram.task.executor.ExecutorObserver;
import com.tangram.task.single.SingleObservable;
import com.tangram.task.single.SingleObserver;
import com.tangram.task.task.TaskObservable;
import com.tangram.task.task.TaskObserver;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.assertEquals;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.tangram.asynctask", appContext.getPackageName());

        test1();
    }

    @Test
    public void test1() {
        SingleObserver<String> single = new SingleObserver<String>() {
            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onSuccess(@NonNull String s) {

            }
        };

        SingleObservable<String> observable = new SingleObservable<String>() {
            @Override
            public void call(@NonNull SingleObserver<String> observer) throws Throwable {
                observer.onSuccess("SUCCESS");
            }
        };

        observable.subscribe(single);

        observable.publish();
    }

    @Test
    public void test2() {

        ExecutorObservable executor = new ExecutorObservable() {
            @Override
            public void call(@NonNull ExecutorObserver observer) throws Throwable {
                observer.onComplete();
            }
        };

        executor.subscribe(new ExecutorObserver() {
            @Override
            public void onComplete() {
                Log.d("wlx||test", "onComplete-" + " " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        executor.publish();

    }

    @Test
    public void test3() {
        TaskObservable<Result> task = new TaskObservable<Result>() {
            @Override
            public void call(@NonNull TaskObserver<Result> observer) throws Throwable {
                observer.onStart();
                for (int i = 0; i < 10; i++) {
                    Result result = new Result("结果1");
                    observer.onNext(result);
                }
                observer.onComplete();
            }
        };

        task.subscribe(new TaskObserver<Result>() {
            @Override
            public void onComplete() {

            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onNext(@NonNull Result result) {
                Log.d("wlx", result.getName());
            }

            @Override
            public void onStart() {

            }
        });
    }

    static class Result {
        private String name;

        public Result(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }
    }
}
