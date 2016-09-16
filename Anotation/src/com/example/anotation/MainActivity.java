package com.example.anotation;

import java.lang.reflect.Method;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;


public class MainActivity extends Activity {

	Button button;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		button = (Button) findViewById(R.id.button);
		button.setOnClickListener(new View.OnClickListener() {
			
			@Override
			public void onClick(View v) {
				Class<?> clazz = DocumentClass.class;

				   // Kiểm tra xem class này có được gắn bởi Annotation FirstAnotation không.
			       boolean isUsingAnotation = clazz.isAnnotationPresent(FirstAnotation.class);
				   
			       if (isUsingAnotation) {
			           // Lấy ra annotation AnnHtmlUL gắn trên class này.
			    	   FirstAnotation annUL = clazz.getAnnotation(FirstAnotation.class);
			    	   Log.w("Anotation", "class anotation: " + annUL.name());
			       } else {
			    	   Log.w("Anotation", "class khong co anotation");
			       }
			       
			       Method[] methods = clazz.getMethods();
			       for (Method method : methods) {
			           // Kiểm tra xem method này có được gắn annotation FirstAnotation không?
			           if (method.isAnnotationPresent(FirstAnotation.class)) {
			               // Lấy ra annotation đó.
			        	   FirstAnotation annLI = method.getAnnotation(FirstAnotation.class);
			        	   Log.w("Anotation", "method anotation: " + annLI.name());
			           } else {
			        	   Log.w("Anotation", "method khong co anotation : " + method.getName());
			           }
			       }
			}
		});
		
	   
	}
	
}
