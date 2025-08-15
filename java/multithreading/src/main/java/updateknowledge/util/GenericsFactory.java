package updateknowledge.util;

public class GenericsFactory <T> {

	Class<?> theClass = null;
	
	public GenericsFactory(Class<?> theClass) {
		this.theClass = theClass;
	}
	
	@SuppressWarnings({ "unchecked" })
	public T createInstance() throws Exception {
		return (T) theClass.getDeclaredConstructor().newInstance();
	}
	
}
