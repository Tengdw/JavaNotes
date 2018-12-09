package com.tengdw.lambda.session10;

import java.util.Optional;

public class Person {

    private Optional<Car> car;

    public Optional<Car> getCar() {
        return car;
    }

    public Person() {
    }

    public Person(Optional<Car> car) {
        this.car = car;
    }
}
