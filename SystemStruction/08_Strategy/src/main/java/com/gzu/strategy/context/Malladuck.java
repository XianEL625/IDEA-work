package com.gzu.strategy.context;

import com.gzu.strategy.fly.IFlyBehavior;
import com.gzu.strategy.speak.ISpeakBehavior;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Malladuck extends Duck{
  public Malladuck(IFlyBehavior flyBehavior, ISpeakBehavior speakBehavior){
      super();
      super.flyBehavior=flyBehavior;
      super.SpeakBehavior=speakBehavior;
  }


    @Override
    public void speak() {
    }

    @Override
    public void fly() {

    }
}
