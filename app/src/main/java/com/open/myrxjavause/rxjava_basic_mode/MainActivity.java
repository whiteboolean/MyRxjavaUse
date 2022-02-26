package com.open.myrxjavause.rxjava_basic_mode;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.open.myrxjavause.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        Observable.create(new ObservableOnSubscribe<String>() {
            @Override
            public void subscribe(Emitter<String> emitter) {
                emitter.onNext("大家好");
            }
        }).subscribeObserver(new Observer<String>() {
            @Override
            public void onNext(String s) {

            }

            @Override
            public void onSubscribe() {

            }

            @Override
            public void onError(Throwable throwable) {

            }

            @Override
            public void onComplete() {

            }
        });

    }
}