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
import org.joda.time.DateTime;
import org.joda.time.Instant;
import org.joda.time.Interval;

import java.util.List;
import java.util.Map;

import static griffon.util.GriffonNameUtils.isBlank;
import static java.lang.Math.abs;

/**
 * @author Andres Almiray
 */
public class IntervalPropertyEditor extends AbstractPropertyEditor {
    protected void setValueInternal(Object value) {
        if (null == value) {
            super.setValueInternal(null);
        } else if (value instanceof CharSequence) {
            handleAsString(String.valueOf(value));
        } else if (value instanceof Interval) {
            super.setValueInternal(value);
        } else if (value instanceof List) {
            handleAsList((List) value);
        } else if (value instanceof Map) {
            handleAsMap((Map) value);
        } else {
            throw illegalValue(value, Interval.class);
        }
    }

    private void handleAsList(List list) {
        switch (list.size()) {
            case 2:
                long s = parseValue(list.get(0));
                long e = parseValue(list.get(1));
                super.setValueInternal(new Interval(s, e));
                break;
            default:
                throw illegalValue(list, Interval.class);
        }
    }

    private void handleAsMap(Map map) {
        long s = getMapValue(map, "start", 0L);
        long e = getMapValue(map, "end", 0L);
        super.setValueInternal(new Interval(s, e));
    }

    private long getMapValue(Map map, String key, long defaultValue) {
        Object val = map.get(key);
        if (null == val) val = map.get(String.valueOf(key.charAt(0)));
        if (null == val) {
            return defaultValue;
        } else if (val instanceof CharSequence) {
            return parse(String.valueOf(val));
        } else if (val instanceof Number) {
            return parse((Number) val);
        }
        throw illegalValue(map, Interval.class);
    }

    private long parseValue(Object value) {
        if (value instanceof CharSequence) {
            return parse(String.valueOf(value));
        } else if (value instanceof Number) {
            return parse((Number) value);
        }
        throw illegalValue(value, Interval.class);
    }

    private long parse(String val) {
        try {
            return Long.parseLong(val.trim());
        } catch (NumberFormatException nfe) {
            try {
                return DateTime.parse(val).toDate().getTime();
            } catch (IllegalArgumentException iae) {
                throw illegalValue(val, Interval.class, iae);
            }
        }
    }

    private void handleAsString(String str) {
        if (isBlank(str)) {
            super.setValueInternal(null);
            return;
        }

        try {
            super.setValueInternal(Instant.parse(str));
        } catch (IllegalArgumentException e) {
            throw illegalValue(str, Interval.class, e);
        }
    }

    private long parse(Number number) {
        return abs(number.longValue());
    }
}
