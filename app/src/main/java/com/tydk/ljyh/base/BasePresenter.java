package com.tydk.ljyh.base;

import android.app.Activity;

/**
 * 
 * <b>类名称：</b>BasePresenter<br/>
 * <b>类描述：</b>Presenter基类<br/>
 * <b>修改时间：</b>2015-12-22 下午4:38:12<br/>
 * @version 1.0.0<br/>
 */
public class BasePresenter<P extends IBaseView> {
	protected P mView;
    /**
     * TODO 这里用是否用Activity待考证
     */
    protected Activity mContext;
    
    public BasePresenter(Activity context, P view) {
        mContext = context;
        mView = view;
    }
    public BasePresenter(P view) {
        mView = view;
    }
}
