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

/**
 * @author Andres Almiray
 */
class JodatimeGriffonPlugin {
    // the plugin version
    String version = '0.1.0'
    // the version or versions of Griffon the plugin is designed for
    String griffonVersion = '1.3.0 > *'
    // the other plugins this plugin depends on
    Map dependsOn = [:]
    // resources that are included in plugin packaging
    List pluginIncludes = []
    // the plugin license
    String license = 'Apache Software License 2.0'
    // Toolkit compatibility. No value means compatible with all
    // Valid values are: swing, javafx, swt, pivot, gtk
    List toolkits = []
    // Platform compatibility. No value means compatible with all
    // Valid values are:
    // linux, linux64, windows, windows64, macosx, macosx64, solaris
    List platforms = []
    // URL where documentation can be found
    String documentation = ''
    // URL where source can be found
    String source = 'https://github.com/griffon/griffon-jodatime-plugin'

    List authors = [
        [
            name: 'Andres Almiray',
            email: 'aalmiray@yahoo.com'
        ]
    ]

    String title = 'Jodatime editors and formatters'
    // accepts Markdown syntax. See http://daringfireball.net/projects/markdown/ for details
    String description = '''
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
'''
}
