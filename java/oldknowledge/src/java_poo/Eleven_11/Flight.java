package java_poo.Eleven_11;

public class Flight {

	private int flightNumber;
	private String passengerName;
	private String origin;
	private String destination;
	private String date;
	private int numPassengers;
	private double price;
	private int confirmationNumber;

	public Flight(int flightNumber, String passengerName, String origin, String destination, String date,
			int numPassengers, double price) {
		this.flightNumber = flightNumber;
		this.passengerName = passengerName;
		this.origin = origin;
		this.destination = destination;
		this.date = date;
		this.numPassengers = numPassengers;
		this.price = price;
	}

	public int getFlightNumber() {
		return flightNumber;
	}

	public String getPassengerName() {
		return passengerName;
	}

	public String getOrigin() {
		return origin;
	}

	public String getDestination() {
		return destination;
	}

	public String getDate() {
		return date;
	}

	public int getNumPassengers() {
		return numPassengers;
	}

	public double getPrice() {
		return price;
	}

	public int getConfirmationNumber() {
		return confirmationNumber;
	}

	public void setConfirmationNumber(int confirmationNumber) {
		this.confirmationNumber = confirmationNumber;
	}

}
