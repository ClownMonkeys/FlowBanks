package com.tydk.ljyh.base;


/**
 * 
 * <b>类名称：</b>IBaseView<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>qudapeng<br/>
 * <b>修改时间：</b>2015-12-22 下午4:36:20<br/>
 * <b>修改备注：</b>所有项目View的基类<br/>
 * @version 1.0.0<br/>
 */
public interface IBaseView{
	/**
	 * 
	 * showDialog
	 * 显示进度Dialog
	 * @param message 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void  showDialog(String message);
	
	/**
	 * 
	 * dismissDialog
	 * 取消进度Dialog
	 * @param message 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void  dismissDialog(String message);
	
	/**
	 * 
	 * showMessages
	 * 显示信息
	 * @param message 
	 * void
	 * @exception 
	 * @since  1.0.0
	 */
	public void  showMessages(String message);
	
}
