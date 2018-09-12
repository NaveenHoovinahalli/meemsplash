package com.meem.meemsplashscreen.view;
import com.meem.meemsplashscreen.renderer.SplashRender;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

public class SplashGLSurfaceView extends GLSurfaceView {

	private SplashRender mRender;
	public SplashGLSurfaceView(Context context) {
		super(context);
	}

	public SplashGLSurfaceView(final Context context, AttributeSet attrs)
	{
		super(context, attrs);
	}


/*	public SplashGLSurfaceView(Context context) {
		super(context);
		setEGLContextClientVersion(2);
		mRender = new SplashRender();
		setRenderer(mRender);
	}*/
}
