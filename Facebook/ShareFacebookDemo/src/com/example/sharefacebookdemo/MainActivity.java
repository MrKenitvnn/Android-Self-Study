package com.example.sharefacebookdemo;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.FacebookSdk;
import com.facebook.share.Sharer;
import com.facebook.share.model.ShareLinkContent;
import com.facebook.share.widget.ShareDialog;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	
	private static CallbackManager callbackManager;
	Button buttonShareCustom;

	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

        FacebookSdk.sdkInitialize(this.getApplicationContext());
        FacebookSdk.setApplicationId("936889173084630");

		buttonShareCustom = (Button) findViewById(R.id.button_share);
		buttonShareCustom.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				shareYourContentOnFacebook();
			}
		});
		
	}

	
	private void shareYourContentOnFacebook() {

	    callbackManager = CallbackManager.Factory.create();
	    ShareDialog shareDialog = new ShareDialog(this);
	    shareDialog.registerCallback(callbackManager, new FacebookCallback<Sharer.Result>() {
	        @Override
	        public void onSuccess(Sharer.Result result) {
	            Log.d(this.getClass().getSimpleName(), "shared successfully");
	            //add your code to handle successful sharing
	            Toast.makeText(MainActivity.this, "share success", Toast.LENGTH_SHORT).show();
	        }

	        @Override
	        public void onCancel() {
	            Log.d(this.getClass().getSimpleName(), "sharing cancelled");
	            //add your code to handle cancelled sharing
	            Toast.makeText(MainActivity.this, "share cancel", Toast.LENGTH_SHORT).show();

	        }

	        @Override
	        public void onError(FacebookException error) {
	            Log.d(this.getClass().getSimpleName(), "sharing error");
	            //add your code to handle sharing error
	            Toast.makeText(MainActivity.this, "share error", Toast.LENGTH_SHORT).show();

	        }
	    });

	    if (ShareDialog.canShow(ShareLinkContent.class)) {
	        ShareLinkContent shareLinkContent = new ShareLinkContent.Builder()
	                .setContentTitle("Facebook")
	                .setContentDescription("facebook")
	                .setContentUrl(Uri.parse("https://facebook.com"))
	                .build();

	        shareDialog.show(shareLinkContent);
	    }

	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	  super.onActivityResult(requestCode, resultCode, data);
	  // TODO, if button share is inside fragment, copy this code to Fragment's onActivityResult() function.
	  callbackManager.onActivityResult(requestCode, resultCode, data);
	}
	
}
