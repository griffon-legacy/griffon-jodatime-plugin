/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package griffon.plugins.jodatime;

import org.joda.time.*;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import static java.lang.Math.abs;

/**
 * @author Andres Almiray
 */
public class JodatimeExtension {
    public static DateTime toDateTime(Date date) {
        return new DateTime(date);
    }

    public static DateTime toDateTime(Calendar calendar) {
        return new DateTime(calendar);
    }

    public static DateTime toDateTime(Number number) {
        return new DateTime(abs(number.longValue()));
    }

    public static DateTime toDateTime(String string) {
        return DateTime.parse(string);
    }

    public static DateMidnight toDateMidnight(Date date) {
        return new DateMidnight(date);
    }

    public static DateMidnight toDateMidnight(Calendar calendar) {
        return new DateMidnight(calendar);
    }

    public static DateMidnight toDateMidnight(Number number) {
        return new DateMidnight(abs(number.longValue()));
    }

    public static DateMidnight toDateMidnight(String string) {
        return DateMidnight.parse(string);
    }

    public static Instant toInstant(Date date) {
        return new Instant(date);
    }

    public static Instant toInstant(Calendar calendar) {
        return new Instant(calendar);
    }

    public static Instant toInstant(Number number) {
        return new Instant(abs(number.longValue()));
    }

    public static Instant toInstant(String string) {
        return Instant.parse(string);
    }

    public static LocalDateTime toLocalDateTime(Date date) {
        return new LocalDateTime(date);
    }

    public static LocalDateTime toLocalDateTime(Calendar calendar) {
        return new LocalDateTime(calendar);
    }

    public static LocalDateTime toLocalDateTime(Number number) {
        return new LocalDateTime(abs(number.longValue()));
    }

    public static LocalDateTime toLocalDateTime(String string) {
        return LocalDateTime.parse(string);
    }

    public static LocalDate toLocalDate(Date date) {
        return new LocalDate(date);
    }

    public static LocalDate toLocalDate(Calendar calendar) {
        return new LocalDate(calendar);
    }

    public static LocalDate toLocalDate(Number number) {
        return new LocalDate(abs(number.longValue()));
    }

    public static LocalDate toLocalDate(String string) {
        return LocalDate.parse(string);
    }

    public static LocalTime toLocalTime(Date date) {
        return new LocalTime(date);
    }

    public static LocalTime toLocalTime(Calendar calendar) {
        return new LocalTime(calendar);
    }

    public static LocalTime toLocalTime(Number number) {
        return new LocalTime(abs(number.longValue()));
    }

    public static LocalTime toLocalTime(String string) {
        return LocalTime.parse(string);
    }

    public static DateTimeZone toDateTimeZone(TimeZone timeZone) {
        return DateTimeZone.forTimeZone(timeZone);
    }

    public static DateTimeZone toDateTimeZone(String string) {
        return DateTimeZone.forID(string);
    }

    // --== == --

    public static Years toYears(Number number) {
        return Years.years(abs(number.intValue()));
    }

    public static Months toMonths(Number number) {
        return Months.months(abs(number.intValue()));
    }

    public static Weeks toWeeks(Number number) {
        return Weeks.weeks(abs(number.intValue()));
    }

    public static Days toDays(Number number) {
        return Days.days(abs(number.intValue()));
    }

    public static Hours toHours(Number number) {
        return Hours.hours(abs(number.intValue()));
    }

    public static Minutes toMinutes(Number number) {
        return Minutes.minutes(abs(number.intValue()));
    }

    public static Seconds toSeconds(Number number) {
        return Seconds.seconds(abs(number.intValue()));
    }

    public static Duration toDuration(Number number) {
        return new Duration(abs(number.longValue()));
    }
}
