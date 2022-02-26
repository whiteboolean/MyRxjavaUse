package com.open.myrxjavause.rxjava_basic_mode;

/**
 * 抽象观察者 B
 * @param <T>
 */
public interface Observer <T >{
    //接受消息 update()
    void onNext(T t);

    //订阅observer.add(server) onSuccess
    void onSubscribe();

    //异常
    void onError(Throwable throwable);

    //接受消息完成
    void onComplete();
}
