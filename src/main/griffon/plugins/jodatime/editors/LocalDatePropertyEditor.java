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

package griffon.plugins.jodatime.editors;

import griffon.core.resources.editors.AbstractPropertyEditor;
import griffon.core.resources.formatters.Formatter;
import griffon.core.resources.formatters.ParseException;
import griffon.plugins.jodatime.formatters.DateTimeFormatter;
import org.joda.time.DateMidnight;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalDateTime;

import java.util.Calendar;
import java.util.Date;

import static griffon.plugins.jodatime.formatters.DateTimeFormatter.Pattern;
import static griffon.util.GriffonNameUtils.isBlank;

/**
 * @author Andres Almiray
 */
public class LocalDatePropertyEditor extends AbstractPropertyEditor {
    protected void setValueInternal(Object value) {
        if (null == value) {
            super.setValueInternal(null);
        } else if (value instanceof LocalDate) {
            super.setValueInternal(value);
        } else if (value instanceof DateTime) {
            super.setValueInternal(((DateTime) value).toLocalDate());
        } else if (value instanceof LocalDateTime) {
            super.setValueInternal(((LocalDateTime) value).toLocalDate());
        } else if (value instanceof DateMidnight) {
            super.setValueInternal(((DateMidnight) value).toLocalDate());
        } else if (value instanceof CharSequence) {
            handleAsString(String.valueOf(value));
        } else if (value instanceof Calendar) {
            super.setValueInternal(new LocalDate(value));
        } else if (value instanceof Date) {
            super.setValueInternal(new LocalDate(value));
        } else if (value instanceof Number) {
            super.setValueInternal(new LocalDate(((Number) value).longValue()));
        } else {
            throw illegalValue(value, LocalDate.class);
        }
    }

    private void handleAsString(String str) {
        if (isBlank(str)) {
            super.setValueInternal(null);
            return;
        }

        try {
            super.setValueInternal(new LocalDate(Long.parseLong(str)));
            return;
        } catch (NumberFormatException nfe) {
            // ignore
        }

        try {
            super.setValueInternal(new DateTimeFormatter(Pattern.FULL_DATE).parse(str));
        } catch (ParseException e) {
            throw illegalValue(str, LocalDate.class, e);
        }
    }

    protected Formatter resolveFormatter() {
        return isBlank(getFormat()) ? null : new DateTimeFormatter(getFormat());
    }
}
