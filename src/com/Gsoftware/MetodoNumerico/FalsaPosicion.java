package com.Gsoftware.MetodoNumerico;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class FalsaPosicion extends Activity
{
EditText txtX0,txtX1,txtError,txtFuncion;
TextView txtresp;
float X0,X1,E;
String Funcion="";
Evaluador e;

protected void onCreate(Bundle savedInstanceState)
{
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_falsaposicion);
		 e=new Evaluador(); 
			this.txtX0=(EditText) findViewById(R.id.ValorX0Falsaposicion);
			this.txtX1=(EditText) findViewById(R.id.ValorX1Falsaposicion);
			this.txtError=(EditText) findViewById(R.id.ValorEFalsaposicion);
			this.txtFuncion=(EditText) findViewById(R.id.ValorFuncionFalsaposicion);
			this.txtresp=(TextView) findViewById(R.id.txtResultFalsaposicion);
}



public void Entrada(View view)
{
	
	if(this.txtFuncion.getText().toString().length()>0 && this.txtX0.getText().toString().length()>0 && this.txtX1.getText().toString().length()>0 && this.txtError.getText().toString().length()>0 )
	{
		X0=Float.parseFloat(txtX0.getText().toString());
		X1=Float.parseFloat(txtX1.getText().toString());
		E=Float.parseFloat(txtError.getText().toString());
		Funcion=txtFuncion.getText().toString();
		txtresp.setText(Calculo(X0, X1, E));	
	}
}
	


public String Calculo(float x0,float x1,float Error)
{
	float x2=0;
	int cont=0;
	float e=0;
	String salida="********************************";
	while(true)
	{
		cont++;
		x2=x1-((x1-x0)/(Funcion(x1)-Funcion(x0)))*Funcion(x0);
		
		salida+="\n\n   "+cont+" Iteraccion\n";
		
		salida+="X0="+x0+"\n";
		salida+="X1="+x1+"\n";
		salida+="F(X0)="+Funcion(x0)+"\n";
		salida+="F(X1)="+Funcion(x1)+"\n";
		salida+="X2="+x2+"\n";
		
		
		if(cont>1){
			e=Math.abs(x2-x1);
			salida+="Error Absoluto="+e+"\n";
			e=Math.abs(((x2-x1)/x2));
			salida+="Error="+e+"\n";
			if(e<=Error){
				salida+="La raiz Buscada es: "+x2+" +- "+e;
				break;
				}
		}
		
		x0=x1;
		x1=x2;
		
	}
	
	return salida;
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
