package net.deludobellico.commandops.estabeditor.util;

/**
 * Created by Mario on 15/02/2015.
 */

import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

public final class DateTimeUtils {
    public static final DateTimeFormatter DATE_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    public static final DateTimeFormatter TIME_FORMATTER = DateTimeFormatter.ofPattern("HH:mm:ss");
    public static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("dd/MM/yyy HH:mm:ss");

    private DateTimeUtils() {
    }

    public static LocalDate parseDate(String dateString) {
        return LocalDate.parse(dateString, DATE_FORMATTER);
    }

    public static LocalTime parseTime(String timeString) {
        LocalTime time;
        try {
            time = LocalTime.parse(timeString, TIME_FORMATTER);
        } catch (DateTimeParseException ex) {
            time = LocalTime.parse("00:" + timeString, TIME_FORMATTER);
        }
        return time;
    }

    public static LocalDateTime parseDateTime(String dateTimeString) {
        return LocalDateTime.parse(dateTimeString, DATE_TIME_FORMATTER);
    }

    public static String format(LocalDate date, LocalTime time) {
        return LocalDateTime.of(date, time).format(DATE_TIME_FORMATTER);
    }

    public static String format(LocalDateTime localDateTime) {
        return localDateTime.format(DATE_TIME_FORMATTER);
    }

    public static String format(LocalDate localDate) {
        return localDate.format(DATE_FORMATTER);
    }

    public static String format(LocalTime localTime) {
        return localTime.format(TIME_FORMATTER);
    }

    public static LocalDateTime convertToLocalDateTime(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        Date date = calendar.toGregorianCalendar().getTime();
        return LocalDateTime.ofInstant(date.toInstant(), ZoneId.systemDefault());
    }

    public static LocalDate toLocalDate(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return convertToLocalDateTime(calendar).toLocalDate();
    }

    public static LocalTime toLocalTime(XMLGregorianCalendar calendar) {
        if (calendar == null) {
            return null;
        }
        return convertToLocalDateTime(calendar).toLocalTime();
    }

    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDate date) {
        GregorianCalendar gCalendar = new GregorianCalendar(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XMLGregorianCalendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlCalendar;
    }

    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDate date, LocalTime time) {
        if (time == null) return toXMLGregorianCalendar(date);
        GregorianCalendar gCalendar = new GregorianCalendar(date.getYear(), date.getMonthValue(), date.getDayOfMonth(),
                time.getHour(), time.getMinute(), time.getSecond());
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XMLGregorianCalendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlCalendar;
    }

//    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDate date) {
//        GregorianCalendar gCalendar = new GregorianCalendar(date.getYear(), date.getMonthValue(), date.getDayOfMonth());
//        XMLGregorianCalendar xmlCalendar = null;
//        try {
//            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
//        } catch (DatatypeConfigurationException ex) {
//            Logger.getLogger(XMLGregorianCalendar.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        return xmlCalendar;
//    }

    public static XMLGregorianCalendar toXMLGregorianCalendar(LocalDateTime datetime) {
        GregorianCalendar gCalendar = new GregorianCalendar(datetime.getYear(), datetime.getMonthValue(),
                datetime.getDayOfMonth(), datetime.getHour(), datetime.getMinute(), datetime.getSecond());
        XMLGregorianCalendar xmlCalendar = null;
        try {
            xmlCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(gCalendar);
        } catch (DatatypeConfigurationException ex) {
            Logger.getLogger(XMLGregorianCalendar.class.getName()).log(Level.SEVERE, null, ex);
        }
        return xmlCalendar;
    }
}
