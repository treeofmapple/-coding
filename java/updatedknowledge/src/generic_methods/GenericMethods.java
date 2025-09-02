package generic_methods;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@SuppressWarnings({ "unused", "deprecation", "removal" })
public class GenericMethods {

	public static <T> T addAndReturn(T element, Collection<T> collection) {
		collection.add(element);
		return element;
	}

	private void storedData() {
		String stringElement = "stringElement";
		List<String> stringList = new ArrayList<String>();

		String theElement = addAndReturn(stringElement, stringList);
	}

	private void storedData2() {
		Integer integerElement = new Integer(123);
		List<Integer> integerList = new ArrayList<Integer>();

		Integer theElement = addAndReturn(integerElement, integerList);
	}

	private void advancedType() {
		String stringElement = "stringElement";
		List<Object> objectList = new ArrayList<Object>();

		Object theElement = addAndReturn(stringElement, objectList);
	}
	
	private void inverseGenericType() {
		Object objectElement = new Object();
		List<String> stringList = new ArrayList<String>();

		// Object theElement = addAndReturn(objectElement, stringList); // invalid
	}
	
	public static <T> T getInstance(Class<T> theClass)
		    throws IllegalAccessException, InstantiationException {

	    return theClass.newInstance();
	} // using class

}
