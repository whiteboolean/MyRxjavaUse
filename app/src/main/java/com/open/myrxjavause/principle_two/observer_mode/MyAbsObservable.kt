package com.open.myrxjavause.principle_two.observer_mode

/**
 * 抽象的被观察者
 */
interface MyAbsObservable<T> {
    fun addObserver(t:T)
    fun removeObserver(t:T)
    fun notifyAllObservers()
    fun pushMessage(message:String)
}