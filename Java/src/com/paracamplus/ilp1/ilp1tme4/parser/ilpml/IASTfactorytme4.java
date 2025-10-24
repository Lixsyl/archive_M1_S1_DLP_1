package com.paracamplus.ilp1.ilp1tme4.parser.ilpml;

import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfactory;

public interface IASTfactorytme4 extends IASTfactory {
	
	IASTexpression newUnless(IASTexpression body, IASTexpression condition);
	
}
