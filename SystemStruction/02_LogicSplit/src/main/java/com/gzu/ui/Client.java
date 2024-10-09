package com.gzu.ui;

import com.gzu.bll.AddOperation;
import com.gzu.bll.Operation;
import com.gzu.bll.SubOperation;

import java.util.Scanner;

public class Client {
    public static  void main(String[] args){
        double numberA,numberB;
        double result;
        String operator;
        //界面逻辑——控制台
        Scanner input =new Scanner(System.in);
        numberA= input.nextDouble();
        numberB=input.nextDouble();
        operator=input.next();
        //业务逻辑部分
       switch(operator){
           case"+":
               AddOperation addOperation=new AddOperation();
               addOperation.setNumberA(numberA);
               addOperation.setNumberB(numberB);
               result=addOperation.getResult();
               break;
           case"-":
               SubOperation subOperation=new SubOperation();
               subOperation.setNumberB(numberB);
               subOperation.setNumberA(numberA);
               break;
           default:
               throw new RuntimeException();
       }
        System.out.println(result);
    }
}
