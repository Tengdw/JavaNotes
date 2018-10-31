package com.tengdw.lambda.session12;

import org.junit.Test;

import java.time.*;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * @author Tengdw t_dw@qq.com
 * @date 2018/10/31 15:51
 */
public class TimeMain {
    public static void main(String[] args) {
        LocalDate date = LocalDate.of(2018, 10, 31);
        int year = date.getYear();
        Month month = date.getMonth();
        int day = date.getDayOfMonth();
        DayOfWeek dow = date.getDayOfWeek();
        int len = date.lengthOfMonth();
        boolean leap = date.isLeapYear();

    }

    @Test
    public void temporalField() {
        //使用TemporalField读取LocalDate的值
        LocalDate date = LocalDate.now();
        int year1 = date.get(ChronoField.YEAR);
        int month1 = date.get(ChronoField.MONTH_OF_YEAR);
        int day1 = date.get(ChronoField.DAY_OF_MONTH);
        //创建LocalTime并读取其值
        LocalTime time = LocalTime.of(16, 10, 25);
        int hour = time.getHour();
        int minute = time.getMinute();
        int second = time.getSecond();
        //通过字符串创建LocalDate、LocalTime
        LocalDate parseDate = LocalDate.parse("2018-10-31");
        LocalTime parseTime = LocalTime.parse("16:10:20");
        //合并日期和时间
        LocalDateTime dt1 = LocalDateTime.of(2018, Month.OCTOBER, 31, 16, 15, 20);
        LocalDateTime dt2 = LocalDateTime.of(date, time);
        LocalDateTime dt3 = date.atTime(16, 15, 40);
        LocalDateTime dt4 = date.atTime(time);
        LocalDate date1 = dt1.toLocalDate();
        LocalTime time1 = dt1.toLocalTime();
        //机器的日期和时间格式
        Instant instant1 = Instant.ofEpochSecond(3);
        Instant instant2 = Instant.ofEpochSecond(3, 0);
        Instant instant3 = Instant.ofEpochSecond(2, 1_000_000_000);
        Instant instant4 = Instant.ofEpochSecond(4, -1_000_000_000);
        int day = Instant.now().get(ChronoField.DAY_OF_MONTH);
        System.out.println();
    }

    @Test
    public void durationTest() {
        LocalTime time1 = LocalTime.parse("16:15:40");
        LocalTime time2 = LocalTime.parse("20:15:40");
        LocalDateTime dateTime1 = LocalDateTime.of(2018, Month.OCTOBER, 31, 16, 15, 20);
        LocalDateTime dateTime2 = LocalDateTime.parse("2018-10-31T20:15:30");
        Instant instant1 = Instant.parse("2018-10-31T16:15:30.00Z");
        Instant instant2 = Instant.parse("2018-10-31T20:15:30.00Z");
        Duration d1 = Duration.between(time1, time2);
        Duration d2 = Duration.between(dateTime1, dateTime2);
        Duration d3 = Duration.between(instant1, instant2);
        Period tenDays = Period.between(LocalDate.of(2018, 10, 3),
                LocalDate.of(2018, 10, 13));
        Duration threeMinutes = Duration.ofMillis(3);
        threeMinutes = Duration.of(3, ChronoUnit.MINUTES);
        tenDays = Period.ofDays(10);
        Period threeWeeks = Period.ofWeeks(3);
        Period twoYearSixMonthsOneDay = Period.of(2, 6, 1);
        System.out.println();
    }

    @Test
    public void formatDateTest() {
        LocalDate date1 = LocalDate.of(2014, 3, 18); //2014-3-18
        LocalDate date2 = date1.withYear(2011); //2011-3-18
        LocalDate date3 = date2.withDayOfMonth(25); //2011-3-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9); //2011-9-25
    }
}
