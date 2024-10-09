package com.gzu.strategy.speak;

public class Quack implements ISpeakBehavior {
    @Override
    public void speak() {
        System.out.println("嘎嘎");
    }
}
