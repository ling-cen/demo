package com.imooc.ui_checkbox;

import java.util.ArrayList;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.TextView;

public class MainActivity extends Activity {
	private CheckBox cb_game, cb_travel, cb_read;
	private Button btn_all, btn_notall, getLike;
	private TextView showLike;
	private CheckBoxListener listener;
	private ButtonClickListener btn_Listener;
	private ArrayList<String> list;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.checkbox_layout);
		this.initView();
		this.initListener();
		// 获取监听对象

		initData();

	}

	private void initData() {
		list = new ArrayList<String>();

	}

	private void initListener() {

		// 为按钮设置监听对象
		cb_game.setOnCheckedChangeListener(listener);
		cb_travel.setOnCheckedChangeListener(listener);
		cb_read.setOnCheckedChangeListener(listener);
		// 为按钮添加监听器
		btn_all.setOnClickListener(btn_Listener);
		btn_notall.setOnClickListener(btn_Listener);
		getLike.setOnClickListener(btn_Listener);
		showLike.setOnClickListener(btn_Listener);

	}

	protected void initView() {
		listener = new CheckBoxListener();
		btn_Listener = new ButtonClickListener();

		cb_game = (CheckBox) findViewById(R.id.cb_game);
		cb_travel = (CheckBox) findViewById(R.id.cb_travel);
		cb_read = (CheckBox) findViewById(R.id.cb_read);

		btn_all = (Button) findViewById(R.id.btn_all);
		btn_notall = (Button) findViewById(R.id.btn_notall);
		getLike = (Button) findViewById(R.id.getLike);
		showLike = (TextView) findViewById(R.id.showLike);
	}

	class CheckBoxListener implements OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			// 当选择发生变化时触发
			CheckBox checkBox = (CheckBox) buttonView;
			// 监听是否点击
			switch (checkBox.getId()) {
			case R.id.cb_game:
				if (cb_game.isChecked()) {
					Toast.makeText(MainActivity.this, "少玩游戏多写代码：", Toast.LENGTH_SHORT).show();
					cb_game.setTextColor(Color.RED);

				} else {
//					Toast.makeText(MainActivity.this, "电竞", Toast.LENGTH_SHORT).show();
					cb_game.setTextColor(Color.BLACK);
				}

				break;
			case R.id.cb_travel:
				Toast.makeText(MainActivity.this, "旅游" + isChecked, Toast.LENGTH_SHORT).show();
				break;
			case R.id.cb_read:
				Toast.makeText(MainActivity.this, "阅读" + isChecked, Toast.LENGTH_SHORT).show();
				break;
			}
		}
	}

	class ButtonClickListener implements OnClickListener {

		@Override
		public void onClick(View v) {
			switch (v.getId()) {
			case R.id.btn_all:
				cb_game.setChecked(true);
				cb_travel.setChecked(true);
				cb_read.setChecked(true);
				break;
			case R.id.btn_notall:
				cb_game.setChecked(false);
				cb_travel.setChecked(false);
				cb_read.setChecked(false);
				break;
			case R.id.getLike:

				list.clear();
				if (cb_game.isChecked()) {
					list.add(cb_game.getText().toString());
				}
				if (cb_travel.isChecked()) {
					list.add(cb_travel.getText().toString());
				}
				if (cb_read.isChecked()) {
					list.add(cb_read.getText().toString());
				}
				showLike.setText(list.toString());
				break;
			}

		}

	}
}
