package com.open.myrxjavause.principle_two.rxjava_hook;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;

import com.open.myrxjavause.R;
import com.uber.autodispose.AutoDispose;
import com.uber.autodispose.android.lifecycle.AndroidLifecycleScopeProvider;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.plugins.RxJavaPlugins;
import io.reactivex.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        RxJavaPlugins.setOnObservableAssembly(new Function<Observable, Observable>() {
            @Override
            public Observable apply(Observable observable) throws Exception {
                Log.d(TAG, "apply：整个项目全局监听到底有多少地方使用RxJava：" + observable);
                return observable;
            }
        });

        hook();

        observer2();

        map();
    }

    private void map() {
        Observable.create(
                //自定义source
                new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext("123");
            }
        })
                .map(new Function<Object, String>() {
                    @Override
                    public String apply(Object o) throws Exception {
                        return o.toString();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(
                        //自定义观察者（终点）
                        new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {

            }
        });
    }

    private void observer2() {
        /**
         * 1.Observer 源码
         * 2.create 源码
         * 3.subscribe 源码
         */
        Observable.create(
                //自定义source
                new ObservableOnSubscribe<String>() {
                    @Override
                    public void subscribe(ObservableEmitter<String> emitter) throws Exception {
                        emitter.onNext("123");
                    }
                }).as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))

                //new ObservableCreate<T>(source).subscribe
                .subscribe(
                        // 自定义观察者
                        new Observer<String>() {
                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(String s) {

                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });
    }


    private void hook() {


        Observable.create(new ObservableOnSubscribe<Object>() {
            @Override
            public void subscribe(ObservableEmitter<Object> emitter) throws Exception {
                emitter.onNext("123");
            }
        }).map(new Function<Object, Boolean>() {
            @Override
            public Boolean apply(Object o) throws Exception {
                return true;
            }
        })
                .as(AutoDispose.autoDisposable(AndroidLifecycleScopeProvider.from(this)))
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {

                    }
                });
    }
}