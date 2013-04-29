package com.linbin.match002;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RotateAnimation extends Animation {
	
    /** 值为true时可明确查看动画的旋转方向。 */  
    public static final boolean DEBUG = false;  
    /** 沿Y轴正方向看，数值减1时动画逆时针旋转。 */  
    public static final boolean ROTATE_DECREASE = true;  
    /** 沿Y轴正方向看，数值减1时动画顺时针旋转。 */  
    public static final boolean ROTATE_INCREASE = false;  
    /** Z轴上最大深度。 */  
    public static final float DEPTH_Z = 310.0f;  
    /** 动画显示时长。 */  
    public static final long DURATION = 800l;  
    /** 图片翻转类型。 */  
    private final boolean type;  
    private final float centerX;  
    private final float centerY;  
    private Camera camera;  
    
    /** 用于监听动画进度。当值过半时需更新txtNumber的内容。 */  
    //private InterpolatedTimeListener listener;  
    private AnimationListener listener;
    
    
    public RotateAnimation(float cX, float cY, boolean type) {  
        centerX = cX;  
        centerY = cY;  
        this.type = type;  
        setDuration(DURATION);  
    }

	/* (non-Javadoc)
	 * @see android.view.animation.Animation#initialize(int, int, int, int)
	 */
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		// TODO Auto-generated method stub
		super.initialize(width, height, parentWidth, parentHeight);
		camera = new Camera();
		
	}

	/* (non-Javadoc)
	 * @see android.view.animation.Animation#setAnimationListener(android.view.animation.Animation.AnimationListener)
	 */
	@Override
	public void setAnimationListener(AnimationListener listener) {
		// TODO Auto-generated method stub
		super.setAnimationListener(listener);
	}

	/* (non-Javadoc)
	 * @see android.view.animation.Animation#applyTransformation(float, android.view.animation.Transformation)
	 */
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// TODO Auto-generated method stub
		if (listener!=null )
		{
			//listener.
		}
		
		super.applyTransformation(interpolatedTime, t);
	} 
	
	
    
    

}
