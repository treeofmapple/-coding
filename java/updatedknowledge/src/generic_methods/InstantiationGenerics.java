package generic_methods;


public class InstantiationGenerics {

    static GenericsFactory<InstantiationGenerics> factory1 = new GenericsFactory<>(InstantiationGenerics.class);
    static GenericsFactory<SomeObject> factory2 = new GenericsFactory<>(SomeObject.class);

	public static void main(String[] args) {
		try {
			InstantiationGenerics myClassInstance = factory1.createInstance();
			SomeObject someObjectInstance = factory2.createInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}
