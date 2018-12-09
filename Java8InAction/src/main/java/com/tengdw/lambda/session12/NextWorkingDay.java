package com.tengdw.lambda.session12;

import java.time.DayOfWeek;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.time.temporal.Temporal;
import java.time.temporal.TemporalAdjuster;

/**
 * 自定义 TemporalAdjuster，计算下一个工作日的日期，能够计算明天
 * 的日期，同时过滤掉周六和周日这些节假日。
 * @author Tengdw t_dw@qq.com
 * @date 2018/11/1 11:21
 */
public class NextWorkingDay implements TemporalAdjuster {

    @Override
    public Temporal adjustInto(Temporal temporal) {
        //如果当天的星期介于周一至周五之间，日期向后移动一天；如果当天是周六或者周日，则返回下一个周一。
        DayOfWeek now = DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
        int dayToAdd = 1;
        if (now == DayOfWeek.FRIDAY) {
            dayToAdd = 3;
        } else if (now == DayOfWeek.SATURDAY) {
            dayToAdd = 2;
        }
        return temporal.plus(dayToAdd, ChronoUnit.DAYS);
    }
}
