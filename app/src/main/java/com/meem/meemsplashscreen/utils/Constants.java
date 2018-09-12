package com.meem.meemsplashscreen.utils;

public class Constants {

	public int ME_SPEED = 30;
	public int ME_SPEED_SLOW=18;

	public float CIRCLE_START_POSITION = 2.0f;
	public float CIRCLE_END_POSITION = 0.0f;
	public float _direction = -1.0f;
	public float EQUAL_GAP_SPEED = 0.002944f * ME_SPEED;
	public static float EXTRA_SPACE_EXTRA_WIDTH = 0;


	public float ME_ROTATION_SPEED = .000f * ME_SPEED;
	public int ME_ROTATION_PER_FRAME = 1 * ME_SPEED;
	public float EXTRA_SPACE = .0f;
	public static int WAIT_COUNT = 10;
	public static float[] _defaultGreen = {0.52941176f, 0.81960784f, 0.0f, 1.0f};
	public int ME_ROTATION_PER_FRAME1 = 1 * ME_SPEED_SLOW;
	public float EQUAL_GAP_SPEED1 = 0.002944f * ME_SPEED_SLOW;



	public void setMobileSpeed(int mobileSpeed) {
		ME_SPEED = 30 * mobileSpeed;
	}

	public void setMEGap(double ratio) {
//		if(ratio>.677) {
//				EQUAL_GAP_SPEED = 0.002944f * MESPEED;
//			EXTRA_SPACE_EXTRA_WIDTH = .008645833f+(.00125f*8);
//		}else if(ratio >= 0.6f)
//			EQUAL_GAP_SPEED = 0.002944f* MESPEED;
//		else
//			EQUAL_GAP_SPEED =(0.002944f+.00021f)* MESPEED;
//	}
	}
}
