package com.open.myrxjavause.principle_two.observer_mode

class MyObserverImpl(val name:String) : MyAbsObserver<String> {

    override fun update(t: String) {
        println("$name 收到了推送的额消息:$t")
    }

}