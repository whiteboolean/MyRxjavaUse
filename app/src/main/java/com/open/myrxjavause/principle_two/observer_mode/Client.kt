package com.open.myrxjavause.principle_two.observer_mode

fun main() {

    val observableImpl = MyObservableImpl()
    val observer1 = MyObserverImpl("张三")
    val observer2 = MyObserverImpl("李四")
    val observer3 = MyObserverImpl("王五")

    observableImpl.apply {
        addObserver(observer1)
        addObserver(observer2)
        addObserver(observer3)
    }


}