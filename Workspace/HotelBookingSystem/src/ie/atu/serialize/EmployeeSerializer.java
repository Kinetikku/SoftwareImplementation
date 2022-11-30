package ie.atu.serialize;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import ie.lyit.hotel.Employee;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

//EmployeeSerializer contains an ArrayList of Employee's, and methods to 
//serialize and deserialize that ArrayList of Employees.
//It also contains methods to add() an Employee to the ArrayList,
//and view(), edit(), delete(), list() Book(s) in the ArrayList.

public class EmployeeSerializer {

	private ArrayList<Employee> employees;
	
	final String FILENAME = "employees.bin";	
	
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
		JTextField empNumber = new JTextField();
		empNumber.requestFocus();
	    
	    Object[] message = {
	        "Employee Number:", empNumber
	    };
	      
	    JDialog dialog = new JDialog();
	     
	    dialog.setAlwaysOnTop(true);    
	      
	    int option = JOptionPane.showConfirmDialog(dialog, message, "Enter Employee Details", JOptionPane.OK_CANCEL_OPTION);

	    if (option == JOptionPane.OK_OPTION){
	    	int empNum = Integer.parseInt(empNumber.getText());
	    	
	    	for(Employee emp : employees) {
	    		if(emp.getNumber() == empNum) {
	    			JOptionPane.showMessageDialog(null, emp.toString());
	    			return emp;
	    		}
	    	}
	    }
	    
	    return null;
	}
	
	///////////////////////////////////////////////////////
	// Method Name : edit()						 		 //
	// Return Type : void					   	 		 //
	// Parameters : None						 		 //
	// Purpose : Edit an Employee record in employees    //
	///////////////////////////////////////////////////////	
	public void edit() {
		Employee emp = view();
		
		if(emp != null) {
			int i = employees.indexOf(emp);
			emp.read();
			employees.set(i, emp);
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
	// i.e. it will write it to a file called employees.ser
	public void serializeEmployees(){
		ObjectOutputStream os=null;
		try {
			// Serialize the ArrayList...
			FileOutputStream fileStream = new FileOutputStream(FILENAME);
			
			os = new ObjectOutputStream(fileStream);
			
			os.writeObject(employees);
		}
		catch(FileNotFoundException fNFE){
			System.out.println("Cannot create file to store books.");
		}
		catch(IOException ioE){
			System.out.println("Cannot write to " + FILENAME + ".");
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
		// i.e. it will restore the ArrayList from the file employees.ser
		public void deserializeEmployees(){
			ObjectInputStream is=null;
			
			try {
				// Deserialize the ArrayList...
				FileInputStream fileStream = new FileInputStream(FILENAME);
			
				is = new ObjectInputStream(fileStream);
					
				employees = (ArrayList<Employee>)is.readObject();	
			}
			catch(FileNotFoundException fNFE){
				System.out.println("Cannot create file to store books.");
			}
			catch(IOException ioE){
				System.out.println("Cannot read from " + FILENAME + ".");
			}
			catch(Exception e){
				System.out.println(e.getMessage());
			}
			finally {
				try {
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