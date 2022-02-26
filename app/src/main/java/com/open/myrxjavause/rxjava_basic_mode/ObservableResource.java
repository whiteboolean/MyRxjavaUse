package com.open.myrxjavause.rxjava_basic_mode;

public interface ObservableResource<T> {

    void subscribeObserver(Observer<T> observer);

}
