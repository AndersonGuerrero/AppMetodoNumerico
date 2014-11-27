package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Simson1_3_Sub extends Activity
{
	EditText txtA,txtB,txtFuncion,txtN;
	TextView txtresp;
	float a,b;
	int n;
	String Funcion="";
	Evaluador e;
	protected void onCreate(Bundle savedInstanceState)
	{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.simson1_3_sub);
			 e=new Evaluador(); 
				this.txtA=(EditText) findViewById(R.id.Simson1_3_sub_A);
				this.txtB=(EditText) findViewById(R.id.Simson1_3_sub_B);
				this.txtFuncion=(EditText) findViewById(R.id.Simson1_3_sub_Funcion);
				this.txtresp=(TextView) findViewById(R.id.Simson1_3_sub_result);
				this.txtN=(EditText) findViewById(R.id.Simson1_3_sub_N);
	}
	
	public void Entrad(View view)
	{
		if(this.txtFuncion.getText().toString().length()>0 && this.txtA.getText().toString().length()>0 && this.txtB.getText().toString().length()>0 )
		{
			a=Float.parseFloat(txtA.getText().toString());
			b=Float.parseFloat(txtB.getText().toString());
			n=Integer.parseInt(txtN.getText().toString());
			Funcion=txtFuncion.getText().toString();
			txtresp.setText("Resultado:\n"+calcular(a,b,n));	
		}
	}
	

	public float calcular(float a,float b,int N)
	{
		float H=(b-a)/N;
		float p[]=new float[N+1];
		float XM[]=new float[N];
		float ant=a;
		float PS=0;
		for(int i=0;i<p.length;i++)
		{
			p[i]=ant;
			ant=p[i]+H;
			if(i>0 && i<p.length-1)
			{
				PS+=F(p[i]);
			}
		}
		float XMS=0;
		for(int i=0;i<XM.length;i++)
		{
			XM[i]=F((p[i]+p[i+1])/2);
			XMS+=XM[i];
		}
		float resp=F(a)+(4*XMS)+(2*PS)+F(b);
		return (resp/(6*N))*(b-a);
	}
	
	
	
	public float F(float x)
	{	
		String  f="";
		for(int i=0;i<Funcion.length();i++)
		{
			if(Funcion.charAt(i)=='x' || Funcion.charAt(i)=='X')
			{
				f+=x;
			}else
			{
				f+=Funcion.charAt(i);
			}      
		}
	     return (float)e.eval(f);
	}

}
