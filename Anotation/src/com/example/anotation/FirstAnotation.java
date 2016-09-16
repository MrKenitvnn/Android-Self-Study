package com.example.anotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;
import org.apache.http.impl.client.DefaultHttpClient;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)


/** Note
 * Chỉ gắn trên Field, Method thì bỏ comment đoạn này
 * @Target(value = { ElementType.FIELD, ElementType.METHOD })
 * 
 * Annotation có thể được gắn trên:
 *	TYPE - Gắn trên khai báo Class, interface, enum, annotation.
 *	FIELD - Gắn trên khai báo trường (field), bao gồm cả các hằng số enum.
 *	METHOD - Gắn trên khai báo method.
 *	PARAMETER - Gắn trên khai báo parameter
 *	CONSTRUCTOR - Gắn trên khai báo cấu tử
 *	LOCAL_VARIABLE - Gắn trên biến địa phương.
 *	ANNOTATION_TYPE - Gắn trên khai báo Annotation
 *	PACKAGE - Gắn trên khai báo package.
 * 
 */

// @Target(value = { ElementType.FIELD, ElementType.METHOD })
public @interface FirstAnotation {

	public String name ();
	
	public String value() default "";
	
	public int price ();
	
}
