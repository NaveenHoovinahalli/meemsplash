package com.meem.meemsplashscreen.objects;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

import com.meem.meemsplashscreen.renderer.SplashRender;
import com.meem.meemsplashscreen.utils.Constants;

import android.opengl.GLES20;
import android.opengl.Matrix;

public class DrawCircle{

	private float _vertices[] = new float[364 * 3];
	private float _normals[] = new float[364 * 3];

	private final String vertexShaderCode = "uniform mat4 uMVPMatrix;"+
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

	private int _program;
	private int _positionHandle;
	private int _mvpMatrixHandle;

	private int _vertexBufferID;
	private int _normalBufferID;
	
	public static int _lightAmbientHandle; 
	public static int _lightDiffuseHandle; 
	public static int _lightSpecularHandle;
	public static int _lightPosHandle;     

	public static int _materialAmbientHandle;  
	public static int _materialDiffuseHandle;  
	public static int _materialSpecularHandle; 
	public static int _materialShininessHandle;
	
	private int _normalHandle;
	public static int _normalMatrixHandle;




	public DrawCircle(){

		_vertices[0] = 0;
		_vertices[1] = 0;
		_vertices[2] = 0;

		for (int i = 1; i < 364; i++) {
			_vertices[(i * 3) + 0] = (float) (0.014 * Math.cos((3.14 / 180)
					* (float) i));
			_vertices[(i * 3) + 1] = (float) (0.014 * Math.sin((3.14 / 180)
					* (float) i));
			_vertices[(i * 3) + 2] = 0;
		}
		
		_normals[0] = 0;
		_normals[1] = 0;
		_normals[2] = 0;

		for (int i = 1; i < 364; i++) {
			_normals[(i * 3) + 0] = (float) (0.014 * Math.cos((3.14 / 180)
					* (float) i));
			_normals[(i * 3) + 1] = (float) (0.014 * Math.sin((3.14 / 180)
					* (float) i));
			_normals[(i * 3) + 2] = 0;
		} 
		float div= (float)Math.sqrt((0.014f*0.014f)+(0.014f*0.014f)+(0.014f*0.014f));

		for (int i=0; i<_normals.length; i++) 
			_normals[i]/=div;

		_vertexBufferID= makeFloatVBO(_vertices);
		_normalBufferID = makeFloatVBO(_normals);
		
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

	public void draw(float[] mvpMatrix) {
		
		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, _vertexBufferID);
		GLES20.glEnableVertexAttribArray(_positionHandle);
		GLES20.glVertexAttribPointer(_positionHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, 0);

		GLES20.glBindBuffer(GLES20.GL_ARRAY_BUFFER, _normalBufferID);
		GLES20.glEnableVertexAttribArray(_normalHandle);
		GLES20.glVertexAttribPointer(_normalHandle, COORDS_PER_VERTEX, GLES20.GL_FLOAT, false, 0, 0);

		GLES20.glUniformMatrix4fv(_mvpMatrixHandle, 1, false, mvpMatrix, 0);
		
		float[] normalM=new float[16];
		normalM(normalM, mvpMatrix);
		GLES20.glUniformMatrix4fv(_normalMatrixHandle, 1, false, normalM, 0);

		//GLES20.glUniform4f(_lightPosHandle,  -SplashRender.specularValue, -3.0f, -3.0f, 1.0f);
		
		setMaterial(Constants._defaultGreen[0], Constants._defaultGreen[1],Constants._defaultGreen[2], Constants._defaultGreen[3]);
		GLES20.glDrawArrays(GLES20.GL_TRIANGLE_FAN, 0, 364);
	}
	
	public static void normalM(float[] rm,float[] m) {
		float[] invertM=new float[16];
		Matrix.invertM(invertM, 0, m, 0);
		Matrix.transposeM(rm, 0, invertM, 0);
	}

	private void setMaterial(float r,float g,float b,float a) {
		GLES20.glUniform4f(DrawCircle._materialAmbientHandle,r,g,b,a);
		GLES20.glUniform4f(DrawCircle._materialDiffuseHandle,r,g,b,a);
		GLES20.glUniform4f(DrawCircle._materialSpecularHandle,r,g,b,a);
		GLES20.glUniform1f(DrawCircle._materialShininessHandle, 0.6f);
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
};
