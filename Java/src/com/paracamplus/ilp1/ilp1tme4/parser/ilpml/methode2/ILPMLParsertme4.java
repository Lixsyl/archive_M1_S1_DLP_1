package com.paracamplus.ilp1.ilp1tme4.parser.ilpml.methode2;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import antlr4.ILPMLgrammar1tme4Lexer;
import antlr4.ILPMLgrammar1tme4Parser;

import com.paracamplus.ilp1.compiler.normalizer.INormalizationFactory;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.ASTfactorytme4;
import com.paracamplus.ilp1.ilp1tme4.parser.ilpml.IASTfactorytme4;
import com.paracamplus.ilp1.interfaces.IASTfactory;
import com.paracamplus.ilp1.interfaces.IASTprogram;
import com.paracamplus.ilp1.parser.ParseException;
import com.paracamplus.ilp1.parser.ilpml.ILPMLParser;

public class ILPMLParsertme4 extends ILPMLParser{
	
	public ILPMLParsertme4(IASTfactory factory) {
		super(factory);
	}

	@Override
	public IASTprogram getProgram() throws ParseException {
		try {
			ANTLRInputStream in = new ANTLRInputStream(input.getText());
			// flux de caractères -> analyseur lexical
			ILPMLgrammar1tme4Lexer lexer = new ILPMLgrammar1tme4Lexer(in);
			// analyseur lexical -> flux de tokens
			CommonTokenStream tokens =	new CommonTokenStream(lexer);
			// flux tokens -> analyseur syntaxique
			ILPMLgrammar1tme4Parser parser =	new ILPMLgrammar1tme4Parser(tokens);
			// démarage de l'analyse syntaxique
			ILPMLgrammar1tme4Parser.ProgContext tree = parser.prog();		
			// parcours de l'arbre syntaxique et appels du Listener
			ParseTreeWalker walker = new ParseTreeWalker();
			ILPMLListener extractor = new ILPMLListener(factory);
			walker.walk(extractor, tree);
			VisitorMethode2 visitmeth = new VisitorMethode2((IASTfactorytme4)factory);
			return (IASTprogram)visitmeth.visit(tree.node, null);
		} catch (Exception e) {
			throw new ParseException(e);
		}
		
	}

}
