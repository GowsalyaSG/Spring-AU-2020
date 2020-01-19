package DateDIFF;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
public class second {
	public static void main(String args[]) {
		
		ZonedDateTime zdate1, zdate2;
		Scanner scan = new Scanner(System.in);
		String date1, date2,date3;
		LocalDateTime ldate1, ldate2;
		System.out.println("Enter your date of birth (dd/mm/yyyy HH:mm) if start of day means enter HH:mm=00:00");
		date1 = scan.nextLine();
		System.out.println("Enter parent/sibling of birth (dd/mm/yyyy HH:mm)");
		date2 = scan.nextLine();
		System.out.println("Enter your dob in different time zone ");
		date3 = scan.nextLine();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
		try {
			ldate1 = LocalDateTime.parse(date1, formatter);
			ldate2 = LocalDateTime.parse(date2, formatter);
			zdate1 = ldate1.atZone(ZoneId.of(date3));
			zdate2 = ldate2.atZone(ZoneId.of("Asia/Qatar")); 
System.out.println("Difference in NO.OF.Days is: "+Math.abs(ChronoUnit.NANOS.between(zdate1, zdate2)));	
System.out.println("Difference in Nanoseconds is: "+Math.abs(ChronoUnit.DAYS.between(zdate1, zdate2)));
		}
		catch(Exception e)
		{
			System.out.println("enter the correct date and time and zone");
			System.out.println(e);
		}
		
	}}