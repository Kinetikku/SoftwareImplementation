package ie.atu.unitTests;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.hotel.Room;

public class RoomTest {
	Room room;
	
	@Before
	public void setUp() throws Exception{
		room = new Room(2, 3, 60.00, 69);

	}
	
	@Test
	public void testConstructor(){
	    assertEquals(2, room.getMaxAdults());
	    assertEquals(3, room.getMaxKids());
	    assertEquals(room.getPricePerNight(), 60.00, 0.01);
	    assertEquals(room.isAllocated(), false);
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
