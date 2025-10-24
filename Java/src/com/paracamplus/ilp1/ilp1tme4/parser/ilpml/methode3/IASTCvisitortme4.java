package com.paracamplus.ilp1.ilp1tme4.parser.ilpml.methode3;

import com.paracamplus.ilp1.compiler.interfaces.IASTCvisitor;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTunless;

public interface IASTCvisitortme4<Result, Data, Anomaly extends Throwable> extends IASTCvisitor<Result, Data, Anomaly>{
	Result visit(IASTunless iast, Data data) throws Anomaly;
}
