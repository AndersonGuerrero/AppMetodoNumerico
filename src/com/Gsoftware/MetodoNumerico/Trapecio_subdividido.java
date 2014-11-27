package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Trapecio_subdividido extends Activity {
	
	
	EditText txtA,txtB,txtN,txtFuncion;
	TextView txtresp;
	float a,b;
	int N;
	String Funcion="";
	Evaluador e;
	protected void onCreate(Bundle savedInstanceState)
	{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.trapecio_subdividido);
			 e=new Evaluador(); 
				this.txtA=(EditText) findViewById(R.id.trapecio_sub_A);
				this.txtB=(EditText) findViewById(R.id.trapecio_sub_B);
				this.txtN=(EditText) findViewById(R.id.trapecio_sub_N);
				this.txtFuncion=(EditText) findViewById(R.id.trapecio_sub_funcion);
				this.txtresp=(TextView) findViewById(R.id.trapecio_sub_resp);
	}
	
	public void Entrad(View view)
	{	
		if(this.txtFuncion.getText().toString().length()>0 && this.txtA.getText().toString().length()>0 && this.txtB.getText().toString().length()>0 && this.txtN.getText().toString().length()>0 )
		{
			a=Float.parseFloat(txtA.getText().toString());
			b=Float.parseFloat(txtB.getText().toString());
			N=Integer.parseInt(txtN.getText().toString());
			Funcion=txtFuncion.getText().toString();
			txtresp.setText("Resultado:\n"+calcular(a,b,N));	
		}
	}
	

	public float calcular(float a,float b,int xN)
	{
		float H=0;
		H=(b-a)/xN;
		
		float[] vector=new float[xN+1];
		vector[0]=F(a);
		vector[xN]=F(b);
		
		float ant=0;
		for(int i=1;i<xN;i++)
		{
			ant=ant+H;
			vector[i]=F(ant)*2;
		}
		
		float resul=0;
		for(int i=1;i<xN;i++)
		{
			resul+=vector[i];
		}
		
		resul+=vector[0]+vector[xN];
		resul=resul/(2*xN);
		resul=resul*(b-a);
		
		return resul;
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
