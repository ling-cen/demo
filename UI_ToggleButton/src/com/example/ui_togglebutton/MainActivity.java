package com.example.ui_togglebutton;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private ToggleButton toggleBtn;
	private ImageView imageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.toggle_layout);
		toggleBtn = (ToggleButton)findViewById(R.id.toggle_btn);
		imageView = (ImageView)findViewById(R.id.toHappy);
		 toggleBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				if (toggleBtn.isChecked()) {
					imageView.setImageResource(R.drawable.happy);
					Log.i("开心", "开心");
					Toast.makeText(MainActivity.this, "开心", 2000).show();

				} else {
					imageView.setImageResource(R.drawable.unhappy);
					Toast.makeText(MainActivity.this, "不开心", 2000).show();

				}

			}

		});

	}
}
