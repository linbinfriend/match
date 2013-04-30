package com.linbin.match002;

import android.graphics.Camera;
import android.graphics.Matrix;
import android.view.animation.Animation;
import android.view.animation.Transformation;

public class Rotate3dAnimation extends Animation {

	// ��ʼ�Ƕ�
	private final float mFromDegrees;
	// �����Ƕ�
	private final float mToDegrees;
	// ���ĵ�
	private final float mCenterX;
	private final float mCenterY;
	//�ǳ�Z���򿴣����ǳ�-Z�����أ���opengl���ǳ�-Z���򿴣���������������ϵ��
	private final float mDepthZ;
	//�Ƿ���ҪŤ��  
    private final boolean mReverse; 
    
    //����ͷ  
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
		//�����м�Ƕ� , interpolated time �����
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
        
        //camera ����������ϵ,X�����ֻ���ˮƽ����Y�����ֻ�����ֱ����Z���Ǵ�ֱ���ֻ�������Ǹ�����
        //������ǳ�-Z���򿴵ģ�������۾�����Z�����ƶ�һ�㣬��ʾ����[XY��Z=0]��ƽ�档
        //camera.translate(0.0f, 0.0f, mDepthZ * interpolatedTime);
        
        
        //��X����תdegrees�ȡ�
        camera.rotateX(degrees);  
        //ȡ�ñ任��ľ���  
        camera.getMatrix(matrix);  
        camera.restore();  
 
        //����ת����ԭ��(0,0)���(-centerX, -centerY)
        matrix.preTranslate(-centerX, -centerY);   
        //���ԭ������״
        matrix.postTranslate(centerX, centerY);  
        
        
	}  
    
	
    

}
