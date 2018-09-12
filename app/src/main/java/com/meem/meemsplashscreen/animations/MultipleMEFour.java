package com.meem.meemsplashscreen.animations;

import android.opengl.Matrix;

import com.meem.meemsplashscreen.utils.Constants;

/**
 * Created by scs on 6/10/2015.
 */
public class MultipleMEFour {

//    float xDistance=0.0125f;
    float xDistance=0f;

    float rotate=0;



    private MEEMOneAnimation _MEEMOneAnimation;
    private float moveInXaxis=0;
    public boolean oneCompleted;
    private float rotate2;
    private float moveXY;
    private float moveXY2;
    private float firstX;
    private boolean twoCompleted;
    private int rotate3;
    private float moveInXaxis3;
    private float moveXY3;
    private boolean threeCompleted;
    private int rotate4;
    private float moveInXaxis4;
    private float moveXY4;
    public boolean fourCompleted;


    private int rotationEY1=0;
    private float moveXYforRotation=0;
    private float initialGap=0;
    private static final float gapBetweenME=.150f;
    private float moveInYAxis1=0;

    private int rotationEY2=0;
    private float moveXYforRotation2=0;
    private boolean RotationCompleted1;
    private float moveInYAxis2=0;

    private int rotationEY3=0;
    private float moveXYforRotation3=0;
    private boolean RotationCompleted2;
    private float moveInYAxis3=0;

    private int rotationEY4=0;
    private float moveXYforRotation4=0;
    private boolean RotationCompleted3;
    private float moveInYAxis4=0;

    private int rotationEY5=0;
    private float moveXYforRotation5=0;
    public boolean RotationCompleted4;
    private float moveInYAxis5=0;

    private int rotationEY6=0;
    private float moveXYforRotation6=0;
    private boolean RotationCompleted5;
    private float moveInYAxis6=0;

    private int rotationEY7=0;
    private float moveXYforRotation7=0;
    private boolean RotationCompleted6;
    private float moveInYAxis7=0;

    private int rotationEY8=0;
    private float moveXYforRotation8=0;
    private boolean RotationCompleted7;
    private float moveInYAxis8=0;

    private int rotationEY9=0;
    private float moveXYforRotation9=0;
    public boolean RotationCompleted8;
    private float moveInYAxis9=0;

    private int rotationEY10=0;
    private float moveXYforRotation10=0;
    public boolean RotationCompleted9;
    private float moveInYAxis10=0;
    Constants _constants;
    private MultipleMEThree _multipleMEThree;
    private MultipleMETwo _multipleMETwo;
    private MultipleMEThreeTwo multipleMEThreeTwo;
    private MultipleMETwoTwo multipleMETwoTwo;
    boolean isLight=false;



    public MultipleMEFour(){
       _MEEMOneAnimation=new MEEMOneAnimation();
        _constants=new Constants();
        _multipleMEThree=new MultipleMEThree();
        _multipleMETwo=new MultipleMETwo();

        multipleMEThreeTwo= new MultipleMEThreeTwo();
        multipleMETwoTwo=new MultipleMETwoTwo();


    }


    public void createMultipleMEfromEone(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix){

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

                                        }
                                        else RotationCompleted9=true;
                                    }
                                }
                            }
                        }

                    }

                }

            }
        }

        float[] tempMatrix=_mvpMatrix.clone();
        float[] tempMatrix2=_mvpMatrix.clone();
        float[] tempMatrix3=_mvpMatrix.clone();

//        Matrix.translateM(_mvpMatrix, 0, + .045f, .045f, 0);
        Matrix.rotateM(_mvpMatrix, 0, -90, 0, 0, 1);


        float tempMatrixUp[] = _mvpMatrix.clone();
        float tempMatrixDown[]=_mvpMatrix.clone();
        float tempMatrixRight[]=_mvpMatrix.clone();
        float tempMatrixRightTwo[]=_mvpMatrix.clone();
        float tempMatrixRightThree[]=_mvpMatrix.clone();

        Matrix.rotateM(_mvpMatrix, 0, 90, 0, 0, 1);
        Matrix.rotateM(_mvpMatrix, 0, -rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(_mvpMatrix, _projectionMatrix, _viewMatrix,isLight);



        //x axis
        if(!RotationCompleted1) {


            Matrix.translateM(tempMatrixRight, 0,0,- moveInYAxis1, 0);
            Matrix.rotateM(tempMatrixRight, 0, rotationEY1, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixRight, _projectionMatrix, _viewMatrix,isLight);
        }

        if(RotationCompleted1) {
            //y axis for new X axis
            Matrix.translateM(tempMatrix, 0, -.265f - (_constants.EXTRA_SPACE_EXTRA_WIDTH), 0f, 0);
//            _multipleMEThree.createMultipleMEfromMTwo(tempMatrix, _projectionMatrix, _viewMatrix);
            multipleMEThreeTwo.createMultipleMEfromMTwo(tempMatrix, _projectionMatrix, _viewMatrix);



            if(!RotationCompleted2) {
//                Matrix.translateM(tempMatrix2, 0, 0, .025f + .045f, 0);
                Matrix.translateM(tempMatrix2, 0, -.265f,0, 0);
                Matrix.translateM(tempMatrix2, 0,moveXYforRotation2, moveXYforRotation2, 0);
                Matrix.translateM(tempMatrix2, 0, -moveInYAxis2,0, 0);

                Matrix.rotateM(tempMatrix2, 0, -rotationEY2, 0, 0, 1);

                _MEEMOneAnimation.createMultipleME(tempMatrix2, _projectionMatrix, _viewMatrix,isLight);
            }
            if(RotationCompleted2) {
                Matrix.translateM(tempMatrix3, 0, -.265f - .265f - (_constants.EXTRA_SPACE_EXTRA_WIDTH * 2), 0, 0);
//                _multipleMETwo.createMultipleMEfromEone(tempMatrix3, _projectionMatrix, _viewMatrix);
                multipleMETwoTwo.createMultipleMEfromEone(tempMatrix3, _projectionMatrix, _viewMatrix);

            }
        }




        //+Yaxis

        Matrix.translateM(tempMatrixUp, 0, -moveInYAxis1,0 ,0);
        Matrix.rotateM(tempMatrixUp, 0,rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix,isLight);


        if(RotationCompleted1) {
            Matrix.translateM(tempMatrixUp, 0,0, moveInYAxis2, 0);
            Matrix.rotateM(tempMatrixUp, 0, -rotationEY2, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix,isLight);

        }

        if(RotationCompleted2){
            Matrix.translateM(tempMatrixUp, 0, -moveInYAxis3,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,rotationEY3, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted3) {
            Matrix.translateM(tempMatrixUp, 0,0, moveInYAxis4, 0);
            Matrix.rotateM(tempMatrixUp, 0, -rotationEY4, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted4){
            Matrix.translateM(tempMatrixUp, 0, -moveInYAxis5,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,rotationEY5, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted5) {
            Matrix.translateM(tempMatrixUp, 0,0, moveInYAxis6, 0);
            Matrix.rotateM(tempMatrixUp, 0, -rotationEY6, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted6){
            Matrix.translateM(tempMatrixUp, 0, -moveInYAxis7,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,rotationEY7, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted7) {
            Matrix.translateM(tempMatrixUp, 0,0, moveInYAxis8, 0);
            Matrix.rotateM(tempMatrixUp, 0, -rotationEY8, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted8){
            Matrix.translateM(tempMatrixUp, 0, -moveInYAxis9,0 ,0);
            Matrix.rotateM(tempMatrixUp, 0,rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted9) {
            Matrix.translateM(tempMatrixUp, 0,0, moveInYAxis10, 0);
            Matrix.rotateM(tempMatrixUp, 0, -rotationEY10, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }


        //-Yaxis


        Matrix.translateM(tempMatrixDown, 0, moveInYAxis1,0, 0);
        Matrix.rotateM(tempMatrixDown, 0,rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix,isLight);


        if(RotationCompleted1) {
            Matrix.translateM(tempMatrixDown, 0,0,- moveInYAxis2, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY2, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix,isLight);

        }

        if(RotationCompleted2){
            Matrix.translateM(tempMatrixDown, 0, moveInYAxis3,0, 0);
            Matrix.rotateM(tempMatrixDown, 0,rotationEY3, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted3) {
            Matrix.translateM(tempMatrixDown, 0,0,- moveInYAxis4, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY4, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted4){
            Matrix.translateM(tempMatrixDown, 0, moveInYAxis5,0, 0);
            Matrix.rotateM(tempMatrixDown, 0,rotationEY5, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted5) {
            Matrix.translateM(tempMatrixDown, 0,0,- moveInYAxis6, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY6, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted6){
            Matrix.translateM(tempMatrixDown, 0, moveInYAxis7,0, 0);
            Matrix.rotateM(tempMatrixDown, 0,rotationEY7, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted7) {
            Matrix.translateM(tempMatrixDown, 0,0,- moveInYAxis8, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY8, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted8){
            Matrix.translateM(tempMatrixDown, 0, moveInYAxis9,0, 0);
            Matrix.rotateM(tempMatrixDown, 0,rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }
        if(RotationCompleted9) {
            Matrix.translateM(tempMatrixDown, 0,0,- moveInYAxis8, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY8, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted9){
            Matrix.translateM(tempMatrixDown, 0, moveInYAxis9,0, 0);
            Matrix.rotateM(tempMatrixDown, 0,rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }
    }



    public void createMultipleMEfromMTwo(float[] _mvpMatrix, float[] _projectionMatrix, float[] _viewMatrix) {

        if(rotationEY1<90){
            rotationEY1 = rotationEY1 + _constants.ME_ROTATION_PER_FRAME;
            moveXYforRotation=moveXYforRotation+_constants.ME_ROTATION_SPEED;
            initialGap=initialGap+.000277f;
            moveInYAxis1 = moveInYAxis1 + _constants.EQUAL_GAP_SPEED;

        }else {
            RotationCompleted1 = true;
            if(rotationEY2<90){
                rotationEY2 = rotationEY2 + _constants.ME_ROTATION_PER_FRAME;
                moveXYforRotation2=moveXYforRotation2+_constants.ME_ROTATION_SPEED;
                moveInYAxis2 = moveInYAxis2 + _constants.EQUAL_GAP_SPEED;

            }else {
                RotationCompleted2 = true;
                if(rotationEY3<90){
                    rotationEY3 = rotationEY3 +_constants.ME_ROTATION_PER_FRAME;
                    moveXYforRotation3=moveXYforRotation3+_constants.ME_ROTATION_SPEED;
                    moveInYAxis3 = moveInYAxis3 + _constants.EQUAL_GAP_SPEED;

                }else {
                    RotationCompleted3 = true;
                    if(rotationEY4<90){
                        rotationEY4 = rotationEY4 +_constants.ME_ROTATION_PER_FRAME;
                        moveXYforRotation4=moveXYforRotation4+_constants.ME_ROTATION_SPEED;
                        moveInYAxis4 = moveInYAxis4 +_constants.EQUAL_GAP_SPEED;

                    }else {
                        RotationCompleted4 = true;
                        if(rotationEY5<90){
                            rotationEY5 = rotationEY5 + _constants.ME_ROTATION_PER_FRAME;
                            moveXYforRotation5=moveXYforRotation5+_constants.ME_ROTATION_SPEED;
                            moveInYAxis5 = moveInYAxis5 + _constants.EQUAL_GAP_SPEED;

                        }else {
                            RotationCompleted5 = true;
                            if(rotationEY6<90){
                                rotationEY6 = rotationEY6 +_constants.ME_ROTATION_PER_FRAME;
                                moveXYforRotation6=moveXYforRotation6+_constants.ME_ROTATION_SPEED;
                                moveInYAxis6 = moveInYAxis6 +_constants.EQUAL_GAP_SPEED;

                            }else {
                                RotationCompleted6 = true;
                                if(rotationEY7<90){
                                    rotationEY7 = rotationEY7 + _constants.ME_ROTATION_PER_FRAME;
                                    moveXYforRotation7=moveXYforRotation7+_constants.ME_ROTATION_SPEED;
                                    moveInYAxis7 = moveInYAxis7 + _constants.EQUAL_GAP_SPEED;

                                }else {
                                    RotationCompleted7 = true;
                                    if(rotationEY8<90){
                                        rotationEY8 = rotationEY8 +_constants.ME_ROTATION_PER_FRAME;
                                        moveXYforRotation8=moveXYforRotation8+_constants.ME_ROTATION_SPEED;
                                        moveInYAxis8 = moveInYAxis8 +_constants.EQUAL_GAP_SPEED;

                                    }else {
                                        RotationCompleted8 = true;
                                        if(rotationEY9<90){
                                            rotationEY9 = rotationEY9 + _constants.ME_ROTATION_PER_FRAME;
                                            moveXYforRotation9=moveXYforRotation9+_constants.ME_ROTATION_SPEED;
                                            moveInYAxis9 = moveInYAxis9 + _constants.EQUAL_GAP_SPEED;

                                        }else {
                                            RotationCompleted9 = true;
                                            if(rotationEY10<90){
                                                rotationEY10 = rotationEY10 + _constants.ME_ROTATION_PER_FRAME;
                                                moveXYforRotation10=moveXYforRotation10+_constants.ME_ROTATION_SPEED;
                                                moveInYAxis10 = moveInYAxis10 + _constants.EQUAL_GAP_SPEED;

                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

//        Matrix.translateM(_mvpMatrix, 0,- .025f , 0, 0);
        _MEEMOneAnimation.createMultipleME(_mvpMatrix, _projectionMatrix, _viewMatrix);


        float tempMatrixUp[] = _mvpMatrix.clone();
        float tempMatrixDown[]=_mvpMatrix.clone();

        //+Yaxis

        Matrix.translateM(tempMatrixUp, 0, moveXYforRotation, moveXYforRotation, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis1, 0);
            Matrix.rotateM(tempMatrixUp, 0,- rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);


        if(RotationCompleted1) {
        Matrix.rotateM(tempMatrixUp, 0, rotationEY2, 0, 0, 1);
        Matrix.translateM(tempMatrixUp, 0, -moveXYforRotation2, -moveXYforRotation2, 0);
        Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis2, 0);
        _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted2){

            Matrix.translateM(tempMatrixUp, 0, moveXYforRotation3, moveXYforRotation3, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis3, 0);
            Matrix.rotateM(tempMatrixUp, 0,- rotationEY3, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted3) {
            Matrix.rotateM(tempMatrixUp, 0, rotationEY4, 0, 0, 1);
            Matrix.translateM(tempMatrixUp, 0, -moveXYforRotation4, -moveXYforRotation4, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis4, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted4){

            Matrix.translateM(tempMatrixUp, 0, moveXYforRotation5, moveXYforRotation5, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis5, 0);
            Matrix.rotateM(tempMatrixUp, 0,- rotationEY5, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted5) {
            Matrix.rotateM(tempMatrixUp, 0, rotationEY6, 0, 0, 1);
            Matrix.translateM(tempMatrixUp, 0, -moveXYforRotation6, -moveXYforRotation6, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis6, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted6){

            Matrix.translateM(tempMatrixUp, 0, moveXYforRotation7, moveXYforRotation7, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis7, 0);
            Matrix.rotateM(tempMatrixUp, 0,- rotationEY7, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted7) {
            Matrix.rotateM(tempMatrixUp, 0, rotationEY8, 0, 0, 1);
            Matrix.translateM(tempMatrixUp, 0, -moveXYforRotation8, -moveXYforRotation8, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis8, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted8){

            Matrix.translateM(tempMatrixUp, 0, moveXYforRotation9, moveXYforRotation9, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis9, 0);
            Matrix.rotateM(tempMatrixUp, 0,- rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted9) {
            Matrix.rotateM(tempMatrixUp, 0, rotationEY10, 0, 0, 1);
            Matrix.translateM(tempMatrixUp, 0, -moveXYforRotation10, -moveXYforRotation10, 0);
            Matrix.translateM(tempMatrixUp, 0, 0,moveInYAxis10, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixUp, _projectionMatrix, _viewMatrix);
        }


        //-Yaxis

        Matrix.translateM(tempMatrixDown, 0, moveXYforRotation, moveXYforRotation, 0);
        Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis1, 0);
        Matrix.rotateM(tempMatrixDown, 0, -rotationEY1, 0, 0, 1);
        _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);


        if(RotationCompleted1) {
            Matrix.rotateM(tempMatrixDown, 0, rotationEY2, 0, 0, 1);
            Matrix.translateM(tempMatrixDown, 0, -moveXYforRotation2, -moveXYforRotation2, 0);
            Matrix.translateM(tempMatrixDown, 0, 0, -moveInYAxis2, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }


        if(RotationCompleted2){
            Matrix.translateM(tempMatrixDown, 0, moveXYforRotation3, moveXYforRotation3, 0);
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis3, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY3, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted3) {
            Matrix.rotateM(tempMatrixDown, 0, rotationEY4, 0, 0, 1);
            Matrix.translateM(tempMatrixDown, 0, -moveXYforRotation4, -moveXYforRotation4, 0);
            Matrix.translateM(tempMatrixDown, 0, 0, -moveInYAxis4, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }


        if(RotationCompleted4){
            Matrix.translateM(tempMatrixDown, 0, moveXYforRotation5, moveXYforRotation5, 0);
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis5, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY5, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted5) {
            Matrix.rotateM(tempMatrixDown, 0, rotationEY6, 0, 0, 1);
            Matrix.translateM(tempMatrixDown, 0, -moveXYforRotation6, -moveXYforRotation6, 0);
            Matrix.translateM(tempMatrixDown, 0, 0, -moveInYAxis6, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }


        if(RotationCompleted6){
            Matrix.translateM(tempMatrixDown, 0, moveXYforRotation7, moveXYforRotation7, 0);
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis7, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY7, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted7) {
            Matrix.rotateM(tempMatrixDown, 0, rotationEY8, 0, 0, 1);
            Matrix.translateM(tempMatrixDown, 0, -moveXYforRotation8, -moveXYforRotation8, 0);
            Matrix.translateM(tempMatrixDown, 0, 0, -moveInYAxis8, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }


        if(RotationCompleted8){
            Matrix.translateM(tempMatrixDown, 0, moveXYforRotation9, moveXYforRotation9, 0);
            Matrix.translateM(tempMatrixDown, 0, 0,-moveInYAxis9, 0);
            Matrix.rotateM(tempMatrixDown, 0, -rotationEY9, 0, 0, 1);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }

        if(RotationCompleted9) {
            Matrix.rotateM(tempMatrixDown, 0, rotationEY10, 0, 0, 1);
            Matrix.translateM(tempMatrixDown, 0, -moveXYforRotation10, -moveXYforRotation10, 0);
            Matrix.translateM(tempMatrixDown, 0, 0, -moveInYAxis10, 0);
            _MEEMOneAnimation.createMultipleME(tempMatrixDown, _projectionMatrix, _viewMatrix);
        }



    }
}