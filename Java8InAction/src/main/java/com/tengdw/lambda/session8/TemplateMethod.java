package com.tengdw.lambda.session8;

import java.util.function.Consumer;

/**
 * 模板方法
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/24 17:51
 */
public class TemplateMethod {
    public static void main(String[] args) {
        ICBCBank icbcBank = new ICBCBank();
        icbcBank.processCustomer(1337);
        //Lambda实现
        new OnlineBankingLambda().processCustomer(1337, (Customer c) -> System.out.println("Hello!"));
    }
}

/**
 * 模板方法
 */
class ICBCBank extends OnlineBanking {

    @Override
    void makeCustomerHappy(Customer c) {
        System.out.println("Hello!");
    }
}

abstract class OnlineBanking {

    public void processCustomer(int id) {
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy(c);
    }

    abstract void makeCustomerHappy(Customer c);


}
/**
 * 模板方法Lambda实现
 */
class OnlineBankingLambda {

    public void processCustomer(int id, Consumer<Customer> makeCustomerHappy){
        Customer c = Database.getCustomerWithId(id);
        makeCustomerHappy.accept(c);
    }

}

// dummy Customer class
class Customer {}
// dummy Datbase class
class Database{
    static Customer getCustomerWithId(int id){ return new Customer();}
}
