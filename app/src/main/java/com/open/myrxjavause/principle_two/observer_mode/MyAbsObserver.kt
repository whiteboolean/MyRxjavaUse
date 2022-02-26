package com.open.myrxjavause.principle_two.observer_mode

interface MyAbsObserver<T>  {
    fun update(t:T)
}