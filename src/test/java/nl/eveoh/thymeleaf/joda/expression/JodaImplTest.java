package nl.eveoh.thymeleaf.joda.expression;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Locale;

public class JodaImplTest {
    private Joda joda;

    @Before
    public void setUp() throws Exception {
        joda = new JodaImpl(Locale.ENGLISH);
    }

    @Test
    public void testFormatDateTime() throws Exception {
        DateTime dateTime = new DateTime(2014, 1, 1, 2, 4);

        Assert.assertEquals(joda.format(dateTime, "HH:mm"), "02:04");
        Assert.assertEquals(joda.format(dateTime, "E MMMM d"), "Wed January 1");
    }

    @Test
    public void testFormatLocalDate() throws Exception {
        LocalDate localDate = new LocalDate(2014, 1, 1);

        Assert.assertEquals(joda.format(localDate, "E MMMM d"), "Wed January 1");
    }

    @Test
    public void testFormatLocalTime() throws Exception {
        LocalTime localDate = new LocalTime(2, 4);

        Assert.assertEquals(joda.format(localDate, "HH:mm"), "02:04");
    }

    @Test
    public void testTimestamp() throws Exception {
        DateTime dateTime = new DateTime(2014, 1, 1, 2, 4);

        Assert.assertEquals(joda.timestamp(dateTime), 1388538240000L);
    }

    @Test
    public void testBeforeDateTime() throws Exception {
        DateTime dateTime1 = new DateTime(2014, 1, 1, 2, 4);
        DateTime dateTime2 = new DateTime(2014, 1, 1, 2, 5);

        Assert.assertTrue(joda.before(dateTime1, dateTime2));
    }

    @Test
    public void testBeforeLocalDate() throws Exception {
        LocalDate localDate1 = new LocalDate(2014, 1, 1);
        LocalDate localDate2 = new LocalDate(2014, 1, 2);

        Assert.assertTrue(joda.before(localDate1, localDate2));
    }

    @Test
    public void testBeforeLocalTime() throws Exception {
        LocalTime localDate1 = new LocalTime(2, 4);
        LocalTime localDate2 = new LocalTime(2, 5);

        Assert.assertTrue(joda.before(localDate1, localDate2));
    }

    @Test
    public void testAfterDateTime() throws Exception {
        DateTime dateTime1 = new DateTime(2014, 1, 1, 2, 4);
        DateTime dateTime2 = new DateTime(2014, 1, 1, 2, 5);

        Assert.assertTrue(joda.after(dateTime2, dateTime1));
    }

    @Test
    public void testAfterLocalDate() throws Exception {
        LocalDate localDate1 = new LocalDate(2014, 1, 1);
        LocalDate localDate2 = new LocalDate(2014, 1, 2);

        Assert.assertTrue(joda.after(localDate2, localDate1));
    }

    @Test
    public void testAfterLocalTime() throws Exception {
        LocalTime localDate1 = new LocalTime(2, 4);
        LocalTime localDate2 = new LocalTime(2, 5);

        Assert.assertTrue(joda.after(localDate2, localDate1));
    }

    @Test
    public void testEqualsDateTime() throws Exception {
        DateTime dateTime1 = new DateTime(2014, 1, 1, 2, 4);
        DateTime dateTime2 = new DateTime(2014, 1, 1, 2, 4);

        Assert.assertTrue(joda.equals(dateTime1, dateTime2));
    }

    @Test
    public void testEqualsLocalDate() throws Exception {
        LocalDate localDate1 = new LocalDate(2014, 1, 1);
        LocalDate localDate2 = new LocalDate(2014, 1, 1);

        Assert.assertTrue(joda.equals(localDate1, localDate2));
    }

    @Test
    public void testEqualsLocalTime() throws Exception {
        LocalTime localDate1 = new LocalTime(2, 4);
        LocalTime localDate2 = new LocalTime(2, 4);

        Assert.assertTrue(joda.equals(localDate1, localDate2));
    }

    @Test
    public void testCreateNow() throws Exception {
        DateTime dateTime = new DateTime();

        Assert.assertTrue(Math.abs(dateTime.getMillis() - joda.createNow().getMillis()) < 25);
    }

    @Test
    public void testCreateToday() throws Exception {
        DateTime dateTime = new DateTime().withTimeAtStartOfDay();

        Assert.assertEquals(joda.createToday(), dateTime);
    }

    @Test
    public void testCreateDate() throws Exception {
        DateTime dateTime = new DateTime(2014, 1, 1, 0, 0);

        Assert.assertEquals(joda.create(2014, 1, 1), dateTime);
    }

    @Test
    public void testCreateDateAndTime() throws Exception {
        DateTime dateTime = new DateTime(2014, 1, 1, 12, 6);

        Assert.assertEquals(joda.create(2014, 1, 1, 12, 6), dateTime);
    }
}
