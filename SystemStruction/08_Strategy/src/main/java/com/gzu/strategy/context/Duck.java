package com.gzu.strategy.context;

import com.gzu.strategy.fly.IFlyBehavior;
import com.gzu.strategy.speak.ISpeakBehavior;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/*
父类型
 */
@Setter
@Getter
@AllArgsConstructor

public abstract  class Duck {
protected IFlyBehavior flyBehavior;
protected ISpeakBehavior  SpeakBehavior;
public abstract void speak();
public abstract void fly();

}
