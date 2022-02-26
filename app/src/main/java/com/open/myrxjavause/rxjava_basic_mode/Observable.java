package com.open.myrxjavause.rxjava_basic_mode;

public abstract class Observable implements ObservableResource {

    @Override
    public void subscribeObserver(Observer observer) {
        //observer.onNext(msg) ；发消息这个功能，是由程序员来完成的
        //把发消息的事情，预留给程序员去干就行了
        subscribeActual(observer);
    }

    protected abstract void subscribeActual(Observer observer);

    //创建程序员使用的方法
    public static <T> Observable create(ObservableOnSubscribe<T> source){
        return new ObservableCreate<>(source);
    }
}
