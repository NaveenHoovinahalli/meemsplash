package com.meem.meemsplashscreen.animations;
import com.meem.meemsplashscreen.objects.DrawArc;
import com.meem.meemsplashscreen.objects.DrawHalfRect;
import android.opengl.Matrix;

public class DrawHalfCylinder {

	DrawHalfRect _drawHalfRect;
	DrawArc _drawArc;
	private float[] _tempMatrix;
	
	public DrawHalfCylinder(){
		
		_drawHalfRect = new DrawHalfRect();
		_drawArc = new DrawArc();
	}
	
	public void drawHalfCylinder(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix, boolean isETwoLight)
	{
		createHalfCylinder(_mvpMatrix,isETwoLight);
	}

	private void createHalfCylinder(float[] _mvpMatrix, boolean isETwoLight) {

		_tempMatrix = _mvpMatrix.clone();
		
		float[] mvpm1 = _tempMatrix.clone();
		Matrix.translateM(mvpm1, 0, 0.0f,.0400f, 0);
		_drawHalfRect.draw(mvpm1,isETwoLight);

		float[] mvpm2 = _tempMatrix.clone();
		Matrix.translateM(mvpm2, 0, 0,0.07375f, 0.0f);
		_drawArc.draw(mvpm2, isETwoLight);

		float[] mvpm3 = _tempMatrix.clone();
		Matrix.translateM(mvpm3, 0, 0, 0.005f, 0.0f);
//		Matrix.rotateM(mvpm3, 0, 180, 0, 0, 1);
		_drawArc.draw(mvpm3, isETwoLight);
	}
}
