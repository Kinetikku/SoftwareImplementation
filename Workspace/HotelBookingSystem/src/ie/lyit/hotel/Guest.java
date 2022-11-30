package ie.lyit.hotel;

public class Guest extends Person{// INHERITANCE - Customer IS-A Person
	// Customer has name & phoneNumber from Person
	private String emailAddress;    // AND emailAddress
	private CreditCard creditCard;  // AND creditCard

	// Default Constructor
	// Called when a Guest object is created like this ==> 
	//   Guest g1 = new Guest();	
	public Guest() {
		super();	// Don't need to call super() explicitly.
		emailAddress="";
	}
	
	// Overloaded initialization constructor
	// Called when a Guest object is created like this ==>
	//    Name name=new Name("Mr", "Joe", "Bloggs");
	//    CreditCard creditCard=new CreditCard(5555666677778888,new Date(31,12,2024),123);
	//    Guest g2 = new Guest(name, "087 1234567", "joe@gmail.com" =, creditCard);
	public Guest(Name name, String phoneNumber, String emailAddress, CreditCard creditCard) {
		super(name,phoneNumber);
		this.emailAddress=emailAddress;
		this.creditCard=creditCard;
	}

	// OVERRIDING the Person toString() method!
	// Calling Persons toString() method, and adding emailAddress
	@Override
	public String toString() {
		return super.toString() + " " + emailAddress;
	}
	
	// no equals() method because the super class equals() is sufficient
	// We can compare two Guest objects using their name and phoneNumber only
	// if(g1.equals(g2))
	//    given that there is no equals method in Guest it will call Persons equals
	//    and compare g1's name and phoneNumber with g2's name and phoneNumber
	
	// set() and get() methods
	public String getEmailAddress(){
	   return emailAddress;
	}	
	public void setEmailAddress(String emailAddress) {
		this.emailAddress=emailAddress;
	}
	public CreditCard getCreditCard() {
		return creditCard;
	}
	public void setCreditCard(CreditCard creditCard) {
		this.creditCard=creditCard;
	}
}
