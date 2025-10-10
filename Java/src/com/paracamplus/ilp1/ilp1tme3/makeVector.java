package com.paracamplus.ilp1.ilp1tme3;

import java.math.BigInteger;
import java.util.Arrays;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;

public class makeVector extends BinaryPrimitive {
	
	public makeVector() {
        super("makeVector");
    }

    @Override
	public Object apply (Object taille, Object valeur) throws EvaluationException {  
    	
    	if (taille instanceof BigInteger) {
	    	Object[] vect = new Object[((BigInteger)taille).intValue()];
	    	Arrays.fill(vect, valeur);
	    	/*return Arrays.toString(vect);*/
	    	return vect;
    	} else {
    		throw new EvaluationException("arguments invalides : 1er argument taille doit etre int") ;
    	}
    }
}
