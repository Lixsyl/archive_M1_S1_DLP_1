package com.paracamplus.ilp1.ilp1tme1;

import java.io.File;

import com.paracamplus.ilp1.compiler.test.CompilerRunner;
import com.paracamplus.ilp1.compiler.test.CompilerTest;

public class FileCompiler extends CompilerTest {
	public static void main (String[] args) {
		File fichier = new File(args[0]);
		try {
			CompilerRunner run = createRunner();
	    	run.checkPrintingAndResult(fichier, run.compileAndRun(fichier));	
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	};
}
