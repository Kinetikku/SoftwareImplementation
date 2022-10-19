package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.CreditCard;
import ie.lyit.hotel.Date;
import ie.lyit.hotel.Guest;
import ie.lyit.hotel.Name;

public class GuestTester {

	public static void main(String[] args) {
		ArrayList<Guest> guests=new ArrayList<Guest>();
		
		// Create a Guest object called g1 with initial values
		Name name=new Name("Mr", "Homer", "Simpson");
		CreditCard card=new CreditCard(1111222233334444L,new Date(31,12,2027),111);
		Guest g1 = new Guest(name, "087 1234567", "homer.simpson@atu.ie", card);	

		// Create a Guest object called g2 with initial values
		name=new Name("Mrs", "Marge", "Simpson");
		card=new CreditCard(5555666677778888L,new Date(31,12,2024),222);
		Guest g2 = new Guest(name, "086 1234567", "marge.simpson@atu.ie", card);	
		
		// Create a Guest object called g3 with initial values
		name=new Name("Miss", "Lisa", "Simpson");
		card=new CreditCard(9999888877776666L,new Date(31,3,2024),333);
		Guest g3 = new Guest(name, "087 9876543", "lisa.simpson@atu.ie", card);	

		guests.add(g1);
		guests.add(g2);
		guests.add(g3);
	
		// Display Guest's
		System.out.println("LIST OF GUESTS");
		for(Guest guest:guests)
			System.out.println(guest);
		
		// Display male/female count
		int femaleCount=0, maleCount=0;
		System.out.println();
		System.out.println("MALE/FEMALE GUEST COUNT");
		for(Guest guest:guests)
		// check if g1 is MALE or FEMALE
		if(guest.getName().isFemale())
			femaleCount++;
		else
			maleCount++;
		
		System.out.println(maleCount + " MALE(S), " + femaleCount + " FEMALE(S).");

		// Display Guests CreditCard numbers on screen
		System.out.println();
		System.out.println("GUESTS CREDIT CARD DETAILS");
		for(Guest guest:guests)
     		System.out.println(guest.getName() + " " + guest.getCreditCard());		
	}
}
