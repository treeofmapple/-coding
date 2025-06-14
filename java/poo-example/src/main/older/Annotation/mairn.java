package Annotation;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class mairn {
	
	public static void main(String[] args) throws IllegalArgumentException, IllegalAccessException, InvocationTargetException {
		
		@SuppressWarnings("unused")
		Cat myCat = new Cat ("Stella");
		Dog myDog = new Dog ("Jerry");
		
		if (myDog.getClass().isAnnotationPresent(VeryImportant.class)) {
			System.out.println("Yeah");
		} else {
			System.out.println("Nah");
		} 
	
		for (Method method : myCat.getClass().getDeclaredMethods()) {
			if(method.isAnnotationPresent(RunImmediatly.class)) {
				RunImmediatly annotation = method.getAnnotation(RunImmediatly.class);
				for (int i = 0; i < annotation.times(); i++) {
					method.invoke(myCat);
				}
			}
		}
		
		for (Field field : myCat.getClass().getDeclaredFields()) {
			if(field.isAnnotationPresent(ImportantString.class)) {
				Object objectValue = field.get(myCat);
				
				if (objectValue instanceof String stringValue) {
					System.out.println(stringValue.toUpperCase());
				}
			}
		}
	
	
	}
	
	
	
}
