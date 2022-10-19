package ie.lyit.testers;

import java.text.DecimalFormat;
import java.util.ArrayList;

import ie.lyit.hotel.CreditCard;
import ie.lyit.hotel.Date;
import ie.lyit.hotel.Employee;
import ie.lyit.hotel.Guest;
import ie.lyit.hotel.Name;
import ie.lyit.hotel.Person;

public class EmployeeTester {

	public static void main(String[] args) {
		// Array list of type Employee
		ArrayList<Employee> employees = new ArrayList<Employee>();
		
		Name name = new Name("Ms", "Faye", "McGuire");
		Employee emp1 = new Employee(name, "087 2244371", new Date(7,12,2000), new Date(12,10,2020), 42000.00);
		
		Name name1 = new Name("Mr", "Lando", "Norris");
		Employee emp2 = new Employee(name1, "087 3342371", new Date(7,12,2003), new Date(10,06,2022), 150000.00);
		
		Name name2 = new Name("Mr", "Alex", "ALbon");
		Employee emp3 = new Employee(name2, "087 5544827", new Date(2,10,2000), new Date(03,04,2021), 100000.00);
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		
		 // Display Employee's
		System.out.println("LIST OF EMPLOYEES");
		for(Employee employee:employees)
			System.out.println(employee);

	    // Increment Employee's earning less than 30000
		System.out.println("");
		System.out.println("LIST OF EMPLOYEES AFTER INCREMENT");
		for(Employee employee:employees) {
			if(employee.getSalary() < 30000)
			    employee.incrementSalary(1000);
	        System.out.println(employee);
		}

		System.out.println("");
		System.out.println("EMPLOYEES TAKE HOME PAY");
		DecimalFormat df=new DecimalFormat("#.00");
		for(Employee employee:employees) {
			System.out.print(employee.getNumber() + "\t" + employee.getName());			
			System.out.println(employee.getSalary() < 35000 
			    ? "\t€" + df.format(employee.calculatePay(20))
			    : "\t€" + df.format(employee.calculatePay(40)));
		}
		// Polymorphic ArrayList
		ArrayList<Person> personsInHotel = new ArrayList<Person>();
		personsInHotel.add(emp1);
		personsInHotel.add(emp2);
		personsInHotel.add(emp3);
		
		// Create a Guest object called g1 with initial values
		name=new Name("Mr", "Homer", "Simpson");
		CreditCard card=new CreditCard(1111222233334444L,new Date(31,12,2027),111);
		Guest g1 = new Guest(name, "087 1234567", "homer.simpson@atu.ie", card);	

		// Create a Guest object called g2 with initial values
		name=new Name("Mrs", "Marge", "Simpson");
		card=new CreditCard(5555666677778888L,new Date(31,12,2024),222);
		Guest g2 = new Guest(name, "086 1234567", "marge.simpson@atu.ie", card);	
	  
		personsInHotel.add(g1);
		personsInHotel.add(g2);	
		
		System.out.println("");
		System.out.println("ALL PEOPLE IN HOTEL, BOTH GUESTS AND EMPLOYEES");
		for(Person person : personsInHotel)
			System.out.println(person);
	}

}
