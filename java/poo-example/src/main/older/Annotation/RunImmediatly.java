package Annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface RunImmediatly {
	
	int times();
	int value = 0;
	// int[] also();
	// String paladin();
	// int palso() default 1;

}
