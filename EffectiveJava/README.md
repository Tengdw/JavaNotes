## Effective Java 第二版
总共讲了78条规则，指导我们编写出更规范的代码。
> 目录
#### 1. 考虑静态工厂方法代替构造器

#### 2. [遇到多个构造器参数时要考虑用构建器](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule2.java)

#### 3. [用私有构造器或者枚举类型强化 Singleton 属性](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule3.java)

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

#### 6. [消除过期的对象引用](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule6.java)

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

#### 16. [复合优先于继承](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule16.java)

#### 17. 要么为继承而设计，并提供文档说明，要么就禁止继承

#### 18. 接口优于抽象类
- 现有的类可以很容易被更新，以实现新的接口
- 接口是定义 mixin（混合类型）的理想选择
- 接口允许我们构造非层次结构的类型框架

#### 19. 接口只用于定义类型
*常量接口模式是对接口的不良使用，JDK 源码中也用这种写法*

#### 20. [类层次优于标签类](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule20.java)

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

#### 30. [用 enum 代替 int 常量](https://github.com/Tengdw/JavaNotes/blob/master/EffectiveJava/src/main/java/com/tengdw/rule/rule30.java)

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

#### 43. 

#### 44. 

#### 45. 

#### 46. 

#### 47. 

#### 48. 

#### 49. 

#### 50. 

#### 51. 

#### 52. 

#### 53. 

#### 54. 

#### 55. 

#### 56. 

#### 57. 

#### 58. 

#### 59. 

#### 60. 

#### 61. 

#### 62. 

#### 63. 

#### 64. 

#### 65. 

#### 66. 

#### 67. 

#### 68. 

#### 69. 

#### 70. 

#### 71. 

#### 72. 

#### 73. 

#### 74. 

#### 75. 

#### 76. 

#### 77. 

#### 78. 

