package ie.lyit.testers;

import java.util.ArrayList;

import ie.lyit.hotel.Name;

public class NameTester{

	public static void main(String[] args) {
		// Simple tester class for names
		Name gareth = new Name("Mr", "Gareth", "Craig");
		Name kiera = new Name("Mrs", "Kiera", "Meyer");
		Name erin = new Name("Mr", "Erin", "Yager");
		
		System.out.println(gareth.toString());
		System.out.println("Is it a female: " + gareth.isFemale());
		System.out.println();
		
		System.out.println(kiera.toString());
		System.out.println("Is it a female: " + kiera.isFemale());
		System.out.println();

		System.out.println(erin.toString());
		System.out.println("Is it a female: " + erin.isFemale());
		System.out.println();
		
		ArrayList<Name> names = new ArrayList<Name>();
		names.add(gareth);
		names.add(kiera);
		names.add(erin);
		
		System.out.println(names);
	}

}
