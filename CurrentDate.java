import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;


public class CurrentDate {
    private static CurrentDate instance = new CurrentDate();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
    ;

    private CurrentDate() {
    }

    public static CurrentDate getInstance() {
        return instance;
    }

    // Returns the current date in the format dd-MM-yyyy HH:mm
    public String getCurrentDate() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        Date date = new Date();
        return formatter.format(date);
    }

    // Returns true if the date1 is before the current date
    public boolean isExpiredDate(String date1) {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");
        try {
            Date parsedDate1 = formatter.parse(date1);
            Date parsedDate2 = formatter.parse(this.getCurrentDate());
            return parsedDate1.before(parsedDate2);
        } catch (ParseException e) {
            e.printStackTrace();
            return false;
        }
    }

    public String YearMonthDateHHmm(String date) {

        // Define the input format
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");

        // Define the output format
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");

        // Parse the input date
        LocalDateTime dateTime = LocalDateTime.parse(date, inputFormatter);

        // Format the date into the desired output format

        return dateTime.format(outputFormatter);
    }

    public String ReturnDateReversedNohour(String date) {
        try {
            SimpleDateFormat inputFormat = new SimpleDateFormat("dd-MM-yyyy");

            // Define the desired output date format
            SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

            // Parse the input date string into a Date object
            Date newdate = inputFormat.parse(date);

            // Format the Date object into the desired output format
            return outputFormat.format(newdate);
        } catch (ParseException e) {
            // Handle error if the input date format is invalid
            System.err.println("Invalid date format: " + date);
            return null;
        }
    }


}
