package com.tim.shadow.ball;

import android.app.Activity;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.MotionEvent;

public class MainActivity extends Activity {

	GLSurfaceView mGlSurfaceView;
	Ball mBall;
	private float mPreviousY;
	private float mPreviousX;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mGlSurfaceView = new GLSurfaceView(this);
		mGlSurfaceView.setEGLContextClientVersion(2);
		mBall = new Ball(this);
		mGlSurfaceView.setRenderer(mBall);
		setContentView(mGlSurfaceView);
	}

	@Override
	public boolean onTouchEvent(MotionEvent e) {
		float y = e.getY();
		float x = e.getX();
		switch (e.getAction()) {
		case MotionEvent.ACTION_MOVE:
			float dy = y - mPreviousY;// º∆À„¥•øÿ± YŒª“∆
			float dx = x - mPreviousX;// º∆À„¥•øÿ± XŒª“∆
			mBall.yAngle += dx * 0.3f;// …Ë÷√ÃÓ≥‰Õ÷‘≤»∆y÷·–˝◊™µƒΩ«∂»
			mBall.xAngle += dy * 0.3f;// …Ë÷√ÃÓ≥‰Õ÷‘≤»∆x÷·–˝◊™µƒΩ«∂»
		}
		mPreviousY = y;// º«¬º¥•øÿ± Œª÷√
		mPreviousX = x;// º«¬º¥•øÿ± Œª÷√
		return true;
	}

	@Override
	protected void onResume() {
		super.onResume();
		if (null != mGlSurfaceView) {
			mGlSurfaceView.onResume();
		}
	}

	@Override
	protected void onPause() {
		super.onPause();
		if (null != mGlSurfaceView) {
			mGlSurfaceView.onPause();
		}
	}

}
