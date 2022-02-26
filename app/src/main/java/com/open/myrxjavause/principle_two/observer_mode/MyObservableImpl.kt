package com.open.myrxjavause.principle_two.observer_mode

class MyObservableImpl : MyAbsObservable<MyAbsObserver<String>> {

    protected val observers = mutableListOf<MyAbsObserver<String>>()
    protected lateinit var message: String

    @Synchronized
    override fun addObserver(t: MyAbsObserver<String>) {
        observers.add(t)
    }

    @Synchronized
    override fun removeObserver(t: MyAbsObserver<String>) {
        if (observers.contains(t)) {
            observers.remove(t)
        }
    }

    override fun notifyAllObservers() {
        for (myAbsObserver in observers) {
            if (::message.isInitialized) {
                myAbsObserver.update(message)
            }
        }
    }

    override fun pushMessage(message: String) {
        this.message = message
        notifyAllObservers()
    }
}