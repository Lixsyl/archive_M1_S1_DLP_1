package com.paracamplus.ilp1.ilp1tme3;

import java.math.BigDecimal;
import java.math.BigInteger;

import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.primitive.UnaryPrimitive;

public class Sinus extends UnaryPrimitive{
	
	public Sinus() {
        super("sinus");
    }

    @Override
	public Object apply (Object value) throws EvaluationException {  
    	if (value instanceof BigInteger) {
    		double val = ((BigInteger)value).doubleValue();
    		return Math.sin(Math.toRadians(val));
    	} else if (value instanceof BigDecimal) {
    		double val = ((BigDecimal)value).doubleValue();
    		return Math.sin(Math.toRadians(val));
    	} else {
    		throw new EvaluationException("arguments invalides : int/float") ;
    	}
    }
}
