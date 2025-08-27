package java_poo.Eleven_11;

import java.util.ArrayList;
import java.util.Random;

public class TravelApp {

	private ArrayList<Flight> flights;
	private ArrayList<Hotel> hotels;

	public TravelApp() {
		this.flights = new ArrayList<Flight>();
		this.hotels = new ArrayList<Hotel>();
	}

	public void searchFlights(String origin, String destination, String date, int numPassengers) {
		System.out.println("Searching for flights from " + origin + " to " + destination + " on " + date + " for "
				+ numPassengers + " passengers.");
	}

	public void searchHotels(String location, String checkIn, String checkOut, int numGuests) {
		System.out.println("Searching for hotels in " + location + " from " + checkIn + " to " + checkOut + " for "
				+ numGuests + " guests.");
	}

	public void bookFlight(int flightNumber, String passengerName, String origin, String destination, String date,
			int numPassengers, double price) {
		Flight flight = new Flight(flightNumber, passengerName, origin, destination, date, numPassengers, price);
		int confirmationNumber = generateConfirmationNumber();
		flight.setConfirmationNumber(confirmationNumber);
		this.flights.add(flight);
		System.out.println("Flight booked! Confirmation number: " + confirmationNumber);
	}

	public void bookHotel(int hotelId, String guestName, String location, String checkIn, String checkOut,
			int numGuests, double price) {
		Hotel hotel = new Hotel(hotelId, guestName, location, checkIn, checkOut, numGuests, price);
		int confirmationNumber = generateConfirmationNumber();
		hotel.setConfirmationNumber(confirmationNumber);
		this.hotels.add(hotel);
		System.out.println("Hotel booked! Confirmation number: " + confirmationNumber);
	}

	public void cancelReservation(int confirmationNumber) {
		// Cancel a flight or hotel reservation based on confirmation number
		for (Flight flight : this.flights) {
			if (flight.getConfirmationNumber() == confirmationNumber) {
				this.flights.remove(flight);
				System.out.println("Flight reservation with confirmation number " + confirmationNumber + " cancelled.");
				return;
			}
		}
		for (Hotel hotel : this.hotels) {
			if (hotel.getConfirmationNumber() == confirmationNumber) {
				this.hotels.remove(hotel);
				System.out.println("Hotel reservation with confirmation number " + confirmationNumber + " cancelled.");
				return;
			}
		}
		System.out.println("No reservation found with confirmation number " + confirmationNumber + ".");
	}

	private int generateConfirmationNumber() {
		Random rand = new Random();
		return rand.nextInt(900000) + 100000;
	}

}
