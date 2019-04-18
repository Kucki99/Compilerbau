package de.robinkuck.numberreader;

public class NumberReaderMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		NumberReaderTest test = new NumberReaderTest("numberReader.txt");
		test.testRun();
		System.err.println("END");
	}

}

