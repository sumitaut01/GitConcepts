package datemanipulations;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
public class DateUtility {

    public static String getDateTimeStringInFormat(int daysToAddSubTract, String sSimpleDateFormat) {
        try {
            // Get the current date
            Date currentDate = new Date();

            // Create a Calendar instance and set it to the current date
            Calendar calendar = Calendar.getInstance();
            calendar.setTime(currentDate);

            // Add the specified number of days to the current date
                calendar.add(Calendar.DAY_OF_MONTH, daysToAddSubTract);
            // Get the date after adding days
            Date modifiedDate = calendar.getTime();
            // Format the future date according to the provided format pattern
            SimpleDateFormat dateFormat = new SimpleDateFormat(sSimpleDateFormat.trim());
            return dateFormat.format(modifiedDate);
        } catch (Exception oEx) {
            // If there's an error during formatting, catch the exception and return an error message
            System.err.println("Error while getting date string in provided format. Returning in dd_MMM_yyyy_hhmmss ");

            return null;
        }
    }
}