package de.robinkuck.statemachine;

import java.io.InputStream;

public class StateMachineTest extends TestBase {

	public StateMachineTest(String fileName) throws Exception {
		super(fileName);
	}

	public String executeTest(String input) throws Exception {
		InputStream inputStream = stringToInputStream(input);
		FileReaderIntf fileReader = new FileReader(inputStream);
		StateReaderIntf stateReader = new StateReader(fileReader);
		while (fileReader.lookAheadChar() != '#') {
			stateReader.readState();
		}
		fileReader.advance();
		fileReader.advance();
		String output = new String();
		while (fileReader.lookAheadChar() != '$' && fileReader.lookAheadChar() != 0) {
			String word = new String();
			while (fileReader.lookAheadChar() != '\n' && fileReader.lookAheadChar() != 0) {
				word += fileReader.lookAheadChar();
				fileReader.advance();
			}
			fileReader.advance();
			output += testWord(stateReader.getStateMap(), word, false);
			output += '\n';			
		}
		return output;
	}
	
	public static String testWord(StateMap stateMachine, String word, Boolean verbose) {
		State currentState = stateMachine.getStartState();
		int curCharIdx = 0;
		int wordLen = word.length();
		while (curCharIdx != wordLen) {
			char nextChar = word.charAt(curCharIdx);
			State nextState = currentState.getTransition(nextChar);
			if (nextState == null) {
				String result = "missing transition in state: ";
				result += currentState.getName();
				result += " ";
				result += nextChar;
				return result;
			}
			if (verbose) {
				System.err.print(nextChar);
				System.err.print("->");
				System.err.println(nextState.getName());
			}
			currentState = nextState;
			curCharIdx++;
		}
        if (currentState.isFinal()) {
        	return "ok";
        } else {
        	String result = "unexpected end in state: ";
			result += currentState.getName();
        	return result;
        }		
	}
}
