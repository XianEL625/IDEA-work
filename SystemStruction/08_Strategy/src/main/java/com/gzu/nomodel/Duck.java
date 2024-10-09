package com.gzu.nomodel;

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
protected String type;
public abstract void speak();
public abstract void fly();
public abstract void display();

}
