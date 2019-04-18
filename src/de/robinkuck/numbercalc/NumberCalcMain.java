package de.robinkuck.numbercalc;

public class NumberCalcMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		NumberCalcTest test = new NumberCalcTest("numberCalc.txt");
		test.testRun();
		System.err.println("END");
	}

}

