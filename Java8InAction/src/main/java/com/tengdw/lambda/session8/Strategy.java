package com.tengdw.lambda.session8;

/**
 * Lambda中的策略模式
 * 我们希望验证输入的内容是否根据标准进行了恰当的格式化（比如只包含小写字母或数字）。
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/24 16:59
 */
public class Strategy {

    public static void main(String[] args) {
        Validator numericValidator = new Validator(new IsNumeric());
        boolean aaa = numericValidator.validate("aaa");
        Validator lowerCaseValidator = new Validator(new IsAllLowerCase());
        boolean bbb = lowerCaseValidator.validate("bbb");

        /**使用Lambda*/
        Validator lambdaNumericValidator = new Validator((String s) -> s.matches("\\d+"));
        boolean aaaa = lambdaNumericValidator.validate("aaaa");
        Validator lambdalowerCaseValidator = new Validator((String s) -> s.matches("[a-z]+"));
        boolean bbbb = lambdalowerCaseValidator.validate("bbbb");
    }
}

/**
 * 验证接口
 */
interface ValidationStrategy{
    boolean execute(String s);
}

/**
 * 验证小写字母
 */
class IsAllLowerCase implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("[a-z]+");
    }
}

/**
 * 数字验证
 */
class IsNumeric implements ValidationStrategy {
    @Override
    public boolean execute(String s) {
        return s.matches("\\d+");
    }
}

/**
 * 校验器
 */
class Validator {
    private final ValidationStrategy strategy;

    public Validator(ValidationStrategy strategy) {
        this.strategy = strategy;
    }

    public boolean validate(String s) {
        return strategy.execute(s);
    }
}
