package de.robinkuck.numberreader;

import de.robinkuck.filereader.FileReader;
import de.robinkuck.filereader.FileReaderIntf;

import java.io.InputStream;

public class NumberReaderTest extends TestBase {

	public NumberReaderTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		String output = new String();
		NumberReaderIntf numberReader = new NumberReader(fileReader);
		int number = numberReader.getNumber();
		output += Integer.toString(number);
		output += '\n';
		return output;
	}
}
