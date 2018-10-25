package com.tengdw.lambda.session8;

import java.util.function.Function;
import java.util.function.UnaryOperator;

/**
 * 责任链模式
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/25 11:39
 */
public class ChainOfResponsibility {
    public static void main(String[] args) {
        ProcessingObject<String> p1 = new HeaderTextProcessing();
        ProcessingObject<String> p2 = new SpellCheckerProcessing();
        p1.setSuccessor(p2);
        String result = p1.handle("Aren't labdas really sexy?!!");
        System.out.println(result);
        //使用Lambda
        UnaryOperator<String> headerProcessing = s -> "From Raoul, Mario and Alan: " + s;
        UnaryOperator<String> spellCheckProcessing = s -> s.replaceAll("labda", "lambda");
        Function<String, String> pipeline = headerProcessing.andThen(spellCheckProcessing);
        String apply = pipeline.apply("Aren't labdas really sexy?!!");
        System.out.println(apply);
    }
}

abstract class ProcessingObject<T> {

    protected ProcessingObject<T> successor;
    public void setSuccessor(ProcessingObject<T> successor) {
        this.successor = successor;
    }

    public T handle(T input) {
        T r = handleWork(input);
        if (successor != null) {
            return successor.handle(r);
        }
        return r;
    }

    abstract protected T handleWork(T input);
}

class HeaderTextProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return "From Raoul, Mario and Alan: " + input;
    }
}

class SpellCheckerProcessing extends ProcessingObject<String> {

    @Override
    protected String handleWork(String input) {
        return input.replaceAll("labda", "lambda");
    }
}