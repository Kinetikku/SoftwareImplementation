package ie.atu.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.ConcurrentModificationException;

import ie.lyit.hotel.Employee;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//EmployeeSerializer contains an ArrayList of Employee's, and methods to 
//serialize and deserialize that ArrayList of Employees.
//It also contains methods to add() an Employee to the ArrayList,
//and view(), edit(), delete(), list() Book(s) in the ArrayList.

public class EmployeeSerializer {

	//This is the AarayList that holds all employees that are being created and de-serialized
	private ArrayList<Employee> employees;

	//This is the filename of the bin file that holds all the serialized employees
	final String FILENAME = "employee.bin";	

	// Default Constructor
	public EmployeeSerializer(){
		// Construct employees ArrayList
		employees = new ArrayList<Employee>();
	}

	/////////////////////////////////////////////////////////
	// Method Name : add()								   //
	// Return Type : void								   //
	// Parameters : None								   //
	// Purpose : Reads one Employee record from the user   //
	//       and adds it to the ArrayList called employees //
	/////////////////////////////////////////////////////////
	public void add(){
		// Create an Employee object
		Employee emp = new Employee();
		// Read its details
		emp.read();	
		// And add it to the employees ArrayList
		employees.add(emp);

		/*This try catch is here so that if the user incorrectly creates an employee
		 * from inside the read() method, that the employee that is passed back with
		 * some default values is removed as they don't meet the conditions set.*/
		int count = -1;
		try {
			for(Employee emp1 : employees) {
				++count;
				if(emp1.getPhoneNumber().length() <= 7 || emp1.getSalary() == 0.00)
					employees.remove(count);	
			}
		}
		catch(ConcurrentModificationException ex) {
			System.out.println(ex.getMessage());
		}
	}

	///////////////////////////////////////////////////////
	// Method Name : list()						         //
	// Return Type : void					   	         //
	// Parameters : None						 		 //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////		
	public void list(){
		String employeesToList="";

		// for every Employee object in employees
		for(Employee tmpEmp : employees) {
			// add it to employeesToList and
			employeesToList += tmpEmp;
			// add a newline
			employeesToList+="\n";
		}

		// Display employeesToList in a messageDialog
		JOptionPane.showMessageDialog(null, employeesToList);			
	}

	///////////////////////////////////////////////////////
	// Method Name : view()						 		 //
	// Return Type : Employee					   	 	 //
	// Parameters : None						 		 //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////	
	public Employee view() {
		Employee tmpEmp = null;

		//Create the text input box
		JTextField empNumber = new JTextField();
		empNumber.requestFocus();

		Object[] message = {
				"Employee Number:", empNumber
		};

		JDialog dialog = new JDialog();

		dialog.setAlwaysOnTop(true);    

		int option = JOptionPane.showConfirmDialog(dialog, message, "Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);

		/*This try catch checks if the number is able to be parsed, if it is then it
		 * will return the employee details*/
		if (option == JOptionPane.OK_OPTION){
			try {
				int empNum = Integer.parseInt(empNumber.getText());

				for(Employee emp : employees) {
					if(emp.getNumber() == empNum) {
						JOptionPane.showMessageDialog(null, emp.toString());
						return emp;
					}
				}

				JOptionPane.showMessageDialog(null, "No employee found using that Employee Number...");
				tmpEmp = view();
			}
			catch(NumberFormatException ex) {
				System.out.println("You must enter the correct employee number. Error Code: " + ex.getMessage());
				tmpEmp = view();
			}
		}
		return tmpEmp;
	}

	///////////////////////////////////////////////////////
	// Method Name : edit()						 		 //
	// Return Type : void					   	 		 //
	// Parameters : None						 		 //
	// Purpose : Edit an Employee record in employees    //
	///////////////////////////////////////////////////////	
	public void edit() {
		Employee emp = view();

		/*Simply check if returned emp is null
		 * if not then logs the index value into int i
		 * then uses the read() method so the user can make changes
		 * and if all goes correctly in the read()
		 * it sets the object at index i, to the new employee*/
		try {
			if(emp != null) {
				int i = employees.indexOf(emp);
				emp.read();
				employees.set(i, emp);
			}
		}
		catch(IndexOutOfBoundsException iob) {
			System.out.println(iob.getMessage());
		}
	}

	///////////////////////////////////////////////////////
	// Method Name : delete()						     //
	// Return Type : void					   	 		 //
	// Parameters : None						 		 //
	// Purpose : Delete an Employee record from employees//
	///////////////////////////////////////////////////////	
	public void delete() {
		Employee emp = view();

		if(emp != null)
			employees.remove(emp);
	}

	// This method will serialize the employees ArrayList when called, 
	// i.e. it will write it to a file called employee.bin
	// If one already exists it will override it
	public void serializeEmployees(){
		ObjectOutputStream os = null;

		try {
			FileOutputStream fileStream = new FileOutputStream(FILENAME);

			os = new ObjectOutputStream(fileStream);

			os.writeObject(employees);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			System.out.println("Cannot write to " + FILENAME + "." + ioE.getMessage());
		}
		finally {
			try {
				os.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
		}
	}
	// This method will deserialize the employees ArrayList when called, 
	// i.e. it will restore the ArrayList from the file employee.bin
	public void deserializeEmployees(){
		ObjectInputStream is = null;

		try {
			FileInputStream fileStream = new FileInputStream(FILENAME);

			is = new ObjectInputStream(fileStream);

			employees = (ArrayList<Employee>)is.readObject();	
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store employees.");
		}
		catch(IOException ioE){
			System.out.println("Cannot read from " + FILENAME + "." + ioE.getMessage());
		}
		catch(Exception e){
			System.out.println(e.getMessage());
		}
		finally {
			try {
				//This if statement gets the last employee in the list and checks if their
				//number is larger than the Employee.nextNumber variable. If it is, it passes
				//the employees number + 1 to the Employee class and updates the number to the
				//larger one. It'll do this everytime the app opens.
				//It checks if the employees ArrayList size is > 0 because if you delete the bin
				//file and run it without that check, it will throw an index out of bounds exception
				if(employees.size() > 0)
					if(employees.get(employees.size() - 1).getNumber() >= Employee.getNextNumber()) {
						int num = employees.get(employees.size() - 1).getNumber();
						Employee.setNextNumber(num + 1);

					}
				is.close();
			}
			catch(IOException ioE){
				System.out.println(ioE.getMessage());
			}
			catch(NullPointerException ex) {
				System.out.println(ex.getMessage());
			}
		}
	}
}