import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Date;

/**
 * The CurrentDate class provides utility methods for working with dates and times,
 * including formatting, date validation, and age calculation.
 * We made all the methods to be static because the usage is always the same
 * And it doesn't matter who wants the info.
 */
public class CurrentDate {

    /**
     * Retrieves the current date and time formatted as "dd-MM-yyyy HH:mm".
     *
     * @return A string representing the current date and time.
     */
    public static String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    /**
     * Checks if a given date (in "dd-MM-yyyy HH:mm" format) is before the current date and time.
     *
     * @param date1 The date string to check.
     * @return True if the given date is before the current date, false otherwise.
     */
    public static boolean isExpiredDate(String date1) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date parsedDate1 = formatter.parse(date1);
            Date parsedDate2 = formatter.parse(getCurrentDate());
            return parsedDate1.before(parsedDate2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
     * Converts a date string from "dd-MM-yyyy HH:mm" format to "yyyy-MM-dd HH:mm" format.
     *
     * @param date The input date string in "dd-MM-yyyy HH:mm" format.
     * @return The date string formatted as "yyyy-MM-dd HH:mm".
     */
    public static String YearMonthDateHHmm(String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);
        return dateTime.format(outputFormatter);
    }

    /**
     * Converts a date string from "dd-MM-yyyy" format to "yyyy-MM-dd" format.
     *
     * @param date The input date string in "dd-MM-yyyy" format.
     * @return The formatted date string as "yyyy-MM-dd", or null if the input format is invalid.
     */
    public static String ReturnDateReversedNohour(String date) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");
            Date newdate = inputFormat.parse(date);
            return outputFormat.format(newdate);
        } catch (ParseException e) {
            System.err.println("Invalid date format: " + date);
            return null;
        }
    }

    /**
     * Calculates the age based on a given birth date in "dd-MM-yyyy" format.
     *
     * @param date The birth date string in "dd-MM-yyyy" format.
     * @return The calculated age as an integer.
     */
    public static int getAge(String date) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate birthDate = LocalDate.parse(date, formatter);
        LocalDate today = LocalDate.now();
        Period age = Period.between(birthDate, today);
        return age.getYears();
    }
}
