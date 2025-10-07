package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interfaces.IASTblock.IASTbinding;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.Invocable;

public class CountConstants implements IASTvisitor<Integer, Void, EvaluationException> {
	
	public int visit(IASTprogram iast, Void data) throws EvaluationException {
        try {
            return iast.getBody().accept(this, null);
        } catch (Exception exc) {
        	exc.printStackTrace();
            return 0;
        }
    }
	
	@Override
	public Integer visit(IASTalternative iast, Void data) throws EvaluationException {
        return iast.getCondition().accept(this, null) 
        		+ iast.getConsequence().accept(this, null) 
        		+ iast.getAlternant().accept(this, null);
	}

	@Override
	public Integer visit(IASTbinaryOperation iast, Void data) throws EvaluationException {
		Integer leftOperand = iast.getLeftOperand().accept(this, null);
		Integer rightOperand = iast.getRightOperand().accept(this, null);
        return leftOperand + rightOperand;
	}

	@Override
	public Integer visit(IASTblock iast, Void data) throws EvaluationException {
		int res = 0;
        for ( IASTbinding binding : iast.getBindings() ) {
            res += binding.getInitialisation().accept(this, null);
        }
        return res;
	}

	@Override
	public Integer visit(IASTboolean iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTfloat iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTinteger iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTinvocation iast, Void data) throws EvaluationException {
		Object function = iast.getFunction().accept(this, null);
        if ( function instanceof Invocable ) {
            int res = 0;
            for ( IASTexpression arg : iast.getArguments() ) {
                res += arg.accept(this, null);
            }
            return res;
        } else {
            return 0;
        }
	}

	@Override
	public Integer visit(IASTsequence iast, Void data) throws EvaluationException {
		IASTexpression[] expressions = iast.getExpressions();
        int res = 0;
        for ( IASTexpression e : expressions ) {
            res += e.accept(this, null);
        }
        return res;
	}

	@Override
	public Integer visit(IASTstring iast, Void data) throws EvaluationException {
		return 1;
	}

	@Override
	public Integer visit(IASTunaryOperation iast, Void data) throws EvaluationException {
		Integer operand = iast.getOperand().accept(this, null);
        return operand;
	}

	@Override
	public Integer visit(IASTvariable iast, Void data) throws EvaluationException {
		return 0;
	}
	
	
}
