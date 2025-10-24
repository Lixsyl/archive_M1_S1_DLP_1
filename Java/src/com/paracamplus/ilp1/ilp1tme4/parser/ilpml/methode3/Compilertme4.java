package com.paracamplus.ilp1.ilp1tme4.parser.ilpml.methode3;

import com.paracamplus.ilp1.compiler.AssignDestination;
import com.paracamplus.ilp1.compiler.CompilationException;
import com.paracamplus.ilp1.compiler.Compiler;
import com.paracamplus.ilp1.compiler.interfaces.IASTCprogram;
import com.paracamplus.ilp1.compiler.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.compiler.interfaces.IOperatorEnvironment;
import com.paracamplus.ilp1.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp1.compiler.normalizer.NormalizationFactory;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTunless;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.interfaces.IASTvariable;

public class Compilertme4 extends Compiler implements IASTCvisitortme4<Void, Compiler.Context, CompilationException> {

	public Compilertme4(IOperatorEnvironment ioe, IGlobalVariableEnvironment igve) {
		super(ioe, igve);
	}

	@Override
	public IASTCprogram normalize(IASTprogram program) 
            throws CompilationException {
        INormalizationFactory nf = new NormalizationFactory();
        Normalizertme4 normalizer = new Normalizertme4(nf);
        IASTCprogram newprogram = normalizer.transform(program);
        return newprogram;
    }

	@Override
	public Void visit(IASTunless iast, Context context) throws CompilationException {
		IASTvariable tmp1 = context.newTemporaryVariable();
		emit("{ \n");
        emit("  ILP_Object " + tmp1.getMangledName() + "; \n");
        Context c = context.redirect(new AssignDestination(tmp1));
        iast.getCondition().accept(this, c);
        emit("  if (! ILP_isEquivalentToTrue(");
        emit(tmp1.getMangledName());
        emit(" ) ) {\n");
        iast.getBody().accept(this, context);
        emit("\n  }\n}\n");
        return null;
	}
}
