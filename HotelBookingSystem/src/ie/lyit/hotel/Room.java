package ie.lyit.hotel;

public class Room {
	private int maxAdults;
	private int maxKids;
	private double pricePerNight;
	private boolean allocated = false;
	private int number;

	public Room(int adults, int kids, double price, int roomNumber){
		if(adults > 2 || adults < 1)
			throw new IllegalArgumentException("Maxium adults is 2, Minimum is 1");
		if(kids > 3 || kids < 0)
			throw new IllegalArgumentException("Maxium kids is 3, Minimum is 0");
		if(price < 60.00)
			throw new IllegalArgumentException("Minimum room price is 60.00");
		
		maxAdults = adults;
		maxKids = kids;
		pricePerNight = price;
		number = roomNumber;
	}

	public void setMaxAdults(int maxAdults) {
		if(maxAdults <= 2 && maxAdults >= 1)
			this.maxAdults = maxAdults;
		else {
			throw new IllegalArgumentException("Maximum adults is 2, Minimum is 1");
		}
	}

	public void setMaxKids(int maxKids) {
		if(maxKids <= 3 && maxKids >= 0)
			this.maxKids = maxKids;
		else
			throw new IllegalArgumentException("Maximum kids is 3, Minimum is 0");
	}

	public void setPricePerNight(double pricePerNight) {
		if(pricePerNight >= 60.00)
			this.pricePerNight = pricePerNight;
		else
			throw new IllegalArgumentException("Minimum room price is 60.00");
	}

	public void setAllocated(boolean allocated) {
		this.allocated = allocated;
	}
	
	public int getMaxAdults() {
		return maxAdults;
	}

	public int getMaxKids() {
		return maxKids;
	}

	public double getPricePerNight() {
		return pricePerNight;
	}

	public boolean isAllocated() {
		return allocated;
	}

	public int getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "Room [maxAdults=" + maxAdults + ", maxKids=" + maxKids + ", pricePerNight=" + pricePerNight
				+ ", allocated=" + allocated + ", number=" + number + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Room other = (Room) obj;
		return allocated == other.allocated && maxAdults == other.maxAdults && maxKids == other.maxKids
				&& number == other.number
				&& Double.doubleToLongBits(pricePerNight) == Double.doubleToLongBits(other.pricePerNight);
	}

}
