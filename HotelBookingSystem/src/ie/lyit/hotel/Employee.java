package ie.lyit.hotel;

import java.text.DecimalFormat;

public class Employee extends Person implements Payable {

	private static final double MAX_SALARY = 150000;
	private Date dob;
	private Date StartDate;
	private int number;
	private double salary;
	
	private static int nextNumber = 10000;
	
	public Employee() {
		super(); //Don't have to call super,
				 //It will call itself.
		this.dob = new Date();
		this.StartDate = new Date();
		this.salary =  0.00;
		this.number = nextNumber++;
	}
	
	public Employee(Name name, String phoneNo, Date dob, Date startDate, double salary) {
		super(name, phoneNo);
		this.dob = dob;
		this.StartDate = startDate;
		this.salary = salary;
		this.number = nextNumber++;
	}
	
	@Override
	public String toString() {
		DecimalFormat df = new DecimalFormat("#.00");
		return number + "\t" + super.toString() + "\t€" + df.format(salary);
	}
	
	public boolean equals(Object obj) {
		Employee nObject;
		
		if(obj instanceof Employee)
			nObject = (Employee)obj;
		else
			return false;
		
		return (this.number == nObject.number);
	}
	
	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Date getStartDate() {
		return StartDate;
	}

	public void setStartDate(Date startDate) {
		StartDate = startDate;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public static int getNextNumber() {
		return nextNumber;
	}

	//You shouldn't be able to set number therefore don't create
	//A set method for number.
	
	@Override
	public double calculatePay(double taxPercentage) {
		double pay = salary / 12;
		pay -= (pay * (taxPercentage / 100));
		return pay;
	}
	
	@Override
	public double incrementSalary(double incrementAmount) {
		if((salary + incrementAmount) <= MAX_SALARY)
			salary += incrementAmount;
		return salary;
	}

}
