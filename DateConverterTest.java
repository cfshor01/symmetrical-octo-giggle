package assignment_3;

//imported packages for program functionality
import java.lang.*;
import java.util.*;

public class DateConverterTest {
	public static void main(String args[]) {
		int month, day, year; //variables for date
		int daynumber = 0; //variable to initialize ordinal number
		String smonth, sday, syear; //string variables of the date
		boolean displayDate = false; //used for final display
		
		//arraylist for the months
		ArrayList<String> monthName = new ArrayList<String>();
		monthName.add("January");
		monthName.add("February");
		monthName.add("March");
		monthName.add("April");
		monthName.add("May");
		monthName.add("June");
		monthName.add("July");
		monthName.add("August");
		monthName.add("September");
		monthName.add("October");
		monthName.add("November");
		monthName.add("December");
		
		//arraylist for days in each month
		ArrayList<Integer> numDays = new ArrayList<Integer>();
		numDays.add(31);
		numDays.add(28);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		numDays.add(30);
		numDays.add(31);
		
		Date dateobj; //Date class object
		
		Scanner scan = new Scanner(System.in); //used for user input
		
		//asks user for a date
		while(displayDate == false) {
			System.out.println("Enter MM/DD/YYYY");
			String date = scan.nextLine();
		
		//gets string version of date user enters based upon format	
			if(date.substring(0,2).contains("/")) {
				if(date.substring(3).contains("/")) {
					smonth = date.substring(0,1);
					sday = date.substring(2,3);
					syear = date.substring(4);
				}
				else
				smonth = date.substring(0, 1);
				sday = date.substring(2, 4);
				syear = date.substring(5, 9);
			}
			else if(date.substring(3,5).contains("/")) {
				smonth = date.substring(0, 2);
				sday = date.substring(3, 4);
				syear = date.substring(5, 9);
			}
			else {
				smonth = date.substring(0, 2);
				sday = date.substring(3,5);
				syear = date.substring(6, 10);
			}
			
			//turns string dates into integers using Integer wrapping class
			month = Integer.parseInt(smonth);
			day = Integer.parseInt(sday);
			year = Integer.parseInt(syear);
			
			//creates Date class object with constructor for date
			dateobj = new Date(month, day, year);
			//uses dateobj method to get the month and assigns value to monthNum
			int monthNum = dateobj.getMonth();
			
			//checks for valid month number
			if (dateobj.checkMonth() == false) {
				System.out.println("Date Does Not Exist!\nEnter New Date");
				displayDate = false;
			}
			else if(dateobj.checkMonth() == true)
			{
				//checks for valid days in each month
				int daysofmonth = numDays.get(monthNum);
				//checks for leap year
				if(dateobj.checkLeapYear() == true) {
					if(daysofmonth==28) {
						daysofmonth = 29;
					}
				}
				if(day <= daysofmonth && day >0) {
					displayDate = true;//displays if valid value
				}
				else displayDate = false;
				if(displayDate == false) {
					System.out.println("Date Does Not Exist!\nEnter New Date");
				}
			}
			else displayDate = true;
			
			//prints out date in Name date, year format if true
			if(displayDate == true) {
				System.out.println(monthName.get(monthNum) +" " + day + ", " + year);
				//prints 'Leap Year' if true
				if(dateobj.checkLeapYear() == true) {
					System.out.println("Leap Year");
				}
				else {
					System.out.println("Not a Leap Year");
				}
				System.out.print("Ordinal Position: ");
				for(int i = 0; i < monthNum; i++) {
					//adds number of days in previous months
					daynumber = daynumber + numDays.get(i);
				}
				//gets ordinal number by adding day to num of days in previous months
				System.out.println(daynumber + day);
			}
		};
	};
}
