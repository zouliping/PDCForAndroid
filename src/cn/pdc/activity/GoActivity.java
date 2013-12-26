package cn.pdc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import cn.pdc.R;
import cn.pdc.utils.AppUtil;

public class GoActivity extends Activity {

	private String content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppUtil.setNotTitleScreen(GoActivity.this);
		setContentView(R.layout.activity_go);

		initData();
		AppUtil.shareToWeibo(GoActivity.this, content);
	}

	private void initData() {
		Intent intent = getIntent();
		if (null != intent) {
			Bundle bundle = getIntent().getExtras();
			content = bundle.getString(JPushInterface.EXTRA_ALERT);
		}
	}

}
