package com.tydk.ljyh.module.welcome.ui;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.telephony.TelephonyManager;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.tydk.ljyh.R;
import com.tydk.ljyh.base.BaseActivity;
import com.tydk.ljyh.module.welcome.presenter.WelComePresenter;
import com.tydk.ljyh.module.welcome.view.IWelcomeView;
import com.tydk.ljyh.utils.PreferencesUtils;
import com.tydk.ljyh.utils.logutils.LogUtils;
import com.tydk.ljyh.widget.DilatingDotsProgressBar;

/**
* <b>类名称：</b>WelcomeActivity<br/>
* <b>类描述：</b>欢迎页<br/>
* <b>创建人：</b>qudapeng<br/>
* <b>修改人：</b>qudapeng<br/>
* <b>修改时间：</b>2016-1-8 下午1:27:07<br/>
* <b>修改备注：</b><br/>
* @version 1.0.0<br/>
*/

public class WelcomeActivity extends BaseActivity<WelComePresenter> implements IWelcomeView {
	private Context mContext;
	private ImageView welcome_image;
	private Animation myAnimation;
	private RelativeLayout welcome_relat;
	private DilatingDotsProgressBar mDilatingDotsProgressBar;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (isAppFirstLaunch()) {
			LogUtils.e("第一次启动");
		} else {
			LogUtils.e("不是第一次启动");
		}
	}
	
	@Override
	public void initView() {
		mContext = WelcomeActivity.this;
		welcome_image = (ImageView) findViewById(R.id.welcome_image);
		welcome_relat = (RelativeLayout) findViewById(R.id.welcome_relat);
		mDilatingDotsProgressBar = (DilatingDotsProgressBar) findViewById(R.id.progress);
        mDilatingDotsProgressBar.show(500);
		myAnimation = AnimationUtils.loadAnimation(this, R.anim.anim_alpha);
		welcome_relat.startAnimation(myAnimation);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
					TelephonyManager tm = (TelephonyManager) getSystemService(Context.TELEPHONY_SERVICE);
					String imsi=tm.getSubscriberId();
				}
		}, 3000);
	}

	private boolean isAppFirstLaunch() {
		if (PreferencesUtils.getBoolean(mContext, "FIRST")) {
			// 第一次
			PreferencesUtils.putBoolean(mContext, "FIRST", false);
			return true;
		} else {
			return false;
		}
	}

	@Override
	protected void initPresenter() {
		mPresenter=new WelComePresenter(this,this);
	}

	@Override
	protected int getLayoutId() {
		return R.layout.activity_welcome;
	}

	@Override
	protected void onClickView(View view) {
		
	}

	@Override
	public void showDialog(String message) {
		
	}

	@Override
	public void dismissDialog(String message) {
		
	}

	@Override
	public void showMessages(String message) {
		showToastMessage(message);
	}

	@Override
	public void successResultsControl(Object object) {
	}

	@Override
	public void failureresultsControl() {
	}
}
