package com.tengdw.lambda.session10;

import java.util.Optional;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/26 14:13
 */
public class OptionalMain {
    public static void main(String[] args) {
        //声明一个空的Optional
        Optional<Car> optCar = Optional.empty();
        /*依据一个非空值创建Optional 如果car是一个null，这段代码会立即抛出一个NullPointerException，而不是等到你
        试图访问car的属性值时才返回一个错误。*/
        Car car = new Car();
        optCar = Optional.of(car);
        // 可接受null的Optional
        optCar = Optional.ofNullable(car);
        //使用 map 从 Optional 对象中提取和转换值
        Insurance insurance = new Insurance();
        Optional<Insurance> optInsurance = Optional.ofNullable(insurance);
        Optional<String> name = optInsurance.map(Insurance::getName);
        //使用 flatMap 链接 Optional 对象
        Person person = new Person();
        Optional<Person> optPerson = Optional.of(person);

    }
}
