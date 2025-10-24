package com.paracamplus.ilp1.ilp1tme4.parser.ilpml.methode2;

import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTfactorytme4;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTunless;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTvisitortme4;
import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASToperator;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;

public class VisitorMethode2 implements IASTvisitortme4<IASTexpression, Void, EvaluationException> {

	public VisitorMethode2 (IASTfactorytme4 factory) {
	        this.factory = factory;
	    }
	protected final IASTfactorytme4 factory;
	
	public Object visit(IASTprogram iast, Void data) throws EvaluationException {
        try {
            return iast.getBody().accept(this, null);
        } catch (Exception exc) {
            return exc;
        }
    }
	
	@Override
	public IASTexpression visit(IASTalternative iast, Void data) throws EvaluationException {
		IASTexpression c = iast.getCondition().accept(this, null);
        IASTexpression t = iast.getConsequence().accept(this, null);
        if ( iast.isTernary() ) {
            IASTexpression a = iast.getAlternant().accept(this, null);
            return factory.newAlternative(c, t, a);
        } else {
            IASTexpression whatever = factory.newBooleanConstant("false");
            return factory.newAlternative(c, t, whatever);
        }
	}

	@Override
	public IASTexpression visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
		IASToperator operator = iast.getOperator();
        IASTexpression left = iast.getLeftOperand().accept(this, null);
        IASTexpression right = iast.getRightOperand().accept(this, null);
        return factory.newBinaryOperation(operator, left, right);
	}

	@Override
	public IASTexpression visit(IASTblock iast, Void data) throws EvaluationException {
		return iast;
	}

	@Override
	public IASTexpression visit(IASTboolean iast, Void data) throws EvaluationException {
		return iast;
	}

	@Override
	public IASTexpression visit(IASTfloat iast, Void data) throws EvaluationException {
		return iast;
	}

	@Override
	public IASTexpression visit(IASTinteger iast, Void data) throws EvaluationException {
		return iast;
	}

	@Override
	public IASTexpression visit(IASTinvocation iast, Void data) throws EvaluationException {
		IASTexpression funexpr = iast.getFunction().accept(this, null);
    	IASTexpression[] arguments = iast.getArguments();
    	IASTexpression[] args = new IASTexpression[arguments.length];
    	for ( int i=0 ; i<arguments.length ; i++ ) {
    		IASTexpression argument = arguments[i];
    		IASTexpression arg = argument.accept(this, null);
    		args[i] = arg;
    	}
    	return factory.newInvocation(funexpr, args);
	}

	@Override
	public IASTexpression visit(IASTsequence iast, Void data) throws EvaluationException {
		IASTexpression[] expressions = iast.getExpressions();
        IASTexpression[] exprs = new IASTexpression[expressions.length];
        for ( int i=0 ; i< expressions.length ; i++ ) {
            exprs[i] = expressions[i].accept(this, null);
        }
        if ( iast.getExpressions().length == 1 ) {
            return exprs[0];
        } else {
            return factory.newSequence(exprs);
        }
	}

	@Override
	public IASTexpression visit(IASTstring iast, Void data) throws EvaluationException {
		return iast;
	}

	@Override
	public IASTexpression visit(IASTunaryOperation iast, Void data) throws EvaluationException {
		IASToperator operator = iast.getOperator();
        IASTexpression operand = iast.getOperand().accept(this, null);
        return factory.newUnaryOperation(operator, operand);
	}

	@Override
	public IASTexpression visit(IASTvariable iast, Void data) throws EvaluationException {
		return iast;
	}

	@Override
	public IASTexpression visit(IASTunless iast, Void data) throws EvaluationException {
        IASTexpression b = iast.getBody().accept(this, null);
		IASTexpression c = iast.getCondition().accept(this, null);
        IASTexpression whatever = factory.newBooleanConstant("false");

        if ( c != null && c instanceof IASTboolean ) {
        	Boolean cc = ((IASTboolean)c).getValue();
        	IASTexpression ccc;
        	if (cc) {
            	ccc = factory.newBooleanConstant("false");
        	} else {
            	ccc = factory.newBooleanConstant("true");
        	}
        	return factory.newAlternative(ccc, b, whatever);
        } else {
        	throw new EvaluationException("condition not boolean");
        }
	}

}
