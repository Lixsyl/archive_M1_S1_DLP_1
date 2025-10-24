package com.paracamplus.ilp1.ilp1tme4.parser.ilpml;

import com.paracamplus.ilp1.ast.ASTfactory;
import com.paracamplus.ilp1.interfaces.IASTexpression;

public class ASTfactorytme4 extends ASTfactory implements IASTfactorytme4 {
	
	@Override
	public IASTunless newUnless(IASTexpression body, IASTexpression condition) {
		return new ASTunless(body, condition);
	}

}
