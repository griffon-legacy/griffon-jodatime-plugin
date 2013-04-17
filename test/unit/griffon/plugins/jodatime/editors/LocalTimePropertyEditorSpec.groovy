package griffon.plugins.jodatime.editors

import org.joda.time.DateTime
import org.joda.time.LocalTime
import spock.lang.Specification
import spock.lang.Unroll

import java.beans.PropertyEditor

@Unroll
class LocalTimePropertyEditorSpec extends Specification {
    void "LocalTime format '#format' should be equal to #localtime"() {
        setup:

        PropertyEditor editor = new LocalTimePropertyEditor()

        when:
        editor.value = format

        then:

        localtime == editor.value

        where:
        localtime                     | format
        new LocalTime(1366208426821L) | 1366208426821L
        new LocalTime(1366208426821L) | '1366208426821'
        new LocalTime(1366208426821L) | new Date(1366208426821L)
        new LocalTime(1366208426821L) | calendar(1366208426821L)
        new LocalTime(1366208426821L) | new LocalTime(1366208426821L)
        new LocalTime(1366208426821L) | new DateTime(1366208426821L)
    }

    private Calendar calendar(long time) {
        Calendar c = Calendar.getInstance()
        c.time = new Date(time)
        c
    }

    void "Invalid localtime format '#format'"() {
        setup:

        PropertyEditor editor = new LocalTimePropertyEditor()

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
