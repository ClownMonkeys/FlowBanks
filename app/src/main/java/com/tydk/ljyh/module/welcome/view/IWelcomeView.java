/**
 * <b>项目名：</b>流量无忧<br/>
 * <b>包名：</b>com.tydk.ljyh.view<br/>
 * <b>文件名：</b>IWelcomeView.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016-3-3-下午5:46:49<br/>
 * <b>Copyright (c)</b> 2016深圳天源迪科信息技术股份有限公司-版权所有<br/>
*/
package com.tydk.ljyh.module.welcome.view;


import com.tydk.ljyh.base.IBaseView;

/**
 * <b>名称：</b>IWelcomeView<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>qudapeng<br/>
 * <b>修改人：</b>qudapeng<br/>
 * <b>修改时间：</b>2016-3-3 下午5:46:49<br/>
 * <b>修改备注：</b><br/>
 * @version 1.0.0<br/>
 */
public interface IWelcomeView extends IBaseView {
	/**
	 * 
	 * successResultsControl
	 * 成功<br/> 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void successResultsControl(Object object);
	
	/**
	 * 
	 * failureresultsControl
	 * 失败<br/> 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void failureresultsControl();
}
