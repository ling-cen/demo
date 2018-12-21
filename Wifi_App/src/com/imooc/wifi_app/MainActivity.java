package com.imooc.wifi_app;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private ToggleButton toggle_btn;
	private RadioGroup radio_group;
	private RadioButton office, meeting, visitor;

	private ImageView image_view;
	private TextView isTime;
	private LinearLayout linearLayout;
	int year, month, day, Hour, Minute;

	private ToggleButtonClickChangeListener listener;
	private RadioButtonListener radioListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_layout);
		initView();
		listener = new ToggleButtonClickChangeListener();
		radioListener = new RadioButtonListener();
		toggle_btn.setOnClickListener(listener);
		radio_group.setOnCheckedChangeListener(radioListener);
		getTime();

	}

	private void getTime() {
		// 获取系统时间
		Calendar calendar = Calendar.getInstance();
		year = calendar.get(Calendar.YEAR);
		day = calendar.get(Calendar.DAY_OF_MONTH);
		month = calendar.get(Calendar.MONTH);
		Hour = calendar.get(Calendar.HOUR_OF_DAY);
		Minute = calendar.get(Calendar.MINUTE);

	}

	private void initView() {
		linearLayout = (LinearLayout) findViewById(R.id.isVisible);
		toggle_btn = (ToggleButton) findViewById(R.id.wifi_off);
		radio_group = (RadioGroup) findViewById(R.id.radio_group);
		office = (RadioButton) findViewById(R.id.imooc_offoce);
		meeting = (RadioButton) findViewById(R.id.imooc_meeting);
		visitor = (RadioButton) findViewById(R.id.imooc_visitor);

		image_view = (ImageView) findViewById(R.id.image_view);
		isTime = (TextView) findViewById(R.id.is_time);
	}

	// 监听RadioButton
	class RadioButtonListener implements OnCheckedChangeListener {

		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			isTime.setVisibility(isTime.VISIBLE);
			isTime.setText("当前时间是:" + year + "年" + (month + 1) + "月" + (day) + "日" + "---" + (Hour) + ":" + Minute);
			switch (checkedId) {
			case R.id.imooc_offoce:
				image_view.setImageResource(R.drawable.office);
				image_view.setVisibility(image_view.VISIBLE);
				break;
			case R.id.imooc_visitor:
				image_view.setImageResource(R.drawable.visitor);
				image_view.setVisibility(image_view.VISIBLE);
				break;
			case R.id.imooc_meeting:
				image_view.setImageResource(R.drawable.meeting);
				image_view.setVisibility(image_view.VISIBLE);
				break;
			}

		}

	}

	// 监听ToggleButton
	class ToggleButtonClickChangeListener implements OnClickListener {
		@Override
		public void onClick(View v) {

			ToggleButton btn = (ToggleButton) v;
			// 打开局域网
			if (btn.isChecked()) {
				linearLayout.setVisibility(linearLayout.VISIBLE);
			} else {
				
				office.setChecked(false);
				meeting.setChecked(false);
				visitor.setChecked(false);
				
				linearLayout.setVisibility(linearLayout.GONE);
				image_view.setVisibility(image_view.GONE);
				isTime.setVisibility(isTime.GONE);
				Toast.makeText(MainActivity.this, "关闭了开关", 2000).show();

			}

		}

	}

}
