package griffon.plugins.jodatime.editors

import org.joda.time.DateMidnight
import org.joda.time.DateTime
import org.joda.time.LocalDate
import spock.lang.Specification
import spock.lang.Unroll

import java.beans.PropertyEditor

@Unroll
class LocalDatePropertyEditorSpec extends Specification {
    void "LocalDate format '#format' should be equal to #localdate"() {
        setup:

        PropertyEditor editor = new LocalDatePropertyEditor()

        when:
        editor.value = format

        then:

        localdate == editor.value

        where:
        localdate                     | format
        new LocalDate(1366208426821L) | 1366208426821L
        new LocalDate(1366208426821L) | '1366208426821'
        new LocalDate(1366208426821L) | new Date(1366208426821L)
        new LocalDate(1366208426821L) | calendar(1366208426821L)
        new LocalDate(1366208426821L) | new LocalDate(1366208426821L)
        new LocalDate(1366208426821L) | new DateTime(1366208426821L)
        new LocalDate(1366208426821L) | new DateMidnight(1366208426821L)
    }

    private Calendar calendar(long time) {
        Calendar c = Calendar.getInstance()
        c.time = new Date(time)
        c
    }

    void "Invalid localdate format '#format'"() {
        setup:

        PropertyEditor editor = new LocalDatePropertyEditor()

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
