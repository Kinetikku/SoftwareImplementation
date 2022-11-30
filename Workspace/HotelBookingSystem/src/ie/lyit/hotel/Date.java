package ie.lyit.hotel;

import java.util.Calendar;

public class Date {
	protected int day, month, year;
	
	public Date() {
		this.day = 0;
		this.month = 0;
		this.year = 0;
	}
	
	public Date(int d, int m, int y) {
		this.day = d;
		this.month = m;
		this.year = y;
	}
	
	@Override
	public String toString() {
		return this.day + " " + this.month + " " + this.year;
	}
	
	public boolean equals(Object obj) {
		Date nObject;
		
		if(obj instanceof Date)
			nObject = (Date)obj;
		else
			return false;
		
		return this.day == nObject.day
				&& this.month == nObject.month
				&& this.year == nObject.year;
	}

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		if(day > 0 && day <= 31)
			this.day = day;
		else
			throw new IllegalArgumentException("Incorrect day");
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		if(month > 0 && month <= 12)
			this.month = month;
		else
			throw new IllegalArgumentException("Incorrect Month");
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		if(year <= Calendar.getInstance().get(Calendar.YEAR) && year > 1900)
			this.year = year;
		else
			throw new IllegalArgumentException("Incorrect year");
	}
	
	
}
