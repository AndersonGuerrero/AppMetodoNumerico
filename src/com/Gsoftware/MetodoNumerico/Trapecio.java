package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Trapecio extends Activity {
	
	EditText txtA,txtB,txtFuncion;
	TextView txtresp;
	float a,b;
	String Funcion="";
	Evaluador e;

	
	protected void onCreate(Bundle savedInstanceState)
	{
			super.onCreate(savedInstanceState);
			setContentView(R.layout.trapecio);
			 e=new Evaluador(); 
				this.txtA=(EditText) findViewById(R.id.trapecio_A);
				this.txtB=(EditText) findViewById(R.id.trapecio_B);
				this.txtFuncion=(EditText) findViewById(R.id.trapecio_F);
				this.txtresp=(TextView) findViewById(R.id.trapecio_resp);
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
		float resp=(b-a)*((F(a)+F(b))/2);
		
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
