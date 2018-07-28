## Effective Java 第二版
总共讲了78条规则，指导我们编写出更规范的代码。
> 目录
#### 1. 考虑静态工厂方法代替构造器

#### 2. [遇到多个构造器参数时要考虑用构建器](./src/main/java/com/tengdw/rule/rule2.java)

#### 3. [用私有构造器或者枚举类型强化 Singleton 属性](./src/main/java/com/tengdw/rule/rule3.java)

#### 4. 通过私有构造器强化不可实例化能力

例如：
```
// 工具类
public class utilityClass {
    private utilityClass() {
        throw new AssertionError();
    }
    
}
```
#### 5. 避免创建不必要的对象

#### 6. [消除过期的对象引用](/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule6.java)

#### 7. 避免使用终结方法 finalize()

#### 8. 覆盖 equals 时请遵循通用约定
通用约定
- 自反性
- 对称性
- 传递性
- 一致性
- 非空性，对于任何非 null 的引用值 X ，`x.equals(null)`必须返回 false
#### 9. 覆盖 equals 时总要覆盖 hashCode

#### 10. 始终要覆盖 toString

#### 11. 谨慎地覆盖 clone

#### 12. 考虑实现 Comparable 接口

#### 13. 使类和成员的可访问性最小化

#### 14. 在公有类中使用访问方法而非公有域

#### 15. 使可变性最小化
- 不要提供任何会修改对象状态的方法
- 保证类不会被扩展
- 使所有的域都是 final 的
- 使所有的域都成为私有的
- 确保对于任何可变组件的互斥访问

#### 16. [复合优先于继承](/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule16.java)

#### 17. 要么为继承而设计，并提供文档说明，要么就禁止继承

#### 18. 接口优于抽象类
- 现有的类可以很容易被更新，以实现新的接口
- 接口是定义 mixin（混合类型）的理想选择
- 接口允许我们构造非层次结构的类型框架

#### 19. 接口只用于定义类型
*常量接口模式是对接口的不良使用，JDK 源码中也用这种写法*

#### 20. [类层次优于标签类](/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule20.java)

#### 21. 用函数对象表示策略

#### 22. 优先考虑静态成员类

#### 23. 请不要再新代码中使用原生态类型

#### 24. 消除非受检警告
就是 `@SuppressWarnings("unchecked)` 那个注解

#### 25. 列表优先于数组

#### 26. 优先考虑泛型

#### 27. 优先考虑泛型方法

#### 28. 利用有限制通配符来提升 API 的灵活性

#### 29. 优先考虑类型安全的异构容器

#### 30. [用 enum 代替 int 常量](/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule30.java)

#### 31. 用实例域代替序数

#### 32. 用 EnumSet 代替位域

#### 33. 用 EnumMap 代替序数索引

#### 34. [用接口模拟可伸缩的枚举](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule34.java)

#### 35. 注解优先于命名模式

#### 36. 坚持使用 Override 注解

#### 37. 用标记接口定义类型

#### 38. 检查参数的有效性

#### 39. 必要时进行保护性拷贝

#### 40. 谨慎设计方法签名

#### 41. 慎用重载

#### 42. 慎用可变参数
```java
static int min(int... args) {
    //...
}
```

#### 43. 返回零长度的数组或者集合，而不是 null

#### 44. 为所有导出的 API 元素编写文档注释

#### 45. 将局部变量的作用域最小化

#### 46. for-each 循环优先于传统的 for 循环
```java
// for-each 循环
for (Element e : elements) {
    doSomething(e);
}
```

#### 47. 了解和使用类库

#### 48. 如果需要精确的答案，请避免使用 float 和 double
```java
// 下面算出来会丢失精度，货币计算时推荐使用 BigDecimal
System.out.println(1.03 - .42);
```

#### 49. 基本类型优先于装箱基本类型

#### 50. 如果其他类型更适合，则尽量避免使用字符串

#### 51. 当心字符串连接的性能

#### 52. 通过接口引用对象

#### 53. 接口优先于反射机制
使用反射机制：
- 丧失了编译时类型检查的好处
- 执行反射访问所需要的代码非常笨拙和冗长
- 性能损失

#### 54. 谨慎地使用本地方法
本地方法（native method），Java中某些方法是用 C 或 C++ 写的

#### 55. 谨慎地进行优化

#### 56. 遵守普遍接受的命名惯例

#### 57. 只针对异常情况才使用异常

#### 58. 对可恢复的情况使用受检异常，对编程错误使用运行时异常

#### 59. 避免不必要地使用受检的异常

#### 60. 优先使用标准的异常

#### 61. 抛出与抽象相对应的异常

#### 62. 每个方法抛出的异常都要有文档

#### 63. 在细节消息中包含能捕获的信息

#### 64. 努力使失败保持原子性

#### 65. 不要忽略异常

#### 66. 同步访问共享的可变数据

#### 67. 避免过度同步

#### 68. executor 和 task 优先于线程
```java
ExecutorService executor = Executor.newSingleThreadExecutor();
executor.execute(runable);
executor.shutdown();
```

#### 69. 并发工具优先于 wait 和 notify

#### 70. 线程安全性的文档化

#### 71. 慎用延迟初始化

#### 72. 不要依赖于线程调度器

#### 73. 避免使用线程组

#### 74. 谨慎地实现 Serializable 接口

#### 75. 考虑使用自定义的序列化形式

#### 76. 保护性的编写 readObject 方法

#### 77. 对于实例控制，枚举类型优先于 readObject

#### 78. 考虑用序列化代理代替实例化实例

