package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTalternative;
import com.paracamplus.ilp1.interfaces.IASTbinaryOperation;
import com.paracamplus.ilp1.interfaces.IASTblock;
import com.paracamplus.ilp1.interfaces.IASTboolean;
import com.paracamplus.ilp1.interfaces.IASTfloat;
import com.paracamplus.ilp1.interfaces.IASTinteger;
import com.paracamplus.ilp1.interfaces.IASTinvocation;
import com.paracamplus.ilp1.interfaces.IASTsequence;
import com.paracamplus.ilp1.interfaces.IASTstring;
import com.paracamplus.ilp1.interfaces.IASTunaryOperation;
import com.paracamplus.ilp1.interfaces.IASTvariable;
import com.paracamplus.ilp1.interfaces.IASTvisitor;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;

public class CountConstants implements IASTvisitor<Integer, ILexicalEnvironment, EvaluationException> {

	private int count = 0;

	@Override
	public Integer visit(IASTalternative iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTbinaryOperation iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTblock iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTboolean iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTfloat iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTinteger iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTinvocation iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTsequence iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTstring iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTunaryOperation iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Integer visit(IASTvariable iast, ILexicalEnvironment data) throws EvaluationException {
		// TODO Auto-generated method stub
		return null;
	}
	
}
