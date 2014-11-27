package com.Gsoftware.MetodoNumerico;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.ListActivity;
import android.content.Intent;

public class MainActivity extends ListActivity {

	String vector[]={"Biseccion","NewtonRaphson","Secante","FalsaPosicion","Lagrange","Trapecio","Trapecio_subdividido","Simson1_3","Simson1_3_Sub","Simson3_8"};
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setListAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,vector));
	}

	
	
	protected void onListItemClick(ListView l, View v, int position, long id) {
	
		super.onListItemClick(l, v, position, id);
		
        String nombre_clase=vector[position];
        
        try{
        Class<?> clazz= Class.forName("com.Gsoftware.MetodoNumerico."+nombre_clase);
        
        Intent inten=new Intent(this,clazz);
        startActivity(inten);
        }catch(Exception e){}
		
	}

	

}
