package ie.lyit.testers;

import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.lyit.hotel.CreditCard;
import ie.lyit.hotel.Date;
import ie.lyit.hotel.Guest;
import ie.lyit.hotel.Name;

public class ExceptionHandlerDemo {

	public static void main(String[] args) {
		//Create some guests
		Name name=new Name("Mr", "Homer", "Simpson");
		CreditCard card=new CreditCard(11117452233334444L,new Date(31,12,2027),111);
		Guest g1 = new Guest(name, "087 1234567", "homer.simpson@atu.ie", card);	

		Name name2 =new Name("Mrs", "Marge", "Simpson");
		CreditCard card2=new CreditCard(5555666677778888L,new Date(31,12,2024),222);
		Guest g2 = new Guest(name2, "086 1234567", "marge.simpson@atu.ie", card2);
		
		Name name3=new Name("Mr", "John", "Blunt");
		CreditCard card3=new CreditCard(1111222233334444L,new Date(31,12,2027),111);
		Guest g3 = new Guest(name3, "087 1234567", "john.blunt@atu.ie", card3);	
		
		Name name4 =new Name("Mrs", "Janet", "Jackson");
		CreditCard card4=new CreditCard(5555666677778888L,new Date(31,12,2024),222);
		Guest g4 = new Guest(name4, "086 1234567", "janet.jackson@atu.ie", card4);

		ArrayList<Guest> guests = new ArrayList<Guest>();
		
		guests.add(g1);
		guests.add(g2);
		guests.add(g3);
		guests.add(g4);
		
		int guestNumber = 0;
		
		String guestNumberToViewAsString = "";
		
		boolean loop = true;
		
		while(loop) {
			try {
				guestNumberToViewAsString = JOptionPane.showInputDialog(null, "Enter Guest to View ("+ 1 +" to "+ guests.size()+")");
				
				guestNumber = Integer.parseInt(guestNumberToViewAsString) - 1;
				
				JOptionPane.showMessageDialog(null, guests.get(guestNumber));
				loop = false;
			}
			catch(NumberFormatException nfe) {
				JOptionPane.showMessageDialog(null, guestNumberToViewAsString + " is not a valid number, try again");
			}
			catch(IndexOutOfBoundsException ioe) {
				JOptionPane.showMessageDialog(null, "Select a number between 1 - " + guests.size());
			}
		}
		
		
	}

}
