package recds;

public class Mairn {

	public static void main(String[] args) {
		Employee em = new Employee("Jerry", 1515);
		System.out.println(em.getName());
		System.out.println(em); 
		
		EmployeeRecord emar = new EmployeeRecord("Dolver", 1515);
		System.out.println(emar.Name());
		System.out.println(emar);
		System.out.println(emar.nameInUpperCase());
		EmployeeRecord.justPrint();
		
	}
	
}
