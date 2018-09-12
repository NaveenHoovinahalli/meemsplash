package com.meem.meemsplashscreen.activity;
import com.meem.meemsplashscreen.R;
import com.meem.meemsplashscreen.gdc11.MultisampleConfigChooser;
import com.meem.meemsplashscreen.renderer.SplashRender;
import com.meem.meemsplashscreen.view.SplashGLSurfaceView;

import android.app.Activity;
import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import android.opengl.GLSurfaceView;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;


public class SplashActivity extends Activity{


	SplashGLSurfaceView splashGLSurfaceView;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		getActionBar().hide();


		final ActivityManager activityManager = (ActivityManager) getSystemService(Context.ACTIVITY_SERVICE);
		final ConfigurationInfo configurationInfo = activityManager.getDeviceConfigurationInfo();
		final boolean supportsEs2 = configurationInfo.reqGlEsVersion >= 0x20000;

		callGl();

	}

//	public void callGl(View view){

	public void callGl(){

		splashGLSurfaceView = (SplashGLSurfaceView) findViewById(R.id.glview);
		splashGLSurfaceView.setVisibility(View.VISIBLE);
		splashGLSurfaceView.setEGLContextClientVersion(2);
		splashGLSurfaceView.setEGLContextFactory(new ContextFactory());
		splashGLSurfaceView.setEGLConfigChooser(new MultisampleConfigChooser());
		final SplashRender myRendrer=new SplashRender(this);

		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				splashGLSurfaceView.setRenderer(myRendrer);
			}
		});

	}

	public void callLayout() {

		runOnUiThread(new Runnable() {
			@Override
			public void run() {
				splashGLSurfaceView.setVisibility(View.GONE);

			}
		});
	}

	@Override
	protected void onResume() {
		super.onResume();
//		splashGLSurfaceView.onResume();
	}

	@Override
	protected void onPause() {
		super.onPause();
//		splashGLSurfaceView.onPause();
	}

	private class ContextFactory implements GLSurfaceView.EGLContextFactory
	{
		private int EGL_CONTEXT_CLIENT_VERSION = 0x3098;
		public EGLContext createContext( EGL10 egl, EGLDisplay display, EGLConfig eglConfig )
		{
			int[] attrib_list = { EGL_CONTEXT_CLIENT_VERSION, 2, EGL10.EGL_NONE };

			EGLContext context = egl.eglCreateContext(display, eglConfig,EGL10.EGL_NO_CONTEXT, attrib_list);
			return context;
		}

		public void destroyContext(EGL10 egl, EGLDisplay display, EGLContext context)
		{
			egl.eglDestroyContext( display, context );
		}
	}


}