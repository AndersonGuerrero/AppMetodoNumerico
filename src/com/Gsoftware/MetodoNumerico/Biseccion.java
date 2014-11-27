package com.Gsoftware.MetodoNumerico;



import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
public class Biseccion extends Activity 
{
	

EditText txtXa,txtXb,txtError,txtFuncion;
TextView txtresp;
float Xa,Xb,E;
String Funcion="";
Evaluador e;
	protected void onCreate(Bundle savedInstanceState) {
		
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		
		 e=new Evaluador(); 
		this.txtXa=(EditText) findViewById(R.id.ValorXa);
		this.txtXb=(EditText) findViewById(R.id.valorXb);
		this.txtError=(EditText) findViewById(R.id.ValorError);
		this.txtFuncion=(EditText) findViewById(R.id.ValorFuncion);
		this.txtresp=(TextView) findViewById(R.id.txtResultado);
	
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		
		return super.onCreateOptionsMenu(menu);
	}



	public void Entrada(View view)
	{
		
		if(this.txtFuncion.getText().toString().length()>0 && this.txtXa.getText().toString().length()>0 && this.txtXb.getText().toString().length()>0 && this.txtError.getText().toString().length()>0 )
		{
			Xa=Float.parseFloat(txtXa.getText().toString());
			Xb=Float.parseFloat(txtXb.getText().toString());
			E=Float.parseFloat(txtError.getText().toString());
			Funcion=txtFuncion.getText().toString();

				txtresp.setText(Calculo(Xa, Xb, E));
		}
		
	}




public String Calculo(float xa,float xb,float MinimoError)
{
	//Funcion
    //               e^-x*lnx  
	// 
	
	float xn=0;
	float FXa=0;
	float FXn=0;
	float error=0;
	String Salida="*********** Funcion ***********\n";
	
	for(int i=1;i<=100;i++)
	{
 
		Salida+="\n\n  ......... "+i+" Iteracion ..........\n\n";
		
		
		
		
		Salida+="|xa="+xa+"|    |xb="+xb+"|";
		
		xn=(xa+xb)/2;
		Salida+="     |xn="+xn+"|        ";
		
		
		FXn=Funcion(xn);
		
		Salida+="| F(xn)="+FXn+"| \n";
		
		
		
		FXa=Funcion(xa);
		
		Salida+="| F(xa)="+FXa+"|  \n";
		
		
		
		if((FXa*FXn)<0)
		{
			xb=xn;
			Salida+="La raiz se encuentra entre ["+xa+","+xb+"]\n";
			
		}else
		{
			xa=xn;
			Salida+="La raiz se encuentra entre ["+xa+","+xb+"]\n";
		}
		
		if(i>=2){
			error=Math.abs((xa-xb)/xa);
			Salida+="El error cometido es: "+error;
			if(error<=MinimoError)
			{
			break;	
			}
		}

		Salida+="\n";
		
	}
	
	return Salida;
}




public  float Funcion(float x)
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
