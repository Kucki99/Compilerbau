package de.robinkuck.filereader;

public interface FileReaderIntf {
	// constructs FileReader reading from inputStream
	// public FileReader(InputStream inputStream) throws Exception;

	// look at the current character without
	// consuming it. 0 means EOF.
	char lookAheadChar();
	
	// consume current char and
	// advance to next character
	void advance() throws Exception;
	
	// check if next char is the expected character
	// throw Exception if not	
	void expect(char c) throws Exception;
}