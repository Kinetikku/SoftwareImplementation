package ie.lyit.hotel;

public class Name {
	private String title, firstName, surname;

	public Name() {
		title = "";
		firstName = "";
		surname = "";
	}
	
	public Name(String t, String f, String s) {
		this.title = t;
		this.firstName = f;
		this.surname = s;
	}
	
	@Override
	public String toString() {
		return this.title + " " + this.firstName + " " + this.surname;
	}
	
	public boolean equals(Object obj) {
		Name nObject;
		
		if(obj instanceof Name)
			nObject = (Name)obj;
		else
			return false;
		
		return this.title.equals(nObject.title)
				&& this.firstName.equals(nObject.firstName)
				&& this.surname.equals(nObject.surname);
	}
	
	public boolean isFemale() {
		if(this.title.equalsIgnoreCase("Miss") || this.title.equalsIgnoreCase("Ms") || this.title.equalsIgnoreCase("Mrs"))
			return true;
		else
			return false;
	}
	
	public String getTitle() {
		return this.title;
	}
	
	public String getFirstName() {
		return this.firstName;
	}
	
	public String getSurname() {
		return this.surname;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}
	
	
}