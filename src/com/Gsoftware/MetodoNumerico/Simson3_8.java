package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Simson3_8 extends Activity 
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
			setContentView(R.layout.simson3_8);
			 e=new Evaluador(); 
				this.txtA=(EditText) findViewById(R.id.simson3_8_A);
				this.txtB=(EditText) findViewById(R.id.simson3_8_B);
				this.txtN=(EditText) findViewById(R.id.simson3_8_N);
				this.txtFuncion=(EditText) findViewById(R.id.simson3_8_funcion);
				this.txtresp=(TextView) findViewById(R.id.simson3_8_resul);
	}
	
	public void Entradx(View view)
	{
		
		if(this.txtFuncion.getText().toString().length()>0 && this.txtA.getText().toString().length()>0 && this.txtB.getText().toString().length()>0 && this.txtN.getText().toString().length()>0 )
		{
			a=Float.parseFloat(txtA.getText().toString());
			b=Float.parseFloat(txtB.getText().toString());
			n=Integer.parseInt(txtN.getText().toString());
			Funcion=txtFuncion.getText().toString();
			txtresp.setText("Resultado:\n"+calcular(a,b,n));	
		}
	}
	
	public float calcular(float a,float b,int n)
	{	
		float xs[]=new float[(int)b];
		xs[0]=a;
		xs[(int)b-1]=b;
		float resp=0;
		resp+=F(xs[0]);
		for(int i=1;i<xs.length-1;i++)
		{
			xs[i]=a+i;
		   resp+=F(xs[i])*n;
		}
		resp+=F(xs[(int)b-1]);
		resp=resp/8;
		resp=resp*(b-a);
		return resp;
	}
	
	
	
	public  float F(float x)
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
