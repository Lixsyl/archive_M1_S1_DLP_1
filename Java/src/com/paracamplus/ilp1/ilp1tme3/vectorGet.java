package com.paracamplus.ilp1.ilp1tme3;

import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class vectorGet extends BinaryPrimitive {
	
	public vectorGet() {
        super("vectorGet");
    }

    @Override
	public Object apply (Object vecteur, Object index) throws EvaluationException {  
    	
    	if (vecteur instanceof Object[] && index instanceof BigInteger) {
    		return ((Object[])vecteur)[((BigInteger)index).intValue()];
    	} else {
    		throw new EvaluationException("arguments invalides : object[] et int") ;
    	}
    }
}
