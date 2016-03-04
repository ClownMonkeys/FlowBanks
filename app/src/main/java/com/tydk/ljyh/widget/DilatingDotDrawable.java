/**
 * <b>项目名：</b>流量无忧<br/>
 * <b>包名：</b>com.tydk.ljyh.customview<br/>
 * <b>文件名：</b>DilatingDotDrawable.java<br/>
 * <b>版本信息：</b><br/>
 * <b>日期：</b>2016-3-3-下午5:17:14<br/>
 * <b>Copyright (c)</b> 2016深圳天源迪科信息技术股份有限公司-版权所有<br/>
 */
package com.tydk.ljyh.widget;

import android.annotation.SuppressLint;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;

/**
 * <b>类名称：</b>DilatingDotDrawable<br/>
 * <b>类描述：</b><br/>
 * <b>创建人：</b>qudapeng<br/>
 * <b>修改人：</b>qudapeng<br/>
 * <b>修改时间：</b>2016-3-3 下午5:17:14<br/>
 * <b>修改备注：</b><br/>
 * 
 * @version 1.0.0<br/>
 */
@SuppressLint("Override")
public class DilatingDotDrawable extends Drawable {

	private static final String TAG = DilatingDotDrawable.class.getSimpleName();
	private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
	private float radius;
	private float maxRadius;
	final Rect mDirtyBounds = new Rect(0, 0, 0, 0);

	public DilatingDotDrawable(final int color, final float radius,
			final float maxRadius) {
		mPaint.setColor(color);
		mPaint.setStyle(Paint.Style.FILL);
		mPaint.setStrokeCap(Paint.Cap.ROUND);
		mPaint.setStrokeJoin(Paint.Join.ROUND);

		this.radius = radius;
		setMaxRadius(maxRadius);
	}

	@Override
	public void draw(Canvas canvas) {
		final Rect bounds = getBounds();
		canvas.drawCircle(bounds.centerX(), bounds.centerY(), radius - 1,
				mPaint);
	}

	@Override
	public void setAlpha(int alpha) {
		if (alpha != mPaint.getAlpha()) {
			mPaint.setAlpha(alpha);
			invalidateSelf();
		}
	}

	@Override
	public void setColorFilter(ColorFilter colorFilter) {
		mPaint.setColorFilter(colorFilter);
		invalidateSelf();
	}

	@Override
	public int getOpacity() {
		return PixelFormat.TRANSLUCENT;
	}

	public void setColor(int color) {
		mPaint.setColor(color);
		invalidateSelf();
	}

	public void setRadius(float radius) {
		this.radius = radius;
		invalidateSelf();
	}

	public float getRadius() {
		return radius;
	}

	@Override
	public int getIntrinsicWidth() {
		return (int) (maxRadius * 2) + 2;
	}

	@Override
	public int getIntrinsicHeight() {
		return (int) (maxRadius * 2) + 2;
	}

	public void setMaxRadius(final float maxRadius) {
		this.maxRadius = maxRadius;
		mDirtyBounds.bottom = (int) (maxRadius * 2) + 2;
		mDirtyBounds.right = (int) (maxRadius * 2) + 2;
	}

	public Rect getDirtyBounds() {
		return mDirtyBounds;
	}

	@Override
	protected void onBoundsChange(final Rect bounds) {
		super.onBoundsChange(bounds);
		mDirtyBounds.offsetTo(bounds.left, bounds.top);
	}

}
