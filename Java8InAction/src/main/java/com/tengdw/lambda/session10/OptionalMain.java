package com.tengdw.lambda.session10;

import org.junit.Test;

import java.util.Optional;
import java.util.Properties;

import static org.junit.Assert.assertEquals;


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
        //使用 flatMap 链接 Optional 对象 使用Optional获取car的Insurance名称
        Car car1 = new Car(Optional.ofNullable(insurance));
        Person person = new Person(Optional.ofNullable(car1));
        Optional<Person> optPerson = Optional.of(person);
        String carInsuranceName = getCarInsuranceName(optPerson);
        System.out.println(carInsuranceName);

        Optional<Integer> integer = stringToInt("a");
        System.out.println(integer.isPresent());


    }

    @Test
    public void test() {
        Properties props = new Properties();
        props.setProperty("a", "5");
        props.setProperty("b", "true");
        props.setProperty("c", "-3");

        assertEquals(5, readDurationImperative(props, "a"));
        assertEquals(0, readDurationImperative(props, "b"));
        assertEquals(0, readDurationImperative(props, "c"));
        assertEquals(0, readDurationImperative(props, "d"));

        assertEquals(5, readDurationWithOptional(props, "a"));
        assertEquals(0, readDurationWithOptional(props, "b"));
        assertEquals(0, readDurationWithOptional(props, "c"));
        assertEquals(0, readDurationWithOptional(props, "d"));

    }

    public static String getCarInsuranceName(Optional<Person> person) {
        return person.flatMap(Person::getCar)
                .flatMap(Car::getInsurance)
                .map(Insurance::getName)
                .orElse("Unknown");
    }

    public static Optional<Integer> stringToInt(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

    public static int readDurationImperative(Properties props, String name) {
        String value = props.getProperty(name);
        if (value != null) {
            try {
                int i = Integer.parseInt(value);
                if (i > 0) {
                    return i;
                }
            } catch (NumberFormatException nfe) { }
        }
        return 0;
    }

    public static int readDurationWithOptional(Properties props, String name) {
        return Optional.ofNullable(props.getProperty(name))
                .flatMap(OptionalMain::s2i)
                .filter(i -> i > 0)
                .orElse(0);
    }

    public static Optional<Integer> s2i(String s) {
        try {
            return Optional.of(Integer.parseInt(s));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }

}
