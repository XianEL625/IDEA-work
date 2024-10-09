package com.gzu.bll;
        /*
        只负责完成加法操作
        符合：类的功能单一化原则
         */
public class AddOperation extends Operation {
    public double getResult(){
                      return numberA+numberB;
    }
}
