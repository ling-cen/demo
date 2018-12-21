package com.example.ui_basetest;

import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.SeekBar;
import android.widget.SeekBar.OnSeekBarChangeListener;
import android.widget.TextView;
import android.widget.TextView.OnEditorActionListener;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends Activity {
	private EditText editText;
	private RadioGroup rg_group;
	private RadioButton rb_man, rb_woman;
	private ToggleButton tb_show;
	private CheckBox isFish, isSour, isHot;
	private boolean fish, sour, hot;
	private SeekBar seek_money;
	private Button search_btn;
	private ImageView image_view;
	private OnRadioGroupCheckedChang radioCheckChangeListener;
	private CheckedOnChangeListener checkOnChangeListener;
	private OnSeekBarListenr seekbarListener;
	private onButtonClickListener buttonClickListener;
	private List<Foods> lists;
	private Persion persion;
	private int price = 30;
	private List<Foods> foodList;
	int count = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_foods);
		initView();
		initData();
		initListener();
	}

	private void initListener() {
		radioCheckChangeListener = new OnRadioGroupCheckedChang();
		checkOnChangeListener = new CheckedOnChangeListener();
		seekbarListener = new OnSeekBarListenr();
		buttonClickListener = new onButtonClickListener();

		// 查找
		search_btn.setOnClickListener(buttonClickListener);
		// 显示
		tb_show.setOnClickListener(buttonClickListener);

		// 性别
		rg_group.setOnCheckedChangeListener(radioCheckChangeListener);
		// 多选
		isFish.setOnCheckedChangeListener(checkOnChangeListener);
		isSour.setOnCheckedChangeListener(checkOnChangeListener);
		isHot.setOnCheckedChangeListener(checkOnChangeListener);
		// 预算
		seek_money.setOnSeekBarChangeListener(seekbarListener);
	}

	// 初始化数据
	private void initData() {
		lists = new ArrayList<Foods>();
		foodList = new ArrayList();
		// 辣的 海鲜 酸的
		/**
		 * name price drawable isHot isFish isSour
		 */
		lists.add(new Foods("红烧螃蟹", 20, R.drawable.timg_1, true, true, false));
		lists.add(new Foods("香酥排骨", 30, R.drawable.timg_2, true, false, false));
		lists.add(new Foods("毛血旺", 60, R.drawable.timg_5, true, false, false));
		//
		lists.add(new Foods("红烧鲫鱼", 70, R.drawable.timg_7, true, true, false));
		lists.add(new Foods("披萨", 50, R.drawable.timg_3, false, true, false));
		lists.add(new Foods("虾", 80, R.drawable.timg_7, false, true, false));
		// 酸的 辣的
		lists.add(new Foods("酸菜鱼", 90, R.drawable.timg_10, true, true, true));
	}

	// 初始化View
	private void initView() {
		persion = new Persion();
		// 名字
		editText = (EditText) findViewById(R.id.use_name);
		rg_group = (RadioGroup) findViewById(R.id.rg_sex);
		// 性别
		rb_man = (RadioButton) findViewById(R.id.rb_man);
		rb_woman = (RadioButton) findViewById(R.id.rb_woman);

		tb_show = (ToggleButton) findViewById(R.id.tb_show);
		// 口味
		isFish = (CheckBox) findViewById(R.id.isFish);
		isSour = (CheckBox) findViewById(R.id.isSour);
		isHot = (CheckBox) findViewById(R.id.isHot);

		seek_money = (SeekBar) findViewById(R.id.seek_money);
		search_btn = (Button) findViewById(R.id.search);
		image_view = (ImageView) findViewById(R.id.image_view);
	}

	// 监听性别选项
	class OnRadioGroupCheckedChang implements OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(RadioGroup group, int checkedId) {
			switch (checkedId) {
			case R.id.rb_man:
				persion.setSex("男");
//				Toast.makeText(MainActivity.this, "男：", 1000).show();
				break;
			case R.id.rb_woman:
				persion.setSex("女");
//				Toast.makeText(MainActivity.this, "女：", 1000).show();
				break;
			}

		}

	}

	// 监听喜好
	class CheckedOnChangeListener implements android.widget.CompoundButton.OnCheckedChangeListener {
		@Override
		public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
			CheckBox checkBox = (CheckBox) buttonView;
			switch (checkBox.getId()) {
			case R.id.isFish:
				// 判断是否选择
				
					fish = isChecked;
	
				break;
			case R.id.isHot:
	           hot=isChecked;
//				if (isChecked) {
//					hot = true;
//				} else {
//					hot = false;
//				}

				break;
			case R.id.isSour:
				//这里可以直接对其赋值;
				sour= isChecked;
				//不需要判断
//				if (isChecked) {
//					sour = true;
//				} else {
//					sour = false;
//				}
				break;
			}
			Toast.makeText(MainActivity.this, "辣：" + hot + "酸：" + sour + "海鲜：" + fish, 2000).show();

		}

	}

	// 监听用户选择的价格
	class OnSeekBarListenr implements OnSeekBarChangeListener {

		@Override
		public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
			// TODO Auto-generated method stub

		}

		@Override
		public void onStartTrackingTouch(SeekBar seekBar) {
			// TODO Auto-generated method stub
		}

		@Override
		public void onStopTrackingTouch(SeekBar seekBar) {
			// 获取用户预算价格
			price = seekBar.getProgress();
			Toast.makeText(MainActivity.this, "预算价格：" + price, 2000).show();
		}

	}

	// 获取下一菜品信息或显示信息
	class onButtonClickListener implements OnClickListener {
		@Override
		public void onClick(View v) {
			persion.setUsename(editText.getText().toString());
			switch (v.getId()) {
			case R.id.search:
				// 获取符合的的数据
				foodList.clear();
				count = 0;
				for (int i = 0; i < lists.size(); i++) {
					Foods food = (Foods) lists.get(i);
					if (food.getPrice() <= price
							&& (food.isFish() == fish && food.isHot() == hot && food.isSour() == sour)) {
						foodList.add(food);
					}
				}
				if (foodList.isEmpty()) {
					Toast.makeText(MainActivity.this, "没有找到符合的菜品信息", 2000).show();
					break;
				}
				//设置第一次显示的信息
				persion.setFood(foodList.get(count));
				image_view.setImageResource(foodList.get(count).getDrawable());
				System.out.println("**************************************");
				System.out.println("*"+foodList);
				break;
			case R.id.tb_show:
				if (tb_show.isChecked()) {
					System.out.println("*********************count:" + count);
					ShowPic(count);
				} else {
					//每次显示后加一
					count++;
					Toast.makeText(MainActivity.this, "显示：" + persion, 2000).show();
				}
				break;
			}
		}

		private void ShowPic(int counts) {
			if (counts < foodList.size()) {
				persion.setFood(foodList.get(counts));
				image_view.setImageResource(persion.getFood().getDrawable());
			} else {
				//当没有菜品时;将显示恢复为默认图片.这样用户体验会更好.
				image_view.setImageResource(R.color.beige);
				Toast.makeText(MainActivity.this, "没有更多菜品啦", 2000).show();
			}

		}

	}

}
