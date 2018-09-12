package com.meem.meemsplashscreen.animations;
import com.meem.meemsplashscreen.objects.DrawArc;
import com.meem.meemsplashscreen.objects.DrawFullRect;
import android.opengl.Matrix;

public class DrawFullCylinder {

	DrawFullRect _drawFullRect;
	DrawArc _drawArc;
	private float[] _tempMatrix;
	
	public DrawFullCylinder(){
		
		_drawFullRect = new DrawFullRect();
		_drawArc = new DrawArc();
	}
	
	public void drawFullCylinder(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix, boolean isEoneLight)
	{
		createFullCylinder(_mvpMatrix,isEoneLight);
	}

	private void createFullCylinder(float[] _mvpMatrix, boolean isEoneLight) {
//  bottom circle as main rotation point
//		_tempMatrix = _mvpMatrix.clone();
//
//		float[] mvpm1 = _tempMatrix.clone();
//		Matrix.translateM(mvpm1, 0, 0,.0725f, 0.0f);
//		_drawFullRect.draw(mvpm1,isEoneLight);
//
//		float[] mvpm2 = _tempMatrix.clone();
//		Matrix.translateM(mvpm2, 0, 0, 0.0725f+.0725f, 0.0f);
//		_drawArc.draw(mvpm2, isEoneLight);
//
//		float[] mvpm3 = _tempMatrix.clone();
//		_drawArc.draw(mvpm3, isEoneLight);


		//center as a main rotation point

		_tempMatrix = _mvpMatrix.clone();

		float[] mvpm1 = _tempMatrix.clone();
		_drawFullRect.draw(mvpm1,isEoneLight);

		float[] mvpm2 = _tempMatrix.clone();
		Matrix.translateM(mvpm2, 0, 0, 0.07375f, 0.0f);
		_drawArc.draw(mvpm2,isEoneLight);

		float[] mvpm3 = _tempMatrix.clone();
		Matrix.translateM(mvpm3, 0, 0, -0.0725f, 0.0f);
		_drawArc.draw(mvpm3, isEoneLight);
	}

	public void drawFullCylinder(float[] m1, float[] projectionMatrix, float[] viewMatrix, boolean isEoneLight, boolean b) {

		if(b) {
			//bottom as center
			_tempMatrix = m1.clone();
			float[] mvpm1 = _tempMatrix.clone();
			Matrix.translateM(mvpm1, 0, 0, .0725f, 0.0f);
			_drawFullRect.draw(mvpm1, isEoneLight);

			float[] mvpm2 = _tempMatrix.clone();
			Matrix.translateM(mvpm2, 0, 0, 0.0725f + .0725f, 0.0f);
			_drawArc.draw(mvpm2, isEoneLight);

			float[] mvpm3 = _tempMatrix.clone();
			_drawArc.draw(mvpm3, isEoneLight);
		}else {
			//top as center
			_tempMatrix = m1.clone();
			float[] mvpm1 = _tempMatrix.clone();
			Matrix.translateM(mvpm1, 0, 0,.0725f, 0.0f);
			_drawFullRect.draw(mvpm1,isEoneLight);

			float[] mvpm2 = _tempMatrix.clone();
			Matrix.translateM(mvpm2, 0, 0, 0.0725f+.0725f, 0.0f);
			_drawArc.draw(mvpm2, isEoneLight);

			float[] mvpm3 = _tempMatrix.clone();
			_drawArc.draw(mvpm3, isEoneLight);
		}

	}

	public void drawFullCylinder(float[] cylenderMVP, float[] projectionMatrix, float[] viewMatrix, boolean b, boolean b1, float transferArc) {

		_tempMatrix = cylenderMVP.clone();

		float[] mvpm1 = _tempMatrix.clone();
		_drawFullRect.draw(mvpm1,b);

		float[] mvpm2 = _tempMatrix.clone();
		Matrix.translateM(mvpm2, 0, 0, 0.07375f, 0.0f);
		_drawArc.draw(mvpm2,b);

		float[] mvpm3 = _tempMatrix.clone();
		Matrix.translateM(mvpm3, 0, 0, -0.0725f, 0.0f);
		_drawArc.draw(mvpm3,b);

	}
}
