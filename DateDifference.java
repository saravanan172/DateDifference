import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
public class DateDifference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the date in DD-MM-YYYY hh:mm format:");
        String userInput = scanner.nextLine();        
        SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy HH:mm");        
        try {
            Date enteredDate = sdf.parse(userInput);
            Date currentDate = new Date();
            if (enteredDate.after(currentDate)) {
                Calendar currentCal = Calendar.getInstance();
                Calendar enteredCal = Calendar.getInstance();                
                currentCal.setTime(currentDate);
                enteredCal.setTime(enteredDate);
                if (enteredCal.get(Calendar.YEAR) != currentCal.get(Calendar.YEAR)) {
                    System.out.println("Difference in years: " + (enteredCal.get(Calendar.YEAR) - currentCal.get(Calendar.YEAR)));
                } else if (enteredCal.get(Calendar.MONTH) != currentCal.get(Calendar.MONTH)) {
                    System.out.println("Difference in months: " + (enteredCal.get(Calendar.MONTH) - currentCal.get(Calendar.MONTH)));
                } else if (enteredCal.get(Calendar.WEEK_OF_YEAR) != currentCal.get(Calendar.WEEK_OF_YEAR)) {
                    System.out.println("Difference in weeks: " + (enteredCal.get(Calendar.WEEK_OF_YEAR) - currentCal.get(Calendar.WEEK_OF_YEAR)));
                } else if (enteredCal.get(Calendar.DAY_OF_YEAR) != currentCal.get(Calendar.DAY_OF_YEAR)) {
                    System.out.println("Difference in days: " + (enteredCal.get(Calendar.DAY_OF_YEAR) - currentCal.get(Calendar.DAY_OF_YEAR)));
                } else {
                    long differenceInMinutes = (enteredDate.getTime() - currentDate.getTime()) / (1000 * 60);
                    System.out.println("Difference in minutes: " + differenceInMinutes);
                }
            } else {
                System.out.println("Invalid date");
            }
        } catch (ParseException e) {
            System.out.println("Invalid date");
        }
    }
}
