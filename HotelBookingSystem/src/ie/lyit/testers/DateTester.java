package ie.lyit.testers;

import java.util.Scanner;

import ie.lyit.hotel.Date;

public class DateTester {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		Date date = new Date(01, 06, 1997);
		Date date2 = new Date(07, 06, 2002);
		Date d1 = new Date();
		
		boolean loop = true;
		
		int day = 0, month = 0, year = 0;
		
		while(loop) {
			try {
				d1.setDay(day);
				d1.setMonth(month);
				d1.setYear(year);
				loop = false;
			}
			catch(IllegalArgumentException iae) {
				System.out.println("Incorrect day, month or year");
				
				System.out.println("Enter a day, 1 - 31");
				day = scanner.nextInt();
				System.out.println("Enter a mont, 1 - 12");
				month = scanner.nextInt();
				System.out.println("Enter a year, 1900 - current year");
				year = scanner.nextInt();
			}
		}
		
		
		System.out.println(date.toString());
		System.out.println();
		
		System.out.println(date2.toString());
		System.out.println();
		
		System.out.println(date.equals(date2));
		System.out.println(date.equals(date));
		System.out.println(date.equals("01/06/1997"));
 	}

}
