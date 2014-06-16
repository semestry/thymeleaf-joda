package nl.eveoh.thymeleaf.joda.expression;

import org.joda.time.DateTime;
import org.joda.time.base.AbstractInstant;
import org.joda.time.base.AbstractPartial;
import org.joda.time.format.DateTimeFormat;
import org.thymeleaf.exceptions.TemplateProcessingException;

import java.util.Locale;

/**
 * Contains all methods that can be used in the #joda expression object.
 *
 * @author Marco Krikke
 */
public final class JodaImpl implements Joda {
    private final Locale locale;

    public JodaImpl(Locale locale) {
        this.locale = locale;
    }

    @Override
    public String format(final AbstractInstant target, String pattern) {
        try {
            return DateTimeFormat.forPattern(pattern).withLocale(locale).print(target);
        } catch (final Exception e) {
            throw new TemplateProcessingException(
                    "Error formatting Joda DateTime with pattern '" + pattern + "' for locale " + this.locale, e);
        }
    }

    @Override
    public String format(final AbstractPartial target, String pattern) {
        try {
            return DateTimeFormat.forPattern(pattern).withLocale(locale).print(target);
        } catch (final Exception e) {
            throw new TemplateProcessingException(
                    "Error formatting Joda LocalTime with pattern '" + pattern + "' for locale " + this.locale, e);
        }
    }

    @Override
    public long timestamp(final AbstractInstant target) {
        return target.getMillis();
    }

    @Override
    public boolean before(final AbstractInstant date1, final AbstractInstant date2) {
        return date1.isBefore(date2);
    }

    @Override
    public boolean before(final AbstractPartial date1, final AbstractPartial date2) {
        return date1.isBefore(date2);
    }

    @Override
    public boolean after(final AbstractInstant date1, final AbstractInstant date2) {
        return date1.isAfter(date2);
    }

    @Override
    public boolean after(final AbstractPartial date1, final AbstractPartial date2) {
        return date1.isAfter(date2);
    }

    @Override
    public boolean equals(final AbstractInstant date1, final AbstractInstant date2) {
        return date1.equals(date2);
    }

    @Override
    public boolean equals(final AbstractPartial date1, final AbstractPartial date2) {
        return date1.equals(date2);
    }

    @Override
    public DateTime createNow() {
        return new DateTime();
    }

    @Override
    public DateTime createToday() {
        return new DateTime().withTimeAtStartOfDay();
    }

    @Override
    public DateTime create(int year, int monthOfYear, int dayOfMonth) {
        return new DateTime(year, monthOfYear, dayOfMonth, 0, 0);
    }

    @Override
    public DateTime create(int year, int monthOfYear, int dayOfMonth, int hourOfDay, int minuteOfHour) {
        return new DateTime(year, monthOfYear, dayOfMonth, hourOfDay, minuteOfHour);
    }
}
