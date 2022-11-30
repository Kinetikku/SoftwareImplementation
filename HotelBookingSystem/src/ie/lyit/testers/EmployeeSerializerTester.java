package ie.lyit.testers;

import java.awt.*;
import javax.swing.*;
import ie.atu.serialize.EmployeeSerializer;

// JFrame that contains two panels, one to the LEFT of the JFrame, and one to the CENTER
// GUIMenu IS-A JFrame ==> Inheritance
public class EmployeeSerializerTester extends JFrame{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	// Instance Variables go here (properties of our JFrame)...
    private static final int FRAME_WIDTH = 600;
    private static final int FRAME_HEIGHT = 600;     
	
	// It has two JPanels...
    //    centerPanel with a JLabel, and...
    private JPanel centerPanel;
    private JLabel jlblHotel;	
	private Font f;
	
	//    buttonPanel with 6 JButtonsH
	private JPanel buttonPanel;  
    private JButton jbtAdd, jbtList, jbtView, jbtEdit, jbtDelete, jbtExit;
	
    private EmployeeSerializer employeeSerializer;
    
	// Constructor - SetLayout & Add Components here...
    public void GUIMenu(){	   
	   f = new Font("Gill Sans MT", Font.BOLD, 22);		
	   
	   /////
	   // Build centerPanel      
	   centerPanel = new JPanel(new BorderLayout());
	   centerPanel.setBackground(Color.WHITE);
	   jlblHotel = new JLabel("Hotel",SwingConstants.CENTER);
	   // Centre the icon and text and place the text under the icon, and set the Font of jlblHotel
	   jlblHotel.setHorizontalTextPosition(JLabel.CENTER);
	   jlblHotel.setVerticalTextPosition(JLabel.TOP);
	   jlblHotel.setFont(f);
	   centerPanel.add(jlblHotel,BorderLayout.NORTH);
	   jlblHotel.setFont(f);
	   centerPanel.add(jlblHotel, BorderLayout.CENTER);
       centerPanel.setBackground(Color.WHITE);

		// Set up buttonPanel
       buttonPanel = new JPanel();
       buttonPanel.setLayout(new GridLayout(6,1,5,5));
       buttonPanel.setBackground(Color.WHITE);
       
       buttonPanel.add(jbtAdd=new JButton("ADD"));
       buttonPanel.add(jbtList=new JButton("LIST"));				
       buttonPanel.add(jbtView=new JButton("VIEW"));		
       buttonPanel.add(jbtEdit=new JButton("EDIT"));				
       buttonPanel.add(jbtDelete=new JButton("DELETE"));	
       buttonPanel.add(jbtExit=new JButton("EXIT"));				

		// setMnemonics on JButtons
       jbtAdd.setMnemonic('A');
       jbtList.setMnemonic('L');
       jbtView.setMnemonic('V');
       jbtEdit.setMnemonic('E');
       jbtDelete.setMnemonic('D');
       jbtExit.setMnemonic('X');

		// Set up Frame
        add(centerPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.WEST);

 	    // Create a EmployeeSerializer object to call add(), list(), etc. methods
        employeeSerializer = new EmployeeSerializer();
        // deserializeEmployees() before the JFrame is displayed...
        employeeSerializer.deserializeEmployees();
        
        // Create a Listener for each of the 6 JButtons		
		jbtAdd.addActionListener(e -> {
			employeeSerializer.add();
		});
		jbtList.addActionListener(e -> {
			employeeSerializer.list();
		});				
		jbtView.addActionListener(e -> {
			employeeSerializer.view();
		});
		jbtEdit.addActionListener(e -> {
			employeeSerializer.edit();
		});
		jbtDelete.addActionListener(e -> {
			employeeSerializer.delete();
		});				
		jbtExit.addActionListener(e -> {
			// Serialize the Employees ArrayList on Exit		
			employeeSerializer.serializeEmployees();
			dispose();
		});
   }
   
  
   public static void main(String[] args){ 
	    EmployeeSerializerTester frame = new EmployeeSerializerTester();
	    frame.GUIMenu();

		// Do whatever to frame object
		frame.setTitle("Hotel Application");

		// Make frame big enough to hold components
		frame.setSize(FRAME_WIDTH, FRAME_HEIGHT);

		// Add the Default Close operation to frame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Center the frame
        frame.setLocationRelativeTo(null);

		// Set frame visible
		frame.setVisible(true);
   }
}
