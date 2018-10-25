package com.tengdw.lambda.session8;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

/**
 * 工厂模式
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/25 15:23
 */
public class FactoryPattern {
    public static void main(String[] args) {
        Product p1 = ProductFactory.createProduct("loan");
        //使用Lambda
        Supplier<Product> loanSupplier = Loan::new;
        Product p2 = loanSupplier.get();

        Product p3 = ProductFactory.createProductLambda("loan");
    }

}

class ProductFactory {

    final static private Map<String, Supplier<Product>> map = new HashMap<>();
    static {
        map.put("loan", Loan::new);
        map.put("stock", Stock::new);
        map.put("bond", Bond::new);
    }
    public static Product createProduct(String name) {
        switch (name) {
            case "loan":
                return new Loan();
            case "stock":
                return new Stock();
            case "bond":
                return new Bond();
            default:
                throw new RuntimeException("No such product " + name);
        }
    }

    public static Product createProductLambda(String name) {
        Supplier<Product> p = map.get(name);
        if (p != null) {
            return p.get();
        }
        throw new RuntimeException("No such product " + name);
    }
}

interface Product {

}

class Loan implements Product { }

class Stock implements Product { }

class Bond implements Product { }