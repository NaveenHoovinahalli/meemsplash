package com.meem.meemsplashscreen.renderer;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import com.meem.meemsplashscreen.activity.SplashActivity;
import com.meem.meemsplashscreen.animations.DrawFullCylinder;
import com.meem.meemsplashscreen.animations.DrawHalfCylinder;
import com.meem.meemsplashscreen.animations.MEEMOneAnimation;
import com.meem.meemsplashscreen.animations.MultipleMEFour;
import com.meem.meemsplashscreen.animations.MultipleMEOne;
import com.meem.meemsplashscreen.animations.MultipleMEThree;
import com.meem.meemsplashscreen.animations.MultipleMEThreeTwo;
import com.meem.meemsplashscreen.animations.MultipleMETwo;
import com.meem.meemsplashscreen.animations.MultipleMETwoTwo;
import com.meem.meemsplashscreen.objects.DrawArc;
import com.meem.meemsplashscreen.objects.DrawBlackCircle;
import com.meem.meemsplashscreen.objects.DrawCircle;
import com.meem.meemsplashscreen.objects.DrawFullRect;
import com.meem.meemsplashscreen.objects.DrawHalfRect;
import com.meem.meemsplashscreen.utils.Constants;
import com.meem.meemsplashscreen.utils.FPSCounter;

import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.util.Log;

public class SplashRender implements GLSurfaceView.Renderer {

	private static String TAG = "MeemRenderer123";
	public static int MESpeed;
	private final float[] _mvpMatrix = new float[16];
	private final float[] _projectionMatrix = new float[16];
	private final float[] _viewMatrix = new float[16];
	private float[] _tempMatrix = new float[16];
	private DrawCircle _drawCircle;
	private Constants _const;
	private DrawFullCylinder _drawFullCylinder;
	private boolean _drawCircleOnce = true;
	boolean lightEffect = false;
	private MEEMOneAnimation _MEEMOneAnimation;
	private float setLookatY = 0;
	private float setLookatZ = -7.5f;
	public static boolean defaultcolor = true;
	boolean firstMeemStatus = false;
	private MultipleMETwo _multipleMETwo, multipleMETwoTwo, multipleMETwoThree;
	private MultipleMEFour _multipleMEFour;
	private MultipleMEThree _multipleMEThree, multipleMEThreeTwo, multipleMEThreeThree;
	private MultipleMEOne _multipleMEOne;
	private MultipleMETwoTwo multipleMETwoBak1, multipleMETwoBak2;
	private MultipleMEThreeTwo multipleMEThreeBak1, multipleMEThreeBak2;

	long startTime;
	public static boolean firstMeemLight;
	static float[] _dcolor = { 0, 0, 0, 1 };

	static float bgR = 0;
	static float bgG = 0;
	static float bgB = 0;
	static float meR = 114f;
	static float meG = 171f;
	static float meB = 35f;
	private float setLookZ = 2.8f;
	float ratio;
	private long endFrameTime;
	private long startFrameTime;
	private DrawHalfCylinder _drawHalfCylinder;
	int wait = 0;
	private float rotateM1;
	private float translateM1;
	FPSCounter fpsCounter;
	int frames = 0;
	boolean changeBagroundColor = false;
	boolean logOnce = true;
	public static int mobileSpeed = 1;
	private float frustMTop = 1;
	private float zoom1;
	private float centerY = 0;
	private float adjustTheHeight = 0;
	private SplashActivity splashActivity;
	DrawBlackCircle drawBlackCircle;
	float translateCircles = 0;
	int translateCircleSpeed = 7;
	float translateTopNBottomArcofCylenter = 0;
	private DrawArc _drawArc;
	private float translateCircles2;
	private boolean startMAnimation = false;
	private int waitframes = 9;
	private float zoomSpeed = 1f;

	private boolean calloutCallbackCalled = false;
	private boolean endCallBackCalled = false;
	private boolean startAnimationCallbackCalled = false;

	public SplashRender(SplashActivity splashActivity) {

		this.splashActivity = splashActivity;
		fpsCounter = new FPSCounter();

		defaultcolor = true;
		bgR = 0;
		bgG = 0;
		bgB = 0;
		meR = 114f;
		meG = 171f;
		meB = 35f;

	}

	@Override
	public void onSurfaceCreated(GL10 gl, EGLConfig config) {

		GLES20.glClearColor(0.0f, 0.0f, 0.0f, 1.f);
		startTime = System.currentTimeMillis();
		startFrameTime = System.nanoTime();
		_drawCircle = new DrawCircle();
		_drawFullCylinder = new DrawFullCylinder();
		_const = new Constants();
		_MEEMOneAnimation = new MEEMOneAnimation();
		_multipleMEOne = new MultipleMEOne();
		_multipleMETwo = new MultipleMETwo();
		_multipleMEThree = new MultipleMEThree();
		_multipleMEFour = new MultipleMEFour();
		multipleMETwoThree = new MultipleMETwo();
		multipleMETwoTwo = new MultipleMETwo();
		multipleMEThreeTwo = new MultipleMEThree();
		multipleMEThreeThree = new MultipleMEThree();
		MESpeed = 18;
		_drawHalfCylinder = new DrawHalfCylinder();
		drawBlackCircle = new DrawBlackCircle();
		_drawArc = new DrawArc();
		multipleMEThreeBak1 = new MultipleMEThreeTwo();
		multipleMEThreeBak2 = new MultipleMEThreeTwo();
		multipleMETwoBak1 = new MultipleMETwoTwo();
		multipleMETwoBak2 = new MultipleMETwoTwo();

		GLES20.glEnable(GLES20.GL_BLEND);
		GLES20.glUniform4f(DrawFullRect._lightAmbientHandle, 1.0f, 1.0f, 1.0f, 1.0f);
		GLES20.glUniform4f(DrawFullRect._lightDiffuseHandle, 0.0f, 0.0f, 0.0f, 1.0f);
		GLES20.glUniform4f(DrawFullRect._lightSpecularHandle, 0.0f, 0.0f, 0.0f, 1.0f);

		GLES20.glUniform4f(DrawHalfRect._lightAmbientHandle, 1.0f, 1.0f, 1.0f, 1.0f);
		GLES20.glUniform4f(DrawHalfRect._lightDiffuseHandle, 0.0f, 0.0f, 0.0f, 1.0f);
		GLES20.glUniform4f(DrawHalfRect._lightSpecularHandle, 0.0f, 0.0f, 0.0f, 1.0f);

		GLES20.glUniform4f(DrawArc._lightAmbientHandle, 1.0f, 1.0f, 1.0f, 1.0f);
		GLES20.glUniform4f(DrawArc._lightDiffuseHandle, 0.0f, 0.0f, 0.0f, 1.0f);
		GLES20.glUniform4f(DrawArc._lightSpecularHandle, 0.0f, 0.0f, 0.0f, 1.0f);
	}

	@Override
	public void onSurfaceChanged(GL10 gl, int width, int height) {

		GLES20.glViewport(0, 0, width, height);
		ratio = (float) width / height;
		_const.setMEGap(ratio);

		Log.d("widthheight", +width + "--" + height);
		//		if(ratio>.67)
		//			zoom1=-6.5f;
		//		else if(ratio==0.62992126f)
		//			zoom1=-7;
		//		else if(ratio >= 0.6f)
		//			zoom1 = -6.9f;
		//		else
		//			zoom1 = -7.5f;

		if (ratio > .67)
			zoom1 = -6.5f;
		else if (ratio == 0.62992126f)
			zoom1 = -7;
		else if (ratio >= 0.6f)
			zoom1 = -6.9f;
		else
			zoom1 = -7.5f;

		Matrix.frustumM(_projectionMatrix, 0, -ratio, ratio, -1, frustMTop, setLookZ, 8);

	}

	@Override
	public void onDrawFrame(GL10 gl) {
		drawFrame(gl);
	}

	private void drawFrame(GL10 gl) {

		if (!startAnimationCallbackCalled) {
			startAnimationCallbackCalled = true;
//			splashActivity.onSplashAnimationStarted();
		}

		if (changeBagroundColor) {
			if (meR > 95)
				meR = meR - .5f;
			else
				meR = 95;
			if (meG > 100)
				meG = meG - 2.4f;
			else
				meG = 100;
			if (meB < 106)
				meB = meB + 2.4f;
			else
				meB = 106;
			if (bgR < 71)
				bgR = bgR + 3.3f;
			else
				bgR = 71;
			if (bgG < 77)
				bgG = bgG + 3.4f;
			else
				bgG = 77;
			if (bgB < 82)
				bgB = bgB + 3.6f;
			else
				bgB = 82;
			GLES20.glClearColor(convertColor(bgR), convertColor(bgG), convertColor(bgB), 1.0f);
		} else {
			GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
		}

		GLES20.glClear(GLES20.GL_DEPTH_BUFFER_BIT | GLES20.GL_COLOR_BUFFER_BIT);
		Matrix.setLookAtM(_viewMatrix, 0, 0, setLookatY, setLookatZ, 0f, centerY, 0f, 0f, 1, 0.0f);
		Matrix.setIdentityM(_mvpMatrix, 0);
		Matrix.multiplyMM(_mvpMatrix, 0, _projectionMatrix, 0, _viewMatrix, 0);
		//		Matrix.translateM(_mvpMatrix,0,0,adjustTheHeight,0);

		float[] centercylender = _mvpMatrix.clone();
		float[] defaultME = _mvpMatrix.clone();

		if (!startMAnimation) {
			createFirstCylinder(centercylender, _projectionMatrix, _viewMatrix);

		} else {
			if (!firstMeemStatus) {
				long l = System.currentTimeMillis() - startTime;
				Log.d("Total time", "0" + l + "--" + ratio);
				setLookatZ = -3.5f;
				//main
				_MEEMOneAnimation.CreateMOne(_mvpMatrix, _projectionMatrix, _viewMatrix);
				if (rotateM1 < 90) {
					rotateM1 = rotateM1 + .25f;
					translateM1 = translateM1 + .0005275f;
				}
			}
		}

		if (_MEEMOneAnimation.getAnimationStatus()) {
			firstMeemStatus = true;
			if (firstMeemStatus) {

				float[] _tempOne = _tempMatrix.clone();
				float[] _tempTwo = _tempMatrix.clone();
				float[] _tempThree = _tempMatrix.clone();
				float[] _tempFour = _tempMatrix.clone();
				float[] _tempFive = _tempMatrix.clone();
				float[] _tempSix = _tempMatrix.clone();
				float[] _tempSeven = _tempMatrix.clone();
				float[] _tempEight = _tempMatrix.clone();

				//First 4 MEME
				Matrix.setIdentityM(_tempOne, 0);
				Matrix.multiplyMM(_tempOne, 0, _projectionMatrix, 0, _viewMatrix, 0);
				Matrix.translateM(_tempOne, 0, 0.3975f + .00125f + .00125f + (_const.EXTRA_SPACE_EXTRA_WIDTH * 2),
						adjustTheHeight, 0.0f);
				_multipleMEOne.createMultipleMEfromMTwo(_tempOne, _projectionMatrix, _viewMatrix);

				Matrix.setIdentityM(_tempTwo, 0);
				Matrix.multiplyMM(_tempTwo, 0, _projectionMatrix, 0, _viewMatrix, 0);
				Matrix.translateM(_tempTwo, 0, 0.1325f + .00125f + (_const.EXTRA_SPACE_EXTRA_WIDTH * 1) / 2, adjustTheHeight,
						0.0f);
				_multipleMETwo.createMultipleMEfromEone(_tempTwo, _projectionMatrix, _viewMatrix);

				Matrix.setIdentityM(_tempThree, 0);
				Matrix.multiplyMM(_tempThree, 0, _projectionMatrix, 0, _viewMatrix, 0);
				Matrix.translateM(_tempThree, 0, -0.1325f - (_const.EXTRA_SPACE_EXTRA_WIDTH * 1) / 2, adjustTheHeight, 0.0f);
				_multipleMEThree.createMultipleMEfromMTwo(_tempThree, _projectionMatrix, _viewMatrix);

				Matrix.setIdentityM(_tempFour, 0);
				Matrix.multiplyMM(_tempFour, 0, _projectionMatrix, 0, _viewMatrix, 0);
				Matrix.translateM(_tempFour, 0, -.3975f - .00125f - (_const.EXTRA_SPACE_EXTRA_WIDTH * 2), adjustTheHeight, 0.0f);
				_multipleMEFour.createMultipleMEfromEone(_tempFour, _projectionMatrix, _viewMatrix);

				//hidden ME
				if (_multipleMEOne.RotationCompleted3) {
					changeBagroundColor = true;
					//L-side
					Matrix.setIdentityM(_tempFive, 0);
					Matrix.multiplyMM(_tempFive, 0, _projectionMatrix, 0, _viewMatrix, 0);
					Matrix.translateM(_tempFive, 0, (.265f * 4) + .1325f + (_const.EXTRA_SPACE_EXTRA_WIDTH * 4),
							adjustTheHeight, 0);
					//					multipleMETwoTwo.createMultipleMEfromEone(_tempFive, _projectionMatrix, _viewMatrix);
					multipleMETwoBak1.createMultipleMEfromEone(_tempFive, _projectionMatrix, _viewMatrix);

					if (_multipleMEOne.RotationCompleted4) {
						Matrix.setIdentityM(_tempSix, 0);
						Matrix.multiplyMM(_tempSix, 0, _projectionMatrix, 0, _viewMatrix, 0);
						Matrix.translateM(_tempSix, 0, (.265f * 5) + .1325f + (_const.EXTRA_SPACE_EXTRA_WIDTH * 5),
								adjustTheHeight, 0);
						//						multipleMEThreeThree.createMultipleMEfromMTwo(_tempSix, _projectionMatrix, _viewMatrix);
						multipleMEThreeBak1.createMultipleMEfromMTwo(_tempSix, _projectionMatrix, _viewMatrix);
						if (multipleMEThreeBak1.RotationCompleted8 && !calloutCallbackCalled) {
							calloutCallbackCalled = true;
//							splashActivity.callLayout();
						}
						if (multipleMEThreeBak1.RotationCompleted9 && !endCallBackCalled) {
							endCallBackCalled = true;
//							splashActivity.onSplashAnimationFinished();
						}
					}

					//R-Side
					Matrix.setIdentityM(_tempSeven, 0);
					Matrix.multiplyMM(_tempSeven, 0, _projectionMatrix, 0, _viewMatrix, 0);
					Matrix.translateM(_tempSeven, 0, -(.265f * 4) - .1325f + .00125f - (_const.EXTRA_SPACE_EXTRA_WIDTH * 4),
							adjustTheHeight, 0);
					//					multipleMEThreeTwo.createMultipleMEfromMTwo(_tempSeven, _projectionMatrix, _viewMatrix);
					multipleMEThreeBak2.createMultipleMEfromMTwo(_tempSeven, _projectionMatrix, _viewMatrix);

					if (_multipleMEOne.RotationCompleted4) {
						Matrix.setIdentityM(_tempEight, 0);
						Matrix.multiplyMM(_tempEight, 0, _projectionMatrix, 0, _viewMatrix, 0);
						Matrix.translateM(_tempEight, 0,
								-(.265f * 5) - .1325f + .00125f - (_const.EXTRA_SPACE_EXTRA_WIDTH * 5), adjustTheHeight, 0);
						//						multipleMETwoThree.createMultipleMEfromEone(_tempEight, _projectionMatrix, _viewMatrix);
						multipleMETwoBak2.createMultipleMEfromEone(_tempEight, _projectionMatrix, _viewMatrix);

					}
				}

				//				if(_multipleMEOne.startZoomingOut){
				if (true) {
					//					changeBagroundColor=true;
					colorShadingME();

					if (setLookatZ > zoom1) {
						setLookatZ = setLookatZ - (0.1f * zoomSpeed);
						defaultcolor = false;
						MESpeed = MESpeed + 1;

					} else {
						//						setLookatZ=zoom1-.1f;
					}
				}

				if (ratio < .59 && adjustTheHeight < .20f)
					adjustTheHeight = adjustTheHeight + .01f;

				else if (ratio > .66f && adjustTheHeight > -.15f)
					adjustTheHeight = adjustTheHeight - .01f;

			}
		}
	}

	private void createFirstCylinder(float[] centercylender, float[] projectionMatrix, float[] viewMatrix) {

		float[] cylenderMVP = centercylender.clone();
		float[] temp1 = centercylender.clone();
		float[] circleMVP = centercylender.clone();

		float[] circleLeftMVP = centercylender.clone();
		float[] circleRiteMVP = centercylender.clone();
		float[] circleTopMVP = centercylender.clone();
		float[] circleBottomMVP = centercylender.clone();
		Matrix.translateM(temp1, 0, .3f, 0, 0);
		_drawFullCylinder.drawFullCylinder(temp1, _projectionMatrix, _viewMatrix, false);

		if (translateCircles < .1) {
			translateCircles = translateCircles + (.001f * translateCircleSpeed);
			translateCircles2 = translateCircles2 + (.0001f * translateCircleSpeed);
			setLookatZ = setLookatZ + (.04f * translateCircleSpeed);
			translateTopNBottomArcofCylenter = translateTopNBottomArcofCylenter + (.000825f * translateCircleSpeed);
		} else if (translateCircles2 < .05) {
			translateCircles = translateCircles + (.01f * translateCircleSpeed);
			translateCircles2 = translateCircles2 + (.001f * translateCircleSpeed);
			setLookatZ = -3.5f;
			//			setLookatZ = setLookatZ + .04f;

		} else if (wait < waitframes)
			wait++;
		else
			startMAnimation = true;

		_drawFullCylinder.drawFullCylinder(cylenderMVP, _projectionMatrix, _viewMatrix, false, false,
				translateTopNBottomArcofCylenter);

		Matrix.translateM(circleLeftMVP, 0, translateCircles2 + .17725f, 0, 0);
		drawBlackCircle.draw(circleLeftMVP, false);

		Matrix.translateM(circleRiteMVP, 0, -translateCircles2 - .17725f, 0, 0);
		drawBlackCircle.draw(circleRiteMVP, false);

		Matrix.translateM(circleTopMVP, 0, 0, translateCircles + .14225f + .018f, 0);
		drawBlackCircle.draw(circleTopMVP, false);

		Matrix.translateM(circleBottomMVP, 0, 0, -translateCircles - .14225f - .018f, 0);
		drawBlackCircle.draw(circleBottomMVP, false);

		float[] mvpm2 = cylenderMVP.clone();
		Matrix.translateM(mvpm2, 0, 0, translateTopNBottomArcofCylenter - .01f, 0.0f);
		_drawArc.draw(mvpm2, false);

		float[] mvpm3 = cylenderMVP.clone();
		Matrix.translateM(mvpm3, 0, 0, -translateTopNBottomArcofCylenter + .01f, 0.0f);
		Matrix.rotateM(mvpm3, 0, 180, 0, 0, 1);
		_drawArc.draw(mvpm3, false);

		//circle
		if (setLookatZ < -6.3)
			_drawArc.draw(circleMVP, false);

	}

	public static boolean getDefaultColor() {

		return defaultcolor;
	}

	public static int getMESpeed() {

		return MESpeed;
	}

	public static float convertColor(float color) {

		float value = color / 255;
		return value;
	}

	public static float[] colorShadingME() {

		_dcolor = new float[] { convertColor(meR), convertColor(meG), convertColor(meB), 1.0f };

		return _dcolor;
	}

	public static float[] getDefaultColorforME() {

		return _dcolor;
	}

	public static int loadShader(int type, String vertexShaderCode) {

		int shader = GLES20.glCreateShader(type);
		GLES20.glShaderSource(shader, vertexShaderCode);
		GLES20.glCompileShader(shader);
		return shader;
	}

	public static void checkGlError(String glOperation) {

		int error;
		while ((error = GLES20.glGetError()) != GLES20.GL_NO_ERROR) {
			Log.e(TAG, glOperation + ": glError " + error);
			throw new RuntimeException(glOperation + ": glError " + error);
		}
	}

}
