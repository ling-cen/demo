package com.example.ui_seekbar;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;

public class MainActivity extends Activity {
	private SeekBar seek_bar;
	

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.seekbar_layout);
		seek_bar = (SeekBar) findViewById(R.id.seek_bar);
		seek_bar.setMax(1000);
		seek_bar.setProgress(30);
		
		seek_bar.setOnSeekBarChangeListener(new OnSeekBarChangeListener() {

			@Override
			public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
				// 在进度条发现变化时触发
				Log.i("progress", "变化："+seekBar.getProgress());
			}

			@Override
			public void onStartTrackingTouch(SeekBar seekBar) {
				// TODO 将在进度条开始拖拽时触发
				Log.i("progress", "开始："+seekBar.getProgress());
				
			}

			@Override
			public void onStopTrackingTouch(SeekBar seekBar) {
				// TODO 将在进度条拖拽结束是触发
				Log.i("progress", "结束："+seekBar.getProgress());
				
			}
			
		});
	}
}
