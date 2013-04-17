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
import org.joda.time.*;

import java.util.Calendar;
import java.util.Date;

import static griffon.util.GriffonNameUtils.isBlank;
import static java.lang.Math.abs;

/**
 * @author Andres Almiray
 */
public class InstantPropertyEditor extends AbstractPropertyEditor {
    protected void setValueInternal(Object value) {
        if (null == value) {
            super.setValueInternal(null);
        } else if (value instanceof CharSequence) {
            handleAsString(String.valueOf(value));
        } else if (value instanceof Instant) {
            super.setValueInternal(value);
        } else if (value instanceof DateTime) {
            super.setValueInternal(((DateTime) value).toInstant());
        } else if (value instanceof DateMidnight) {
            super.setValueInternal(((DateMidnight) value).toInstant());
        } else if (value instanceof LocalDate) {
            super.setValueInternal(new Instant(((LocalDate) value).toDate()));
        } else if (value instanceof LocalDateTime) {
            super.setValueInternal(new Instant(((LocalDateTime) value).toDate()));
        } else if (value instanceof LocalTime) {
            super.setValueInternal(((LocalTime) value).toDateTimeToday().toInstant());
        } else if (value instanceof Calendar) {
            super.setValueInternal(new Instant(value));
        } else if (value instanceof Date) {
            super.setValueInternal(new Instant(value));
        } else if (value instanceof Number) {
            super.setValueInternal(parse((Number) value));
        } else {
            throw illegalValue(value, Instant.class);
        }
    }

    private void handleAsString(String str) {
        if (isBlank(str)) {
            super.setValueInternal(null);
            return;
        }

        try {
            super.setValueInternal(parse(Long.parseLong(str)));
            return;
        } catch (NumberFormatException nfe) {
            // ignore
        }

        try {
            super.setValueInternal(Instant.parse(str));
        } catch (IllegalArgumentException e) {
            throw illegalValue(str, Instant.class, e);
        }
    }

    private Instant parse(Number number) {
        return new Instant(abs(number.longValue()));
    }
}
