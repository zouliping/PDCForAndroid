package cn.pdc.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import cn.jpush.android.api.JPushInterface;
import cn.pdc.R;
import cn.pdc.utils.AppUtil;
import cn.pdc.utils.Config;

public class GoActivity extends Activity {

	private String content;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppUtil.setNotTitleScreen(GoActivity.this);
		setContentView(R.layout.activity_go);

		initData();
		// open mechanism of android sharing
		// AppUtil.shareToWeibo(GoActivity.this, content);
		// open weiciyuan application and send content to weibo
		AppUtil.openActivity(GoActivity.this, Config.WEICIYUAN_PACKAGE_NAME,
				Config.WEICIYUAN_ACTIIVTY_NAME, content);
	}

	private void initData() {
		Intent intent = getIntent();
		if (null != intent) {
			Bundle bundle = getIntent().getExtras();
			content = bundle.getString(JPushInterface.EXTRA_ALERT);
		}
	}

}
