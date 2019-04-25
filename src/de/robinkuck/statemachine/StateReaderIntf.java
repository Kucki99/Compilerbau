package de.robinkuck.statemachine;

public interface StateReaderIntf {

    // creates a StateReader for a given FileReader
	// StateReaderIntf(FileReaderIntf reader)

	// reads a state with all its state transitions and inserts it into the state map
	public void readState() throws Exception;

	// reads an identifier
	public String getIdent() throws Exception;
	
	// is the given character a legal start of an identifier
	public boolean isIdentifierStart(char c);

	// is the given character a legal part of an identifier
	public boolean isIdentifierPart(char c);

	// return the state map
	public StateMap getStateMap();
}
