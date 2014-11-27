package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class NewtonRaphson extends Activity
{
	
	EditText txtX,txtError,txtFuncion,txtFuncionD;
	TextView txtresp;
	float X=0,E=0;
	String Funcion="",FuncionD="";
	Evaluador ee1,ee2;
	
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_newtonraphson);
		
		 ee1=new Evaluador(); 
		 ee2=new Evaluador(); 
		 
		this.txtX=(EditText) findViewById(R.id.valorX);
		this.txtError=(EditText) findViewById(R.id.ValorE);
		
		this.txtFuncion=(EditText) findViewById(R.id.ValorFuncionnewton);
		this.txtFuncionD=(EditText) findViewById(R.id.valorFuncionD);
		this.txtresp=(TextView) findViewById(R.id.txtresultNewton);
	
	}
	
	
	public void EntradaNewton(View view)
	{
		if(this.txtX.getText().toString().length()>0 && this.txtFuncion.getText().toString().length()>0 && this.txtError.getText().toString().length()>0 && this.txtFuncionD.getText().toString().length()>0 )
		{
			this.X=Float.parseFloat(txtX.getText().toString());
			this.E=Float.parseFloat(txtError.getText().toString());
			this.Funcion=txtFuncion.getText().toString();
			this.FuncionD=txtFuncionD.getText().toString();

			this.txtresp.setText(Calculos(X, E));
		}
		
	}
	
	
	public String Calculos(float x,float errordado)
	{
		int cont=0;
		String salida=" ";
		float error=100; 
		float x1=0;
		
		
		if(evalD(x)==0 || (evalD(x)<0.5 && evalD(x)>0.1))
		{
			salida=" No tiene Solucion por este Metodo o No es Factible";
		}else{
		while(true)
		{
			cont++;
			x1=x-(evalF(x)/evalD(x));
	        salida+="\n \nIteccion "+cont+"\n";
	        salida+="x0="+x+"\n"; 
	        salida+="F(x)="+evalF(x)+"\n";
	        salida+="F'(x)"+evalD(x)+"\n";
	        salida+="x1="+x1+"\n";
	        if(cont>1)
	        {
	        error=Math.abs(x1-x);
	        salida+="Error Absoluto="+error+"\n";
	       
	        error=Math.abs(((x1-x)/x1));
	        salida+="Error="+error+"\n";
	        
	        if(error<errordado)
	        {
	        	break;
	        }
	        }
	        x=x1;   
		}
		}
		return salida;
	}

	public float evalD(float x)
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
	     return (float)ee2.eval(f);
	}
	
	public float evalF(float x)
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
	     return (float)ee2.eval(f);
	}
}
