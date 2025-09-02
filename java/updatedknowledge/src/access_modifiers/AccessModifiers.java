package access_modifiers;

public class AccessModifiers {

	/*
	 * 
	Modifier	Same Class	Same Package	Subclass (Diff. Pkg)	World (Diff. Pkg)
	public	       Yes	       Yes	               Yes	                  Yes
	protected	   Yes	       Yes	               Yes	                  No
	default	       Yes	       Yes	               No	                  No
	private	       Yes	       No	               No	                  No
	 * */
	
}

class House {
    // public: Accessible from anywhere
    public String address = "123 Main St";

    // protected: Accessible in this package and by subclasses anywhere
    protected String wifiPassword = "SecretPassword123";

    // default (package-private): Accessible only within the 'com.example.building' package
    String heatingSystem = "BrandX Furnace";

    // private: Accessible ONLY within this House class
    private int safeCode = 998877;

    // A method inside the class can access everything
    public void testInternalAccess() {
        System.out.println("--- Testing access from inside House ---");
        System.out.println(this.address);      // OK
        System.out.println(this.wifiPassword); // OK
        System.out.println(this.heatingSystem);// OK
        System.out.println(this.safeCode);     // OK
    }
}

class Neighbor {
    public static void main(String[] args) {
        House myNeighborsHouse = new House();

        System.out.println("--- Testing access from Neighbor (same package) ---");

        // Public is always accessible
        System.out.println("Address: " + myNeighborsHouse.address); // OK

        // Protected is accessible from the same package
        System.out.println("WiFi: " + myNeighborsHouse.wifiPassword); // OK

        // Default is accessible from the same package
        System.out.println("Heating: " + myNeighborsHouse.heatingSystem); // OK

        // Private is NOT accessible from another class
        // System.out.println(myNeighborsHouse.safeCode); // COMPILE ERROR!
    }
}

class SuburbanHouse extends House {

    public void testSubclassAccess() {
        System.out.println("--- Testing access from SuburbanHouse (subclass in different package) ---");

        // Public is always accessible
        System.out.println("Address: " + this.address); // OK

        // Protected is accessible to a subclass, even in a different package
        System.out.println("WiFi: " + this.wifiPassword); // OK

        // Default is NOT accessible from a different package, even for a subclass
        // System.out.println(this.heatingSystem); // COMPILE ERROR!

        // Private is never accessible outside its own class
        // System.out.println(this.safeCode); // COMPILE ERROR!
    }
}

class Stranger {
    public static void main(String[] args) {
        House someHouse = new House();

        System.out.println("--- Testing access from Stranger (unrelated class in different package) ---");

        // Public is the only thing accessible from an unrelated class in a different package
        System.out.println("Address: " + someHouse.address); // OK

        // Protected is NOT accessible here (not a subclass)
        // System.out.println(someHouse.wifiPassword); // COMPILE ERROR!

        // Default is NOT accessible from a different package
        // System.out.println(someHouse.heatingSystem); // COMPILE ERROR!

        // Private is never accessible outside its own class
        // System.out.println(someHouse.safeCode); // COMPILE ERROR!
    }
}