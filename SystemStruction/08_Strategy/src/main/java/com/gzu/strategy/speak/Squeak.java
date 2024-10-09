package com.gzu.strategy.speak;

public class Squeak implements ISpeakBehavior {

    @Override
    public void speak() {
        System.out.println("橡皮声");
    }
}
