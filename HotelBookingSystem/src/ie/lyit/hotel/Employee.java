package ie.lyit.hotel;

import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.regex.Pattern;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends Person implements Payable, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -8532001641180216743L;
	private static final double MAX_SALARY = 150000;
	private Date dob;
	private Date StartDate;
	private int number;
	private double salary;

	private static int nextNumber = 10000;

	public Employee() {
		super(); //Don't have to call super,
		//It will call itself.
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
		return "Emp No: " + number + " Name: " + super.toString() + " Salary: €" + df.format(salary);
	}

	//Added this for the purpose of updating the next number to the largest
	//number of the last employee in the list
	public static void setNextNumber(int num) {
		nextNumber = num;
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

	// read() - To read a book from the user	
	public void read(){
		JTextField empTitle = new JTextField();
		empTitle.requestFocus();
		JTextField empFirstName = new JTextField();
		JTextField empLastName = new JTextField();
		JTextField empPhone = new JTextField();
		JTextField salary = new JTextField();
		Object[] message = {
				"Employee Title:", empTitle,
				"Employee First Name:", empFirstName,
				"Employee Last Name:", empLastName,
				"Employee Phone Number:", empPhone,
				"Employee Salary:", salary,
		};

		JDialog dialog = new JDialog();
		dialog.setAlwaysOnTop(true);    
		int option = JOptionPane.showConfirmDialog(dialog, message, "Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION){
			this.name.setTitle(empTitle.getText());
			this.name.setFirstName(empFirstName.getText());
			this.name.setSurname(empLastName.getText());
			try {
				if(Pattern.matches("[a-zA-Z]+", empPhone.getText()) == false && empPhone.getText().length() >= 7 && empPhone.getText().length() <= 15)
					this.setPhoneNumber(empPhone.getText());
				else {
					JOptionPane.showMessageDialog(null, "Employee was not created successfully, please try again");
					read();
				}
			}
			catch(NumberFormatException nfe) {
				System.out.println(nfe.getMessage());
				this.setPhoneNumber("");
			}
			try {
				if(Pattern.matches("[a-zA-Z]+", salary.getText()) == false)
					if(Double.parseDouble(salary.getText()) <= MAX_SALARY)
						this.setSalary(Double.parseDouble(salary.getText()));
					else {
						JOptionPane.showMessageDialog(null, "The salary entered is above the " + MAX_SALARY + " limit, try again");
						read();
					}

			}
			catch(NumberFormatException ex) {
				System.out.println(ex.getMessage());
			}

		}   
	}
}
