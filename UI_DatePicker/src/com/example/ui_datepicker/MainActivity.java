package com.example.ui_datepicker;

import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.DatePicker;
import android.widget.DatePicker.OnDateChangedListener;
import android.widget.TimePicker;
import android.widget.TimePicker.OnTimeChangedListener;

public class MainActivity extends Activity {
	private TimePicker time_picker;
	private DatePicker date_picker;
	private int Year, Month, Day, Hour, Minute;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.date_picker);
		initView();
		getCurrentTime();
		setPicker();

	}

	private void initView() {
		time_picker = (TimePicker) findViewById(R.id.time_picker);
		date_picker = (DatePicker) findViewById(R.id.date_picker);

	}

	private void setPicker() {
		time_picker.setIs24HourView(true);
		// 设置当前时间
		time_picker.setCurrentHour(Hour);
		time_picker.setCurrentMinute(Minute);

		time_picker.setOnTimeChangedListener(new OnTimeChangedListener() {

			@Override
			public void onTimeChanged(TimePicker view, int hourOfDay, int minute) {
				// 当前时间选择器发生改变时,触发
				System.out.println("Forim TimePicker" + hourOfDay+"时"+ + minute+"分");

			}
		});

		date_picker.init(Year, Month, Day, new OnDateChangedListener() {

			@Override
			public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
				System.out.println("DatePicker:" + year + "/" + (monthOfYear + 1) + "/" + dayOfMonth);
			}

		});

	}

	// 获取时间
	private void getCurrentTime() {
		Calendar calendar = Calendar.getInstance();
		Year = calendar.get(Calendar.YEAR);
		Month = calendar.get(Calendar.MONTH);
		Day = calendar.get(Calendar.DAY_OF_MONTH);
		Hour = calendar.get(Calendar.HOUR);
		Minute = calendar.get(Calendar.MINUTE);
	}
	// 设置

}
