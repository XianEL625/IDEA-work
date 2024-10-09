import java.util.Scanner;

public class Simple {
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
                result=numberA+numberB;
                break;
            case "-":
                result=numberA-numberB;
            default:
                throw new RuntimeException("运算符号错误！");
        }
        System.out.println(result);
    }
}
