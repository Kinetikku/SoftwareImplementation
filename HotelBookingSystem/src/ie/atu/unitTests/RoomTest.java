package ie.atu.unitTests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import ie.lyit.hotel.Room;

class RoomTest {
	
	Room room = new Room(2, 3, 60.00, 69);
	
	@Test
	public void testConstructor(){
	    assertEquals(2, room.getMaxAdults());
	    assertEquals(3, room.getMaxKids());
	    assertEquals(60.00, room.getPricePerNight(), 0.01);
	    assertTrue(room.isAllocated());
	    assertEquals(69, room.getNumber());
	}

	@Test
	public void testConstructorValues() {
		Integer adultInt = Integer.valueOf(room.getMaxAdults());
		Integer kidsInt = Integer.valueOf(room.getMaxKids());
		Double priceDou = Double.valueOf(room.getPricePerNight());
		
	    assertTrue(room.getMaxAdults() >= 1 && room.getMaxAdults() <= 2);
	    assertTrue(room.getMaxKids() >= 0 && room.getMaxKids() <= 3);
	    assertTrue(room.getPricePerNight() >= 60.00);
	    
	    assertTrue(adultInt instanceof Integer);
	    assertTrue(kidsInt instanceof Integer);
	    assertTrue(priceDou instanceof Double);
	}
}
