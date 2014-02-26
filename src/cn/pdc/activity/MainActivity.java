package cn.pdc.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;
import cn.jpush.android.api.InstrumentedActivity;
import cn.jpush.android.api.JPushInterface;
import cn.pdc.R;
import cn.pdc.utils.AppUtil;
import cn.pdc.utils.Util;

public class MainActivity extends InstrumentedActivity {

	private Context mContext = MainActivity.this;
	private ImageView iv_logout;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		AppUtil.setNotTitleScreen(MainActivity.this);
		setContentView(R.layout.main);
		initView();

		JPushInterface.setAlias(getApplicationContext(), Util.uid, null);
	}

	private void initView() {
		TextView mImei = (TextView) findViewById(R.id.tv_imei);
		String udid = JPushInterface.getUdid(getApplicationContext());
		if (null != udid)
			mImei.setText("IMEI: " + udid);

		TextView mAppKey = (TextView) findViewById(R.id.tv_appkey);
		String appKey = Util.getAppKey(getApplicationContext());
		if (null == appKey)
			appKey = "AppKey exception";
		mAppKey.setText("AppKey: " + appKey);

		String packageName = getPackageName();
		TextView mPackage = (TextView) findViewById(R.id.tv_package);
		mPackage.setText("PackageName: " + packageName);

		String versionName = Util.GetVersion(getApplicationContext());
		TextView mVersion = (TextView) findViewById(R.id.tv_version);
		mVersion.setText("Version: " + versionName);

		iv_logout = (ImageView) findViewById(R.id.logout_btn);
		iv_logout.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				SharedPreferences data = mContext.getSharedPreferences("data",
						0);
				Editor editor = data.edit();
				editor.clear();
				editor.commit();

				Intent i = new Intent(mContext, LoginActivity.class);
				startActivity(i);
			}
		});

	}
}