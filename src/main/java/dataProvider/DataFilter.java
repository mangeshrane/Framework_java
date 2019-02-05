package dataProvider;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;

/*
 * Mangesh Rane
 * Annotation to get data from specified sheet into DataProvider 
 */
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.METHOD, ElementType.TYPE, ElementType.CONSTRUCTOR })
public @interface DataFilter {
	public String fileName();
	public String sheetName() default "";
	public int sheetIndex() default 0;
	public String filter();
	public boolean header();
	public String seperator() default ",";
}
