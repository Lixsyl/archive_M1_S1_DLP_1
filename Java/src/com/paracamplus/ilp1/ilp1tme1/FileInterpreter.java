package com.paracamplus.ilp1.ilp1tme1;

import java.io.File;

import com.paracamplus.ilp1.interpreter.test.InterpreterRunner;
import com.paracamplus.ilp1.interpreter.test.InterpreterTest;

public class FileInterpreter extends InterpreterTest {
	
	public static void main (String[] args) {
		File fichier = new File(args[0]);
		try {
			InterpreterRunner run = createRunner();
	       	run.testFile(fichier);
	    	run.checkPrintingAndResult(fichier);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	};
}
