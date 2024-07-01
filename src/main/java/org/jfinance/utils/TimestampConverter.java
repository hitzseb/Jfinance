package org.jfinance.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimestampConverter {
    private static final String DEFAULT_TIMEZONE = "America/New_York";

    public static String convertTimestampToDate(Long timestamp, String timeZone) {
        if (timeZone == null || timeZone.isEmpty()) {
            timeZone = DEFAULT_TIMEZONE;
        }
        Instant instant = Instant.ofEpochSecond(timestamp);
        ZoneId zoneId = ZoneId.of(timeZone);
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        return zonedDateTime.format(formatter);
    }

    public static long convertDateToTimestamp(String isoDate, String timeZone) {
        if (timeZone == null || timeZone.isEmpty()) {
            timeZone = DEFAULT_TIMEZONE;
        }
        try {
            LocalDate localDate = LocalDate.parse(isoDate, DateTimeFormatter.ISO_LOCAL_DATE);
            ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.of(timeZone));
            return zonedDateTime.toEpochSecond();
        } catch (DateTimeParseException e) {
            System.out.println("Error parsing date: " + isoDate);
            e.printStackTrace();
            return -1;
        }
    }
}
