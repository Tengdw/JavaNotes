package com.tengdw.lambda.session10;

import java.util.Optional;

public class Car {

    private Optional<Insurance> insurance;

    public Optional<Insurance> getInsurance() {
        return insurance;
    }

    public Car() {
    }

    public Car(Optional<Insurance> insurance) {
        this.insurance = insurance;
    }
}
