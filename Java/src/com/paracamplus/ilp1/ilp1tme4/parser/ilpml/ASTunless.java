package com.paracamplus.ilp1.ilp1tme4.parser.ilpml;

import com.paracamplus.ilp1.ast.ASTexpression;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitor;

public class ASTunless extends ASTexpression implements IASTunless {

	public ASTunless (IASTexpression body, IASTexpression condition) {
		this.body = body;
		this.condition = condition;
	}
	private final IASTexpression body;
	private final IASTexpression condition;
	
	@Override
	public <Result, Data, Anomaly extends Throwable> Result accept(IASTvisitor<Result, Data, Anomaly> visitor,
			Data data) throws Anomaly {
		/*return visitor.visit(this, data);*/
		return null;
	}

	@Override
	public IASTexpression getBody() {
		return body;
	}

	@Override
	public IASTexpression getCondition() {
		return condition;
	}

}
