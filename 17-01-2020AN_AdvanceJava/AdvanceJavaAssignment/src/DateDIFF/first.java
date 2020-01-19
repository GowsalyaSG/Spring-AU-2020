package DateDIFF;

import java.time.LocalDateTime;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class first {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		String date1, date2;
		LocalDateTime ldate1, ldate2;
		
		System.out.println("Enter your date of birth (dd/mm/yyyy HH:mm) if start of day means enter HH:mm=00:00");
		date1 = scan.nextLine();
		
		System.out.println("Enter parent/sibling of birth (dd/mm/yyyy HH:mm)");
		date2 = scan.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		try {
			ldate1 = LocalDateTime.parse(date1, formatter);
			ldate2 = LocalDateTime.parse(date2, formatter);
System.out.println("Difference in NO.OF.Days is: "+Math.abs(ChronoUnit.DAYS.between(ldate1, ldate2)));	
System.out.println("Difference in Nanoseconds is: "+Math.abs(ChronoUnit.NANOS.between(ldate1, ldate2)));
		}
		catch(Exception e)
		{
			System.out.println("enter the correct date and time");
			System.out.println(e);
		}
	}
	
	
}