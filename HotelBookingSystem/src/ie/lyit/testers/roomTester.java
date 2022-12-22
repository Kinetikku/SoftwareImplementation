package ie.lyit.testers;
import ie.lyit.hotel.Room;

public class roomTester {

	public static void main(String[] args) {
		Room room1 = null;
		try {
			room1 = new Room(2, 1, 120.00, 101);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println(room1.toString());
		System.out.println("we live");
	}

}
