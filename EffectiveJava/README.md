## Effective Java 第二版
总共讲了78条规则，指导我们编写出更规范的代码
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

#### 16. 复合优先于继承

#### 17. 

#### 18. 

#### 19. 

#### 20. 

#### 21. 

#### 22. 

#### 23. 

#### 24. 

#### 25. 

#### 26. 

#### 27. 

#### 28. 

#### 29. 

#### 30. 

#### 31. 

#### 32. 

#### 33. 

#### 34. 

#### 35. 

#### 36. 

#### 37. 

#### 38. 

#### 39. 

#### 40. 

#### 41. 

#### 42. 

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

