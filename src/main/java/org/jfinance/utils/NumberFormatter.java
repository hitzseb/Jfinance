package org.jfinance.utils;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NumberFormatter {
    private static final DecimalFormat decimalFormat = new DecimalFormat("#,##0.00");

    /**
     * Formats a large number into a readable format with appropriate suffix (K, M, B, T).
     *
     * @param number the number to format
     * @return the formatted string
     */
    public static String formatNumber(double number) {
        if (number >= 1_000_000_000_000L) {
            return "$" + decimalFormat.format(number / 1_000_000_000_000L) + "T";
        } else if (number >= 1_000_000_000) {
            return "$" + decimalFormat.format(number / 1_000_000_000) + "B";
        } else if (number >= 1_000_000) {
            return "$" + decimalFormat.format(number / 1_000_000) + "M";
        } else if (number >= 1_000) {
            return "$" + decimalFormat.format(number / 1_000) + "K";
        } else {
            return "$" + decimalFormat.format(number);
        }
    }

    /**
     * Parses a formatted string with appropriate suffix (K, M, B, T) back into a number.
     *
     * @param formatted the formatted string
     * @return the parsed number
     * @throws ParseException if the string cannot be parsed
     */
    public static double parseFormattedNumber(String formatted) throws ParseException {
        Pattern pattern = Pattern.compile("\\$(\\d{1,3}(?:[.,]\\d{3})*(?:[.,]\\d+)?)([KMBT]?)");
        Matcher matcher = pattern.matcher(formatted);

        if (matcher.matches()) {
            String numberStr = matcher.group(1).replace(",", ".");
            double value = Double.parseDouble(numberStr);
            String suffix = matcher.group(2);

            switch (suffix) {
                case "T":
                    return value * 1_000_000_000_000L;
                case "B":
                    return value * 1_000_000_000;
                case "M":
                    return value * 1_000_000;
                case "K":
                    return value * 1_000;
                default:
                    return value;
            }
        } else {
            throw new ParseException("Invalid formatted number: " + formatted, 0);
        }
    }
}
