package com.imooc.ui_button;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
	private Button button_1;
	private MyButtonListener myButtonListener;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		/**
		 * 实现监听器的4中方式
		 * 1:内部类
		 * 		1:为按钮添加监听器第一步：XML布局文件中添加<Button> 设置id
		 * 						第二步：在java代码中（需要先显示该控件的activity中）
		 * 					setContentView，装载Button所在的Xml布局
		 * 						第三步：通过Button的id获取Activty中获取Button的对象
		 * 						第四步：为button按钮添加监听事件
		 * 					    a.创建内部类并实现OnClickListener接口
		 *b.重写OnClick（）方法（当按钮点击后想要他干什么）
		 *c：生成内部类对象
		 *d：为按钮添加监听器对象
		 */
		super.onCreate(savedInstanceState);
		setContentView(R.layout.button_layout);
		button_1 = (Button)findViewById(R.id.button_1);
		myButtonListener = new MyButtonListener();
		button_1.setOnClickListener(myButtonListener);
		
	}

	class MyButtonListener implements OnClickListener{

		@Override
		public void onClick(View v) {
			Toast.makeText(MainActivity.this,"按钮被点击啦",Toast.LENGTH_SHORT).show();
			
		}
		
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

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
