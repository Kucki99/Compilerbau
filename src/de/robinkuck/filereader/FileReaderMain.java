package de.robinkuck.filereader;

public class FileReaderMain {

	public static void main(String[] args) throws Exception {
		System.err.println("BEGIN");
		FileReaderTest test = new FileReaderTest("fileReader.txt");
		test.testRun();
		System.err.println("END");
	}

}
