package com.imooc.activity01;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

//创建MainActivity继承自Activity（Actiivty？界面）
//用户与应用程序进行交互的界面
public class MainActivity extends Activity {

	@Override
	//重写onCreate方法
	//当前界面创建时被系统调用
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		//设置内容视图
		//动态更改
		//findById 动态查询layout设置的id
		setContentView(R.layout.activity_main);
		/**
		 * 设置TextView   文本显示
		 * 
		 */
	}
	@Override
	//创建选择按钮
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	/*
	 * 操作系统通过 manifase.xml  查找相应的 activity 调用onCreate()方法中的setContent() 设置界面布局
	 * 
	 */

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}