
import java.util.*;
import java.text.DateFormatSymbols;
/**
 *
 */
public class CalendarPrint {
	public static void main(String[] args) {
		//Construct calendar as current
		GregorianCalendar calendar = new GregorianCalendar();

		int today = calendar.get(Calendar.DAY_OF_MONTH);
		int month = calendar.get(Calendar.MONTH);

        //Set calendar to start date of the month
		calendar.set(Calendar.DAY_OF_MONTH, 1);

		int weekday = calendar.get(Calendar.DAY_OF_WEEK);

		//Get first day of week
		int firstDayOfWeek = calendar.getFirstDayOfWeek();

		//Determine the required indentation for the first line
		int indent = 0;
		while (weekday != firstDayOfWeek) {
			indent++;
			calendar.add(Calendar.DAY_OF_MONTH, -1);
			weekday = calendar.get(Calendar.DAY_OF_WEEK);
		}

		//Print weekday names
		String[] weekdayNames = new DateFormatSymbols().getShortWeekdays();
		do {
			System.out.printf("%4s", weekdayNames[weekday]);
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = calendar.get(Calendar.DAY_OF_WEEK);
		}
        while (weekday != firstDayOfWeek);
		System.out.println();

		//Print indent of first line
		for (int i = 1; i <= indent; i++) {
			System.out.print("    ");
		}
		calendar.set(Calendar.DAY_OF_MONTH, 1);
		do {
			//Print day
			int day = calendar.get(Calendar.DAY_OF_MONTH);
			System.out.printf("%3s", day);

			//Mark current day with *
			if (day == today) System.out.print("*");
			else System.out.print(" ");

			//Advane calendar to the next day
			calendar.add(Calendar.DAY_OF_MONTH, 1);
			weekday = calendar.get(Calendar.DAY_OF_WEEK);

			//Start a new line at the start of the week
			if (weekday == firstDayOfWeek) System.out.println();
		}
		while (calendar.get(Calendar.MONTH) == month);
		//The loop exists when calendar is day 1 of the next month
		
		//Print final end of line if necrssary
		if (weekday != firstDayOfWeek) System.out.println();
	}
}
       






