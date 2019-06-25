package assignment_3;

import java.util.*;

public class Date {
	//instance private variables for encapsulation
	private int _month;
	private int _day;
	private int _year;
	
	//constructor which sets assigns values to instance variables
	public Date(int month, int day, int year) {
		_month = month;
		_day = day;
		_year = year;
	};
	
	//checks for valid month
	public boolean checkMonth() {
		if(_month > 12 || _month < 1) {
			return false;
		}
		else return true;
	};
	
	//checks if year is a leap year
	public boolean checkLeapYear() {
		if(_year %4 == 0) {
			if(_year %100 == 0 & _year%400 != 0) {
				return false;
			}
			return true;
		}
		else return false;
	}
	
	//gets month number
	public int getMonth() {
		for(int i = 1; i <= 12 ; i++) {
			if(i == _month) {
				return i-1;
			}
		}
		return 1;
	}

}

