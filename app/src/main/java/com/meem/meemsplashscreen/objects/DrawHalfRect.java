package com.meem.meemsplashscreen.objects;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import com.meem.meemsplashscreen.renderer.SplashRender;
import com.meem.meemsplashscreen.utils.Constants;

import android.opengl.GLES20;
import android.opengl.Matrix;

public class DrawHalfRect {

	private final String vertexShaderCode = 
			"uniform mat4 uMVPMatrix;"+
					"uniform vec4 u_LightAmbient;"+ 
					"uniform vec4 u_LightDiffuse;"+ 
					"uniform vec4 u_LightSpecular;"+
					"uniform vec4 u_LightPos;"+     

			        "uniform vec4 u_MaterialAmbient;"+   
			        "uniform vec4 u_MaterialDiffuse;"+   
			        "uniform vec4 u_MaterialSpecular;"+  
			        "uniform float u_MaterialShininess;"

					+"uniform mat4 u_NormalMatrix;"
					+"attribute vec4 vPosition;"
					+"attribute vec3 a_Normal;" 
					+"varying vec4 vColor;"

					+ "void main() {"
					+ "vec4 ambient = u_LightAmbient * u_MaterialAmbient;"
					+ "vec3 P = vec3(uMVPMatrix * vPosition);"
					+ "vec3 L = normalize(vec3(u_LightPos)-P);"
					+ "vec3 N = normalize(vec3(u_NormalMatrix)) * a_Normal;"
					+ "vec4 diffuseP=vec4(max(dot(L,N),0.0));"
					+ "vec4 diffuse=diffuseP*u_LightDiffuse*u_MaterialDiffuse;"

					+ "vec3 S=normalize(L+vec3(0.0,0.0,1.0));" 
					+ "float specularP=pow(max(dot(N,S),0.0),u_MaterialShininess);"
					+ "vec4 specular=specularP*u_LightSpecular*u_MaterialSpecular;"
					+ "vColor=ambient+diffuse+specular;"
					+ "gl_Position = uMVPMatrix * vPosition;" 
					+"}";

	private final String fragmentShaderCode = "precision mediump float;"
			+ "varying vec4 vColor;" + "void main() {"
			+ "gl_FragColor=vColor;"+"}";

	static final int COORDS_PER_VERTEX = 3;

	static float _rectCoords[] = {
			-0.0225f, 0.03375f+.00125f, 0.0f,
			-0.0225f, -0.03375f+.00125f, 0.0f,
			0.0225f, -0.03375f+.00125f, 0.0f,
			0.0225f, 0.03375f+.00125f, 0.0f
	};


	private final byte[] _indexOrder = { 
			0, 1, 2, 0, 2, 3, 0 
	};

	private int _program;
	private int _positionHandle;
	private int _mvpMatrixHandle;
	private int _normalHandle;
	public static int _normalMatrixHandle;

	private int _vertexBufferID;
	private int _indexBufferID;
	private int _normalBufferID;

	static float[] _dcolor ={0,0,0,1};

	public static int _lightAmbientHandle; 
	public static int _lightDiffuseHandle; 
	public static int _lightSpecularHandle;
	public static int _lightPosHandle;     

	public static int _materialAmbientHandle;  
	public static int _materialDiffuseHandle;  
	public static int _materialSpecularHandle; 
	public static int _materialShininessHandle;

	public DrawHalfRect(){

		float _rectNormals[] = {
				-0.02270f, 0.035f, 0.0f,
				-0.02270f, -0.035f, 0.0f,
				0.02270f, -0.035f, 0.0f,
				0.02270f, 0.035f, 0.0f
		};
		float div= (float)Math.sqrt((0.0225f*0.045f)+(0.0225f*0.045f)+(0.0225f*0.045f));
		for (int i=0; i<_rectNormals.length; i++) 
			_rectNormals[i]/=div;

		_vertexBufferID = makeFloatVBO(_rectCoords);
		_indexBufferID = makeByteVBO(_indexOrder);
		_normalBufferID = makeFloatVBO(_rectNormals);

		int vertexShader = SplashRender.loadShader(GLES20.GL_VERTEX_SHADER, vertexShaderCode);
		int fragmentShader = SplashRender.loadShader(GLES20.GL_FRAGMENT_SHADER, fragmentShaderCode);
		_program = GLES20.glCreateProgram();
		GLES20.glAttachShader(_program, vertexShader);
		GLES20.glAttachShader(_program, fragmentShader);
		GLES20.glLinkProgram(_program);

		_lightAmbientHandle=GLES20.glGetUniformLocation(_program,"u_LightAmbient");
		_lightDiffuseHandle=GLES20.glGetUniformLocation(_program,"u_LightDiffuse");
		_lightSpecularHandle=GLES20.glGetUniformLocation(_program,"u_LightSpecular");
		_lightPosHandle=GLES20.glGetUniformLocation(_program,"u_LightPos");

		_materialAmbientHandle=GLES20.glGetUniformLocation(_program,"u_MaterialAmbient");
		_materialDiffuseHandle=GLES20.glGetUniformLocation(_program,"u_MaterialDiffuse");
		_materialSpecularHandle=GLES20.glGetUniformLocation(_program,"u_MaterialSpecular");
		_materialShininessHandle=GLES20.glGetUniformLocation(_program,"u_MaterialShininess");

		_normalMatrixHandle=GLES20.glGetUniformLocation(_program,"u_NormalMatrix");
		_positionHandle = GLES20.glGetAttribLocation(_program, "vPosition");
		_mvpMatrixHandle = GLES20.glGetUniformLocation(_program, "uMVPMatrix");
		_normalHandle = GLES20.glGetAttribLocation(_program,"a_Normal");

		GLES20.glUseProgram(_program);
	}

	public void draw(float[] mvpMatrix, boolean isETwoLight) {

		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, _vertexBufferID);
		GLES20.glEnableVertexAttribArray(_positionHandle);
		GLES20.glVertexAttribPointer(_positionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, 0);

		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, _normalBufferID);
		GLES20.glEnableVertexAttribArray(_normalHandle);
		GLES20.glVertexAttribPointer(_normalHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, 0);

		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, _indexBufferID);

		GLES20.glUniformMatrix4fv(_mvpMatrixHandle, 1, false, mvpMatrix, 0);

		float[] normalM=new float[16];
		normalM(normalM, mvpMatrix);
		GLES20.glUniformMatrix4fv(_normalMatrixHandle, 1, false, normalM, 0);

		//GLES20.glUniform4f(_lightPosHandle,  -SplashRender.specularValue, -3.0f, -3.0f, 1.0f);

		if(isETwoLight)
		{
//			setMaterial(.94f,.96f,.47f,1.0f);
			setMaterial(.94f,.96f,.66f,1.0f);

		}
		else
		{
			if(SplashRender.getDefaultColor()) {
				setMaterial(Constants._defaultGreen[0], Constants._defaultGreen[1],Constants._defaultGreen[2], Constants._defaultGreen[3]);
			}else {
				_dcolor = SplashRender.getDefaultColorforME();
				setMaterial(_dcolor[0], _dcolor[1], _dcolor[2], 1.0f);
			}
		}
		GLES20.glDrawElements(GLES20.GL_TRIANGLE_STRIP, 7, GLES20.GL_UNSIGNED_BYTE, 0);

	}

	public static void normalM(float[] rm,float[] m) {
		float[] invertM=new float[16];
		Matrix.invertM(invertM, 0, m, 0);
		Matrix.transposeM(rm, 0, invertM, 0);
	}

	private void setMaterial(float r,float g,float b,float a) {
		GLES20.glUniform4f(DrawHalfRect._materialAmbientHandle,r,g,b,a);
		GLES20.glUniform4f(DrawHalfRect._materialDiffuseHandle,r,g,b,a);
		GLES20.glUniform4f(DrawHalfRect._materialSpecularHandle,r,g,b,a);
		GLES20.glUniform1f(DrawHalfRect._materialShininessHandle, 0.6f);
	}


	private int makeFloatVBO(float[] array) {
		FloatBuffer fb=ByteBuffer.allocateDirect(array.length*4).order(ByteOrder.nativeOrder()).asFloatBuffer();
		fb.put(array).position(0);

		int[] bufferIds=new int[1];
		GLES20.glGenBuffers(1, bufferIds, 0);
		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, bufferIds[0]);
		GLES20.glBufferData(GLES20.GL_ARRAY_BUFFER, fb.capacity()*4, fb, GLES20.GL_STATIC_DRAW);
		return bufferIds[0];
	}

	private int makeByteVBO(byte[] array) {
		ByteBuffer bb=ByteBuffer.allocateDirect(array.length).order(ByteOrder.nativeOrder());
		bb.put(array).position(0);

		int[] bufferIds=new int[1];
		GLES20.glGenBuffers(1,bufferIds,0);
		GLES20.glBindBuffer(GLES20.GL_ELEMENT_ARRAY_BUFFER, bufferIds[0]);
		GLES20.glBufferData(GLES20.GL_ELEMENT_ARRAY_BUFFER, bb.capacity(), bb, GLES20.GL_STATIC_DRAW);
		return bufferIds[0];
	}
};
