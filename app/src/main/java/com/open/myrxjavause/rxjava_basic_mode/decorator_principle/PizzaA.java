package com.open.myrxjavause.rxjava_basic_mode.decorator_principle;

public class PizzaA extends Decorator{

    private Pizza pizza;
    public PizzaA(Pizza pizza){this.pizza = pizza;}


    @Override
    int getPrice() {
        return 0;
    }
}
