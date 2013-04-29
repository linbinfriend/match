package com.linbin.match002;

import android.graphics.Camera;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class RotateAnimation extends Animation {
	
    /** ֵΪtrueʱ����ȷ�鿴��������ת���� */  
    public static final boolean DEBUG = false;  
    /** ��Y�������򿴣���ֵ��1ʱ������ʱ����ת�� */  
    public static final boolean ROTATE_DECREASE = true;  
    /** ��Y�������򿴣���ֵ��1ʱ����˳ʱ����ת�� */  
    public static final boolean ROTATE_INCREASE = false;  
    /** Z���������ȡ� */  
    public static final float DEPTH_Z = 310.0f;  
    /** ������ʾʱ���� */  
    public static final long DURATION = 800l;  
    /** ͼƬ��ת���͡� */  
    private final boolean type;  
    private final float centerX;  
    private final float centerY;  
    private Camera camera;  
    
    /** ���ڼ����������ȡ���ֵ����ʱ�����txtNumber�����ݡ� */  
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
