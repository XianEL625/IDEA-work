package com.gzu.nomodel;

import com.gzu.strategy.speak.ISpeakBehavior;

public class MallarDuck extends Duck {

    public MallarDuck(String type) {
        super(type);
    }

    @Override
    public void speak(){
        System.out.println();
    }
    @Override
    public void fly(){
        System.out.println();
    }
    @Override
    public void display(){
        System.out.println();
    }


}
