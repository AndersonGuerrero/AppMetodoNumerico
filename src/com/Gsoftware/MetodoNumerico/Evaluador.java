package com.Gsoftware.MetodoNumerico;

import org.nfunk.jep.JEP;

public class Evaluador {
	private JEP jep; 	
	public Evaluador(){ 
	jep=new JEP(); 
    jep.addStandardConstants(); 
	jep.addStandardFunctions(); 
	jep.setImplicitMul(true); 
	} 
	public double eval(String expresion){ 
	jep.parseExpression(expresion); 
	return jep.getValue(); 
	} 
}
