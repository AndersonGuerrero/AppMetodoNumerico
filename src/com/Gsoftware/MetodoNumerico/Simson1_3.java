package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Simson1_3 extends Activity
{
	EditText txtA,txtB,txtFuncion;
	TextView txtresp;
	float a,b;
	String Funcion="";
	Evaluador e;

	
	protected void onCreate(Bundle savedInstanceState)
	{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.simson1_3);
			 e=new Evaluador(); 
				this.txtA=(EditText) findViewById(R.id.simson1_3_A);
				this.txtB=(EditText) findViewById(R.id.simson1_3_B);
				this.txtFuncion=(EditText) findViewById(R.id.simson1_3_funcion);
				this.txtresp=(TextView) findViewById(R.id.simson1_3_resp);
	}
	
	public void Entrad(View view)
	{
		
		if(this.txtFuncion.getText().toString().length()>0 && this.txtA.getText().toString().length()>0 && this.txtB.getText().toString().length()>0 )
		{
			a=Float.parseFloat(txtA.getText().toString());
			b=Float.parseFloat(txtB.getText().toString());
			Funcion=txtFuncion.getText().toString();
			txtresp.setText("Resultado:\n"+calcular(a,b));	
		}
	}
	

	public float calcular(float a,float b)
	{
		float H=(b+a)/2;
		float resp=F(a)+(4*F(H))+F(b);
		resp=resp/6;
		resp=resp*(b-a);
		return resp;
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
