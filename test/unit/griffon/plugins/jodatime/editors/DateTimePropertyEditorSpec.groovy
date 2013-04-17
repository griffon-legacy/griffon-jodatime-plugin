package griffon.plugins.jodatime.editors

import org.joda.time.DateMidnight
import org.joda.time.DateTime
import spock.lang.Specification
import spock.lang.Unroll

import java.beans.PropertyEditor

@Unroll
class DateTimePropertyEditorSpec extends Specification {
    void "DateTime format '#format' should be equal to #datetime"() {
        setup:

        PropertyEditor editor = new DateTimePropertyEditor()

        when:
        editor.value = format

        then:

        datetime == editor.value

        where:
        datetime                     | format
        new DateTime(1366208426821L) | 1366208426821L
        new DateTime(1366208426821L) | '1366208426821'
        new DateTime(1366208426821L) | new Date(1366208426821L)
        new DateTime(1366208426821L) | calendar(1366208426821L)
        new DateTime(1366208426821L) | new DateTime(1366208426821L)
    }

    private Calendar calendar(long time) {
        Calendar c = Calendar.getInstance()
        c.time = new Date(time)
        c
    }

    void "Invalid datetime format '#format'"() {
        setup:

        PropertyEditor editor = new DateTimePropertyEditor()

        when:
        editor.value = format

        then:

        thrown(IllegalArgumentException)

        where:
        format << [
            'garbage',
            new Object()
        ]
    }
}
