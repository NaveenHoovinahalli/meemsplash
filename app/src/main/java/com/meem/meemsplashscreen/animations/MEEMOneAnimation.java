package com.meem.meemsplashscreen.animations;
import com.meem.meemsplashscreen.utils.Constants;

import android.opengl.Matrix;

public class MEEMOneAnimation {
	private DrawFullCylinder _drawFullCylinder;
	private DrawHalfCylinder _drawHalfCylinder;
	private Constants _const;
	private boolean _visibleRightCylinder = false;
	private boolean _drawEOneFlag = false;
	private float[] _mvpMLeftCylinder;
	private float[] _mvpMHalfCylinder;
	private float[] _mvpMRightCylinder;
	private float[] _mvpELeftCylinder;
	private float[] _mvpEHalfCylinder;
	private float[] _mvpERightCylinder;

	private float[] mvpForE;
	private float[] mvpForM;
	private float[] pForM;
	private float[] vForM;

	private float translateHalfCylender;
	private float translateLeftFullCylender;


	private boolean startMultipleME = false;
	private int rotateHalfCylinder;
	private float moveUpHalfCylender;
	private int speedM=10;
	private int speedM1=10;
	private int speedM2=10;
	private int speedM3=10;



	private int rotateFullCylender;
	private float translateRightFullCylinder;
	private float rotateMasE;
	private float translateE1WithRotate;
	private float translateM1WithERotate;

	private int wait1,wait2,wait3,wait4;
	private int waitFrames=9;
	private int waitFrames1=9;
	private int waitFrames2=8;
	private int waitFrames4=8;

	private float moveBackHalfCylender;
	private int rotateME;
	private float translateM2E2;
	private float translateM1E1;

	private boolean isMoneLight=false;
	private boolean isEoneLight=false;
	int mcount=0;
	int ecount=0;
	private boolean isMTwoLight=false;
	private boolean isETwoLight=false;
	int m2count=0;
	int e2count=0;
	private boolean isMeemLight;
	private final int lightWait=4;
	private float moveUpHalfCylender2;
	private int waitMEEM;
	private int waitMEEMFrames=18;
	private boolean setLight=false;



	public MEEMOneAnimation() {
		_drawFullCylinder = new DrawFullCylinder();
		_drawHalfCylinder = new DrawHalfCylinder();
		_const = new Constants();
	}

	public void CreateMOne(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {
		float[] mvpForFirstM = _mvpMatrix.clone();
		float[] mvpForFirstM1 = _mvpMatrix.clone();
		float[] mvpForFirstM2 = _mvpMatrix.clone();
		float[] mvpForFirstM3 = _mvpMatrix.clone();


		float[] mvpForE1=_mvpMatrix.clone();

		mvpForE = _mvpMatrix.clone();
		mvpForM = _mvpMatrix.clone();
		pForM = _projectionMatrix.clone();
		vForM = _viewMatrix.clone();
		if(wait2<waitFrames2) {
			translateLeftFullCylinder(mvpForFirstM1, _projectionMatrix, _viewMatrix);
			translateHalfCylinder(mvpForFirstM2, _projectionMatrix, _viewMatrix);
			translateRightFullCylinder(mvpForFirstM3, _projectionMatrix, _viewMatrix);
		}

		//rotate first half cylinder
		if(rotateHalfCylinder<180){
			rotateHalfCylinder=rotateHalfCylinder+speedM;
			translateLeftFullCylender=translateLeftFullCylender+(.0002014f*speedM);
			translateHalfCylender=translateHalfCylender+(.0002014f*speedM);
			if(rotateHalfCylinder>90)
				moveUpHalfCylender=moveUpHalfCylender+(0.0004305556f*2)*speedM;
		}else {
			_visibleRightCylinder=true;
			if(wait1>waitFrames1) {
				//rotate right full cylinder
				if (rotateFullCylender < 180) {
					rotateFullCylender = rotateFullCylender + (1 * speedM1);
					translateLeftFullCylender = translateLeftFullCylender + (.0002014f * speedM1);
					translateHalfCylender = translateHalfCylender - (.0002014f * speedM1);
					translateRightFullCylinder = translateRightFullCylinder + (.0002014f * speedM1);
					if(rotateFullCylender>90)
						moveUpHalfCylender2=moveUpHalfCylender2+(0.0004305556f*2)*speedM1;
				} else {
					if(wait2>waitFrames2) {
						//Create M1 E1
						CreateM1E1(mvpForE1, _projectionMatrix, _viewMatrix);
					}else {
						wait2++;
					}
				}
			}else {
				wait1++;
			}
		}
	}





	public boolean getAnimationStatus() {
		return startMultipleME;
	}


	void translateLeftFullCylinder(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {

		if (!_drawEOneFlag) {
			Matrix.translateM(_mvpMatrix, 0, translateLeftFullCylender, 0, 0);

			_mvpMLeftCylinder = _mvpMatrix.clone();
			_mvpELeftCylinder = _mvpMatrix.clone();
			_drawFullCylinder.drawFullCylinder(_mvpMatrix, _projectionMatrix, _viewMatrix, isETwoLight);
		}
	}




		void translateHalfCylinder(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {

		if (!_drawEOneFlag) {

			Matrix.rotateM(_mvpMatrix, 0, rotateHalfCylinder, 0, 0, 1);
			Matrix.translateM(_mvpMatrix, 0, translateHalfCylender, -moveUpHalfCylender, 0);
			_mvpMHalfCylinder = _mvpMatrix.clone();
			_mvpEHalfCylinder = _mvpMatrix.clone();
			_drawHalfCylinder.drawHalfCylinder(_mvpMatrix, _projectionMatrix, _viewMatrix, isETwoLight);


		}
	}

	void translateRightFullCylinder(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {


		if (!_drawEOneFlag) {
			if (_visibleRightCylinder) {
				Matrix.translateM(_mvpMatrix, 0, -.03625f, 0, 0);
				Matrix.translateM(_mvpMatrix, 0, -translateRightFullCylinder, 0, 0);
				Matrix.rotateM(_mvpMatrix, 0, (float) rotateFullCylender, 0, 0, 1);


				_drawHalfCylinder.drawHalfCylinder(_mvpMatrix, _projectionMatrix, _viewMatrix, isETwoLight);

				_mvpMRightCylinder = _mvpMatrix.clone();
				_mvpMRightCylinder = _mvpMatrix.clone();
				_mvpERightCylinder = _mvpMatrix.clone();
				Matrix.translateM(_mvpMRightCylinder, 0, 0, -(translateRightFullCylinder + translateRightFullCylinder), 0);
				_drawHalfCylinder.drawHalfCylinder(_mvpMRightCylinder, _projectionMatrix, _viewMatrix, isETwoLight);
			}

		}
	}


	private void CreateM1E1(float[] mvpForE, float[] projectionMatrix, float[] viewMatrix) {
	     float[] mvpForM1=mvpForE.clone();
		float[] mvpForE1=mvpForE.clone();
		float[] mvpForMirror=mvpForE.clone();


		if(rotateMasE<90){
			rotateMasE=rotateMasE+(.5f*speedM2);
			translateE1WithRotate=translateE1WithRotate+(.00006944f*speedM2);
			translateM1WithERotate=translateM1WithERotate+(.000736f*speedM2);
			moveBackHalfCylender=moveBackHalfCylender+(0.0004305556f*1)*speedM2;

		}

		if(wait3>waitFrames4) {
			if (rotateME < 180) {
				rotateME = rotateME + (1 * speedM3);
				translateM2E2 = translateM2E2 + (.001472f * speedM3);
				translateM1E1 = translateM1E1 + (.001472f * speedM3);
			} else {
				waitMEEM++;
			}

			if(waitMEEM> waitMEEMFrames) {
				setLight();
//				startMultipleME = true;
			}
//			}else if(waitMEEM>12) {
////				setLight();
//				setLight=true;
//
//			}
		}




			DrawM1(mvpForM1, projectionMatrix, viewMatrix);
			DrawE1FromMonM1(mvpForE1, projectionMatrix, viewMatrix);


		if(rotateMasE>=90) {
			if (wait3 > waitFrames) {
				DrawMirror(mvpForMirror, projectionMatrix, viewMatrix);
			} else {
				wait3++;
			}
		}
	}



	private void DrawM1(float[] _mvpMatrix, float[] _projectionMatrix,float[] _viewMatrix) {

		Matrix.translateM(_mvpMatrix, 0, translateM1E1, 0.0f, 0.0f);
		Matrix.translateM(_mvpMatrix, 0, translateM1WithERotate, 0.0f, 0.0f);


		float[] m1 = _mvpMatrix.clone();
		float[] temp1 = m1.clone();
		float[] temp2 = m1.clone();

		Matrix.translateM(m1, 0, 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(m1, _projectionMatrix, _viewMatrix, isMoneLight);

		_drawHalfCylinder.drawHalfCylinder(temp1, _projectionMatrix, _viewMatrix,isMoneLight);

		Matrix.translateM(temp2, 0, -0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(temp2, _projectionMatrix, _viewMatrix,isMoneLight);

	}

	private void DrawE1FromMonM1(float[] mvpForE1, float[] _projectionMatrix, float[] _viewMatrix) {

		Matrix.translateM(mvpForE1, 0, translateM1E1, 0.0f, 0.0f);
		Matrix.translateM(mvpForE1, 0,translateE1WithRotate,0, 0.0f);


		float[] temp2 = mvpForE1.clone();

		Matrix.translateM(temp2, 0,- 0.0725f, - 0.0725f, 0.0f);
		Matrix.rotateM(temp2, 0, rotateMasE, 0, 0, 1);
		_drawFullCylinder.drawFullCylinder(temp2, _projectionMatrix, _viewMatrix, isEoneLight, true);


		float[] m1 = temp2.clone();
		float[] temp1 = temp2.clone();


		Matrix.translateM(temp1, 0, 0.0725f, -moveBackHalfCylender + 0.0725f, 0.0f);
		_drawHalfCylinder.drawHalfCylinder(temp1, _projectionMatrix, _viewMatrix, isEoneLight);

		Matrix.translateM(m1, 0, 0.0725f+ 0.0725f, 0, 0.0f);
		_drawFullCylinder.drawFullCylinder(m1, _projectionMatrix, _viewMatrix, isEoneLight, true);

	}

	private void DrawMirror(float[] mvpForMirror, float[] _projectionMatrix, float[] _viewMatrix) {


		Matrix.translateM(mvpForMirror,0,-.265f,0,0);

		Matrix.translateM(mvpForMirror,0,translateM2E2,0,0);
		Matrix.rotateM(mvpForMirror,0,rotateME,0,1,0);
		float[] mvpMirror= mvpForMirror.clone();

		//M2
		float[] m1 =mvpForMirror.clone();
		Matrix.translateM(m1, 0,.3975f, 0.0f, 0.0f);
		float[] temp1 = m1.clone();
		float[] temp2 = m1.clone();

		Matrix.translateM(m1, 0, 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(m1, _projectionMatrix, _viewMatrix,isMTwoLight);
		_drawHalfCylinder.drawHalfCylinder(temp1, _projectionMatrix, _viewMatrix,isMTwoLight);
		Matrix.translateM(temp2, 0,- 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(temp2, _projectionMatrix, _viewMatrix,isMTwoLight);

		//E2
		float[] e1 = mvpMirror.clone();
		Matrix.translateM(e1, 0, .1326f, 0f, 0.0f);
		Matrix.rotateM(e1, 0, -90, 0, 0, 1);
		float[] temp11 = e1.clone();
		float[] temp21 = e1.clone();

		Matrix.translateM(e1, 0, 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(e1, _projectionMatrix, _viewMatrix,isETwoLight);
		_drawHalfCylinder.drawHalfCylinder(temp11, _projectionMatrix, _viewMatrix, isETwoLight);
		Matrix.translateM(temp21, 0,- 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(temp21, _projectionMatrix, _viewMatrix,isETwoLight);

	}

	private void setLight() {

			if(mcount<lightWait){
				mcount++;
				isMoneLight=true;
			}else if(ecount<lightWait){
				ecount++;
				isMoneLight=false;
				isEoneLight=true;
			}else if(e2count<lightWait){
				e2count++;
				isEoneLight=false;
				isETwoLight=true;
			}else if(m2count<lightWait) {
				m2count++;
				isETwoLight = false;
				isMTwoLight=true;
			}else if(isMTwoLight){
				isMTwoLight = false;
			}
//			else if(waitMEEM>waitMEEMFrames){
//				startMultipleME=true;
//			}
//			else
//				waitMEEM++;
		  else startMultipleME=true;

		}




	public void createMultipleME(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {


		float[] e1 = _mvpMatrix.clone();

		float[] temp1 = e1.clone();
		float[] temp2 = e1.clone();

		Matrix.translateM(e1, 0, 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(e1, _projectionMatrix, _viewMatrix, false);


		_drawHalfCylinder.drawHalfCylinder(temp1, _projectionMatrix, _viewMatrix, false);

		Matrix.translateM(temp2, 0, -0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(temp2, _projectionMatrix, _viewMatrix, false);

	}

	public void createMultipleME(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix,boolean lightNeeeded) {


		float[] e1 = _mvpMatrix.clone();

		float[] temp1 = e1.clone();
		float[] temp2 = e1.clone();

		Matrix.translateM(e1, 0, 0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(e1, _projectionMatrix, _viewMatrix, lightNeeeded);


		_drawHalfCylinder.drawHalfCylinder(temp1, _projectionMatrix, _viewMatrix, lightNeeeded);

		Matrix.translateM(temp2, 0, -0.0725f, 0.0f, 0.0f);
		_drawFullCylinder.drawFullCylinder(temp2, _projectionMatrix, _viewMatrix,lightNeeeded);

	}
}
