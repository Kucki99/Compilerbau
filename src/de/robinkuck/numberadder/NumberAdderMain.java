package de.robinkuck.numberadder;

public class NumberAdderMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		NumberAdderTest test = new NumberAdderTest("numberAdder.txt");
		test.testRun();
		System.err.println("END");
	}

}

