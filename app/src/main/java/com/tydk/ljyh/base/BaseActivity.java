package com.tydk.ljyh.base;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.Window;

import com.tydk.ljyh.utils.ToastUtils;
import com.tydk.ljyh.utils.logutils.LogUtils;

/**
 * <b>类名称：</b>BaseActivity<br/>
 * <b>类描述：</b>Activity基类<br/>
 * <b>创建人：</b>qudapeng<br/>
 * <b>修改人：</b>qudapeng<br/>
 * <b>修改时间：</b>2016-1-8 下午1:27:07<br/>
 * <b>修改备注：</b><br/>
 *
 * @version 1.0.0<br/>
 */

@SuppressWarnings("rawtypes")
public abstract class BaseActivity<P extends BasePresenter> extends FragmentActivity implements View.OnClickListener {
    protected Context mContext;
    protected Activity mActivity;
    protected P mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(this.getLayoutId());
        LogUtils.e("onCreate");
        mContext = getApplication();
        mActivity = this;
        //获取当前实例的类名
        LogUtils.e("BaseActivity:" + getClass().getSimpleName());
        this.initView();
        this.initPresenter();
        this.checkPresenterIsNull();
        ActivityCollector.addActivity(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        LogUtils.e("onRestart");
    }

    @Override
    protected void onStart() {
        super.onStart();
        LogUtils.e("onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        LogUtils.e("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        LogUtils.e("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        LogUtils.e("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.e("onDestroy");
        ActivityCollector.removeActivity(this);
    }

    protected abstract void initPresenter();

    protected abstract int getLayoutId();

    protected abstract void initView();

    protected abstract void onClickView(View view);

    private void checkPresenterIsNull() {
        if (mPresenter == null) {
            throw new IllegalStateException("please init mPresenter in initPresenter() method ");
        }
    }

    public void showToastMessage(String message) {
        ToastUtils.show(mContext, message);
    }

    /**
     * 通过Class跳转界面 *
     */
    protected void startActivity(Class<?> cls) {
        startActivity(cls, null);
    }

    /**
     * 通过Class跳转界面不需要返回 *
     */
    protected void startActivityFinish(Class<?> cls) {
        startActivity(cls, null);
        finish();
    }

    /**
     * 含有Bundle通过Class跳转界面 *
     */
    protected void startActivity(Class<?> cls, Bundle bundle) {
        Intent intent = new Intent();
        intent.setClass(mContext, cls);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    /**
     * 通过Action跳转界面 *
     */
    protected void startActivity(String action) {
        startActivity(action, null);
    }

    /**
     * 含有Bundle通过Action跳转界面 *
     */
    protected void startActivity(String action, Bundle bundle) {
        Intent intent = new Intent();
        intent.setAction(action);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {

    }
}
