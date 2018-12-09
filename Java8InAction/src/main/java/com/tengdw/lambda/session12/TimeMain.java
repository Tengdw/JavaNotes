package com.tengdw.lambda.session12;

import org.junit.Test;

import java.time.*;
import java.time.chrono.ChronoLocalDate;
import java.time.chrono.Chronology;
import java.time.chrono.JapaneseDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.time.temporal.*;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
        //以比较直观的方式操纵LocalDate的属性
        LocalDate date1 = LocalDate.of(2014, 3, 18); //2014-3-18
        LocalDate date2 = date1.withYear(2011); //2011-3-18
        LocalDate date3 = date2.withDayOfMonth(25); //2011-3-25
        LocalDate date4 = date3.with(ChronoField.MONTH_OF_YEAR, 9); //2011-9-25
        //以相对方式修改LocalDate对象的属性
        LocalDate d1 = LocalDate.of(2014, 3, 18);
        LocalDate d2 = d1.plusWeeks(1);
        LocalDate d3 = d2.minusWeeks(3);
        LocalDate d4 = d3.plus(6, ChronoUnit.MONTHS);
        //使用预定义的TemporalAdjuster
        LocalDate localDate1 = LocalDate.of(2014, 3, 18);
        LocalDate localDate2 = localDate1.with(TemporalAdjusters.nextOrSame(DayOfWeek.SUNDAY));
        LocalDate localDate3 = localDate2.with(TemporalAdjusters.lastDayOfMonth());
        //格式化日期
        String s1 = date1.format(DateTimeFormatter.BASIC_ISO_DATE);
        String s2 = date1.format(DateTimeFormatter.ISO_LOCAL_DATE);
        //解析日期
        LocalDate date5 = LocalDate.parse("20180618", DateTimeFormatter.BASIC_ISO_DATE);
        LocalDate date6 = LocalDate.parse("2018-06-18", DateTimeFormatter.ISO_LOCAL_DATE);
        //按照某个模式创建DateTimeFormatter
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = date1.format(formatter);
        LocalDate date7 = LocalDate.parse(formattedDate, formatter);
        //创建一个本地化的DateTimeFormatter
        DateTimeFormatter chinaFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy", Locale.CHINA);
        String chinaFormattedDate = date1.format(chinaFormatter);
        LocalDate date8 = LocalDate.parse(chinaFormattedDate, chinaFormatter);
        //构造一个DateTimeFormatter
        DateTimeFormatter chinaDateTimeFormatter = new DateTimeFormatterBuilder()
                .appendText(ChronoField.DAY_OF_MONTH)
                .appendLiteral(". ")
                .appendText(ChronoField.MONTH_OF_YEAR)
                .appendLiteral(" ")
                .appendText(ChronoField.YEAR)
                .parseCaseInsensitive()
                .toFormatter(Locale.CHINA);
        System.out.println();
    }

    @Test
    public void customerTemporalAdjuster() {
        LocalDate date = LocalDate.now();
        LocalDate nextWorkDay = date.with(new NextWorkingDay());
        TemporalAdjuster nextWorkingDay = TemporalAdjusters.ofDateAdjuster(temporal -> {
            DayOfWeek dow =
                    DayOfWeek.of(temporal.get(ChronoField.DAY_OF_WEEK));
            int dayToAdd = 1;
            if (dow == DayOfWeek.FRIDAY) dayToAdd = 3;
            if (dow == DayOfWeek.SATURDAY) dayToAdd = 2;
            return temporal.plus(dayToAdd, ChronoUnit.DAYS);
        });
        LocalDate nextWorkDay1 = date.with(nextWorkingDay);
        System.out.println();
    }

    @Test
    public void zoneIdTest() {
        ZoneId zoneId = TimeZone.getDefault().toZoneId();
        ZoneId chinaZone = ZoneId.of("Asia/Shanghai");
        //为时间点添加时区信息
        LocalDate date = LocalDate.of(2018, Month.NOVEMBER, 1);
        ZonedDateTime adt1 = date.atStartOfDay(chinaZone);

        LocalDateTime dateTime = LocalDateTime.of(2018, Month.OCTOBER, 1, 14, 26);
        ZonedDateTime zdt2 = dateTime.atZone(chinaZone);

        Instant instant = Instant.now();
        ZonedDateTime zdt3 = instant.atZone(chinaZone);

        //利用和 UTC/格林尼治时间的固定偏差计算时区
        LocalDateTime localDateTime = LocalDateTime.of(2014, Month.MARCH, 18, 13, 45);
        ZoneOffset newYorkOffset = ZoneOffset.of("-05:00");
        OffsetDateTime dateTimeInNewYork = OffsetDateTime.of(localDateTime, newYorkOffset);

        //使用别的日历系统  ISO-8601日历系统是世界文明日历系统的事实标准。
        // 两种方式使用日本的日历系统
        LocalDate localDate = LocalDate.of(2014, Month.MARCH, 18);
        JapaneseDate japaneseDate = JapaneseDate.from(localDate);

        Chronology japaneseChronology = Chronology.ofLocale(Locale.JAPAN);
        ChronoLocalDate now = japaneseChronology.dateNow();
        System.out.println();

    }

}
