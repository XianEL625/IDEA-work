package com.gzu;

public class ConcreteDacrator2 extends Decrator {
    protected  Compenent compenent;
    public  void  setCompenent(Compenent compenent){
        this.compenent=compenent;
    }
    @Override
    public void operation() {
        compenent.operation();
        System.out.println("穿短裤");
    }
}
