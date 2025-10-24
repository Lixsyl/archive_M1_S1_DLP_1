package com.paracamplus.ilp1.ilp1tme4.parser.ilpml.methode3;

import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp1.compiler.normalizer.Normalizer;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.ASTunless;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTunless;
import com.paracamplus.ilp1.interfaces.IASTexpression;
import com.paracamplus.ilp1.interfaces.IASTvisitor;

public class Normalizertme4 extends Normalizer implements IASTvisitor<IASTexpression, INormalizationEnvironment, CompilationException>{

	public Normalizertme4(INormalizationFactory factory) {
		super(factory);
	}
	
	public IASTexpression visit(IASTunless iast, INormalizationEnvironment env) throws CompilationException {
        IASTexpression b = iast.getBody().accept(this, env);
        IASTexpression c = iast.getCondition().accept(this, env);
        return (IASTexpression)(new ASTunless(b, c));
    }
}
