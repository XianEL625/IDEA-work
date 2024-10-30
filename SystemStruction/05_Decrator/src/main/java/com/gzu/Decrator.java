package com.gzu;

public abstract class Decrator implements Compenent{
    protected  Compenent compenent;//指针指向实体
    public  void  setCompenent(Compenent compenent){
        this.compenent=compenent;
    }
    @Override
    public void operation() {

    }
}
