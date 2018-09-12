package com.meem.meemsplashscreen.animations;
import android.opengl.Matrix;
import com.meem.meemsplashscreen.utils.Constants;

public class MultipleMEOne {

    //    float xDistance=0.0125f;
    float xDistance=0f;
    float rotate=0;
    private MEEMOneAnimation _MEEMOneAnimation;
    public  boolean startZoomingOut;
    private int rotationEY1=0;
    private float moveXYforRotation=0;
    private float initialGap=0;
    private static final float gapBetweenME=.150f;
    private float moveInYAxis1=0;
    private float moveIndownYAxis1;

    private int rotationEY2=0;
    private float moveXYforRotation2=0;
    private boolean RotationCompleted1;
    private float moveInYAxis2=0;
    private float moveIndownYAxis2;


    private int rotationEY3=0;
    private float moveXYforRotation3=0;
    private boolean RotationCompleted2;
    private float moveInYAxis3=0;
    private float moveIndownYAxis3;


    private int rotationEY4=0;
    private float moveXYforRotation4=0;
    public boolean RotationCompleted3;
    private float moveInYAxis4=0;
    private float moveIndownYAxis4;


    private int rotationEY5=0;
    private float moveXYforRotation5=0;
    public boolean RotationCompleted4;
    private float moveInYAxis5=0;
    private float moveIndownYAxis5;


    private int rotationEY6=0;
    private float moveXYforRotation6=0;
    private boolean RotationCompleted5;
    private float moveInYAxis6=0;
    private float moveIndownYAxis6;


    private int rotationEY7=0;
    private float moveXYforRotation7=0;
    public boolean RotationCompleted6;
    private float moveInYAxis7=0;
    private float moveIndownYAxis7;


    private int rotationEY8=0;
    private float moveXYforRotation8=0;
    public boolean RotationCompleted7;
    private float moveInYAxis8=0;
    private float moveIndownYAxis8;


    private int rotationEY9=0;
    private float moveXYforRotation9=0;
    public boolean RotationCompleted8;
    private float moveInYAxis9=0;
    private float moveIndownYAxis9;


    private int rotationEY10=0;
    private float moveXYforRotation10=0;
    private boolean RotationCompleted9;
    private boolean RotationCompleted10;
    private float moveInYAxis10=0;
    private float moveIndownYAxis10;
    Constants _constants;
    MultipleMETwo _multipleMETwo;
    private MultipleMEThree _multipleMTThree;
    private MultipleMEThreeTwo multipleMEThreeTwo;
    private MultipleMETwoTwo multipleMETwoTwo;
    private boolean isLight=false;



    public MultipleMEOne(){
       _MEEMOneAnimation=new MEEMOneAnimation();
        _constants=new Constants();
        _multipleMETwo=new MultipleMETwo();
         _multipleMTThree = new MultipleMEThree();

        multipleMEThreeTwo= new MultipleMEThreeTwo();
        multipleMETwoTwo=new MultipleMETwoTwo();
    }
    public void createMultipleMEfromMTwo(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {

        if(rotationEY1<90){
//            isLight=true;
            rotationEY1 = rotationEY1 + _constants.ME_ROTATION_PER_FRAME1;
            moveInYAxis1 = moveInYAxis1 + _constants.EQUAL_GAP_SPEED1;

        }else {
            RotationCompleted1 = true;
            if(rotationEY2<90){
                rotationEY2 = rotationEY2 + _constants.ME_ROTATION_PER_FRAME;
                moveInYAxis2 = moveInYAxis2 + _constants.EQUAL_GAP_SPEED;
                if(rotationEY2>45)
                    isLight=false;

            }else {
                RotationCompleted2 = true;
                if(rotationEY3<90){
                    rotationEY3 = rotationEY3 +_constants.ME_ROTATION_PER_FRAME;
                    moveInYAxis3 = moveInYAxis3 + _constants.EQUAL_GAP_SPEED;


                }else {
                    RotationCompleted3 = true;
                    if(rotationEY4<90){
                        rotationEY4 = rotationEY4 +_constants.ME_ROTATION_PER_FRAME;
                        moveInYAxis4 = moveInYAxis4 +_constants.EQUAL_GAP_SPEED;

                    }else {
                        RotationCompleted4 = true;
                        if(rotationEY5<90){
                            rotationEY5 = rotationEY5 + _constants.ME_ROTATION_PER_FRAME;
                            moveInYAxis5 = moveInYAxis5 + _constants.EQUAL_GAP_SPEED;

                        }else {
                            RotationCompleted5 = true;
                            if(rotationEY6<90){
                                rotationEY6 = rotationEY6 +_constants.ME_ROTATION_PER_FRAME;
                                moveInYAxis6 = moveInYAxis6 +_constants.EQUAL_GAP_SPEED;

                            }else {
                                RotationCompleted6 = true;
                                if(rotationEY7<90){
                                    rotationEY7 = rotationEY7 + _constants.ME_ROTATION_PER_FRAME;
                                    moveInYAxis7 = moveInYAxis7 + _constants.EQUAL_GAP_SPEED;

                                }else {
                                    RotationCompleted7 = true;

                                    if(rotationEY8<90){
                                        rotationEY8 = rotationEY8 +_constants.ME_ROTATION_PER_FRAME;
                                        moveInYAxis8 = moveInYAxis8 +_constants.EQUAL_GAP_SPEED;

                                    }else {
                                        RotationCompleted8 = true;
                                        if(rotationEY9<90){
                                            rotationEY9 = rotationEY9 + _constants.ME_ROTATION_PER_FRAME;
                                            moveInYAxis9 = moveInYAxis9 + _constants.EQUAL_GAP_SPEED;

                                        }else
                                            RotationCompleted9=true;
                                    }
                                }
                            }
                        }

                    }

                }

            }
        }

        float tempMatrixLeft[]=_mvpMatrix.clone();
        float tempMatrixLeftTwo[]=_mvpMatrix.clone();
        float tempMatrixLeftThree[]=_mvpMatrix.clone();


//        Matrix.rotateM(_mvpMatrix,0,90,0,0,1);
        _MEEMOneAnimation.createMultipleME(_mvpMatrix, _projectionMatrix, _viewMatrix,isLight);


        float tempMatrixUp[] = _mvpMatrix.clone();
        float tempMatrixDown[]=_mvpMatrix.clone();




        //x axis
        if(!RotationCompleted1) {
            Matrix.translateM(tempMatrixLeft, 0, moveInYAxis1, 0, 0);
            Matrix.rotateM(tempMatrixLeft, 0, -rotationEY1, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixLeft, _projectionMatrix, _viewMatrix,isLight);
        }

        if(RotationCompleted1) {
            //y axis for new X axis
            Matrix.translateM(tempMatrixLeftTwo, 0, .265f + _constants.EXTRA_SPACE_EXTRA_WIDTH, 0, 0);
//            _multipleMETwo.createMultipleMEfromEone(tempMatrixLeftTwo, _projectionMatrix, _viewMatrix);
            multipleMETwoTwo.createMultipleMEfromEone(tempMatrixLeftTwo, _projectionMatrix, _viewMatrix);


            Matrix.translateM(tempMatrixLeft, 0, .265f, 0.000f+(_constants.EXTRA_SPACE*2), 0);
            Matrix.rotateM(tempMatrixLeft, 0, -90, 0, 0, 1);
//            _MEEMOneAnimation.createMultipleME(tempMatrixLeft, _projectionMatrix, _viewMatrix);

            if(!RotationCompleted2) {
                Matrix.translateM(tempMatrixLeft, 0,0, moveInYAxis2, 0);
                Matrix.rotateM(tempMatrixLeft, 0, rotationEY2, 0, 0, 1);
                _MEEMOneAnimation.createMultipleME(tempMatrixLeft, _projectionMatrix, _viewMatrix,isLight);
            }
            if(RotationCompleted2) {
                Matrix.translateM(tempMatrixLeftThree, 0, .265f + .265f + (_constants.EXTRA_SPACE_EXTRA_WIDTH * 2), 0, 0);
//                _multipleMTThree.createMultipleMEfromMTwo(tempMatrixLeftThree, _projectionMatrix, _viewMatrix);
                multipleMEThreeTwo.createMultipleMEfromMTwo(tempMatrixLeftThree, _projectionMatrix, _viewMatrix);


            }
        }



        //+Yaxis

        Matrix.translateM(tempMatrixUp, 0,0, moveInYAxis1, 0);
        Matrix.rotateM(tempMatrixUp, 0, rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix,isLight);


        if(RotationCompleted1) {
            Matrix.translateM(tempMatrixUp, 0, moveInYAxis2,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,-rotationEY2, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix,isLight);
        }

        if(RotationCompleted2){
            Matrix.translateM(tempMatrixUp, 0,0,moveInYAxis3, 0);
            Matrix.rotateM(tempMatrixUp, 0, rotationEY3, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted3) {
            Matrix.translateM(tempMatrixUp, 0, moveInYAxis4,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,-rotationEY4, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted4){
            Matrix.translateM(tempMatrixUp, 0,0,moveInYAxis5, 0);
            Matrix.rotateM(tempMatrixUp, 0, rotationEY5, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted5) {
            Matrix.translateM(tempMatrixUp, 0, moveInYAxis6,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,-rotationEY6, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted6){
            Matrix.translateM(tempMatrixUp, 0,0,moveInYAxis7, 0);
            Matrix.rotateM(tempMatrixUp, 0, rotationEY7, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted7) {
            Matrix.translateM(tempMatrixUp, 0, moveInYAxis8,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,-rotationEY8, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted8){
            Matrix.translateM(tempMatrixUp, 0,0,moveInYAxis9, 0);
            Matrix.rotateM(tempMatrixUp, 0, rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }


        //-Yaxis

        Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis1, 0);
        Matrix.rotateM(tempMatrixDown, 0, rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix,isLight);


        if(RotationCompleted1) {
            Matrix.translateM(tempMatrixDown, 0,- moveInYAxis2,0, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY2, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix,isLight);

        }

        if(RotationCompleted2) {
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis3, 0);
            Matrix.rotateM(tempMatrixDown, 0, rotationEY3, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted3) {
            Matrix.translateM(tempMatrixDown, 0,- moveInYAxis4,0, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY4, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted4) {
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis5, 0);
            Matrix.rotateM(tempMatrixDown, 0, rotationEY5, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted5) {
            Matrix.translateM(tempMatrixDown, 0,- moveInYAxis6,0, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY6, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted6) {
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis7, 0);
            Matrix.rotateM(tempMatrixDown, 0, rotationEY7, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted7) {
            Matrix.translateM(tempMatrixDown, 0,- moveInYAxis8,0, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY8, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted8) {
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis9, 0);
            Matrix.rotateM(tempMatrixDown, 0, rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted9) {
            Matrix.translateM(tempMatrixDown, 0,- moveInYAxis8,0, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY8, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted9) {
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis9, 0);
            Matrix.rotateM(tempMatrixDown, 0, rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

    }
}
