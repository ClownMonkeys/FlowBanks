/**
 * <b>项目名：</b>流量无忧<br/>
 * <b>包名：</b>com.tydk.ljyh.presenter<br/>
 * <b>文件名：</b>WelComePresenter.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016-3-3-下午5:45:53<br/>
 * <b>Copyright (c)</b> 2016深圳天源迪科信息技术股份有限公司-版权所有<br/>
 */
package com.tydk.ljyh.module.welcome.presenter;

import android.app.Activity;

import com.tydk.ljyh.base.BasePresenter;
import com.tydk.ljyh.module.welcome.view.IWelcomeView;


/**
 * <b>类名称：</b>WelComePresenter<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>qudapeng<br/>
 * <b>修改人：</b>qudapeng<br/>
 * <b>修改时间：</b>2016-3-3 下午5:45:53<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 */
public class WelComePresenter extends BasePresenter<IWelcomeView> {
	/**
	 * 创建一个新的实例 WelComePresenter
	 * 
	 * @param context
	 * @param view
	 */
	public WelComePresenter(Activity context, IWelcomeView view) {
		super(context, view);
	}

	public WelComePresenter(IWelcomeView view) {
		super(view);
	}
}
