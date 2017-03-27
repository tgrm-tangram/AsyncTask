### AsyncTask 
AsyncTask是一个轻量级、简单易用、灵活可扩展的Android异步任务库。执行任务在子线程，回调在UI线程。
    
### 如何开始
AsyncTask提供了三种默认实现 executor、single、task，分别是执行器、单任务、多任务。 当然，完全可以自定义一个异步任务，实现起来也是十分简单的.

使用时需要实现被观察者、观察者接口，并调用被观察者的`publish()`方法。

executor 实例:

        ExecutorObservable executor = new ExecutorObservable() {
            @Override
            public void call(@NonNull ExecutorObserver observer) throws Throwable {
                observer.onComplete();
            }
        };

        executor.subscribe(new ExecutorObserver() {
            @Override
            public void onComplete() {
            
            }

            @Override
            public void onError(Throwable e) {

            }
        });

        executor.publish();
        
single 实例:

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
        
task 实例:

        TaskObservable<Result> task = new TaskObservable<Result>() {
            @Override
            public void call(@NonNull TaskObserver<Result> observer) throws Throwable {
                observer.onStart();
                for (int i = 0; i < 10; i++) {
                    Result result = new Result("result " + i);
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
                Log.d("test", result.getName());
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
