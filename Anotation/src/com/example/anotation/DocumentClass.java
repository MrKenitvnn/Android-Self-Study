package com.example.anotation;

import android.util.Log;

@FirstAnotation (name = "day la name cua class", value = "valuedasds", price = 200)
public class DocumentClass {

	@FirstAnotation (name = "day la name", price = 100)
	public void doSomething () {
		Log.d("Anotation", "print somethings");	
	}
	
	
	
}
