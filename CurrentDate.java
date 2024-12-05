import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CurrentDate {
    private static CurrentDate instance = new CurrentDate();
    private SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy HH:mm");;

    private CurrentDate() {}

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
}
