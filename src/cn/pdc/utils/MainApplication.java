package cn.pdc.utils;

import android.app.Application;
import android.util.Log;
import cn.jpush.android.api.JPushInterface;

/**
 * For developer startup JPush SDK
 * 
 */
public class MainApplication extends Application {
	private static final String TAG = "MainApplication";

	@Override
	public void onCreate() {
		Log.d(TAG, "onCreate");
		super.onCreate();
		JPushInterface.setDebugMode(true); // set debug mode
		JPushInterface.init(this); // init JPush
	}
}
