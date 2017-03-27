package com.tangram.example;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.tangram.ex.R;
import com.tangram.task.task.TaskObservable;
import com.tangram.task.task.TaskObserver;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        allTest();
//        adTest(1);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_scrolling, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void allTest() {
        for (int i = 0; i < 20; i++) {
            adTest(i);
        }
    }

    public void adTest(final int i) {
        final TaskObservable<String> observable = new TaskObservable<String>() {
            @Override
            public void call(@NonNull TaskObserver<String> observer) throws Throwable {
                observer.onStart();
                Thread.sleep(1000);
                observer.onNext("task-" + i);
                Thread.sleep(1000);
                observer.onComplete();
                Thread.sleep(1000);
                Log.d("wlx||test", "sleep-" + i + " " + Thread.currentThread().getName());
            }
        };

        observable.subscribe(new TaskObserver<String>() {
            @Override
            public void onStart() {
                Log.d("wlx||test", "onStart-" + i + " " + Thread.currentThread().getName());
            }

            @Override
            public void onNext(@NonNull String s) {
                Log.d("wlx||test", s + " " + Thread.currentThread().getName());
            }

            @Override
            public void onError(Throwable e) {
                Log.e("wlx||test", "onError-" + i + " " + Thread.currentThread().getName(), e);
            }

            @Override
            public void onComplete() {
                Log.d("wlx||test", "onComplete-" + i + " " + Thread.currentThread().getName());
            }
        });
        observable.publish();
    }
}
