package nl.eveoh.thymeleaf.joda.expression;

import org.joda.time.DateTime;
import org.joda.time.base.AbstractInstant;
import org.joda.time.base.AbstractPartial;

/**
 * Contains all methods that can be used in the #joda expression object.
 *
 * @author Marco Krikke
 */
public interface Joda {
    /**
     * Usage: #joda.format(target, pattern)
     *
     * @param target  Joda {@link org.joda.time.DateTime}
     * @param pattern Valid {@link org.joda.time.format.DateTimeFormatter} pattern
     * @return Formatted string
     */
    String format(AbstractInstant target, String pattern);

    /**
     * Usage: #joda.format(target, pattern)
     *
     * @param target  Joda {@link org.joda.time.LocalDate} or {@link org.joda.time.LocalTime}
     * @param pattern Valid {@link org.joda.time.format.DateTimeFormatter} pattern
     * @return Formatted string
     */
    String format(AbstractPartial target, String pattern);

    /**
     * Usage: #joda.timestamp(target)
     *
     * @see org.joda.time.ReadableInstant#getMillis()
     */
    long timestamp(AbstractInstant target);

    /**
     * Usage: #joda.before(date1, date2)
     *
     * @see org.joda.time.base.AbstractInstant#isBefore(org.joda.time.ReadableInstant)
     */
    boolean before(AbstractInstant date1, AbstractInstant date2);

    /**
     * Usage: #joda.before(date1, date2)
     *
     * @see org.joda.time.base.AbstractPartial#isBefore(org.joda.time.ReadablePartial)
     */
    boolean before(AbstractPartial date1, AbstractPartial date2);

    /**
     * Usage: #joda.after(date1, date2)
     *
     * @see org.joda.time.base.AbstractInstant#isAfter(org.joda.time.ReadableInstant)
     */
    boolean after(AbstractInstant date1, AbstractInstant date2);

    /**
     * Usage: #joda.after(date1, date2)
     *
     * @see org.joda.time.base.AbstractPartial#isAfter(org.joda.time.ReadablePartial)
     */
    boolean after(AbstractPartial date1, AbstractPartial date2);

    /**
     * Usage: #joda.equals(date1, date2)
     *
     * @see org.joda.time.base.AbstractInstant#equals(java.lang.Object)
     */
    boolean equals(AbstractInstant date1, AbstractInstant date2);

    /**
     * Usage: #joda.equals(date1, date2)
     *
     * @see org.joda.time.base.AbstractPartial#equals(java.lang.Object)
     */
    boolean equals(AbstractPartial date1, AbstractPartial date2);

    /**
     * Usage: #joda.createNow()
     *
     * @see org.joda.time.DateTime#DateTime()
     */
    DateTime createNow();

    /**
     * Usage: #joda.createToday()
     *
     * @see org.joda.time.DateTime#withTimeAtStartOfDay()
     */
    DateTime createToday();

    /**
     * Usage: #joda.create(year, monthOfYear, dayOfMonth)
     *
     * @see org.joda.time.DateTime#DateTime(int, int, int, int, int)
     */
    DateTime create(int year, int monthOfYear, int dayOfMonth);

    /**
     * Usage: #joda.create(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour)
     *
     * @see org.joda.time.DateTime#DateTime(int, int, int, int, int)
     */
    DateTime create(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour);
}
