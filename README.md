
Jodatime editors and formatters
-------------------------------

Plugin page: [http://artifacts.griffon-framework.org/plugin/jodatime](http://artifacts.griffon-framework.org/plugin/jodatime)


Delivers helper classes for converting values from and to [JodaTime][1].

### Property Editors

This plugin contributes the following property editors

| *Type*                      |
| --------------------------- |
| org.joda.time.DateTime      |
| org.joda.time.DateTimeZone  |
| org.joda.time.Days          |
| org.joda.time.Duration      |
| org.joda.time.Hours         |
| org.joda.time.Instant       |
| org.joda.time.Interval      |
| org.joda.time.LocalDate     |
| org.joda.time.LocalDateTime |
| org.joda.time.LocalTime     |
| org.joda.time.Minutes       |
| org.joda.time.Months        |
| org.joda.time.Seconds       |
| org.joda.time.Weeks         |
| org.joda.time.Years         |

### Groovy Module Extension

This plugin registers a Groovy Module Extension that delivers new methods to
`java.util.Date`, `java.util.Calendar`, `java.lang.Number`, `java.lang.String`
and `java.util.TimeZone`. These methods are

 * toDateTime()
 * toDateMidnight()
 * toInstant()
 * toLocalDateTime()
 * toLocalDate()
 * toLocaleTime()
 * toDateTimeZone()

The following methods are only defined for `java.lang.Number`

 * toDays()
 * toDuration()
 * toHours()
 * toMinutes()
 * toMonths()
 * toSeconds()
 * toWeeks()
 * toYears()

[1]: http://joda-time.sourceforge.net

