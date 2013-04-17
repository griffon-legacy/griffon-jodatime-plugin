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

package griffon.plugins.jodatime.formatters;

import griffon.core.resources.formatters.AbstractFormatter;
import griffon.core.resources.formatters.ParseException;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;

import static griffon.util.GriffonNameUtils.isBlank;

/**
 * @author Andres Almiray
 */
public class DateTimeFormatter extends AbstractFormatter<DateTime> {
    private final org.joda.time.format.DateTimeFormatter dateTimeFormatter;

    public DateTimeFormatter() {
        this((Pattern) null);
    }

    public DateTimeFormatter(String pattern) {
        if (isBlank(pattern)) {
            dateTimeFormatter = DateTimeFormat.fullDateTime();
        } else {
            dateTimeFormatter = Pattern.parse(pattern);
        }
    }

    public DateTimeFormatter(Pattern pattern) {
        if (pattern == null) {
            dateTimeFormatter = DateTimeFormat.fullDateTime();
        } else {
            dateTimeFormatter = pattern.getDateTimeFormatter();
        }
    }

    public String format(DateTime dateTime) {
        return dateTimeFormatter.print(dateTime);
    }

    public DateTime parse(String str) throws ParseException {
        if (isBlank(str)) return null;
        try {
            return dateTimeFormatter.parseDateTime(str);
        } catch (Exception e) {
            throw new ParseException(e);
        }
    }

    public enum Pattern {
        SHORT_TIME(DateTimeFormat.shortTime()),
        SHORT_DATE(DateTimeFormat.shortDate()),
        SHORT_DATE_TIME(DateTimeFormat.shortDateTime()),
        MEDIUM_TIME(DateTimeFormat.mediumTime()),
        MEDIUM_DATE(DateTimeFormat.mediumDate()),
        MEDIUM_DATE_TIME(DateTimeFormat.mediumDateTime()),
        LONG_TIME(DateTimeFormat.longTime()),
        LONG_DATE(DateTimeFormat.longDate()),
        LONG_DATE_TIME(DateTimeFormat.longDateTime()),
        FULL_TIME(DateTimeFormat.fullTime()),
        FULL_DATE(DateTimeFormat.fullDate()),
        FULL_DATE_TIME(DateTimeFormat.fullDateTime());

        private final org.joda.time.format.DateTimeFormatter dateTimeFormatter;

        private Pattern(org.joda.time.format.DateTimeFormatter dateTimeFormatter) {
            this.dateTimeFormatter = dateTimeFormatter;
        }

        private org.joda.time.format.DateTimeFormatter getDateTimeFormatter() {
            return dateTimeFormatter;
        }

        public static org.joda.time.format.DateTimeFormatter parse(String str) {
            try {
                return Pattern.valueOf(str.toUpperCase().replace(" ", "_")).dateTimeFormatter;
            } catch (Exception e) {
                return DateTimeFormat.forPattern(str);
            }
        }
    }
}
