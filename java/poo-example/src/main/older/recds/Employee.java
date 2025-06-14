package recds;

import java.util.Objects;

public class Employee {
	private final String Name;
	private final int Number;

	public Employee(String name, int number) {
		this.Name = name;
		this.Number = number;
	}

	public String getName() {
		return Name;
	}

	public int getNumber() {
		return Number;
	}

	@Override
	public String toString() {
		return "Employee [Name=" + Name + ", Number=" + Number + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(Name, Number);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		return Objects.equals(Name, other.Name) && Number == other.Number;
	}
	
}
