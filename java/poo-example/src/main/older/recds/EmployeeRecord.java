package recds;
	
	// also not allowed extends or multiple inheritance

	// But you can implement interfaces

public record EmployeeRecord(String Name, int Number) implements Runnable {

	public static final String default_employee = "George";
	
	// Also you can add compact construct

	// public EmployeeRecord {
	//	
	// }
	
	public EmployeeRecord(String Name, int Number) {
		if(Number < 0) {
			throw new IllegalArgumentException("Cannot be negative");
		}
		this.Name = Name;
		this.Number = Number;
	}
	
	
	// private String something; not allowed
	
	public String nameInUpperCase() {
		return Name.toUpperCase();
	}
	
	public static void justPrint() {
		System.out.println("Walk");
	}
	
	@Override
	public void run() {
		
	}
}
