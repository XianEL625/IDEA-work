package com.gzu;

public class main {
    public static void main(String[] args){
        Compenent compenent=new ConcreteCompnent();//获得赤裸身体
        Decrator decrator=new ConcreteDacrator();
        Decrator decrator1=new ConcreteDacrator2();
        //将三个对象形成注释
        decrator.setCompenent(decrator1);
        decrator1.setCompenent(compenent);
        decrator.operation();//则会执行operation方法中decrator1.operation();中的穿短裤再执行System.out.println("穿长裤");
        decrator1.operation();
    }
}
