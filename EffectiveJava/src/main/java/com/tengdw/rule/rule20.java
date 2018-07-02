package com.tengdw.rule;

/**
 * 20. 类层次优于标签类
 */
public class rule20 {
}

abstract class Figura {
    abstract double area();
}

class Circle extends Figura {
    final double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double area() {
        return Math.PI * Math.pow(radius, 2);
    }
}

class Rectangle extends Figura {
    final double length;
    final double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double area() {
        return length * width;
    }
}
// 类层次更灵活，正方形是一种特殊的矩形
class Square extends Rectangle {
    Square(double side) {
        super(side, side);
    }
}

/**
 * 不推荐的写法
 */
class Figure {

    // 枚举定于圆形和矩形
    enum Shape {
        RECTANGLE, CIRCLE;
    }
    final Shape shape;

    double length;
    double width;

    double radius;

    Figure(double radius) {
        shape = Shape.CIRCLE;
        this.radius = radius;
    }

    Figure(double length, double width) {
        shape = Shape.RECTANGLE;
        this.length = length;
        this.width = width;
    }

    double area() {
        switch (shape) {
            case CIRCLE:
                return Math.PI * Math.pow(radius, 2);
            case RECTANGLE:
                return length * width;
            default:
                throw new AssertionError();
        }
    }

}
