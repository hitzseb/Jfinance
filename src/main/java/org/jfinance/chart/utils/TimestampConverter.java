package org.jfinance.chart.utils;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class TimestampConverter {
    private static final String DEFAULT_TIMEZONE = "America/New_York";

    public static String convertTimestampToDate(Long timestamp, String timeZone) {
        // Use default timezone if none is provided
        if (timeZone == null || timeZone.isEmpty()) {
            timeZone = DEFAULT_TIMEZONE;
        }
        // Convert timestamp to Instant
        Instant instant = Instant.ofEpochSecond(timestamp);
        // Create a timezone (example: America/New_York)
        ZoneId zoneId = ZoneId.of(timeZone);
        // Convert Instant to a datetime with the specified time zone
        ZonedDateTime zonedDateTime = instant.atZone(zoneId);
        // Format the datetime to a legible format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return zonedDateTime.format(formatter);
    }

    // Method for converting an ISO 8601 format date to a UNIX timestamp
    public static long convertDateToTimestamp(String isoDate) {
        try {
            if (isoDate.length() == 10) { // YYYY-MM-DD format
                LocalDate localDate = LocalDate.parse(isoDate, DateTimeFormatter.ISO_LOCAL_DATE);
                ZonedDateTime zonedDateTime = localDate.atStartOfDay(ZoneId.of("America/Argentina/Buenos_Aires"));
                return zonedDateTime.toEpochSecond();
            } else { // timezone format
                ZonedDateTime zonedDateTime = ZonedDateTime.parse(isoDate, DateTimeFormatter.ISO_DATE_TIME);
                return zonedDateTime.toEpochSecond();
            }
        } catch (DateTimeParseException e) {
            System.out.println("Error al analizar la fecha: " + isoDate);
            e.printStackTrace();
            return -1;
        }
    }
}
