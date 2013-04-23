package com.linbin.match002;

import android.os.Bundle;
import android.app.Activity;
import android.graphics.Color;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
	
	//just test git version 20130423

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onClick_fullscreen_button1(View view) {

		int iflags = (int) (Math.random() * 3);
		Log.v("linbin", "begin to click buttion1");

		// Button button1View= (Button) findViewById(R.id.fullscreen_content_1);
		if (iflags == 1) {
			((Button) view).setText("石头");
		} else if (iflags == 2) {
			((Button) view).setText("剪刀");
		} else {
			((Button) view).setText("布");
		}

		//view.setBackgroundColor(Color.RED);

		// ((Button)view).setText("welcome");

	}

	public void onClick_fullscreen_button2(View view) {

		int iflags = (int) (Math.random() * 3);
		Log.v("linbin", "begin to click buttion1");

		if (iflags == 1) {
			((Button) view).setText("石头");
		} else if (iflags == 2) {
			((Button) view).setText("剪刀");
		} else {
			((Button) view).setText("布");
		}

		//view.setBackgroundColor(Color.RED);

	}

}
