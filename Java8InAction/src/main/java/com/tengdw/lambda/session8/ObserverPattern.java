package com.tengdw.lambda.session8;

import java.util.ArrayList;
import java.util.List;

/**
 * 观察者模式
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/25 10:14
 */
public class ObserverPattern {
    public static void main(String[] args) {
        Feed f = new Feed();
        f.registerObserver(new NYTimes());
        f.registerObserver(new Guardian());
        f.registerObserver(new LeMonde());

        f.notifyObservers("The queen said her favourite book is Java 8 in Action!");
        /*使用Lambda*/
        Feed feed = new Feed();
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("money")) {
                System.out.println("Breaking news in NY! " + tweet);
            }
        });
        feed.registerObserver((String tweet) -> {
            if (tweet != null && tweet.contains("queen")) {
                System.out.println("Yet another news in London... " + tweet);
            }
        });
        feed.notifyObservers("The queen said her favourite book is Java 8 in Action!");
    }
}

/**
 * 假设有好几家报纸机构，比如《纽约时报》《卫报》以及《世界报》都订阅了新闻，
 * 他们希望当接收的新闻中包含他们感兴趣的关键字时，能得到特别通知。
 */
interface Observer {
    void notify(String tweet);
}

class NYTimes implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("money")) {
            System.out.println("Breaking news in NY! " + tweet);
        }
    }
}

class Guardian implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("queen")) {
            System.out.println("Yet another news in London... " + tweet);
        }
    }
}

class LeMonde implements Observer {

    @Override
    public void notify(String tweet) {
        if (tweet != null && tweet.contains("wine")) {
            System.out.println("Today cheese, wine and news! " + tweet);
        }
    }
}

/**
 * 订阅接口
 */
interface Subject{
    void registerObserver(Observer o);
    void notifyObservers(String tweet);
}

class Feed implements Subject {
    private final List<Observer> observers = new ArrayList<>();

    @Override
    public void registerObserver(Observer o) {
        this.observers.add(o);
    }

    @Override
    public void notifyObservers(String tweet) {
        observers.forEach(o -> o.notify(tweet));
    }
}