/* *****************************************************************
 * ILP9 - Implantation d'un langage de programmation.
 * by Christian.Queinnec@paracamplus.com
 * See http://mooc.paracamplus.com/ilp9
 * GPL version 3
 ***************************************************************** */
package com.paracamplus.ilp1.ilp1tme4.parser.ilpml;

import com.paracamplus.ilp1.interpreter.Interpreter;
import com.paracamplus.ilp1.interpreter.interfaces.EvaluationException;
import com.paracamplus.ilp1.interpreter.interfaces.IGlobalVariableEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.ILexicalEnvironment;
import com.paracamplus.ilp1.interpreter.interfaces.IOperatorEnvironment;

public class Interpretertme4 extends Interpreter implements IASTvisitortme4<Object, ILexicalEnvironment, EvaluationException>{
    
    public Interpretertme4 (IGlobalVariableEnvironment globalVariableEnvironment,
                        IOperatorEnvironment operatorEnvironment ) {
        super(globalVariableEnvironment, operatorEnvironment);
    }

    private static Object whatever = "whatever";
    
    @Override
    public Object visit(IASTunless iast, ILexicalEnvironment lexenv) throws EvaluationException {
        Object c = iast.getCondition().accept(this, lexenv);
        if ( c != null && c instanceof Boolean ) {
            Boolean b = (Boolean) c;
            if ( b.booleanValue() ) {
                return iast.getBody().accept(this, lexenv);
            } else {
                return whatever;
            }
        } else {
            return iast.getBody().accept(this, lexenv);
        }
    }

}
