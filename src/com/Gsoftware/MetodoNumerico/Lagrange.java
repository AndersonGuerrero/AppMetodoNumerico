package com.Gsoftware.MetodoNumerico;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class Lagrange extends Activity {
EditText txtX,txtY,txtFuncion;
TextView txtresp;
float funcion;
 String Xs,Ys;
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lagrange);
		this.txtX=(EditText) findViewById(R.id.lagrangeXs);
		this.txtY=(EditText) findViewById(R.id.lagrangeYs);
		this.txtFuncion=(EditText) findViewById(R.id.lagrangeF);
		this.txtresp=(TextView) findViewById(R.id.lagrangeresult);
	}


	public boolean onCreateOptionsMenu(Menu menu) {
		
		return super.onCreateOptionsMenu(menu);
	}

	public void Entrada(View view)
	{
		if(this.txtFuncion.getText().toString().length()>0 && this.txtX.getText().toString().length()>0 && this.txtY.getText().toString().length()>0)
		{
			Xs=txtX.getText().toString();
			Ys=txtY.getText().toString();
			funcion=Float.parseFloat(txtFuncion.getText().toString());
			txtresp.setText(Calculo(Xs, Ys, funcion));
		}	
	}


public String Calculo(String Xs,String Ys,float F)
{	
	int grado=0;
	String salida="";
	String[] listaX=Xs.split(",");
	String[] listaY=Ys.split(",");
	grado=listaX.length;

	if((listaX.length==listaY.length) && grado>1)
	{
		float vectorX[]=new float[grado];
	    float vectorY[]=new float[grado];
		
		for(int x=0;x<listaX.length;x++)
		{
			vectorX[x]=Float.parseFloat(listaX[x]);
			vectorY[x]=Float.parseFloat(listaY[x]);	
		}	
    float X=F;
    float PX=0;
    float L[]=new float[vectorX.length]; 	
  
    float resul1=1;
    float resul2=1;
    
    
    for(int l=0;l<grado;l++)
    {
for(int i=0;i<grado;i++)
{
 if(l!=i)
 {
	 resul1*=(X-vectorX[i]);	
	 resul2*=(vectorX[l]-vectorX[i]); 
 } 
}
L[l]=resul1/resul2;
resul1=1;
resul2=1;

}   
    for(int j=0;j<grado;j++)
    {
    	  PX+=(L[j]*vectorY[j]);
    } 
    for(int i=0;i<grado;i++)
    {
    	salida+="L"+i+": "+L[i]+"\n";
    }
    salida+="P("+X+")="+PX;
}  
return salida;

}
}
