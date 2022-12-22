package ie.atu.unitTests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import org.junit.Before;
import org.junit.Test;

import ie.lyit.hotel.Room;

public class RoomTest {
	Room room, room7, room8;
	
	
	@Before
	public void setUp() throws Exception{
		room = new Room(2, 3, 60.00, 69);
		room7 = new Room(2, 2, 100.0, 1);
		room8 = room7;
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
	
	@Test(expected = IllegalArgumentException.class)
	public void testExceptions() {
		Room room1, room2, room3, room4, room5, room6;
		//Incorrect Adults
		room1 = new Room(3, 3, 60.00, 69);
		//Incorrect Adults
		room2 = new Room(-1, 3, 60.00, 69);
		//Incorrect Kids
		room3 = new Room(2, 4, 60.00, 69);
		//Incorrect Kids
		room4 = new Room(2, -1, 60.00, 69);
		//Incorrect Price
		room5 = new Room(2, 3, 59.99, 69);
		//Incorrect Room
		room6 = new Room(2, 3, 60.00, -1);
		
		assertTrue(room1.getMaxAdults() == 3);		
		assertTrue(room2.getMaxAdults() == -1);
		assertTrue(room3.getMaxKids() == 4);
		assertTrue(room4.getMaxKids() == -1);
		assertTrue(room5.getPricePerNight() == -1);
		assertTrue(room6.getNumber() == -1);
	}
	
	@Test
    public void testGettersAndSetters() {
        assertEquals(2, room7.getMaxAdults());
        assertEquals(2, room7.getMaxKids());
        assertEquals(100.0, room7.getPricePerNight(), 0.001);
        assertEquals(false, room7.isAllocated());
        assertEquals(1, room7.getNumber());

        room7.setMaxAdults(1);
        room7.setMaxKids(1);
        room7.setPricePerNight(80.0);
        room7.setAllocated(true);

        assertEquals(1, room7.getMaxAdults());
        assertEquals(1, room7.getMaxKids());
        assertEquals(80.0, room7.getPricePerNight(), 0.001);
        assertEquals(true, room7.isAllocated());
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testSetMaxAdults() {
		room.setMaxAdults(3);
		room.setMaxAdults(0);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testSetMaxKids() {
		room.setMaxKids(4);
		room.setMaxKids(-1);
    }
	
	@Test(expected = IllegalArgumentException.class)
    public void testPricePerNight() {
		room.setPricePerNight(40.00);
    }
	
	@Test
    public void testToString() {
        String expectedResult = "Room [maxAdults=2, maxKids=2, pricePerNight=100.0, allocated=false, number=1]";
        assertEquals(expectedResult, room7.toString());
    }
	
	 @Test
	    public void testEquals() {
	        assertTrue(room7.equals(room8));
	    }
}
