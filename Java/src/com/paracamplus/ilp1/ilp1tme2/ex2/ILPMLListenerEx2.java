package com.paracamplus.ilp1.ilp1tme2.ex2;

import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.parser.ilpml.ILPMLListener;

import antlr4.ILPMLgrammar1Parser.ConstFalseContext;
import antlr4.ILPMLgrammar1Parser.ConstFloatContext;
import antlr4.ILPMLgrammar1Parser.ConstIntegerContext;
import antlr4.ILPMLgrammar1Parser.ConstStringContext;
import antlr4.ILPMLgrammar1Parser.ConstTrueContext;


/**
 * Cette classe décrit à ANTRL comment construire un AST.
 * C'est un Listener : à chaque pas de l'analyse syntaxique, ANTRL
 * appelle cette classe, qui crée un ASTNode correspondant à ce qui
 * a été reconnu. 
 * Un Listener ne peut pas renvoyer de valeur, nous utilisons donc des
 * champs du contexte ctx pour transferer l'information d'une règle
 * de grammaire à l'autre.
 * 
 */
public class ILPMLListenerEx2 extends ILPMLListener {
	
	protected int compte = 0;
	
	public ILPMLListenerEx2(IASTfactory factory) {
		super(factory);
	}

	@Override
	public void exitConstFloat(ConstFloatContext ctx) {
		super.exitConstFloat(ctx);
		compte += 1;
	}

	@Override
	public void exitConstInteger(ConstIntegerContext ctx) {
		super.exitConstInteger(ctx);
		compte += 1;
	}

	@Override
	public void exitConstFalse(ConstFalseContext ctx) {
		super.exitConstFalse(ctx);
		compte += 1;
		
	}

	@Override
	public void exitConstTrue(ConstTrueContext ctx) {
		super.exitConstTrue(ctx);
		compte += 1;
	}

	@Override
	public void exitConstString(ConstStringContext ctx) {
		super.exitConstString(ctx);
		compte += 1;
	}
	
	
}
