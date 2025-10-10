package com.paracamplus.ilp1.ilp1tme3;

import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class vectorLength extends UnaryPrimitive{
	
	public vectorLength() {
        super("vectorLength");
    }

    @Override
	public Object apply (Object vecteur) throws EvaluationException {  
    	if (vecteur instanceof Object[]) {
    		return BigInteger.valueOf(((Object[])vecteur).length);
    	} else {
    		throw new EvaluationException ("argument invalide : vecteur");
    	}
    }
}