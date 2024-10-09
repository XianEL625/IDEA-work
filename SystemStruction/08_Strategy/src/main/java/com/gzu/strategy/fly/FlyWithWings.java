package com.gzu.strategy.fly;

public class FlyWithWings implements IFlyBehavior{
    @Override
    public void fly() {
        System.out.println("用翅膀飞行");
    }

}
