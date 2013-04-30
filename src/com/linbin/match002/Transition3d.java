package com.linbin.match002;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.ImageView;

public class Transition3d extends Activity {

	private ViewGroup mContainer;
	private ImageView mImageView1;
	private ImageView mImageView2;
	private Button mLine;
	private static boolean isfirstenterchange = true;

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onResume()
	 */
	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		isfirstenterchange = true;
	}

	/*
	 * @see android.app.Activity#onCreate(android.os.Bundle)
	 */
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);

		// requestWindowFeature(Window.FEATURE_CUSTOM_TITLE);
		setContentView(R.layout.activity_main3);
		// getWindow().setFeatureInt(Window.FEATURE_CUSTOM_TITLE,R.layout.title);

		mImageView1 = (ImageView) findViewById(R.id.ImageView1);
		mImageView2 = (ImageView) findViewById(R.id.ImageView2);
		mContainer = (ViewGroup) findViewById(R.id.container);
		mLine = (Button) findViewById(R.id.line1);

		final float centerX = mContainer.getWidth();
		final float centerY = mContainer.getHeight();

		// Log.v("linbin", String.valueOf(centerX));
		// Log.v("linbin", String.valueOf(centerY));
		// mImageView1.setLayoutParams(new
		// ViewGroup.LayoutParams((int)centerX*2/5,(int)centerY*2/5));

		// mImageView2.setLayoutParams(new
		// ViewGroup.LayoutParams((int)centerX*2/5,(int)centerY*2/5));

		// mLine.setLayoutParams(new
		// ViewGroup.LayoutParams((int)centerX*1/5,(int)centerY*1/5));

		mImageView1.setClickable(true);
		mImageView1.setFocusable(true);

		mImageView2.setClickable(true);
		mImageView2.setFocusable(true);

		mContainer
				.setPersistentDrawingCache(ViewGroup.PERSISTENT_ANIMATION_CACHE);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see android.app.Activity#onStart()
	 */
	@Override
	protected void onStart() {
		// TODO Auto-generated method stub
		super.onStart();
	}

	private void applyRotation(int position, float start, float end) {
		// 计算中心点
		// final float centerX = mContainer.getWidth() / 2.0f;
		// final float centerY = mContainer.getHeight() / 2.0f;

		final float centerX = mImageView2.getWidth() / 2.0f;
		final float centerY = mImageView2.getHeight() / 2.0f;

		// Create a new 3D rotation with the supplied parameter
		// The animation listener is used to trigger the next animation

		final Rotate3dAnimation rotation = new Rotate3dAnimation(start, end,
				centerX, centerY, 310.0f, true);

		rotation.setDuration(1000);
		rotation.setFillAfter(true);
		rotation.setInterpolator(new AccelerateInterpolator());
		// 设置监听
		rotation.setAnimationListener(new DisplayNextView(position));

		// mContainer.startAnimation(rotation);

		if (position > -1) {
			mImageView1.startAnimation(rotation);
		} else {
			mImageView2.startAnimation(rotation);
		}

	}

	/**
	 * This class listens for the end of the first half of the animation. It
	 * then posts a new action that effectively swaps the views when the
	 * container is rotated 90 degrees and thus invisible.
	 */
	private final class DisplayNextView implements Animation.AnimationListener {
		private final int mPosition;

		private DisplayNextView(int position) {
			mPosition = position;
		}

		public void onAnimationStart(Animation animation) {
		}

		// 动画结束
		public void onAnimationEnd(Animation animation) {
			mContainer.post(new SwapViews(mPosition));
		}

		public void onAnimationRepeat(Animation animation) {
		}
	}

	private final class SwapViews implements Runnable {

		private final int mPosition;

		public SwapViews(int position) {
			mPosition = position;
		}

		public void run() {

			// final float centerX = mContainer.getWidth() / 2.0f;
			// final float centerY = mContainer.getHeight() / 2.0f;
			final float centerX = mImageView1.getWidth() / 2.0f;
			final float centerY = mImageView1.getHeight() / 2.0f;

			int iflags = (int) (Math.random() * 3);

			Rotate3dAnimation rotation;

			if (mPosition > -1) {

				// mPhotosList.setVisibility(View.GONE);
				// mImageView2.setVisibility(View.GONE);

				if (iflags == 1) {
					mImageView1.setBackgroundResource(R.drawable.quantou);
				} else if (iflags == 2) {
					mImageView1.setBackgroundResource(R.drawable.jiandao);
				} else {
					mImageView1.setBackgroundResource(R.drawable.shouxing);
				}

				mImageView1.setVisibility(View.VISIBLE);
				mImageView1.requestFocus();

				rotation = new Rotate3dAnimation(90, 180, centerX, centerY,
						310.0f, false);
			} else {

				// mImageView.setVisibility(View.GONE);
				// mPhotosList.setVisibility(View.VISIBLE);
				// mPhotosList.requestFocus();

				// mImageView1.setVisibility(View.GONE);

				if (iflags == 1) {
					mImageView2.setBackgroundResource(R.drawable.quantou);
				} else if (iflags == 2) {
					mImageView2.setBackgroundResource(R.drawable.jiandao);
				} else {
					mImageView2.setBackgroundResource(R.drawable.shouxing);
				}

				mImageView2.setVisibility(View.VISIBLE);
				mImageView2.requestFocus();

				rotation = new Rotate3dAnimation(90, 0, centerX, centerY,
						310.0f, false);
			}

			rotation.setDuration(1000);
			rotation.setFillAfter(true);
			rotation.setInterpolator(new DecelerateInterpolator());
			// 开始动画
			// mContainer.startAnimation(rotation);
			if (mPosition > -1) {
				mImageView1.startAnimation(rotation);
			} else {
				mImageView2.startAnimation(rotation);
			}
		}
	}

	public void onClick_fullscreen_button1(View view) {

		
		int iflags = (int) (Math.random() * 3);
		
		final float centerX = mImageView1.getWidth() / 2.0f;
		final float centerY = mImageView1.getHeight() / 2.0f;

		// Create a new 3D rotation with the supplied parameter
		// The animation listener is used to trigger the next animation

		final Rotate3dAnimation rotation = new Rotate3dAnimation(0, 90,
				centerX, centerY, 310.0f, true);
		

		if (isfirstenterchange) {
			rotation.setDuration(1000);
			rotation.setFillAfter(true);
			rotation.setAnimationListener(new AnimationListener() {
				@Override
				public void onAnimationEnd(Animation arg0) {
					mImageView1.setBackgroundResource(0);
					applyRotation(1, 90, 90);
				}

				@Override
				public void onAnimationRepeat(Animation animation) {
					// TODO Auto-generated method stub

				}

				@Override
				public void onAnimationStart(Animation animation) {
					// TODO Auto-generated method stub

				}
			});
			rotation.setInterpolator(new AccelerateInterpolator());
			mImageView1.startAnimation(rotation);
			
			isfirstenterchange=false;
			
		} else {

			
			if (iflags == 1) {
				// ((ImageView) view).setBackgroundResource(R.drawable.quantou);
				applyRotation(1, 180, 90);
			} else if (iflags == 2) {
				// ((Button) view).setText("剪刀");
				// ((ImageView) view).setBackgroundResource(R.drawable.jiandao);
				applyRotation(1, 180, 90);
			} else {
				// ((Button) view).setText("布");
				// ((ImageView)
				// view).setBackgroundResource(R.drawable.shouxing);
				applyRotation(1, 180, 90);
			}
		}

	}

	public void onClick_fullscreen_button2(View view) {

		int iflags = (int) (Math.random() * 3);

		if (iflags == 1) {
			// ((ImageView) view).setBackgroundResource(R.drawable.quantou);
			applyRotation(-1, 0, 90);
		} else if (iflags == 2) {
			// ((Button) view).setText("剪刀");
			// ((ImageView) view).setBackgroundResource(R.drawable.jiandao);
			applyRotation(-1, 0, 90);
		} else {
			// ((Button) view).setText("布");
			// ((ImageView) view).setBackgroundResource(R.drawable.shouxing);
			applyRotation(-1, 0, 90);
		}
	}
}
