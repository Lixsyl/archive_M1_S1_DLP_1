package com.paracamplus.ilp1.ilp1tme4.parser.ilpml;

import com.paracamplus.ilp1.interfaces.IASTexpression;

public interface IASTunless extends IASTexpression {
	IASTexpression getBody();
	IASTexpression getCondition();
}








