package com.linbin.match002;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {

	// 开始角度
	private final float mFromDegrees;
	// 结束角度
	private final float mToDegrees;
	// 中心点
	private final float mCenterX;
	private final float mCenterY;
	//是朝Z方向看，还是朝-Z方向看呢，在opengl中是朝-Z方向看，而且是左手坐标系。
	private final float mDepthZ;
	//是否需要扭曲  
    private final boolean mReverse; 
    
    //摄像头  
    private Camera mCamera; 
    
    public Rotate3dAnimation(float fromDegrees, float toDegrees,  
            float centerX, float centerY, float depthZ, boolean reverse) {  
        mFromDegrees = fromDegrees;  
        mToDegrees = toDegrees;  
        mCenterX = centerX;  
        mCenterY = centerY;  
        mDepthZ = depthZ;  
        mReverse = reverse;  
    }

	/* (non-Javadoc)
	 * @see android.view.animation.Animation#initialize(int, int, int, int)
	 */
	@Override
	public void initialize(int width, int height, int parentWidth,
			int parentHeight) {
		// TODO Auto-generated method stub
		super.initialize(width, height, parentWidth, parentHeight);
		mCamera = new Camera(); 
	}

	/* (non-Javadoc)
	 * @see android.view.animation.Animation#applyTransformation(float, android.view.animation.Transformation)
	 */
	@Override
	protected void applyTransformation(float interpolatedTime, Transformation t) {
		// TODO Auto-generated method stub
		//super.applyTransformation(interpolatedTime, t);
		
		final float fromDegrees = mFromDegrees; 
		//生成中间角度 , interpolated time 插入点
		float degrees = fromDegrees + ((mToDegrees - fromDegrees) * interpolatedTime);
		final float centerX = mCenterX;  
        final float centerY = mCenterY;  
        final Camera camera = mCamera; 
        
        final Matrix matrix = t.getMatrix();
        camera.save();
        
        if (mReverse) {  
        	camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);  
        } else {  
            camera.translate(0.0f, 0.0f, mDepthZ * (1.0f - interpolatedTime));  
        } 
        
        //camera 是左手坐标系,X轴是手机的水平方向，Y轴是手机的竖直方向，Z轴是垂直于手机向里的那个方向。
        //照相机是朝-Z方向看的，如果将眼睛往正Z方向移动一点，表示退向看[XY，Z=0]的平面。
        //camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
        
        
        //绕X轴旋转degrees度。
        camera.rotateX(degrees);  
        //取得变换后的矩阵  
        camera.getMatrix(matrix);  
        camera.restore();  
 
        //经过转换后，原来(0,0)变成(-centerX, -centerY)
        matrix.preTranslate(-centerX, -centerY);   
        //变成原来的形状
        matrix.postTranslate(centerX, centerY);  
        
        
	}  
    
	
    

}
