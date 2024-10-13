package com.gzu;
class PurchaseRequest{
    public  double  Amount;
    public int Number;
    public String Purpose;
}
/*
审批者父类型
 */
abstract class Approve {
    protected Approve successor;
    public  abstract  void  ProcessRequest(PurchaseRequest aRequest);
    public void setSuccessor(Approve successor){
        this.successor=successor;
    }
    public void PassRequest(PurchaseRequest aRequest){
    if(successor!=null)//后继者存在
    {successor.PassRequest(aRequest);
    }}
}
/*
主任类
 */
class Director extends Approve{
    public void ProcessRequest(PurchaseRequest aRequest){
     if(aRequest.Amount<5000){
         System.out.println("主任审批了");
        }else{
super.PassRequest(aRequest);
        }
    }
}
class Vispresident extends Approve{
    public void ProcessRequest(PurchaseRequest aRequest){
        if(aRequest.Amount<10000){
            System.out.println("副董事长审批了");
        }else{
            super.PassRequest(aRequest);
        }
    }
}
class President extends Approve{
    public void ProcessRequest(PurchaseRequest aRequest){
        if(aRequest.Amount<50000){
            System.out.println("董事长审批了");
        }else{
            super.PassRequest(aRequest);
        }
    }
}
class Meeting extends Approve{
    public void ProcessRequest(PurchaseRequest aRequest){
        if(aRequest.Amount>=50000){
            System.out.println("董事会审批了");
        }else{
            super.PassRequest(aRequest);
        }
    }
}
public class RS {
    Meeting Meeting=new Meeting();
    Vispresident Sam=new Vispresident();
    Director Larry=new Director();
    President Tammry=new President();
    Meeting.setSuccessor(null);
    Sam.setSuccessor(Tammry);
    Tammry.setSuccessor(Meeting);
    Larry.setSuccessor(Sam);
    PurchaseRequest aRequest=new PurchaseRequest();
    Larry.ProcessRequest(aRequest);

}