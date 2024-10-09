package com.gzu.bll;
/*
封装业务逻辑
 */
public class Operation {
    //作用：根据运算符获得对应的运算类对象
    //”生产“对应运算类的对象
    protected double numberA;
    protected double numberB;

    public double getNumberA() {
        return numberA;
    }

    public void setNumberA(double numberA) {
        this.numberA = numberA;
    }

    public double getNumberB() {
        return numberB;
    }

    public void setNumberB(double numberB) {
        this.numberB = numberB;
    }
    public abstract double getResult();
}