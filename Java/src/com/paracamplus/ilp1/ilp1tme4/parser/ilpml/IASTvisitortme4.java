package com.paracamplus.ilp1.ilp1tme4.parser.ilpml;

import com.paracamplus.ilp1.interfaces.IASTvisitor;

public interface IASTvisitortme4<Result, Data, Anomaly extends Throwable> extends IASTvisitor<Result, Data, Anomaly>{
	Result visit(IASTunless iast, Data data) throws Anomaly;
}
