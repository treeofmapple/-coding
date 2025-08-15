package java_poo.Eleven_11;

public class Hotel {

	private int hotelId;
	private String name;
	private String location;
	private String checkIn;
	private String checkOut;
	private int numGuests;
	private double price;
	private int confirmationNumber;

	public Hotel(int hotelId, String name, String location, String checkIn, String checkOut, int numGuests,
			double price) {
		this.hotelId = hotelId;
		this.name = name;
		this.location = location;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.numGuests = numGuests;
		this.price = price;
	}

	public int getHotelId() {
		return hotelId;
	}

	public String getName() {
		return name;
	}

	public String getLocation() {
		return location;
	}

	public String getCheckIn() {
		return checkIn;
	}

	public String getCheckOut() {
		return checkOut;
	}

	public double getPrice() {
		return price;
	}

	public int getNumGuests() {
		return numGuests;
	}

	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

}
