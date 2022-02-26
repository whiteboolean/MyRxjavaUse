package com.open.myrxjavause.rxjava_basic_mode;

public interface Emitter <T>{

    //接收消息 update()
    void onNext(T t);
    void onError(Throwable e);
    void onComplete();
}
