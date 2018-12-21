package com.imooc.ui_button;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class SixActivity extends Activity {
	private Button btn1;
	private Button btn2;

	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_layout);
		MyButtonListener myListener = new MyButtonListener();
		btn1= (Button) findViewById(R.id.button_1);
		btn2= (Button)findViewById(R.id.button_2);
		btn1.setOnClickListener(myListener);
		btn2.setOnClickListener(myListener);
		

	}

	class MyButtonListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.button_1:
				Toast.makeText(SixActivity.this, "点击了第一个按钮", Toast.LENGTH_SHORT).show();
				break;
			case R.id.button_2:
				Toast.makeText(SixActivity.this, "点击了第二个按钮", Toast.LENGTH_SHORT).show();
				break;

			}

		}

	}

}
